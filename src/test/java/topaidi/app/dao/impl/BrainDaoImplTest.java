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
import topaidi.app.dao.BrainDao;
import topaidi.app.model.persons.Brain;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ContextConfig.class)
public class BrainDaoImplTest {
	
	@Autowired
	BrainDao brainDao;
	Brain var1;

	@Before
	public void init() {
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
		
		assertTrue(brainDao.findByKey(var1.getId()).getPseudo().equals(var1.getPseudo()));
	}

	@Test
	public void testInsert() {
		brainDao.insert(var1);

		assertTrue(brainDao.findByKey(var1.getId()).getPseudo().equals(var1.getPseudo()));
	}

	@Test
	public void testUpdate() {
		brainDao.insert(var1);
		var1.setPseudo("Toto");
		brainDao.update(var1);
		
		assertTrue(var1.getPseudo().equals(brainDao.findByKey(var1.getId()).getPseudo()));		
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
		
		brainDao.deleteByKey(var1.getId());	
		
		assertTrue(brainDao.findAll().size() == 1);		
	}

	

}
