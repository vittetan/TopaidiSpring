package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import topaidi.app.dao.VoteDao;
import topaidi.app.model.ideas.Vote;
import topaidi.app.utils.Application;

public class VoteDaoImpl implements VoteDao {

	@Override
	public List<Vote> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Vote> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select vot from Vote vot");
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
	public Vote findByKey(Integer id) {
		Vote vote = new Vote();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			vote = em.find(Vote.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return vote;
	}

	@Override
	public void insert(Vote vote) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(vote);
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
	public Vote update(Vote vote) {
		Vote voteUpdated = new Vote();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(vote);
			voteUpdated = em.find(Vote.class, vote.getId());
			em.getTransaction().commit();
			} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return voteUpdated;
	}

	@Override
	public void delete(Vote vote) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			Vote votToDelete = em.find(Vote.class, vote.getId());
			if (votToDelete != null) {
				em.getTransaction().begin();
				em.remove(votToDelete);
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
			Vote vote = em.find(Vote.class, id);
			if (vote != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(vote);
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
