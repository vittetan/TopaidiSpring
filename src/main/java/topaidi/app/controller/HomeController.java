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

import topaidi.app.dao.AdminDao;
import topaidi.app.dao.BrainDao;
import topaidi.app.dao.IdeaDao;
import topaidi.app.model.persons.Brain;
import topaidi.app.validator.BrainValidator;

@Controller
public class HomeController {

	
	HttpSession session;
	@Autowired
	BrainDao bDao;
	
	@Autowired
	AdminDao aDao;
	
	@Autowired
	IdeaDao iDao;
	
	@RequestMapping("/home")
	public String home(@ModelAttribute("action") String action, Model model) {
		if (action.equals("confirm")) {
			model.addAttribute("action", action);
		}
		model.addAttribute("ideas", iDao.findAll());
		return "home/home";
 	}
	
	@GetMapping("/newBrain")
	public String newBrain(Model model) {
		model.addAttribute("newBrain", new Brain());
		return "/home/newBrain";  	
	}
	
	@PostMapping("/newBrain") 
	public String newBrain(@ModelAttribute("newBrain") Brain newBrain,  BindingResult result, Model model) {
		new BrainValidator().validate(newBrain, result);
		if (result.hasErrors()) {
			return "/home/newBrain";
		}
		bDao.insert(newBrain);
		return "redirect:/home?action=confirm";
	}
	
	
	
}
