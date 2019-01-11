package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.categories.Category;
import topaidi.app.utils.Application;

public class CategoryDaoImplTest {
	CategoryDaoImpl categoryDao;
	Category var1;

	@Before
	public void init() {
		categoryDao = new CategoryDaoImpl();
		var1 = new Category();
		var1.setName("Category 1");
	}

	@Test
	public void testFindAll() {
		Category var2 = new Category();
		var2.setName("Category 2");
		
		Category var3 = new Category();
		var3.setName("Category 3");
		
		categoryDao.insert(var1);
		categoryDao.insert(var2);
		categoryDao.insert(var3);

		assertTrue(categoryDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		categoryDao.insert(var1);
		
		assertTrue(categoryDao.findByKey(1).getName().equals(var1.getName()));
	}

	@Test
	public void testInsert() {
		categoryDao.insert(var1);

		assertTrue(categoryDao.findByKey(1).getName().equals(var1.getName()));
	}

	@Test
	public void testUpdate() {
		categoryDao.insert(var1);
		var1.setName("Toto");
		categoryDao.update(var1);
		
		assertTrue(var1.getName().equals(categoryDao.findByKey(1).getName()));		
	}

	@Test
	public void testDelete() {
		Category var2 = new Category();
		var2.setName("Category 2");
		
		categoryDao.insert(var1);
		categoryDao.insert(var2);
		
		categoryDao.delete(var1);		
		
		assertTrue(categoryDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		Category var2 = new Category();
		var2.setName("Category 2");
		
		categoryDao.insert(var1);
		categoryDao.insert(var2);
		
		categoryDao.deleteByKey(1);	
		
		assertTrue(categoryDao.findAll().size() == 1);		
	}

	@After
	public void stop() {
		Application.stop();
	}

}
