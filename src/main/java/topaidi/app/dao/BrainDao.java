package topaidi.app.dao;

import java.util.List;

import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.model.reports.ReportIdea;

public interface BrainDao extends GenericDao<Brain, Integer>{

	public List<Idea> getAllIdeas(Integer id);
	public List<Comment> getAllComments(Integer id);
	public List<Vote> getAllVotes(Integer id);
	public List<ReportIdea> getAllReportsIdea(Integer id);
	public List<ReportComment> getAllReportsComment(Integer id);
	public Brain getBrainByLogin(String email);
	
	
}
