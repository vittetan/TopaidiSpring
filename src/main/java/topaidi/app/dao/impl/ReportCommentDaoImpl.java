package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.ReportCommentDao;
import topaidi.app.model.reports.ReportComment;

@Repository
@Transactional
public class ReportCommentDaoImpl implements ReportCommentDao {

	@PersistenceContext
	EntityManager em;
	
	public List<ReportComment> findAll() {
		return em.createQuery("from ReportComment reportComment").getResultList();
	}

	public ReportComment findByKey(Integer id) {
		return em.find(ReportComment.class,id);
	}

	public void insert(ReportComment reportComment) {
		em.persist(reportComment);
	}

	public ReportComment update(ReportComment reportComment) {
		ReportComment reportCommenteMerged = em.merge(reportComment);
		return reportCommenteMerged;
	}

	public void delete(ReportComment reportComment) {
		ReportComment reportCommentToDelete = em.merge(reportComment);
		em.remove(reportCommentToDelete);
	}

	public void deleteByKey(Integer id) {
		ReportComment reportComment = em.find(ReportComment.class,id);
		em.remove(reportComment);
	}
	
	

}
