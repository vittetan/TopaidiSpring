package topaidi.app.dao.impl;

import java.util.List;

import javax.management.remote.NotificationResult;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public Brain getBrainByLogin(String email) {
		TypedQuery<Brain> query = em.createQuery(
				" SELECT b FROM Brain b WHERE b.login= :email", Brain.class);
		try {
			Brain result =  query.setParameter("email", email).getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	
}
