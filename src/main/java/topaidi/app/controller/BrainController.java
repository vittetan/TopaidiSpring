package topaidi.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
import topaidi.app.validator.IdeaValidator;

@Controller
@RequestMapping("/brain")
@Transactional
public class BrainController {

	@Autowired
	BrainDao bDao;
	@Autowired
	IdeaDao iDao;
	@Autowired
	CategoryDao cDao;
	
	
	@GetMapping("/{id}/welcome")
	public String home(HttpSession session, Model model) {
			
			Object pers = session.getAttribute("person");
			if (pers != null) {
				Brain b = (Brain)pers;
				model.addAttribute("brainId", b.getId());
			}
			return "/brain/welcome";
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
	public String newIdea(@ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session, Model model) {
		new IdeaValidator().validate(idea, result);
		if (result.hasErrors()) {
			model.addAttribute("categories", cDao.findAll());
			return "/idea/newIdea";
		}
		idea.setId(0);
		
		if (idea.getImage().isEmpty()) {
			idea.setImage(null);
		}
		iDao.insert(idea);
		int n = idea.getId();
		return "redirect:/idea/" + n;
	}
	
	
	@GetMapping ("/{id}/rankings")
	public String rankings(@PathVariable(value="id") int id, HttpSession session, Model model) {
		Object isConnected = session.getAttribute("isConnected");
		if (isConnected == null) {
			return "redirect:/login";
		} else {
			boolean c = (boolean)isConnected;
			if(!c) {
				return "redirect:/login";
			}
		}
		
		Brain brain = (Brain)session.getAttribute("person");
		model.addAttribute("rankingTop10", iDao.getRankingTop10());
		ArrayList<Idea> notVotedTop = iDao.getAllNotVotedIdeas(brain, iDao.getRankingTop10());	
		model.addAttribute("notVotedRankingTop10", notVotedTop);
		model.addAttribute("rankingBuzz10", iDao.getRankingBuzz10());
		//model.addAttribute("notVotedRankingBuzz10", iDao.getAllNotVotedIdeas(brain, iDao.getRankingBuzz10()));
		model.addAttribute("rankingBrains", bDao.getRankingBrain());
				
		return "/brain/rankings";
	}
	
	@PostMapping ("/{id}/rankings") 
	public String rankingsShow(@PathVariable(value="id") int id, HttpSession session, Model model) {
		return "/brain/rankings";
	}
		
}
