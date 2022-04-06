package com.etoak.commons.page;

import java.util.List;

//该类是用来分页的组件
public class Page<T> {
    private int pageNumber; //当前页
    private int total;      //总记录
    private int pageSize=3; //每页的条数
        private int pageCount;  //总页数
        private int pre;        //上一页
        private int next;       //下一页
        private int start;       //每页的起始位置 (pageNumber-1)*pageSize
    private List<T> rows;       //显示数据

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageCount() {
        return (total+pageSize-1)/pageSize;
    }
    public int getPre() {
        if(pageNumber>1) {
            return pageNumber - 1;
        }return 1;
    }
    public int getNext() {
        if(pageNumber<getPageCount()) {
            return pageNumber + 1;
        }return getPageCount();
    }
    public int getStart() {
        return (pageNumber-1)*pageSize;
    }
    //是否是最后一页
    public boolean isLast(){
        return pageNumber==getPageCount();
    }
    //是否是第一页
    public boolean isFirst(){
        return pageNumber==1;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
