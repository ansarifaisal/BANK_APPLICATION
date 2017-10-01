package com.project.dao;

import java.util.List;

public interface GenericDAO<T> {

	List<T> getAll();
	
	T get(Object id);
	
	boolean add(T t);
	
	boolean edit(T t);
	
	boolean delete(T t);
	
}
