package com.course.bean;

import java.io.Serializable;
import java.util.Date;

public class Good implements Serializable {
    private Integer gid;
    private String gname;
    private double price;
    private Integer stock;
    private String category;
    private String picture;
    private Date enterdate;

    public Good() {

    }

    public Good(Integer gid, String gname, double price, Integer stock, String category, String picture, Date enterdate) {
        this.gid = gid;
        this.gname = gname;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.picture = picture;
        this.enterdate = enterdate;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    @Override
    public String toString() {
        return "Good{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                ", enterdate=" + enterdate +
                ", picture=" + picture +
                '}';
    }

    public String getPicture() {
        return picture;
    }


    public void setPicture(String picture) {
        this.picture = picture;
    }
}
