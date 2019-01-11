package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.CommentDao;
import topaidi.app.model.ideas.Comment;
import topaidi.app.model.reports.ReportComment;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Comment> findAll() {
		return em.createQuery("from Comment comment").getResultList();
	}

	public Comment findByKey(Integer id) {
		return em.find(Comment.class,id);
	}

	public void insert(Comment comment) {
		em.persist(comment);
	}

	public Comment update(Comment comment) {
		Comment commenteMerged = em.merge(comment);
		return commenteMerged;
	}

	public void delete(Comment comment) {
		Comment commentToDelete = em.merge(comment);
		em.remove(commentToDelete);
	}

	public void deleteByKey(Integer id) {
		Comment comment = em.find(Comment.class,id);
		em.remove(comment);
	}
	
	@Override
	public List<ReportComment> getAllReportsComment() {
		// TODO Auto-generated method stub
		return null;
	}

}
