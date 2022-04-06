package com.etoak.books.dao;

import java.io.Serializable;
import java.util.List;


import com.etoak.commons.factory.SF;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DaoImpl<T> implements IDao<T> {
	Session session = null;
	Transaction tx = null;
	@Override
	public void add(T t) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			session.save(t);
			//t 
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();
		}finally{
			if(session!=null)session.close();
		}
	}
	@Override
	public T queryById(Class<T> cls, Serializable id) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			T t = (T)session.get(cls,id);
			//t  /持久化
			tx.commit();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();
			return null;
		}finally{
			if(session!=null)session.close();
		}
		
		
	}
	@Override
	public List<T> queryAll(Class<T> class1) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			List<T> data = session.createCriteria(class1).list();
			tx.commit();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();
			return null;
		}finally{
			if(session!=null)session.close();
		}
	}
	@Override
	public void update(T t) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			session.update(t);
			//t 
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();
		}finally{
			if(session!=null)session.close();
		}
	}
	@Override
	public T queryOneByHql(String hql) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			T t = (T)session.createQuery(hql).uniqueResult();
			tx.commit();
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();return null;
		}finally{
			if(session!=null)session.close();
		}
	}

	@Override
	public int countByHql(String hql) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			Object v  = session.createQuery(hql).uniqueResult();
			tx.commit();
			return Integer.parseInt(v+"");
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();return 0;
		}finally{
			if(session!=null)session.close();
		}
	}

	@Override
	public List<T> querySomeByHql(String hql, int start, int pageSize) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			List<T> data = session.createQuery(hql).setFirstResult(start)
					.setMaxResults(pageSize).list();

			tx.commit();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();return null;
		}finally{
			if(session!=null)session.close();
		}
	}

	@Override
	public void delete(T t) {
		try {
			session = SF.getSession();
			tx = session.beginTransaction();
			session.delete(t);
			//t
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)tx.rollback();
		}finally{
			if(session!=null)session.close();
		}
	}

}
