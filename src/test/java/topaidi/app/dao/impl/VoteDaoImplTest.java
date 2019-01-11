package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.ideas.Vote;
import topaidi.app.model.persons.Brain;
import topaidi.app.utils.Application;

public class VoteDaoImplTest {
	VoteDaoImpl voteDao;
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

	@After
	public void stop() {
		Application.stop();
	}

}
