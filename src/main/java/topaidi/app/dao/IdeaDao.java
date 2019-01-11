package topaidi.app.dao;

import java.util.List;

import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.reports.ReportIdea;

public interface IdeaDao extends GenericDao<Idea, Integer>{

	public List<Comment> getAllComments();
	public List<Vote> getAllVotes();
	public List<ReportIdea> getAllReportsIdea();
	
}
