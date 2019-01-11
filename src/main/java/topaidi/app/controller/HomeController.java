package topaidi.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.AdminDao;
import topaidi.app.dao.BrainDao;
import topaidi.app.model.persons.Admin;

@Controller
public class HomeController {

	
	HttpSession session;
	@Autowired
	BrainDao bDao;
	
	@Autowired
	AdminDao aDao;
	
	@RequestMapping("/home")
	public String home(Model model) {
			return "home/home";
 	}
	
	@GetMapping("")
	public String loginAdmin(Model model) {
		model.addAttribute("admin", new Admin());
		return null;
	}
	
	/* >@PostMapping("/processForm")
	public String adminhome(@ModelAttribute("admin") Admin admin, Model model) {
		for(Admin a : aDao.findAll()) {
			if(admin.getLogin().equals(a.getLogin()) || admin.getPassword().equals(a.getPassword()) ) {
				session.setAttribute("logged", true);	
			}
			
		
			}
		}
		return "redirect:/home";
	}
	
	@GetMapping("/admin")
	public String toAdmin(Model model) {
		return "admin/welcome";  	
	}
	
	@GetMapping("/brain")
	public String toBrain(Model model) {
		return "brain/welcome";  	
	} */
	
}
