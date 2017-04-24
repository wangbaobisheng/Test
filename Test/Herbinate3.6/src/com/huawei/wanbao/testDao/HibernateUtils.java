package com.huawei.wanbao.testDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sessionFactory;
	static
	{
		Configuration cfg = new Configuration();
		//读取默认hibernate.cfg.xml文件
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getGetSessionFactory()
	{
		return sessionFactory;
	}
	
	public static Session openSession()
	{
		return sessionFactory.openSession();
	}
}
