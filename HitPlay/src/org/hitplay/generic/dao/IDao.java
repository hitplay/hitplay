package org.hitplay.generic.dao;

public interface IDao<T> {
	T getById(Long id);

	T save(T type);

	T update(T type);

	void delete(T type);
}
