package org.hitplay.services;

import java.util.List;

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
	
	public List<Genre> getAllGenres(){
		return genreDao.getAllGenres();
	}
	
	public Genre getGenre(Long id){
		return genreDao.getById(id);
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
	
	public List<Tag> findTagsByName(String tagName){
		return tagDao.getTagsByName(tagName);
	}
	
	public Tag getTagByName(String name){
		return tagDao.getTagByName(name);
	}
	
	//Checks if the Tag Exist, null  is  does not exist.
	public boolean tagExist(String name){
		Tag tg = getTagByName(name);
		return (tg != null) ? true : false;
	}
	
	private TagDao tagDao;
	private GenreDao genreDao;
}
