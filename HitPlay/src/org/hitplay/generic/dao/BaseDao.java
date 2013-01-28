package org.hitplay.generic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class BaseDao<T> implements IDao<T> {
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//So That Spring Can Inject Our Hibernate's SessionFactory 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Short hand for getCurrentSession() because we're fucking lazy
	public Session sess() {
		return getSessionFactory().getCurrentSession();
	}
	
	public abstract T getById(Long id);

	public abstract T save(T type);

	public abstract T update(T type);

	public abstract void delete(T type);
	
	private SessionFactory sessionFactory;
}
