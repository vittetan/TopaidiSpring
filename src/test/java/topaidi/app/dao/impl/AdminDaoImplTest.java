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
import topaidi.app.dao.AdminDao;
import topaidi.app.model.persons.Admin;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ContextConfig.class)
public class AdminDaoImplTest {
	@Autowired
	AdminDao adminDao;
	Admin var1;

	@Before
	public void init() {
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
		
		adminDao.deleteByKey(var1.getId());	
		
		assertTrue(adminDao.findAll().size() == 1);		
	}

	
}
