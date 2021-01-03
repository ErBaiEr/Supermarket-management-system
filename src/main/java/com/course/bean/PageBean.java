package com.course.bean;

import java.util.List;

public class PageBean <T>{
    private Integer currentPage;
    private Integer pageSize;
    private Integer beforePage;
    private Integer afterPage;
    private Integer totalRows;
    private Integer totalPages;

    private List<T> list;

    public PageBean(Integer totalRows) {

        this.totalRows = totalRows;
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer beforePage, Integer afterPage, Integer totalRows, Integer totalPages, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.beforePage = beforePage;
        this.afterPage = afterPage;
        this.totalRows = totalRows;
        this.totalPages = totalPages;
        this.list = list;
    }

    //通过当前页、每一页的数据、集合来确定所有
    public PageBean(Integer currentPage, Integer pageSize, Integer totalRows, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
        this.list = list;

        this.totalPages = this.totalRows%this.pageSize==0?this.totalRows/this.pageSize:this.totalRows/this.pageSize+1;
        this.beforePage = this.currentPage-1<=0?1:this.currentPage-1;
        this.afterPage = this.currentPage+1>=this.totalPages?this.totalPages:this.currentPage+1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeforePage() {
        return beforePage;
    }

    public void setBeforePage(Integer beforePage) {
        this.beforePage = beforePage;
    }

    public Integer getAfterPage() {
        return afterPage;
    }

    public void setAfterPage(Integer afterPage) {
        this.afterPage = afterPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", beforePage=" + beforePage +
                ", afterPage=" + afterPage +
                ", totalRows=" + totalRows +
                ", totalPages=" + totalPages +
                ", list=" + list +
                '}';
    }
}
