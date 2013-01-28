package org.hitplay.users.dao;

import org.hitplay.generic.dao.BaseDao;
import org.hitplay.user.dto.Picture;
import org.hitplay.user.dto.User;
import org.hitplay.user.dto.UserProfile;

public class PictureDao extends BaseDao<Picture> {

	public Picture getById(Long id) {
		return (Picture)sess().get(Picture.class, id);
	}

	public Picture update(Picture type) {
		 sess().update(type);
		 return getById(type.getPictureID());
		
	}

	@Override
	public Picture save(Picture type) {
		Long id = (Long)sess().save(type);
		return getById(id);
	}

	@Override
	public void delete(Picture type) {
		// TODO Auto-generated method stub
		
	}

	

}