package topaidi.app.dao;

import java.util.List;

import java.util.ArrayList;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportIdea;

public interface IdeaDao extends GenericDao<Idea, Integer>{

	public List<Comment> getAllComments(Integer id);
	public List<Vote> getAllVotes(Integer id);
	public List<ReportIdea> getAllReportsIdea(Integer id);
	public int getNombreVotes(Integer id);
	public int getAllTops(Integer id);
	public double getPercentTop(Integer id);
	public ArrayList<Idea> getRankingTop();
	public ArrayList<Idea> getRankingTop10();
	public ArrayList<Idea> getRankingBuzz();
	public ArrayList<Idea> getRankingBuzz10();
	public ArrayList<Idea> getAllNotVotedIdeas(Brain brain, ArrayList<Idea> allIdeas);
		
}
