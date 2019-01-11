package topaidi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.AdminDao;
import topaidi.app.dao.BrainDao;
import topaidi.app.model.persons.Admin;

@Controller
@RequestMapping("/topaidi")
public class HomeController {

	@Autowired
	BrainDao bDao;
	
	@Autowired
	AdminDao aDao;
	
	@RequestMapping("/home")
	public String home(Model model) {
			return "home/home";
 	}
	
	@GetMapping("/home")
	public String login(Model model) {
		model.addAttribute("admin", new Admin());
		return null;
	}
	
	@GetMapping("/admin")
	public String toAdmin(Model model) {
		return "admin/welcome";  	
	}
	
	@GetMapping("/brain")
	public String toBrain(Model model) {
		return "brain/welcome";  	
	}
	
}
