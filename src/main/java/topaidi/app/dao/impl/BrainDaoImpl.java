package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.BrainDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.model.reports.ReportIdea;

@Repository
@Transactional
public class BrainDaoImpl implements BrainDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Brain> findAll() {
		return em.createQuery("from Brain brain").getResultList();
	}

	public Brain findByKey(Integer id) {
		return em.find(Brain.class,id);
	}

	public void insert(Brain brain) {
		em.persist(brain);
	}

	public Brain update(Brain brain) {
		Brain braineMerged = em.merge(brain);
		return braineMerged;
	}

	public void delete(Brain brain) {
		Brain brainToDelete = em.merge(brain);
		em.remove(brainToDelete);
	}

	public void deleteByKey(Integer id) {
		Brain brain = em.find(Brain.class,id);
		em.remove(brain);
	}
	
	
	@Override
	public List<Idea> getAllIdeas(Integer id) {
		TypedQuery<Idea> query = em.createQuery(
	            "SELECT i FROM Idea i WHERE i.brain.id = :id", Idea.class);
	    return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<Comment> getAllComments(Integer id) {
		TypedQuery<Comment> query = em.createQuery(
	            "SELECT c FROM Comment c WHERE c.brain.id = :id", Comment.class);
	    return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<Vote> getAllVotes(Integer id) {
		TypedQuery<Vote> query = em.createQuery(
	            "SELECT v FROM Vote v WHERE v.brain.id = :id", Vote.class);
	    return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<ReportIdea> getAllReportsIdea(Integer id) {
		TypedQuery<ReportIdea> query = em.createQuery(
	            "SELECT ri FROM Idea ri WHERE ri.brain.id = :id", ReportIdea.class);
	    return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<ReportComment> getAllReportsComment(Integer id) {
		TypedQuery<ReportComment> query = em.createQuery(
	            "SELECT rc FROM Idea rc WHERE rc.brain.id = :id", ReportComment.class);
	    return query.setParameter("id", id).getResultList();
	}

	@Override
	public Brain getBrainByLogin(String login) {
		TypedQuery<Brain> query = em.createQuery(
				" SELECT b FROM Brain b WHERE b.login= :login", Brain.class);
		try {
			Brain result =  query.setParameter("login", login).getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public int getNombreIdeas(Integer id) {
		int n = getAllIdeas(id).size();
		return n;
	}

	@Override
	public ArrayList<Brain> getRankingBrain() {
		ArrayList<Brain> allBrains = (ArrayList<Brain>) findAll();
		ArrayList<Brain> rankingBrain = new ArrayList<Brain>();
		for (int i = 0; i < (allBrains.size() - 1); i++) {
			for (int j = i + 1; j < allBrains.size(); j++) {

				Brain brainI = (Brain) allBrains.get(i);
				Brain brainJ = (Brain) allBrains.get(j);
				Integer idI = brainI.getId();
				Integer idJ = brainJ.getId();

				if (getNombreIdeas(idI) >= getNombreIdeas(idJ)) {
					rankingBrain.add(brainI);
				} else {
					rankingBrain.add(brainJ);
				}

			}
		}

		return rankingBrain;
	}

	@Override
	public ArrayList<Brain> getRankingBrain3() {
		ArrayList<Brain> rankingBrain3 = new ArrayList<Brain>();
		ArrayList<Brain> rankingBrain = getRankingBrain();
		for (int i = 0; i < 3; i++) {
			rankingBrain3.add(rankingBrain.get(i));
		}
		return rankingBrain3;
	}
	
	
}
