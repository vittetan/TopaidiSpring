package topaidi.app.dao;

import java.util.List;

import topaidi.app.model.persons.Admin;
import topaidi.app.model.persons.Brain;

public interface AdminDao extends GenericDao<Admin, Integer>{

	public Admin getAdminByLogin(String login);
	public List<Brain> getUnValidatedBrains();
}
