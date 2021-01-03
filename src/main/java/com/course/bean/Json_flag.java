package com.course.bean;

public class Json_flag {
    private Integer flag;

    public Json_flag() {
    }

    public Json_flag(Integer flag) {
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Json_flag{" +
                "flag=" + flag +
                '}';
    }
}
