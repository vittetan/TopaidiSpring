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

@Controller
@RequestMapping("/idea")
public class IdeaController {

	
	HttpSession session;
	@Autowired
	IdeaDao idao;
	
	@Autowired
	CommentDao cdao;
	
	@GetMapping("/{id}")
	public String idea(@PathVariable(value="id") int id, Model model) {
		Idea idea = idao.findByKey(id);
		model.addAttribute("i", idea);
		model.addAttribute("comments", idao.getAllComments(idea.getId()));
		return "idea/presentation";
 	}
	
	@PostMapping ("")	
	public String addComment(@ModelAttribute("Comm") Comment comment, BindingResult result) {		
		if(comment.getId() == 0) {
			cdao.insert(comment);
		}else {
			cdao.update(comment);
		}				
		return "redirect:/{id}";
	}

}
