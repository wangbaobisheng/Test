package com.huawei.wanbao.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory ;
	static
	{
		
		Configuration cfg = new Configuration();		
		cfg.configure("hibernate.cfg.xml");		
		sessionFactory = cfg.buildSessionFactory();		
	}
	
	public static void main(String[] args)
	{
		//testSave();
		testGet();
	}
	/**
	 * 保存
	 */
	public static void testSave()
	{
		User user = new User();
		user.setName("zhangsan");
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	public static void testGet()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, 1);
		tx.commit();
		System.out.println(user.toString());
	}
}
