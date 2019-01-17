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

import topaidi.app.dao.BrainDao;
import topaidi.app.dao.CommentDao;
import topaidi.app.dao.IdeaDao;
import topaidi.app.dao.VoteDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;

@Controller
@RequestMapping("/idea")
public class IdeaController {

	@Autowired
	IdeaDao idao;

	@Autowired
	CommentDao cdao;

	@Autowired
	VoteDao vdao;

	@Autowired
	BrainDao bdao;

	// ------------------------------------------------------------------

	@GetMapping("/{id}")
	public String idea(@PathVariable(value = "id") int id, @ModelAttribute("vote") String vote, HttpSession session,
			Model model) {

		Object isConnected = session.getAttribute("isConnected");
		if (isConnected == null) {
			return "redirect:/login";
		} else {
			boolean c = (boolean) isConnected;
			if (!c) {
				return "redirect:/login";
			}
		}

		Idea idea = idao.findByKey(id);
		model.addAttribute("i", idea);

		Comment c = new Comment();
		c.setIdea(idea);
		model.addAttribute("comm", c);
		model.addAttribute("comments", idao.getAllComments(idea.getId()));

		Vote v = new Vote();
		v.setIdea(idea);
		Brain brain = (Brain) session.getAttribute("person");

		boolean hasVoted = bdao.alreadyVoted(idea, brain);
		model.addAttribute("alreadyVoted", hasVoted);

		if (hasVoted) {
			return "idea/presentation";
		} else {
			if (vote.equals("top")) {
				v.setTop(true);
				v.setBrain(brain);
				vdao.insert(v);
				return "redirect:/idea/" + idea.getId();
			} else if (vote.equals("flop")) {
				v.setTop(false);
				v.setBrain(brain);
				vdao.insert(v);
				return "redirect:/idea/" + idea.getId();
			}
		}

		return "idea/presentation";
	}

	@PostMapping("/{id}")
	public String addComment(@ModelAttribute("comm") Comment comment, BindingResult result, HttpSession session) {
		comment.setId(0);
		comment.setBrain((Brain) session.getAttribute("person"));

		cdao.insert(comment);

		int n = comment.getIdea().getId();
		return "redirect:/idea/" + n;
	}

}
