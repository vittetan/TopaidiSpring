package topaidi.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import topaidi.app.dao.CategoryDao;
import topaidi.app.model.categories.Category;
import topaidi.app.utils.Application;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		List<Category> l = new ArrayList<>();
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("select cate from Category cate");
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
	public Category findByKey(Integer id) {
		Category category = new Category();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			category = em.find(Category.class, id);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return category;
	}

	@Override
	public void insert(Category category) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(category);
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
	public Category update(Category category) {
		Category catUpdated = new Category();
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(category);
			catUpdated = em.find(Category.class, category.getId());
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction() != null)
				em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return catUpdated;
	}

	@Override
	public void delete(Category category) {
		EntityManager em = Application.getInstance().getEmf().createEntityManager();
		try {
			Category catToDelete = em.find(Category.class, category.getId());
			if (catToDelete != null) {
				em.getTransaction().begin();
				em.remove(catToDelete);
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
			Category category = em.find(Category.class, id);
			if (category != null) {
				System.out.println("Found");
				em.getTransaction().begin();
				em.remove(category);
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
	public List<Category> getAllIdeasByCat(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
