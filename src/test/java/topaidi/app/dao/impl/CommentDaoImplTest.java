package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.ideas.Comment;
import topaidi.app.utils.Application;

public class CommentDaoImplTest {
	CommentDaoImpl categoryDao;
	Comment var1;

	@Before
	public void init() {
		categoryDao = new CommentDaoImpl();
		var1 = new Comment();
		var1.setDescription("Comment 1");
	}

	@Test
	public void testFindAll() {
		Comment var2 = new Comment();
		var2.setDescription("Comment 2");
		
		Comment var3 = new Comment();
		var3.setDescription("Comment 3");
		
		categoryDao.insert(var1);
		categoryDao.insert(var2);
		categoryDao.insert(var3);

		assertTrue(categoryDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		categoryDao.insert(var1);
		
		assertTrue(categoryDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testInsert() {
		categoryDao.insert(var1);

		assertTrue(categoryDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testUpdate() {
		categoryDao.insert(var1);
		var1.setDescription("Toto");
		categoryDao.update(var1);
		
		assertTrue(var1.getDescription().equals(categoryDao.findByKey(1).getDescription()));		
	}

	@Test
	public void testDelete() {
		Comment var2 = new Comment();
		var2.setDescription("Comment 2");
		
		categoryDao.insert(var1);
		categoryDao.insert(var2);
		
		categoryDao.delete(var1);		
		
		assertTrue(categoryDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		Comment var2 = new Comment();
		var2.setDescription("Comment 2");
		
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
