package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.reports.ReportIdea;
import topaidi.app.utils.Application;

public class ReportIdeaDaoImplTest {
	ReportIdeaDaoImpl reportIdeaDao;
	ReportIdea var1;

	@Before
	public void init() {
		reportIdeaDao = new ReportIdeaDaoImpl();
		var1 = new ReportIdea();
		var1.setDescription("ReportIdea 1");
	}

	@Test
	public void testFindAll() {
		ReportIdea var2 = new ReportIdea();
		var2.setDescription("ReportIdea 2");
		
		ReportIdea var3 = new ReportIdea();
		var3.setDescription("ReportIdea 3");
		
		reportIdeaDao.insert(var1);
		reportIdeaDao.insert(var2);
		reportIdeaDao.insert(var3);

		assertTrue(reportIdeaDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		reportIdeaDao.insert(var1);
		
		assertTrue(reportIdeaDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testInsert() {
		reportIdeaDao.insert(var1);

		assertTrue(reportIdeaDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testUpdate() {
		reportIdeaDao.insert(var1);
		var1.setDescription("Toto");
		reportIdeaDao.update(var1);
		
		assertTrue(var1.getDescription().equals(reportIdeaDao.findByKey(1).getDescription()));		
	}

	@Test
	public void testDelete() {
		ReportIdea var2 = new ReportIdea();
		var2.setDescription("ReportIdea 2");
		
		reportIdeaDao.insert(var1);
		reportIdeaDao.insert(var2);
		
		reportIdeaDao.delete(var1);		
		
		assertTrue(reportIdeaDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		ReportIdea var2 = new ReportIdea();
		var2.setDescription("ReportIdea 2");
		
		reportIdeaDao.insert(var1);
		reportIdeaDao.insert(var2);
		
		reportIdeaDao.deleteByKey(1);	
		
		assertTrue(reportIdeaDao.findAll().size() == 1);		
	}

	@After
	public void stop() {
		Application.stop();
	}

}
