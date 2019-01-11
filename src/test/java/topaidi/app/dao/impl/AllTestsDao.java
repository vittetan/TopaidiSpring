package topaidi.app.dao.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminDaoImplTest.class, BrainDaoImplTest.class, CategoryDaoImplTest.class, CommentDaoImplTest.class,
		IdeaDaoImplTest.class, ReportCommentDaoImplTest.class, ReportIdeaDaoImplTest.class, VoteDaoImplTest.class })
public class AllTestsDao {

}
