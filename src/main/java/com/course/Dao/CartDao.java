package com.course.Dao;

import com.course.bean.Cart;
import com.course.utils.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public boolean insertCart(Integer uid, Integer gid, Integer count){
        Cart cart = new Cart();
        String sql = "SELECT cid, uid, gid, num FROM cart WHERE gid=? AND uid=?";
        String sql_1 = "UPDATE cart SET num = ? WHERE gid = ? AND uid = ?";
        String sql_2 = "INSERT INTO cart(uid, gid, num) VALUES (?, ?, ?)";
        cart = DatabaseUtils.getCart(sql,uid,gid);
        if (cart.getNum()!=null&&cart.getNum()>0) {
            return DatabaseUtils.updateCart(sql_1, gid, uid, cart.getNum() + count);
        } else {
            return DatabaseUtils.insertCart(sql_2, gid, uid, count);
        }
    }

    public List<Cart> getUserCart(Integer uid){
        Cart cart = new Cart();
        List<Cart> list = new ArrayList<Cart>();
        String sql = "SELECT cid, uid, gid, num FROM cart WHERE uid=?";

        list = DatabaseUtils.getUserAllCart(sql, uid);
        return list;
    }

    public boolean DelCart(Integer cid){
        String sql = "DELETE FROM cart WHERE cid = ?";
        return DatabaseUtils.DelCart(sql,cid);
    }

    public Integer GetCid(Integer uid, Integer gid){
        String sql = "SELECT cid FROM cart WHERE uid=? AND gid=?";
        return DatabaseUtils.GetCid(sql,uid,gid);
    }

    public List<Cart> GetAllCart(){
        String sql = "SELECT cid, uid, gid, num FROM cart";
        return DatabaseUtils.getAllCart(sql);
    }
}
