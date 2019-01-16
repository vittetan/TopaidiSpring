package topaidi.app.dao.impl;

import java.util.ArrayList;
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
import topaidi.app.model.reports.ReportIdea;

@Repository
@Transactional
public class IdeaDaoImpl implements IdeaDao {

	@PersistenceContext
	EntityManager em;

	public List<Idea> findAll() {
		return em.createQuery("from Idea idea order by id desc").getResultList();
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
		double p = getAllTops(id) / getNombreVotes(id);
		return p;
	}

	@Override
	public ArrayList<Idea> getRankingTop() {

		ArrayList<Idea> rankingTop = new ArrayList<Idea>();
		ArrayList<Idea> allIdeas = (ArrayList<Idea>) findAll();

		for (int i = 0; i < allIdeas.size()-1; i++) {
			for (int j = i+1; j < allIdeas.size(); j++) {

				Idea ideaI = (Idea) allIdeas.get(i);
				Idea ideaJ = (Idea) allIdeas.get(j);
				Integer idI = ideaI.getId();
				Integer idJ = ideaI.getId();

				if (getPercentTop(idI) > getPercentTop(idJ)) {
					rankingTop.add(ideaI);
				} else {
					if (getPercentTop(idI) == getPercentTop(idJ)) {
						if (getNombreVotes(idI) > getNombreVotes(idJ)) {
							rankingTop.add(ideaI);
						} else {
							if (getNombreVotes(idI) == getNombreVotes(idJ)) {
								if (ideaI.getDateCreation().after(ideaJ.getDateCreation())) {
									rankingTop.add(ideaI);
								} else {
									rankingTop.add(ideaJ);
								}
							}
							rankingTop.add(ideaJ);
						}
					}
					rankingTop.add(ideaJ);
				}
			}			
		}

		return rankingTop;
	}
	
	public ArrayList<Idea> getRankingTop10() {
		ArrayList<Idea> rankingTop10 = new ArrayList<Idea>();
		ArrayList<Idea> rankingTop = getRankingTop();
		for (int i=0; i<10; i++) {
			rankingTop10.add(rankingTop.get(i));
		}
		return rankingTop10;
	}
	

}
