package org.hitplay.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.hitplay.password.util.PasswordHash;
import org.hitplay.user.dto.User;
import org.hitplay.users.dao.UserDao;
import org.hitplay.validations.Validatable;
import org.hitplay.admin.dao.AdminDao;
import org.hitplay.admin.dto.Administrator;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AuthenticateLoginService {

	
	public User isValid(User user) {
		if(user == null)
			return user;
		
		User db_user = userDao.getUserByUsername(user.getUsername());
		if (db_user != null) {
			try {
				if (PasswordHash.validatePassword(user.getPassword(),db_user.getPassword())) {
					return db_user;
				}
			} catch(Exception e){ e.printStackTrace(); }
		}

		return null;
	}
	
	public Administrator isValid(Administrator admin){
		if(admin == null)
			return admin;

		Administrator db_admin = adminDao.getAdminByUsername(admin.getUsername());
		if(db_admin != null){
			try{
				if (admin.getPassword().equals(db_admin.getPassword())) {
					return db_admin;
				}
			}catch(Exception e){ e.printStackTrace(); }
		}
		
		return null;
	}
	
	/*
	public Validatable isValid(Validatable user){
		if(user == null)
			return user;

		Validatable db_user = adminDao.getAdminByUsername(user.getUsername());
		if(db_user != null){
			try{
				if (PasswordHash.validatePassword(user.getPassword(),db_user.getPassword())) {
					return db_user;
				}
			}catch(Exception e){ e.printStackTrace(); }
		}
		
		return null;
	}*/
	
	private Validatable getValidatable(Validatable object){
		if(object instanceof Administrator) return adminDao.getAdminByUsername(object.getUsername());
		if(object instanceof User) return userDao.getUserByUsername(object.getUsername());
		return object;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public AdminDao getAdminDao() {
		return adminDao;
	}


	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	private UserDao userDao;
	private AdminDao adminDao;
}
