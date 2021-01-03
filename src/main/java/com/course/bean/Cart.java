package com.course.bean;

public class Cart {
    private Integer cid;
    private Integer uid;
    private Integer gid;
    private Integer num;

    public Cart() {

    }

    public Cart(Integer cid, Integer uid, Integer gid, Integer num) {
        this.cid = cid;
        this.uid = uid;
        this.gid = gid;
        this.num = num;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", num=" + num +
                '}';
    }
}
