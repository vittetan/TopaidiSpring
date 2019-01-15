package topaidi.app.controller;

import java.util.List;

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

import topaidi.app.dao.BrainDao;
import topaidi.app.dao.CategoryDao;
import topaidi.app.dao.IdeaDao;
import topaidi.app.model.categories.Category;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.persons.Brain;
import topaidi.app.validator.IdeaValidator;

@Controller
@RequestMapping("/brain")
public class BrainController {

	@Autowired
	BrainDao bDao;
	@Autowired
	IdeaDao iDao;
	@Autowired
	CategoryDao cDao;
	
	
	@RequestMapping("/{id}/welcome")
	public String home(HttpSession session, Model model) {
			
			Object pers = session.getAttribute("person");
			if (pers != null) {
				Brain b = (Brain)pers;
				model.addAttribute("brainId", b.getId());
			}
			return "brain/welcome";
 	}
	
		
	@GetMapping("/{id}/newIdea")
	public String newIdea(@PathVariable("id") int id, HttpSession session, Model model) {
		
		Object isConnected = session.getAttribute("isConnected");
		if (isConnected == null) {
			return "redirect:/login";
		} else {
			boolean c = (boolean)isConnected;
			if(!c) {
				return "redirect:/login";
			}
		}
		
		//Brain brain = bDao.findByKey(id);
		Idea idea = new Idea();
		idea.setBrain((Brain)session.getAttribute("person"));
		model.addAttribute("idea", idea);
		model.addAttribute("categories", cDao.findAll());
		return "/idea/newIdea";  	
	}

	@PostMapping ("/{id}/newIdea") 
	public String newIdea(@ModelAttribute("idea") Idea idea, @ModelAttribute("categories") List<Category> categories, BindingResult result, HttpSession session) {
		new IdeaValidator().validate(idea, result);
		if (result.hasErrors()) {
			categories = cDao.findAll();
			return "/idea/newIdea";
		}
		idea.setId(0);
		iDao.insert(idea);
		int n = idea.getId();
		return "redirect:/idea/" + n;
	}
	
		
}
