package com.etoak.books.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/10/12.
 */
public class Book {
    private String id;
    private String name;
    private Integer price;
    private String author;
    private Timestamp publishdate;
    private Integer status;
    private Integer del;

    private String pdate;

    public String getPdate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(publishdate);

    }



    //--------------------------
    private Category ca;

    public Category getCa() {
        return ca;
    }

    public void setCa(Category ca) {
        this.ca = ca;
    }

    private Set<Bookpic> bps = new HashSet<>();

    public Set<Bookpic> getBps() {
        return bps;
    }

    public void setBps(Set<Bookpic> bps) {
        this.bps = bps;
    }

    //--------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Timestamp publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (publishdate != null ? !publishdate.equals(book.publishdate) : book.publishdate != null) return false;
        if (status != null ? !status.equals(book.status) : book.status != null) return false;
        if (del != null ? !del.equals(book.del) : book.del != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishdate != null ? publishdate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (del != null ? del.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", publishdate=" + publishdate +
                ", status=" + status +
                ", del=" + del +
                ", pdate='" + pdate + '\'' +
                ", ca=" + ca +
                ", bps=" + bps +
                '}';
    }
}
