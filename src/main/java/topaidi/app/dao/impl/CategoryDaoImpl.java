package topaidi.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import topaidi.app.dao.CategoryDao;
import topaidi.app.model.categories.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@PersistenceContext
	EntityManager em;
	
	public List<Category> findAll() {
		return em.createQuery("from Category category").getResultList();
	}

	public Category findByKey(Integer id) {
		return em.find(Category.class,id);
	}

	public void insert(Category category) {
		em.persist(category);
	}

	public Category update(Category category) {
		Category categoryeMerged = em.merge(category);
		return categoryeMerged;
	}

	public void delete(Category category) {
		Category categoryToDelete = em.merge(category);
		em.remove(categoryToDelete);
	}

	public void deleteByKey(Integer id) {
		Category category = em.find(Category.class,id);
		em.remove(category);
	}
	
	
	@Override
	public List<Category> getAllIdeasByCat(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
