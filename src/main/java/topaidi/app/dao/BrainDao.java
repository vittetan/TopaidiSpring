package topaidi.app.dao;

import java.util.List;

import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.model.reports.ReportIdea;

public interface BrainDao extends GenericDao<Brain, Integer>{

	public List<Idea> getAllIdeas();
	public List<Comment> getAllComments();
	public List<Vote> getAllVotes();
	public List<ReportIdea> getAllReportsIdea();
	public List<ReportComment> getAllReportsComment();
		
}
