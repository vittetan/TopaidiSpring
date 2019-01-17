package topaidi.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import topaidi.app.dao.AdminDao;
import topaidi.app.dao.BrainDao;
import topaidi.app.dao.CategoryDao;
import topaidi.app.model.categories.Category;
import topaidi.app.model.persons.Admin;
import topaidi.app.model.persons.Brain;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminDao aDao;

	@Autowired
	BrainDao bDao;
	
	@Autowired
	CategoryDao cDao;
	
	
	@GetMapping("/{id}/welcome")
	public String home(Model model) {
			List<Brain> brains =  aDao.getUnValidatedBrains();
		
			model.addAttribute("unvalidatedUsers", brains);
			model.addAttribute("categories", cDao.findAll());
			model.addAttribute("newCategory", new Category());
			return "/admin/welcome";
 	}
	

	@GetMapping("/activate/{id}")
	public String activate(@PathVariable(value="id") int id,HttpSession session, Model m) {
		Brain brain = bDao.findByKey(id);
		brain.setValidated(true);
		bDao.update(brain);	
		Admin admin = (Admin)session.getAttribute("person");
		return "redirect:/admin/" + admin.getId() + "/welcome";
	}
	
	@PostMapping("/addCategory")
	public String addCategory(@ModelAttribute("newCategory") Category newCategory, HttpSession session, Model model) {
		cDao.insert(newCategory);		
		Admin admin = (Admin)session.getAttribute("person");
		return "redirect:/admin/" + admin.getId() + "/welcome";
	}
	
}
