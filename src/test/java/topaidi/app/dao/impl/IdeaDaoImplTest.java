package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.ideas.Idea;
import topaidi.app.utils.Application;

public class IdeaDaoImplTest {
	IdeaDaoImpl ideaDao;
	Idea var1;

	@Before
	public void init() {
		ideaDao = new IdeaDaoImpl();
		var1 = new Idea();
		var1.setDescription("Idea 1");
	}

	@Test
	public void testFindAll() {
		Idea var2 = new Idea();
		var2.setDescription("Idea 2");
		
		Idea var3 = new Idea();
		var3.setDescription("Idea 3");
		
		ideaDao.insert(var1);
		ideaDao.insert(var2);
		ideaDao.insert(var3);

		assertTrue(ideaDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		ideaDao.insert(var1);
		
		assertTrue(ideaDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testInsert() {
		ideaDao.insert(var1);

		assertTrue(ideaDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testUpdate() {
		ideaDao.insert(var1);
		var1.setDescription("Toto");
		ideaDao.update(var1);
		
		assertTrue(var1.getDescription().equals(ideaDao.findByKey(1).getDescription()));		
	}

	@Test
	public void testDelete() {
		Idea var2 = new Idea();
		var2.setDescription("Idea 2");
		
		ideaDao.insert(var1);
		ideaDao.insert(var2);
		
		ideaDao.delete(var1);		
		
		assertTrue(ideaDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		Idea var2 = new Idea();
		var2.setDescription("Idea 2");
		
		ideaDao.insert(var1);
		ideaDao.insert(var2);
		
		ideaDao.deleteByKey(1);	
		
		assertTrue(ideaDao.findAll().size() == 1);		
	}

	@After
	public void stop() {
		Application.stop();
	}

}
