package topaidi.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.AdminDao;
import topaidi.app.model.persons.Brain;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminDao aDao;

	
	
	@GetMapping("/{id}/welcome")
	public String home(HttpSession session, Model model) {
			List<Brain> brains =  aDao.getUnValidatedBrains();
		
			model.addAttribute("unvalidatedUsers", brains);
			return "/admin/welcome";
 	}
	
		
}
