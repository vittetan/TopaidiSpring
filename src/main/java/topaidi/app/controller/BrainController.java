package topaidi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.BrainDao;
import topaidi.app.dao.IdeaDao;
import topaidi.app.model.ideas.Idea;

@Controller
@RequestMapping("/brain")
public class BrainController {

	@Autowired
	BrainDao bDao;
	@Autowired
	IdeaDao iDao;
	
	
	@RequestMapping("/welcome")
	public String home(Model model) {
		
			return "brain/welcome";
 	}
	
	@GetMapping("/newIdea")
	public String add(Model model) {
		model.addAttribute("idea", new Idea());
		return "/idea/newIdea";  	
	}

	@PostMapping ("/processForm") 
	public String addArtist(@ModelAttribute("idea") Idea idea,  BindingResult result, Model model) {
		iDao.insert(idea);
		return "redirect:/idea/presentation";
	}
	
}
