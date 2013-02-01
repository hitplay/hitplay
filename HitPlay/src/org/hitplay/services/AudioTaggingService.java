package org.hitplay.services;

import java.util.ArrayList;
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
	public boolean isAvailable(String name){
		Tag tg = getTagByName(name);
		if(tg != null){
			return true;
		}else{
			return false;
		}
	}
	
	//Fetch the List of tags from the db using the given tagNames
	public List<Tag> evalTags(List<String> tagNames){
		List<Tag> tags = new ArrayList<Tag>();
		
		for(String names: tagNames){
			Tag tg = tagDao.getTagByName(names);
			System.out.println(tg.getName());
			tags.add(tg);
		}
		
		return tags;
	}
	
	private TagDao tagDao;
	private GenreDao genreDao;
}
