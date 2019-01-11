package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.persons.Admin;
import topaidi.app.utils.Application;

public class AdminDaoImplTest {
	AdminDaoImpl adminDao;
	Admin var1;

	@Before
	public void init() {
		adminDao = new AdminDaoImpl();
		var1 = new Admin();
		var1.setPseudo("Admin 1");
	}

	@Test
	public void testFindAll() {
		Admin var2 = new Admin();
		var2.setPseudo("Admin 2");
		
		Admin var3 = new Admin();
		var3.setPseudo("Admin 3");
		
		adminDao.insert(var1);
		adminDao.insert(var2);
		adminDao.insert(var3);

		assertTrue(adminDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		adminDao.insert(var1);
		
		assertTrue(adminDao.findByKey(1).getPseudo().equals(var1.getPseudo()));
	}

	@Test
	public void testInsert() {
		adminDao.insert(var1);

		assertTrue(adminDao.findByKey(1).getPseudo().equals(var1.getPseudo()));
	}

	@Test
	public void testUpdate() {
		adminDao.insert(var1);
		var1.setPseudo("Toto");
		adminDao.update(var1);
		
		assertTrue(var1.getPseudo().equals(adminDao.findByKey(1).getPseudo()));		
	}

	@Test
	public void testDelete() {
		Admin var2 = new Admin();
		var2.setPseudo("Admin 2");
		
		adminDao.insert(var1);
		adminDao.insert(var2);
		
		adminDao.delete(var1);		
		
		assertTrue(adminDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		Admin var2 = new Admin();
		var2.setPseudo("Admin 2");
		
		adminDao.insert(var1);
		adminDao.insert(var2);
		
		adminDao.deleteByKey(1);	
		
		assertTrue(adminDao.findAll().size() == 1);		
	}

	@After
	public void stop() {
		Application.stop();
	}

}
