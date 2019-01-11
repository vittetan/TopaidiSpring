package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import topaidi.app.dao.ReportIdeaDao;
import topaidi.app.model.reports.ReportIdea;
import topaidi.app.utils.Application;

public class ReportIdeaDaoImpl implements ReportIdeaDao {

	@Override
	public List<ReportIdea> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<ReportIdea> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select ri from ReportIdea ri");
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
	public ReportIdea findByKey(Integer id) {
		ReportIdea ri = new ReportIdea();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			ri = em.find(ReportIdea.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return ri;
	}

	@Override
	public void insert(ReportIdea ri) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(ri);
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
	public ReportIdea update(ReportIdea ri) {
		ReportIdea riUpdated = new ReportIdea();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(ri);
			riUpdated = em.find(ReportIdea.class, ri.getId());
			em.getTransaction().commit();
			} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return riUpdated;
	}

	@Override
	public void delete(ReportIdea ri) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			ReportIdea riToDelete = em.find(ReportIdea.class, ri.getId());
			if (riToDelete != null) {
				em.getTransaction().begin();
				em.remove(riToDelete);
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
			ReportIdea ri = em.find(ReportIdea.class, id);
			if (ri != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(ri);
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

}
