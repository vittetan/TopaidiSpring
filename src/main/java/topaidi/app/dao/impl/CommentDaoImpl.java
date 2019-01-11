package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import topaidi.app.dao.CommentDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.reports.ReportComment;
import topaidi.app.utils.Application;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Comment> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select comment from Comment comment");
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
	public Comment findByKey(Integer id) {
		Comment comment = new Comment();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			comment = em.find(Comment.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return comment;
	}

	@Override
	public void insert(Comment comment) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(comment);
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
	public Comment update(Comment comment) {
		Comment commentUpdated = new Comment();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(comment);
			commentUpdated = em.find(Comment.class, comment.getId());
			em.getTransaction().commit();
			} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return commentUpdated;
	}

	@Override
	public void delete(Comment comment) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			Comment comToDelete = em.find(Comment.class, comment.getId());
			if (comToDelete != null) {
				em.getTransaction().begin();
				em.remove(comToDelete);
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
			Comment comment = em.find(Comment.class, id);
			if (comment != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(comment);
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
	public List<ReportComment> getAllReportsComment() {
		// TODO Auto-generated method stub
		return null;
	}

}
