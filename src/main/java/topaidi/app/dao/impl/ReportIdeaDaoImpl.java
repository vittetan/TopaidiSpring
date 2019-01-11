package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.ReportIdeaDao;
import topaidi.app.model.reports.ReportIdea;

@Repository
@Transactional
public class ReportIdeaDaoImpl implements ReportIdeaDao {

	@PersistenceContext
	EntityManager em;
	
	public List<ReportIdea> findAll() {
		return em.createQuery("from ReportIdea reportIdea").getResultList();
	}

	public ReportIdea findByKey(Integer id) {
		return em.find(ReportIdea.class,id);
	}

	public void insert(ReportIdea reportIdea) {
		em.persist(reportIdea);
	}

	public ReportIdea update(ReportIdea reportIdea) {
		ReportIdea reportIdeaeMerged = em.merge(reportIdea);
		return reportIdeaeMerged;
	}

	public void delete(ReportIdea reportIdea) {
		ReportIdea reportIdeaToDelete = em.merge(reportIdea);
		em.remove(reportIdeaToDelete);
	}

	public void deleteByKey(Integer id) {
		ReportIdea reportIdea = em.find(ReportIdea.class,id);
		em.remove(reportIdea);
	}
	
	

}
