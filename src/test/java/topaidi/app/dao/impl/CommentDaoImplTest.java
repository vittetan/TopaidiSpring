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
import topaidi.app.dao.CommentDao;
import topaidi.app.model.ideas.Comment;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ContextConfig.class)
public class CommentDaoImplTest {
	
	@Autowired
	CommentDao categoryDao;
	Comment var1;

	@Before
	public void init() {
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
		
		assertTrue(categoryDao.findByKey(var1.getId()).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testInsert() {
		categoryDao.insert(var1);

		assertTrue(categoryDao.findByKey(var1.getId()).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testUpdate() {
		categoryDao.insert(var1);
		var1.setDescription("Toto");
		categoryDao.update(var1);
		
		assertTrue(var1.getDescription().equals(categoryDao.findByKey(var1.getId()).getDescription()));		
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
		
		categoryDao.deleteByKey(var1.getId());	
		
		assertTrue(categoryDao.findAll().size() == 1);		
	}


}
