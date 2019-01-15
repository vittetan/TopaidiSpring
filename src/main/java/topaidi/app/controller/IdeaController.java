package topaidi.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.CommentDao;
import topaidi.app.dao.IdeaDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.persons.Brain;

@Controller
@RequestMapping("/idea")
public class IdeaController {

	
	HttpSession session;
	@Autowired
	IdeaDao idao;
	
	@Autowired
	CommentDao cdao;
	
	@GetMapping("/{id}")
	public String idea(@PathVariable(value="id") int id, HttpSession session, Model model) {
		
		Object isConnected = session.getAttribute("isConnected");
		if (isConnected == null) {
			return "redirect:/login";
		} else {
			boolean c = (boolean)isConnected;
			if(!c) {
				return "redirect:/login";
			}
		}

		Idea idea = idao.findByKey(id);
		model.addAttribute("i", idea);
		Comment c= new Comment();
		c.setIdea(idea);
		model.addAttribute("comm", c);
		model.addAttribute("comments", idao.getAllComments(idea.getId()));
		return "idea/presentation";
 	}
	
	@PostMapping("/{id}")	
	public String addComment(@ModelAttribute("comm") Comment comment, BindingResult result, HttpSession session) {	
		comment.setId(0);
		comment.setBrain((Brain)session.getAttribute("person"));
		
		cdao.insert(comment);
		
		int n = comment.getIdea().getId();
		return "redirect:/idea/"+ n;
	}

}
