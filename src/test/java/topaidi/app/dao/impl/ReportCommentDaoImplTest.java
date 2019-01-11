package topaidi.app.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import topaidi.app.model.reports.*;
import topaidi.app.utils.Application;

public class ReportCommentDaoImplTest {
	ReportCommentDaoImpl reportCommentDao;
	ReportComment var1;

	@Before
	public void init() {
		reportCommentDao = new ReportCommentDaoImpl();
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
		
		assertTrue(reportCommentDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testInsert() {
		reportCommentDao.insert(var1);

		assertTrue(reportCommentDao.findByKey(1).getDescription().equals(var1.getDescription()));
	}

	@Test
	public void testUpdate() {
		reportCommentDao.insert(var1);
		var1.setDescription("Toto");
		reportCommentDao.update(var1);
		
		assertTrue(var1.getDescription().equals(reportCommentDao.findByKey(1).getDescription()));		
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
		
		reportCommentDao.deleteByKey(1);	
		
		assertTrue(reportCommentDao.findAll().size() == 1);		
	}

	@After
	public void stop() {
		Application.stop();
	}

}
