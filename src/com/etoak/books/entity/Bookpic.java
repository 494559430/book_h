package com.etoak.books.entity;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Bookpic {
    private String id;
    private String savepath;
    private String showname;
    private Integer fm;
//-----------------------------

    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    //-----------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public Integer getFm() {
        return fm;
    }

    public void setFm(Integer fm) {
        this.fm = fm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bookpic bookpic = (Bookpic) o;

        if (id != null ? !id.equals(bookpic.id) : bookpic.id != null) return false;
        if (savepath != null ? !savepath.equals(bookpic.savepath) : bookpic.savepath != null) return false;
        if (showname != null ? !showname.equals(bookpic.showname) : bookpic.showname != null) return false;
        if (fm != null ? !fm.equals(bookpic.fm) : bookpic.fm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (savepath != null ? savepath.hashCode() : 0);
        result = 31 * result + (showname != null ? showname.hashCode() : 0);
        result = 31 * result + (fm != null ? fm.hashCode() : 0);
        return result;
    }
}
