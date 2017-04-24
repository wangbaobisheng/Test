package com.huawei.wanbao.testDao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.huawei.wanbao.test.User;

public class UserDao {

	/**
	 * 保存
	 * @param user
	 */
	public void save(User user)
	{
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(user);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
		
	}
	
	/**
	 * 更新
	 * @param user
	 */
	public void update(User user)
	{
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.update(user);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}	
	}
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id)
	{
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			Object user = session.get(User.class, id);
			session.delete(user);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public User getById(int id)
	{
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		try
		{
			//session.createCriteria(arg0)
			user = (User) session.get(User.class, id);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
		
		return user;
	}
	
	/**
	 * 查询所有的
	 * @return
	 */
	public List<User> findAll()
	{
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			List<User> list = session.createQuery("from User").list();
			tx.commit();
			return list;
		}
		catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * 查询部分，分页
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public QueryResult findAll(int firstResult, int maxResults)
	{
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			Query query = session.createQuery("from User");
			query.setFirstResult(firstResult);
			query.setMaxResults(maxResults);
			List<User> list = query.list();
			Long total = (Long) session.createQuery("select count(*) from User").uniqueResult();
			
			tx.commit();
			return new QueryResult(total.intValue(), list);
		}
		catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getByIdCriteria(int id)
	{
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		try
		{
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("id", id));
			//criteria.add(Restrictions.ge("id", 2));
			user =  (User) criteria.uniqueResult();
			//System.out.println(lists);
			//user = (User) session.get(User.class, id);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		finally
		{
			session.close();
		}
		
		return user;
	}
}
