package com.course.bean;

import java.util.Date;

public class Sale {
    private Integer sid;
    private Integer uid;
    private String rname;
    private String gname;
    private String phone;
    private String raddress;
    private String remail;
    private Date saledate;

    public Sale() {

    }

    public Sale(Integer sid, Integer uid, String rname, String gname, String phone, String raddress, String remail, Date saledate) {
        this.sid = sid;
        this.uid = uid;
        this.rname = rname;
        this.gname = gname;
        this.phone = phone;
        this.raddress = raddress;
        this.remail = remail;
        this.saledate = saledate;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRemail() {
        return remail;
    }

    public void setRemail(String remail) {
        this.remail = remail;
    }

    public Date getSaledate() {
        return saledate;
    }

    public void setSaledate(Date saledate) {
        this.saledate = saledate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "sid=" + sid +
                ", rname='" + rname + '\'' +
                ", gname='" + gname + '\'' +
                ", phone='" + phone + '\'' +
                ", raddress='" + raddress + '\'' +
                ", remail='" + remail + '\'' +
                ", saledate=" + saledate +
                '}';
    }
}
