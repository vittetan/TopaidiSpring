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
import topaidi.app.dao.ReportIdeaDao;
import topaidi.app.model.reports.ReportIdea;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ContextConfig.class)
public class ReportIdeaDaoImplTest {
	
	@Autowired
	ReportIdeaDao reportIdeaDao;
	ReportIdea var1;

	@Before
	public void init() {
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
		
		assertTrue(reportIdeaDao.findByKey(var1.getId()).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testInsert() {
		reportIdeaDao.insert(var1);

		assertTrue(reportIdeaDao.findByKey(var1.getId()).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testUpdate() {
		reportIdeaDao.insert(var1);
		var1.setDescription("Toto");
		reportIdeaDao.update(var1);
		
		assertTrue(var1.getDescription().equals(reportIdeaDao.findByKey(var1.getId()).getDescription()));		
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
		
		reportIdeaDao.deleteByKey(var1.getId());	
		
		assertTrue(reportIdeaDao.findAll().size() == 1);		
	}

}
