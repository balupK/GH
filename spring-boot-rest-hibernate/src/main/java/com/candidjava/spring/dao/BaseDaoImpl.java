package com.candidjava.spring.dao;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
@Repository
public abstract class BaseDaoImpl<T extends GenericDao> extends HibernateDaoSupport  implements BaseDao<T> {

	public BaseDaoImpl(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}

	protected abstract Class<T> getEntityClass();

	@Override
	public T get(Long id) {
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}

	@Override
	public T get(String id) {
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}

	@Override
	public List<T> getAll() {
		return  getHibernateTemplate().loadAll(getEntityClass());
	}

	@Override
	public void save(T object) {
		getHibernateTemplate().save(object);
	}

	@Override
	public Serializable saveObject(T object) {
		return getHibernateTemplate().save(object);
	}

	@Override
	public void update(T object) {
		getHibernateTemplate().update(object);
	}

	@Override
	public void saveOrUpdate(T object) {
		getHibernateTemplate().saveOrUpdate(object);
	}

	@Override
	public void delete(T object) {
		getHibernateTemplate().delete(object);
	}

	@Override
	protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		return super.createHibernateTemplate(sessionFactory);
	}

	@Override
	public Blob createBlobObject(MultipartFile file) throws IOException {
		Blob blob = Hibernate.getLobCreator(currentSession()).createBlob(file.getInputStream(), file.getSize());
		return blob;
	}





	/*@Override
	public void add(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.save(object);
	}

	@Override
	public List<T> getUser(T object) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<T> list = session.createCriteria(object.getClass()).list();
		return list;
	}

	@Override
	public T findById(T object, int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		T sobject=(T) session.get(object.getClass(),id);
		return sobject;
	}

	@Override
	public T update(T object, int id) {
		Session session = sessionFactory.getCurrentSession();
		session.update(object);
		return object;
	}

	@Override
	public T updateCountry(T object, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T object, int id) {
		Session session = sessionFactory.getCurrentSession();
		T object1 = findById(object, id);
		session.delete(object1);
	}

	@Override
	public List<T> getAll(T object) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<T> list = session.createCriteria(object.getClass()).list();
		return list;
	}*/

}
