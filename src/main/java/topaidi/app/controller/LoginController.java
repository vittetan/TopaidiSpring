package topaidi.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.AdminDao;
import topaidi.app.dao.BrainDao;
import topaidi.app.model.persons.Admin;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.persons.Person;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	BrainDao bDao;

	@Autowired
	AdminDao aDAo;

	@GetMapping
	public String login(HttpSession session, Model m) {
//		if ((boolean)session.getAttribute("connected")) {
////			return "home";
//		}

		m.addAttribute("pers", new Brain());
		return "/login/login";
	}

	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("pers") Brain pers, HttpSession session, Model m) {
		Admin a = aDAo.getAdminByLogin(pers.getLogin());
		Brain b = bDao.getBrainByLogin(pers.getLogin());

		if (a != null || b != null) {
			if (a != null) {
				if (pers.getPassword().equals(a.getPassword())) {
					session.setAttribute("connected", true);
					session.setAttribute("isAdmin", false);
					session.setAttribute("pseudo", a.getPseudo());
					return "/admin/welcome";
				}
			}
			
			if (b != null) {
				if (pers.getPassword().equals(b.getPassword())) {
					session.setAttribute("connected", true);
					session.setAttribute("isAdmin", true);
					session.setAttribute("pseudo", b.getPseudo());
					return "/brain/welcome";
				}
			}
		}
		return "/login/login";
	}

}
