package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.IdeaDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportIdea;
import topaidi.app.model.temp.RankBrain;
import topaidi.app.model.temp.RankIdea;

@Repository
@Transactional
public class IdeaDaoImpl implements IdeaDao {

	@PersistenceContext
	EntityManager em;

	public List<Idea> findAll() {
		return em.createQuery("from Idea idea order by datecreation desc").getResultList();
	}

	public Idea findByKey(Integer id) {
		return em.find(Idea.class, id);
	}

	public void insert(Idea idea) {
		em.persist(idea);
	}

	public Idea update(Idea idea) {
		Idea ideaeMerged = em.merge(idea);
		return ideaeMerged;
	}

	public void delete(Idea idea) {
		Idea ideaToDelete = em.merge(idea);
		em.remove(ideaToDelete);
	}

	public void deleteByKey(Integer id) {
		Idea idea = em.find(Idea.class, id);
		em.remove(idea);
	}

	@Override
	public List<Comment> getAllComments(Integer id) {
		TypedQuery<Comment> query = em.createQuery("SELECT c FROM Comment c WHERE c.idea.id = :id", Comment.class);
		return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<Vote> getAllVotes(Integer id) {
		TypedQuery<Vote> query = em.createQuery("SELECT v FROM Vote v WHERE v.idea.id = :id", Vote.class);
		return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<ReportIdea> getAllReportsIdea(Integer id) {
		TypedQuery<ReportIdea> query = em.createQuery("SELECT ri FROM ReportIdea ri WHERE ri.idea.id = :id",
				ReportIdea.class);
		return query.setParameter("id", id).getResultList();
	}

	@Override
	public int getNombreVotes(Integer id) {
		int n = getAllVotes(id).size();
		return n;
	}

	@Override
	public int getAllTops(Integer id) {
		TypedQuery<Vote> query = em.createQuery("SELECT v FROM Vote v WHERE v.idea.id = :id AND v.isTop = true",
				Vote.class);
		int n = query.setParameter("id", id).getResultList().size();
		return n;
	}

	@Override
	public double getPercentTop(Integer id) {
		double p = 0;
		if(getNombreVotes(id)!=0) {
			p = getAllTops(id) / getNombreVotes(id);
		}
		return p;
		
	}

	@Override
	public ArrayList<Idea> getRankingTop() {
		
		ArrayList<Idea> allIdeas = (ArrayList<Idea>) findAll();
		List<RankIdea> allIdeast = new ArrayList<RankIdea>();
		List<Idea> rankingTop = new ArrayList<Idea>();
		
		for(Idea idea:allIdeas) {
			allIdeast.add(new RankIdea(idea.getVotes().size(), getPercentTop(idea.getId()), idea));
		}
		
		allIdeast.sort(Comparator.comparingDouble(RankIdea::getPercentTops).reversed());
		allIdeast.sort(Comparator.comparingInt(RankIdea::getNumberVotes).reversed());
				
		for(RankIdea ri:allIdeast) {
			rankingTop.add(ri.getIdea());
		}

		return (ArrayList<Idea>) rankingTop;
	}

	public ArrayList<Idea> getRankingTop10() {
		ArrayList<Idea> rankingTop10 = new ArrayList<Idea>();
		ArrayList<Idea> rankingTop = getRankingTop();
		
		int n;
		if(rankingTop.size() < 10) {
			n=rankingTop.size();
		}else {
			n=10;
		}
		
		for (int i = 0; i < n; i++) {
			rankingTop10.add(rankingTop.get(i));
		}
		return rankingTop10;
	}

	public ArrayList<Idea> getRankingBuzz() {
		ArrayList<Idea> allIdeas = (ArrayList<Idea>) findAll();
		List<RankIdea> allIdeast = new ArrayList<RankIdea>();
		List<Idea> rankingBuzz = new ArrayList<Idea>();
		
		for(Idea idea:allIdeas) {
			allIdeast.add(new RankIdea(idea.getVotes().size(), getPercentTop(idea.getId()), idea));
		}
		
		allIdeast.sort(Comparator.comparingInt(RankIdea::getNumberVotes).reversed());
				
		for(RankIdea ri:allIdeast) {
			rankingBuzz.add(ri.getIdea());
		}
		
		return (ArrayList<Idea>) rankingBuzz;
	}

	public ArrayList<Idea> getRankingBuzz10() {
		ArrayList<Idea> rankingBuzz10 = new ArrayList<Idea>();
		ArrayList<Idea> rankingBuzz = getRankingBuzz();
		
		int n;
		if(rankingBuzz.size() < 10) {
			n=rankingBuzz.size();
		}else {
			n=10;
		}
		
		for (int i = 0; i < n; i++) {
			rankingBuzz10.add(rankingBuzz.get(i));
		}
		return rankingBuzz10;
	}
	
	/*public ArrayList<Idea> getAllNotVotedIdeas(Brain brain, ArrayList<Idea> allIdeas){
		ArrayList<Idea> allNotVotedIdeas = new ArrayList<Idea>();
		boolean notVoted = false;
		
		for(int i=0; i < 1; i++) {
			int ideaBrainId = allIdeas.get(i).getBrain().getId();
			if(ideaBrainId == brain.getId()) {
				notVoted = true;
				
				Set<Vote> allVotes = allIdeas.get(i).getVotes();
				for (Vote v : allVotes) {
					if(v.getBrain().getId() == brain.getId()) {
						notVoted=false;
						break;
					}
				}				
			}
			
			if(notVoted) {
				allNotVotedIdeas.add(allIdeas.get(i));
			}
		}
		
		return allNotVotedIdeas;		
	}*/
	public ArrayList<Idea> getAllNotVotedIdeas(Brain brain, ArrayList<Idea> allIdeas){
		BrainDaoImpl bDao = new BrainDaoImpl();
		ArrayList<Idea> allNotVotedIdeas = new ArrayList<Idea>();
		for (Idea i : allIdeas) {
			if(bDao.alreadyVoted(i,brain)){
				allNotVotedIdeas.add(i);
			}
		}
		return allNotVotedIdeas;
	}
	
	
	
	
	
}
