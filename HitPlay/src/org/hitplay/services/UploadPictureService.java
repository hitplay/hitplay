package org.hitplay.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.hitplay.password.util.PasswordHash;
import org.hitplay.user.dto.Picture;
import org.hitplay.user.dto.User;
import org.hitplay.user.dto.UserProfile;
import org.hitplay.users.dao.PictureDao;
import org.hitplay.users.dao.UserProfileDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UploadPictureService {
	
	private UserProfileDao userProfileDao;
	private PictureDao pictureDao;
	
	public Picture uploadPicture(UserProfile userProfile,Picture picture){
		userProfile.setPicture(picture);
		userProfileDao.update(userProfile);
		return pictureDao.save(picture);
	}
	
	public void updatePicture(Picture picture){
		pictureDao.update(picture);
	}
	
	public Picture getPicture(Long id){
		return  pictureDao.getById(id);
	}
		
	public PictureDao getPictureDao() {
		return pictureDao;
	}

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}
	
	public UserProfileDao getUserProfileDao() {
		return userProfileDao;
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}

}