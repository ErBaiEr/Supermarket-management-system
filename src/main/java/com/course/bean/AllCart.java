package com.course.bean;

public class AllCart {
    private Integer uid;
    private String uname;
    private Integer gid;
    private String gname;
    private Integer num;

    public AllCart() {
    }

    public AllCart(Integer uid, String uname, Integer gid, String gname, Integer num) {
        this.uid = uid;
        this.uname = uname;
        this.gid = gid;
        this.gname = gname;
        this.num = num;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "AllCart{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", num=" + num +
                '}';
    }
}
