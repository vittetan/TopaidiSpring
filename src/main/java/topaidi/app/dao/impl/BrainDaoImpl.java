package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public List<Idea> getAllIdeas() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<ReportComment> getAllReportsComment() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
