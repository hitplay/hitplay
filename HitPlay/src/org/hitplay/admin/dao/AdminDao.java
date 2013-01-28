package org.hitplay.admin.dao;

import org.hitplay.admin.dto.Administrator;
import org.hitplay.generic.dao.BaseDao;
import org.hitplay.user.dto.User;

public class AdminDao extends BaseDao<Administrator>{
	
	@Override
	public Administrator getById(Long id) {
		return (Administrator)sess().get(Administrator.class, id);
	}

	@Override
	public Administrator save(Administrator type) {
		Long admin_id = (Long)sess().save(type);
		return getById(admin_id);
	}

	@Override
	public Administrator update(Administrator type) {
		sess().saveOrUpdate(type);
		return getById(type.getAdminId());
	}

	@Override
	public void delete(Administrator type) {
		// TODO Auto-generated method stub
		sess().delete(type);
	}
	
	public Administrator getAdminByUsername(String adminUsername){
		return	(Administrator)sess().createQuery(
						"from Administrator where username = :user_name")
						.setParameter("user_name", adminUsername).uniqueResult();
	}
}
