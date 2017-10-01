package com.project.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.HibernateConfig.HibernateConfig;
import com.project.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	HibernateConfig config = null;
	Session session;
	Transaction transaction;

	private Class<T> entityClass;
	
	public GenericDAOImpl() {
		config = new HibernateConfig();
		session = config.getSession();
		transaction = session.beginTransaction();
		entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		
	}

	@Override
	public List<T> getAll() {
		String HQL = "FROM " + entityClass.getName();
		Query query = session.createQuery(HQL);
		List<T> list = query.list();
		return list;
	}

	@Override
	public boolean add(T t) {
		try {
			session.save(t);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean edit(T t) {
		try {
			session.update(t);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean delete(T t) {
		try {
			session.delete(t);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public T get(Object id) {
		T t = (T) session.get(entityClass, (Serializable) id);
		return t;
	}

}
