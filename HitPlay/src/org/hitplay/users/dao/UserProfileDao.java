package org.hitplay.users.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hitplay.generic.dao.*;
import org.hitplay.user.dto.UserProfile;


public class UserProfileDao extends BaseDao<UserProfile>{

	@Override
	public UserProfile getById(Long id) {
		return (UserProfile)sess().get(UserProfile.class, id);
	}

	@Override
	public UserProfile save(UserProfile type) {
		Long id = (Long)sess().save(type);
		return getById(id);
	}

	@Override
	public UserProfile update(UserProfile type) {
		  sess().update(type);
		 return getById(type.getProfileId());
	}
	
	@Override
	public void delete(UserProfile type) {
		// TODO Auto-generated method stub	
	}
	
	
	/*
	 * @param length - length of profiles to get;
	 * @param start - what row to start to retreive the result;
	 */
	public List<UserProfile> findByName(String name, int start, int length) {
		String temp_name = "%" + name + "%";
//		Query query =  sess().createQuery(
//				"from UserProfile where firstName  LIKE :temp_name OR lastName LIKE :temp_name" );
//		query.setParameter("temp_name",temp_name);
//		query.setFirstResult(start);
//		query.setMaxResults(length);
//		if(start != 0){ start = start * length; }

		Criteria criteria = sess().createCriteria(UserProfile.class);
		criteria.addOrder(Order.asc("profileId"));
		criteria.setFirstResult(start * length);
        criteria.setMaxResults(length);
		criteria.add( Restrictions.or(
				Restrictions.like("firstName", temp_name),
				Restrictions.like("lastName", temp_name)
		    ) );
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		return (List<UserProfile>) criteria.list();
	}
	
	public int countFindByName(String name, int start, int length) {
		String temp_name = "%" + name + "%";
		
		Criteria criteria = sess().createCriteria(UserProfile.class);
		criteria.add( Restrictions.or(
				Restrictions.like("firstName", temp_name),
				Restrictions.like("lastName", temp_name)
		    ) );
		
		List<UserProfile> totalRowCount = (List<UserProfile>) criteria.list();
		int countSize = totalRowCount.size() ;
		System.out.println("The number is int....."  + countSize);
		
		
		return countSize;
	
	}
	
	private int countResult(Query query){
		return query.list().size();
	}
}