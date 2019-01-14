package topaidi.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.BrainDao;

@Controller
@RequestMapping("/brain")
public class BrainController {

	
	HttpSession session;
	@Autowired
	BrainDao bDao;
	
	
	@RequestMapping("/welcome")
	public String home(Model model) {
		
			return "brain/welcome";
 	}
	
	
}
