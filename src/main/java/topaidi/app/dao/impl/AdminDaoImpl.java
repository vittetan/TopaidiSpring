package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import topaidi.app.dao.AdminDao;
import topaidi.app.model.persons.Admin;
import topaidi.app.utils.Application;

public class AdminDaoImpl implements AdminDao {

	@Override
	public List<Admin> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Admin> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select adm from Admin adm");
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
	public Admin findByKey(Integer id) {
		Admin admin = new Admin();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
//			em.getTransaction().begin();
			admin = em.find(Admin.class, id);
//			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
//			if (em.getTransaction() != null)
//				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return admin;
	}

	@Override
	public void insert(Admin admin) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(admin);
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
	public Admin update(Admin admin) {
		Admin adminUpdated = new Admin();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(admin);
			adminUpdated = em.find(Admin.class, admin.getId());
			em.getTransaction().commit();
			} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return adminUpdated;
	}

	@Override
	public void delete(Admin admin) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			Admin admToDelete = em.find(Admin.class, admin.getId());
			if (admToDelete != null) {
				em.getTransaction().begin();
				em.remove(admToDelete);
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
			Admin admin = em.find(Admin.class, id);
			if (admin != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(admin);
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
