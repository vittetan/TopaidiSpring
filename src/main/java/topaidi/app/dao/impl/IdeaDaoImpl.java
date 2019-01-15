package topaidi.app.dao.impl;

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
		return em.find(Idea.class,id);
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
		Idea idea = em.find(Idea.class,id);
		em.remove(idea);
	}
	

	@Override
	public List<Comment> getAllComments(Integer id) {
		TypedQuery<Comment> query = em.createQuery(
                "SELECT c FROM Comment c WHERE c.idea.id = :id", Comment.class);
        return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<Vote> getAllVotes(Integer id) {
		TypedQuery<Vote> query = em.createQuery(
                "SELECT v FROM Vote v WHERE v.idea.id = :id", Vote.class);
        return query.setParameter("id", id).getResultList();
	}

	@Override
	public List<ReportIdea> getAllReportsIdea(Integer id) {
		TypedQuery<ReportIdea> query = em.createQuery(
                "SELECT ri FROM ReportIdea ri WHERE ri.idea.id = :id", ReportIdea.class);
        return query.setParameter("id", id).getResultList();
	}

}
