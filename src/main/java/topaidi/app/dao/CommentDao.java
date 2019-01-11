package topaidi.app.dao;

import java.util.List;

import topaidi.app.model.ideas.Comment;
import topaidi.app.model.reports.ReportComment;

public interface CommentDao extends GenericDao<Comment, Integer>{

	public List<ReportComment> getAllReportsComment();
	
}
