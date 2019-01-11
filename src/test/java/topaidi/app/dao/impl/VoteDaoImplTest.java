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
import topaidi.app.dao.VoteDao;
import topaidi.app.model.ideas.Vote;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ContextConfig.class)
public class VoteDaoImplTest {
	
	@Autowired
	VoteDao voteDao;
	Vote var1;

	@Before
	public void init() {
		voteDao = new VoteDaoImpl();
		var1 = new Vote();
		var1.setTop(true);
	}

	@Test
	public void testFindAll() {
		Vote var2 = new Vote();
		var2.setTop(true);
		
		Vote var3 = new Vote();
		var3.setTop(true);
		
		voteDao.insert(var1);
		voteDao.insert(var2);
		voteDao.insert(var3);

		assertTrue(voteDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		voteDao.insert(var1);
		
		assertTrue(voteDao.findByKey(1).isTop() == true);
	}

	@Test
	public void testInsert() {
		voteDao.insert(var1);

		assertTrue(voteDao.findByKey(1).isTop() == true);
	}

	@Test
	public void testUpdate() {
		voteDao.insert(var1);
		var1.setTop(false);
		voteDao.update(var1);
		
		assertTrue(voteDao.findByKey(1).isTop() == false);
	}

	@Test
	public void testDelete() {
		Vote var2 = new Vote();
		var2.setTop(true);
		
		voteDao.insert(var1);
		voteDao.insert(var2);
		
		voteDao.delete(var1);		
		
		assertTrue(voteDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		Vote var2 = new Vote();
		var2.setTop(true);
		
		voteDao.insert(var1);
		voteDao.insert(var2);
		
		voteDao.deleteByKey(1);	
		
		assertTrue(voteDao.findAll().size() == 1);
	}


}
