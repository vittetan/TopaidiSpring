package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
		return em.createQuery("from Idea idea").getResultList();
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
	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vote> getAllVotes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportIdea> getAllReportsIdea() {
		// TODO Auto-generated method stub
		return null;
	}

}
