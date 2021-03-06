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
import topaidi.app.dao.ReportCommentDao;
import topaidi.app.model.reports.ReportComment;

@Transactional
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ContextConfig.class)
public class ReportCommentDaoImplTest {
	
	@Autowired
	ReportCommentDao reportCommentDao;
	ReportComment var1;

	@Before
	public void init() {
		var1 = new ReportComment();
		var1.setDescription("ReportComment 1");
	}

	@Test
	public void testFindAll() {
		ReportComment var2 = new ReportComment();
		var2.setDescription("ReportComment 2");
		
		ReportComment var3 = new ReportComment();
		var3.setDescription("ReportComment 3");
		
		reportCommentDao.insert(var1);
		reportCommentDao.insert(var2);
		reportCommentDao.insert(var3);

		assertTrue(reportCommentDao.findAll().size() == 3);
	}

	@Test
	public void testFindByKey() {
		reportCommentDao.insert(var1);
		
		assertTrue(reportCommentDao.findByKey(var1.getId()).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testInsert() {
		reportCommentDao.insert(var1);

		assertTrue(reportCommentDao.findByKey(var1.getId()).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testUpdate() {
		reportCommentDao.insert(var1);
		var1.setDescription("Toto");
		reportCommentDao.update(var1);
		
		assertTrue(var1.getDescription().equals(reportCommentDao.findByKey(var1.getId()).getDescription()));		
	}

	@Test
	public void testDelete() {
		ReportComment var2 = new ReportComment();
		var2.setDescription("ReportComment 2");
		
		reportCommentDao.insert(var1);
		reportCommentDao.insert(var2);
		
		reportCommentDao.delete(var1);		
		
		assertTrue(reportCommentDao.findAll().size() == 1);		
	}

	@Test
	public void testDeleteByKey() {
		ReportComment var2 = new ReportComment();
		var2.setDescription("ReportComment 2");
		
		reportCommentDao.insert(var1);
		reportCommentDao.insert(var2);
		
		reportCommentDao.deleteByKey(var1.getId());	
		
		assertTrue(reportCommentDao.findAll().size() == 1);		
	}


}
