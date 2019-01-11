package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import topaidi.app.dao.ReportCommentDao;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.utils.Application;

public class ReportCommentDaoImpl implements ReportCommentDao {

	@Override
	public List<ReportComment> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<ReportComment> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select rc from ReportComment rc");
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
	public ReportComment findByKey(Integer id) {
		ReportComment rc = new ReportComment();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			rc = em.find(ReportComment.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return rc;
	}

	@Override
	public void insert(ReportComment rc) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(rc);
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
	public ReportComment update(ReportComment rc) {
		ReportComment rcUpdated = new ReportComment();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(rc);
			rcUpdated = em.find(ReportComment.class, rc.getId());
			em.getTransaction().commit();
			} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return rcUpdated;
	}

	@Override
	public void delete(ReportComment rc) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			ReportComment rcToDelete = em.find(ReportComment.class, rc.getId());
			if (rcToDelete != null) {
				em.getTransaction().begin();
				em.remove(rcToDelete);
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
			ReportComment rc = em.find(ReportComment.class, id);
			if (rc != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(rc);
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
