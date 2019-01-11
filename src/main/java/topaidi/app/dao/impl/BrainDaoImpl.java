package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import topaidi.app.dao.BrainDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.model.reports.ReportIdea;
import topaidi.app.utils.Application;

public class BrainDaoImpl implements BrainDao {

	@Override
	public List<Brain> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Brain> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select bra from Brain bra");
			l = q.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return l;
	}

	@Override
	public Brain findByKey(Integer id) {
		Brain brain = new Brain();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			brain = em.find(Brain.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return brain;
	}

	@Override
	public void insert(Brain brain) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(brain);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public Brain update(Brain brain) {
		Brain brainUpdated = new Brain();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(brain);
			brainUpdated = em.find(Brain.class, brain.getId());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return brainUpdated;
	}

	@Override
	public void delete(Brain brain) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			Brain brainToDelete = em.find(Brain.class, brain.getId());
			if (brainToDelete != null) {
				em.getTransaction().begin();
				em.remove(brainToDelete);
				em.getTransaction().commit();
				System.out.println("Removed");
			} else {
				System.out.println("Not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteByKey(Integer id) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			Brain brain = em.find(Brain.class, id);
			if (brain != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(brain);
				em.getTransaction().commit();
				System.out.println("Removed");
			} else {
				System.out.println("Not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
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
