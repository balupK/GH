package com.candidjava.spring.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends GenericDao> {

	/*void add(T object);
	List<T> getUser(T object);
	T findById(T object, int id);
	T update(T object, int id);
	T updateCountry(T object, int id);
	void delete(T object, int id);
	List<T> getAll(T object);*/
	public T get(Long id);

	public T get(String id);

	public List<T> getAll();

	public void save(T object);

	public void update(T object);

	public void saveOrUpdate(T object);

	public void delete(T object);

	public Serializable saveObject(T object);
}
