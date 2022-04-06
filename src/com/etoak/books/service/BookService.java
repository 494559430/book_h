package com.etoak.books.service;

import com.etoak.books.dao.DaoImpl;
import com.etoak.books.dao.IDao;
import com.etoak.books.entity.Book;
import com.etoak.books.entity.Bookpic;
import com.etoak.books.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2018/10/13.
 */
public class BookService {
    IDao<Category> dao1 = new DaoImpl<>();
    IDao<Book> dao2 = new DaoImpl<>();
    IDao<Bookpic> dao3 = new DaoImpl<>();


    public void addca(Category ca) {
        dao1.add(ca);
    }

    public List<Category> queryAllCas() {
        return dao1.queryAll(Category.class);
    }

    public String addbook(Book book) {
        dao2.add(book);
        return book.getId();
    }

    public void addbookpic(Bookpic bookpic) {
        dao3.add(bookpic);
    }

    public int countBook(String name, String caid) {
        String hql = "select count(*) from Book b where 1 = 1";
        if (name!=null){
            hql+= " and name like '%"+name + "%'";
        }
        if (caid!=null){
            hql+= " and ca.id ="+caid ;
        }
        return dao2.countByHql(hql);
    }

    public List<Book> querySome(String name, String caid, int start, int pageSize) {
        String hql = "select b from Book b where 1 = 1";
        if (name!=null){
            hql+= " and name like '%"+name + "%'";
        }
        if (caid!=null){
            hql+= " and ca.id ="+caid ;
        }

        return dao2.querySomeByHql(hql,start,pageSize);
    }

    public void update(Book book) {
        dao2.update(book);
    }
}
