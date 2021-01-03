package com.course.utils;

import com.course.bean.Cart;
import com.course.bean.Good;
import com.course.bean.Sale;
import com.course.bean.User;
import com.course.databaseconn.DatabaseConnection;
import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtils {

    public static Integer Add(String sql, Object ...args) {
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;

        try {
            ps = conn.getConn().prepareStatement(sql);

            if(args != null &&args.length > 0){
                for (int i = 0; i < args.length; i++){
                    ps.setObject(i+1, args[i]);
                }
            }

            count = ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException throwables) {
                throwables.printStackTrace();
        }

        if (count == null){
            return 0;
        }else
            return count;
    }

    /*public static boolean AddSale(String sql, Integer uid, String rname, String gname, String phone, String raddress, String remail, java.util.Date saledate){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer count = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public static User getUser(String sql,String info, String password){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        User user = new User();

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setString(1,info);
            ps.setString(2,password);

            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                user.setUid(resultSet.getInt(1));
                user.setUname(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setAddress(resultSet.getString(5));
                user.setType(resultSet.getInt(6));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public static Good getGood(String sql, Integer gid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Good good = new Good();

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,gid);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                good.setGid(resultSet.getInt(1));
                good.setGname(resultSet.getString(2));
                good.setPrice(resultSet.getDouble(3));
                good.setStock(resultSet.getInt(4));
                good.setCategory(resultSet.getString(5));
                good.setPicture(resultSet.getString(6));
                good.setEnterdate(DateUtils.format(resultSet.getDate(7)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return good;
    }

    public static <T> List<T> getAll(String sql, Class<T> clazz){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = null;

        try {
            ps = conn.getConn().prepareStatement(sql);

            rs = ps.executeQuery();
            //获取结果集
            ResultSetMetaData rsmd =rs.getMetaData();
            //获取列数
            int colnum = rsmd.getColumnCount();
            list = new ArrayList<>();

            //获取数据放入list
            while (rs.next()){
                Map<String,Object> rowMap = new HashMap<String,Object>();
                for (int i = 1; i<= colnum; i++){
                    String columnName = rsmd.getColumnLabel(i);
                    Object columValue = rs.getObject(columnName);

                    if (columValue instanceof java.sql.Date){
                        java.sql.Date date = (java.sql.Date)columValue;
                        columValue = new Date(date.getTime());
                    }

                    rowMap.put(columnName,columValue);
                }

                T bean = clazz.newInstance();

                for (Map.Entry<String,Object> entry : rowMap.entrySet()){
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                }

                list.add(bean);
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static Integer getCount(String sql){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer count = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
                count = rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }

    public static Cart getCart(String sql, Integer uid, Integer gid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Cart cart = new Cart();
        ResultSet rs = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,gid);
            ps.setInt(2,uid);
            rs = ps.executeQuery();
            if (rs.next()){
                cart.setCid(rs.getInt(1));
                cart.setUid(rs.getInt(2));
                cart.setGid(rs.getInt(3));
                cart.setNum(rs.getInt(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cart;
    }

    public static boolean updateCart(String sql, Integer gid, Integer uid, Integer count){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer flag = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,count);
            ps.setInt(2,gid);
            ps.setInt(3,uid);
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag>0?true:false;
    }

    public static boolean insertCart(String sql, Integer gid, Integer uid, Integer count){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer flag = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,gid);
            ps.setInt(3,count);
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag>0?true:false;
    }

    public static List<Cart> getUserAllCart(String sql, Integer uid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cart> list = new ArrayList<Cart>();

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,uid);
            rs = ps.executeQuery();
            while (rs.next()){
                Cart cart = new Cart();
                cart.setCid(rs.getInt(1));
                cart.setUid(rs.getInt(2));
                cart.setGid(rs.getInt(3));
                cart.setNum(rs.getInt(4));
                list.add(cart);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static boolean DelCart(String sql, Integer cid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer flag = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,cid);
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag>0?true:false;
    }

    public static Integer GetCid(String sql, Integer uid, Integer gid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        Integer flag = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,gid);
            rs = ps.executeQuery();
            if (rs.next()){
                flag = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }

    public static List<Sale> getAll(String sql, Integer uid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        List<Sale> list = new ArrayList<Sale>();

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,uid);

            rs = ps.executeQuery();
            while (rs.next()){
                Sale sale = new Sale();
                sale.setSid(rs.getInt(1));
                sale.setUid(rs.getInt(2));
                sale.setRname(rs.getString(3));
                sale.setGname(rs.getString(4));
                sale.setPhone(rs.getString(5));
                sale.setRaddress(rs.getString(6));
                sale.setRemail(rs.getString(7));
                DateUtils dateUtils = new DateUtils();
                sale.setSaledate(dateUtils.format(rs.getDate(8)));
                list.add(sale);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static List<Sale> getAllSale(String sql){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        List<Sale> list = new ArrayList<Sale>();

        try {
            ps = conn.getConn().prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()){
                Sale sale = new Sale();
                sale.setSid(rs.getInt(1));
                sale.setUid(rs.getInt(2));
                sale.setRname(rs.getString(3));
                sale.setGname(rs.getString(4));
                sale.setPhone(rs.getString(5));
                sale.setRaddress(rs.getString(6));
                sale.setRemail(rs.getString(7));
                DateUtils dateUtils = new DateUtils();
                sale.setSaledate(dateUtils.format(rs.getDate(8)));
                list.add(sale);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static String GetUnameByUid(String sql, Integer uid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        String uname = null;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,uid);
            rs = ps.executeQuery();
            if(rs.next()){
                uname = rs.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return uname;
    }

    public static List<User> GetAllUser(String sql){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        List<User> list = new ArrayList<User>();

        try {
            ps = conn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setUname(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setAddress(rs.getString(4));
                user.setPassword(rs.getString(5));
                user.setType(rs.getInt(6));
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static Boolean DelUser(String sql,Integer uid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer flag = 0;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,uid);
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag>0?true:false;
    }

    public static Boolean UpdateUser(String sql, String uname, String email, String password, String address, Integer uid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer flag = 0;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,address);
            ps.setInt(5,uid);
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag>0?true:false;
    }

    public static List<Good> GetAllGood(String sql){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        List<Good> list = new ArrayList<Good>();

        try {
            ps = conn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Good good = new Good();
                good.setGid(rs.getInt(1));
                good.setGname(rs.getString(2));
                good.setPrice(rs.getDouble(3));
                good.setStock(rs.getInt(4));
                good.setCategory(rs.getString(5));
                good.setPicture(rs.getString(6));
                good.setEnterdate(rs.getDate(7));
                list.add(good);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static Boolean UpdateGood(String sql, String gname, Double price, Integer stock, String category, String picture, java.util.Date enterdate, Integer gid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer flag = 0;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setString(1,gname);
            ps.setDouble(2,price);
            ps.setInt(3,stock);
            ps.setString(4,category);
            ps.setString(5,picture);
            ps.setDate(6, DateUtils.format(enterdate));
            ps.setInt(7,gid);
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag>0?true:false;
    }

    public static Boolean DelGood(String sql, Integer gid){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        Integer flag = 0;
        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setInt(1,gid);
            flag = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag>0?true:false;
    }

    public static List<Cart> getAllCart(String sql){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Cart> list = new ArrayList<Cart>();

        try {
            ps = conn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Cart cart = new Cart();
                cart.setCid(rs.getInt(1));
                cart.setUid(rs.getInt(2));
                cart.setGid(rs.getInt(3));
                cart.setNum(rs.getInt(4));
                list.add(cart);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static Boolean Seek_email(String sql, String email){
        DatabaseConnection conn = new DatabaseConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer flag = 0;

        try {
            ps = conn.getConn().prepareStatement(sql);
            ps.setString(1,email);
            rs = ps.executeQuery();
            while (rs.next()){
                flag = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag <= 0? true:false;
    }
}
