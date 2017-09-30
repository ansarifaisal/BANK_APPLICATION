package com.project.HibernateConfig;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

	public SessionFactory getSessionFactory() {
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
