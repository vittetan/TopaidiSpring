package topaidi.app.controller;

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
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.persons.Brain;
import topaidi.app.validator.BrainValidator;
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
	public String home(Model model) {
		
			return "brain/welcome";
 	}
	
	@GetMapping("/{id}/newIdea")
	public String newIdea(@PathVariable("id") int id, Model model) {
		Brain brain = bDao.findByKey(id);
		Idea idea = new Idea();
		idea.setBrain(brain);
		model.addAttribute("idea", idea);
		model.addAttribute("categories", cDao.findAll());
		return "/idea/newIdea";  	
	}

	@PostMapping ("/{id}/newIdea") 
	public String newIdea(@PathVariable(value="id") int id, @ModelAttribute("idea") Idea idea,  BindingResult result, Model model) {
		new IdeaValidator().validate(idea, result);
		if (result.hasErrors()) {
			model.addAttribute("categories", cDao.findAll());
			return "/idea/newIdea";
		}
		idea.setId(0);
		iDao.insert(idea);
		int n = idea.getId();
		return "redirect:/idea/" + n;
	}
	
}
