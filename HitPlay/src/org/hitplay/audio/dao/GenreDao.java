package org.hitplay.audio.dao;

import org.hitplay.generic.dao.BaseDao;
import org.hitplay.audio.dto.Genre;

public class GenreDao extends BaseDao<Genre>{

	@Override
	public Genre getById(Long id) {
		return (Genre)sess().get(Genre.class, id);
	}

	@Override
	public Genre save(Genre type) {
		Long id = (Long)sess().save(type);
		return getById(id);
	}

	@Override
	public Genre update(Genre type) {
		sess().update(type);
		return type;
	}

	@Override
	public void delete(Genre type) {
		sess().delete(type);
	}

}
