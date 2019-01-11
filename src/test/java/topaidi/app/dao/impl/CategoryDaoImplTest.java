package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import topaidi.app.config.ContextConfig;
import topaidi.app.dao.CategoryDao;
import topaidi.app.model.categories.Category;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ContextConfig.class)
public class CategoryDaoImplTest {
	
	@Autowired
	CategoryDao categoryDao;
	Category var1;

	@Before
	public void init() {
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
		
		assertTrue(categoryDao.findByKey(var1.getId()).getName().equals(var1.getName()));
	}

	@Test
	public void testInsert() {
		categoryDao.insert(var1);

		assertTrue(categoryDao.findByKey(var1.getId()).getName().equals(var1.getName()));
	}

	@Test
	public void testUpdate() {
		categoryDao.insert(var1);
		var1.setName("Toto");
		categoryDao.update(var1);
		
		assertTrue(var1.getName().equals(categoryDao.findByKey(var1.getId()).getName()));		
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
		
		categoryDao.deleteByKey(var1.getId());	
		
		assertTrue(categoryDao.findAll().size() == 1);		
	}



}
