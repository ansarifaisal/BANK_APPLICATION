package com.project.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	Configuration configuration = null;
	SessionFactory sessionFactory = null;
	Session session = null;
	
	public Session getSession() {
		try {
			// 1. configuring hibernate
			configuration = new Configuration().configure("hibernate.cfg.xml");
			// 2. create sessionfactory
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			return session;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
