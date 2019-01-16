package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.AdminDao;
import topaidi.app.model.persons.Admin;
import topaidi.app.model.persons.Brain;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Admin> findAll() {
		return em.createQuery("from Admin admin").getResultList();
	}

	public Admin findByKey(Integer id) {
		return em.find(Admin.class,id);
	}

	public void insert(Admin admin) {
		em.persist(admin);
	}

	public Admin update(Admin admin) {
		Admin admineMerged = em.merge(admin);
		return admineMerged;
	}

	public void delete(Admin admin) {
		Admin adminToDelete = em.merge(admin);
		em.remove(adminToDelete);
	}

	public void deleteByKey(Integer id) {
		Admin admin = em.find(Admin.class,id);
		em.remove(admin);
	}

	@Override
	public Admin getAdminByLogin(String login) {
		TypedQuery<Admin> query = em.createQuery(
				" SELECT a FROM Admin a WHERE a.login= :login", Admin.class);
		try {
			Admin result =  query.setParameter("login", login).getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Brain> getUnValidatedBrains() {
		TypedQuery<Brain> query = em.createQuery(
				" SELECT b FROM Brain b WHERE b.isValidated= :isValidated", Brain.class);
		try {
			List<Brain> results =  query.setParameter("isValidated", false).getResultList();
			return results;
		} catch (NoResultException e) {
			return null;
		}
	}
	

}
