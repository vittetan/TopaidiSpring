package topaidi.app.dao;

import java.util.List;

import topaidi.app.model.categories.Category;

public interface CategoryDao extends GenericDao<Category, Integer>{

	public List<Category> getAllIdeasByCat(Category category);
	
}
