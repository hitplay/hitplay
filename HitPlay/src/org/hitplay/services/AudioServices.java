package org.hitplay.services;

import java.util.List;

import org.hitplay.audio.dao.AudioDao;
import org.hitplay.audio.dto.Audio;
import org.hitplay.audio.dto.Tag;
import org.hitplay.user.dto.UserProfile;
import org.hitplay.users.dao.PictureDao;
import org.hitplay.users.dao.UserProfileDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AudioServices {
	
	public void uploadAudio(UserProfile profile, Audio audio){
		profile.addAudioUpload(audio);
		userProfileDao.update(profile);
		audioDao.save(audio);
	}
	
	public void uploadAudio(UserProfile profile, Audio audio,List<Tag> audioTags){
		
		for(Tag tag: audioTags){
			audio.addTag(tag);
		}
		
		profile.addAudioUpload(audio);
		userProfileDao.update(profile);
		audioDao.save(audio);
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
	
	
	public void setAudioDao(AudioDao audioDao) {
		this.audioDao = audioDao;
	}
	
	private UserProfileDao userProfileDao;
	private PictureDao pictureDao;
	private AudioDao audioDao;
}
