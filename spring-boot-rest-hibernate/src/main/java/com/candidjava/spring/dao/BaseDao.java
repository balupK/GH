package com.candidjava.spring.dao;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

	public Blob createBlobObject(MultipartFile file) throws IOException;
}
