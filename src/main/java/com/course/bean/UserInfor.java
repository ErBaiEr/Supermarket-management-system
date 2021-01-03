package com.course.bean;

public class UserInfor {
    private User user;
    private Good good;
    private Integer num;

    public UserInfor() {
    }

    public UserInfor(User user, Good good, Integer num) {
        this.user = user;
        this.good = good;
        this.num = num;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "UserInfor{" +
                "user=" + user +
                ", good=" + good +
                ", num=" + num +
                '}';
    }
}
