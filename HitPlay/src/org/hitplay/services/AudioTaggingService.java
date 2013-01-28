package org.hitplay.services;

import org.hitplay.audio.dao.GenreDao;
import org.hitplay.audio.dao.TagDao;
import org.hitplay.audio.dto.Genre;
import org.hitplay.audio.dto.Tag;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public class AudioTaggingService {
	
	public void addTagDefinition(Tag tag){
		tagDao.save(tag);
	}
	
	public void addGenreDefinition(Genre genre){
		genreDao.save(genre);
	}
	
	public TagDao getTagDao() {
		return tagDao;
	}
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}
	public GenreDao getGenreDao() {
		return genreDao;
	}
	public void setGenreDao(GenreDao genreDao) {
		this.genreDao = genreDao;
	}
	
	private TagDao tagDao;
	private GenreDao genreDao;
}
