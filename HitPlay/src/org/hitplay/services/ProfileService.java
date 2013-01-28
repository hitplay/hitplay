package org.hitplay.services;

import java.util.List;

import org.hitplay.user.dto.UserProfile;
import org.hitplay.users.dao.UserProfileDao;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ProfileService {
	
	public void updateProfile(UserProfile profile){
		userProfileDao.update(profile);
	}

	
	public UserProfile getProfile(Long id){
		return  userProfileDao.getById(id);
	}
		
	public UserProfileDao getUserProfileDao() {
		return userProfileDao;
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}
	
	public List<UserProfile> searchProfiles(String name, int firstResult, int maxResult){
		return userProfileDao.findByName(name, firstResult, maxResult);
	}
	
	public int countSearchProfiles(String name, int firstResult, int maxResult){
		return userProfileDao.countFindByName(name, firstResult, maxResult);
	}
	
	
	private UserProfileDao userProfileDao;
}
