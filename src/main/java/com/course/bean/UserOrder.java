package com.course.bean;

import java.util.List;

public class UserOrder {
    private List<Sale> sale;
    private double num;

    public UserOrder() {

    }

    public UserOrder(List<Sale> sale, double num) {
        this.sale = sale;
        this.num = num;
    }

    public List<Sale> getSale() {
        return sale;
    }

    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "sale=" + sale +
                ", num=" + num +
                '}';
    }
}
