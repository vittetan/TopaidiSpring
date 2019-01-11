package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import topaidi.app.dao.IdeaDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.ideas.Idea;
import topaidi.app.model.ideas.Vote;
import topaidi.app.model.reports.ReportIdea;
import topaidi.app.utils.Application;

public class IdeaDaoImpl implements IdeaDao {

	@Override
	public List<Idea> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Idea> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select ide from Idea ide");
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
	public Idea findByKey(Integer id) {
		Idea idea = new Idea();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			idea = em.find(Idea.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return idea;
	}

	@Override
	public void insert(Idea idea) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(idea);
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
	public Idea update(Idea idea) {
		Idea ideaUpdated = new Idea();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(idea);
			ideaUpdated = em.find(Idea.class, idea.getId());
			em.getTransaction().commit();
			} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return ideaUpdated;
	}

	@Override
	public void delete(Idea idea) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			Idea ideaToDelete = em.find(Idea.class, idea.getId());
			if (ideaToDelete != null) {
				em.getTransaction().begin();
				em.remove(ideaToDelete);
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
			Idea idea = em.find(Idea.class, id);
			if (idea != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(idea);
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
