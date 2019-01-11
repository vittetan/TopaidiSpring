package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.persons.Brain;
import topaidi.app.utils.Application;

public class BrainDaoImplTest {
	BrainDaoImpl brainDao;
	Brain var1;

	@Before
	public void init() {
		brainDao = new BrainDaoImpl();
		var1 = new Brain();
		var1.setPseudo("Brain 1");
	}

	@Test
	public void testFindAll() {
		Brain var2 = new Brain();
		var2.setPseudo("Brain 2");
		
		Brain var3 = new Brain();
		var3.setPseudo("Brain 3");
		
		brainDao.insert(var1);
		brainDao.insert(var2);
		brainDao.insert(var3);

		assertTrue(brainDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		brainDao.insert(var1);
		
		assertTrue(brainDao.findByKey(1).getPseudo().equals(var1.getPseudo()));
	}

	@Test
	public void testInsert() {
		brainDao.insert(var1);

		assertTrue(brainDao.findByKey(1).getPseudo().equals(var1.getPseudo()));
	}

	@Test
	public void testUpdate() {
		brainDao.insert(var1);
		var1.setPseudo("Toto");
		brainDao.update(var1);
		
		assertTrue(var1.getPseudo().equals(brainDao.findByKey(1).getPseudo()));		
	}

	@Test
	public void testDelete() {
		Brain var2 = new Brain();
		var2.setPseudo("Brain 2");
		
		brainDao.insert(var1);
		brainDao.insert(var2);
		
		brainDao.delete(var1);		
		
		assertTrue(brainDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		Brain var2 = new Brain();
		var2.setPseudo("Brain 2");
		
		brainDao.insert(var1);
		brainDao.insert(var2);
		
		brainDao.deleteByKey(1);	
		
		assertTrue(brainDao.findAll().size() == 1);		
	}

	@After
	public void stop() {
		Application.stop();
	}

}
