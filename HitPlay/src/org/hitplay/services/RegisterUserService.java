package org.hitplay.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.hitplay.user.dto.User;
import org.hitplay.user.dto.UserProfile;
import org.hitplay.users.dao.UserDao;
import org.hitplay.users.dao.UserProfileDao;
import org.springframework.transaction.annotation.Transactional;
import org.hitplay.password.util.PasswordHash;

@Transactional
public class RegisterUserService {

	private UserDao userDao;
	private UserProfileDao userProfileDao;
	
	public User registerUser(User user,UserProfile userProfile){
		user.setUserProfile(userProfile);
		String password = user.getPassword();
		try {
			String hashSaltedPassword = PasswordHash.createHash(password);
			user.setPassword(hashSaltedPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		User u= userDao.save(user);
		userProfileDao.save(userProfile);
		return userDao.save(user);
	}
	
	public boolean exists(String username){
		User user = userDao.getUserByUsername(username);
		
		return (user != null);
	}
	
	public boolean emailExist(String email){
		User user = userDao.findByEmail(email);
		
		return (user != null);
	}
	
	public UserProfileDao getUserProfileDao() {
		return userProfileDao;
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

}
