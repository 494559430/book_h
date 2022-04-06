package com.etoak.books.action;

import com.etoak.books.entity.Book;
import com.etoak.books.entity.Bookpic;
import com.etoak.books.entity.Category;
import com.etoak.books.service.BookService;
import com.etoak.commons.page.Page;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Administrator on 2018/10/13.
 */
public class BookAction {
    private String name;
    BookService bs = new BookService();
    public void setName(String name) {
        this.name = name;
        if (name.equals(""))
            this.name=null;
    }

    public String addca(){
        Category ca = new Category();
        ca.setName(name);
        bs.addca(ca);
        return "addca_suc";
    }

    private List<Category> cas;

    public List<Category> getCas() {
        return cas;
    }
    public String queryAllCas() {
        cas=bs.queryAllCas();
        return "queryca_suc";
    }
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    private File[] pic;
    private String[] picFileName;
    private int fm;

    public void setPic(File[] pic) {
        this.pic = pic;
    }

    public void setPicFileName(String[] picFileName) {
        this.picFileName = picFileName;
    }

    public void setFm(int fm) {
        this.fm = fm;
    }

    public String addbook(){
        String id = bs.addbook(book);
        for (int i =0;i<pic.length;i++){
            File f = pic[i];
            String fileName = picFileName[i];
            String newName = UUID.randomUUID().toString().replaceAll("-","");
            ServletContext application = ServletActionContext.getServletContext();
            String path = application.getRealPath("/image/"+newName);
            try {
                OutputStream os = new FileOutputStream(path);
                FileUtils.copyFile(f,os);
                os.close();

                Bookpic bookpic = new Bookpic();
                bookpic.setSavepath("/image/"+newName);
                bookpic.setShowname(newName);

                if (i==fm){
                    bookpic.setFm(1);
                }else {
                    bookpic.setFm(0);
                }
                bookpic.setBook(book);
                bs.addbookpic(bookpic);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return "addbook_suc";
    }

    private Page<Book> page;

    public Page<Book> getPage() {
        return page;
    }
    private String caid;

    public void setCaid(String caid) {
        this.caid = caid;
        if (caid.equals("-1")||caid.equals(""))
            this.caid=null;
    }
    private int pageNumber;

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    private int pageSize;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String querySome(){
        page = new Page<Book>();
        page.setPageNumber(pageNumber);
        page.setPageSize(pageSize);
        int count = bs.countBook(name,caid);
        page.setTotal(count);

        List<Book> list = bs.querySome(name,caid,page.getStart(),page.getPageSize());
        page.setRows(list);

        return "querySome_suc";
    }
    public String updateBook(){
        System.out.println(book);
        bs.update(book);
        return "update_suc";
    }
}
