package com.course.bean;

import java.util.List;

public class AllOrder {
    private Sale list;
    private String name;

    public AllOrder() {
    }

    public AllOrder(Sale list, String name) {
        this.list = list;
        this.name = name;
    }

    public Sale getList() {
        return list;
    }

    public void setList(Sale list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AllOrder{" +
                "list=" + list +
                ", name='" + name + '\'' +
                '}';
    }
}
