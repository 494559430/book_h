package com.etoak.books.dao;




import java.io.Serializable;
import java.util.List;





public interface IDao<T> {
	public void add(T t);
	public T queryById(Class<T> cls, Serializable id);
	public List<T> queryAll(Class<T> class1);
	public void update(T p);
	public T queryOneByHql(String hql);

    int countByHql(String hql);

	List<T> querySomeByHql(String hql, int start, int pageSize);

    void delete(T bookpic);
}
