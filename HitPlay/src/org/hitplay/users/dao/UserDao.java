package org.hitplay.users.dao;
import java.util.ArrayList;
import java.util.List;

import org.hitplay.generic.dao.*;
import org.hitplay.user.dto.User;

public class UserDao extends BaseDao<User>{
		
	@Override
	public User getById(Long id) {
		/* load() load will return an exception if the row does not exist
		*   get() will return a null if the row does not exist
		*/
		return (User) sess().get(User.class, id);
	}

	@Override
	public User save(User type) {
		Long id = (Long)sess().save(type);
		return getById(id);
	}

	@Override
	public User update(User type) {
		sess().update(type);
		return type;
	}

	@Override
	public void delete(User type) {
		//Uhmm should we delete in the database? NOBOODY KNOWS~! but for fucls sake here's the impl
		sess().delete(type);
	}
	
	/*
	 * @param  - username of the account to looked 
	 * @return - returns the result as a User object, returns null 
	 * 			 if the User does not exist;
	 */
	public User getUserByUsername(String username) {
	return	(User)sess().createQuery(
				"from User where username = :user_name")
				.setParameter("user_name", username).uniqueResult();
	}
	
	public User findByEmail(String email){
		return	(User)sess().createQuery(
				"from User where email = :user_email")
				.setParameter("user_email", email).uniqueResult();
	}
}
