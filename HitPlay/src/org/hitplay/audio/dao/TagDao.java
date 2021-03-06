package org.hitplay.audio.dao;

import org.hitplay.generic.dao.BaseDao;
import org.hitplay.audio.dto.Tag;

public class TagDao extends BaseDao<Tag>{

	@Override
	public Tag getById(Long id) {
		return (Tag)sess().get(Tag.class,id);
	}

	@Override
	public Tag save(Tag type) {
		Long id = (Long)sess().save(type);
		return getById(id);
	}

	@Override
	public Tag update(Tag type) {
		sess().update(type);
		return type;
	}

	@Override
	public void delete(Tag type) {
		sess().delete(type);
	}

}
