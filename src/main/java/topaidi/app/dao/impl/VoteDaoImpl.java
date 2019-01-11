package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.VoteDao;
import topaidi.app.model.ideas.Vote;

@Repository
@Transactional
public class VoteDaoImpl implements VoteDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Vote> findAll() {
		return em.createQuery("from Vote vote").getResultList();
	}

	public Vote findByKey(Integer id) {
		return em.find(Vote.class,id);
	}

	public void insert(Vote vote) {
		em.persist(vote);
	}

	public Vote update(Vote vote) {
		Vote voteeMerged = em.merge(vote);
		return voteeMerged;
	}

	public void delete(Vote vote) {
		Vote voteToDelete = em.merge(vote);
		em.remove(voteToDelete);
	}

	public void deleteByKey(Integer id) {
		Vote vote = em.find(Vote.class,id);
		em.remove(vote);
	}
	
	
}
