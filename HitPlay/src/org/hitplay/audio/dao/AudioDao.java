package org.hitplay.audio.dao;

import org.hitplay.audio.dto.Audio;
import org.hitplay.generic.dao.BaseDao;

public class AudioDao extends BaseDao<Audio>{

	@Override
	public Audio getById(Long id) {
		return (Audio)sess().get(Audio.class,id);
	}

	@Override
	public Audio save(Audio type) {
		Long id = (Long)sess().save(type);
		return getById(id);
	}

	@Override
	public Audio update(Audio type) {
		sess().update(type);
		return type;
	}

	@Override
	public void delete(Audio type) {
		sess().delete(type);
	}

}
