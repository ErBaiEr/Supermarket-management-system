package com.course.Dao;

import com.course.bean.User;
import com.course.utils.DatabaseUtils;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    public Integer AddUser(User user) {
        String sql = "insert into user(uname, email, password, address, type) " +
                "values(?, ?, ?, ?, ?)";
        return DatabaseUtils.Add(sql, user.getUname(), user.getEmail(), user.getPassword(), user.getAddress(), user.getType());
    }

    public User SeekUser(String username, String password){
        User user_1 = null;
        User user_2 = null;

        String sql = "SELECT uid, uname, email, address, password, type FROM user WHERE uname = ? AND password = ?";
        String sql_1 = "SELECT uid, uname, email, address, password, type FROM user WHERE email = ? AND password = ?";
        user_1 = DatabaseUtils.getUser(sql, username, password);
        user_2 = DatabaseUtils.getUser(sql_1, username, password);
        if (user_1 != null && user_1.getUid() != null){
            return user_1;
        }else if (user_2 != null && user_2.getUid() != null){
            return user_2;
        }

        return null;
    }

    public String GetUname(Integer uid){
        String sql = "SELECT uname FROM user WHERE uid = ?";
        return DatabaseUtils.GetUnameByUid(sql, uid);
    }

    public List<User> GetAllUser(){
        String sql = "SELECT uid, uname, email, address, password, type FROM user";
        return DatabaseUtils.GetAllUser(sql);
    }

    public Boolean DelUser(Integer uid){
        String sql = "DELETE FROM user WHERE uid = ?";
        return DatabaseUtils.DelUser(sql,uid);
    }

    public Boolean UpdateUser(Integer uid, String uname, String email, String password, String address){
        String sql = "UPDATE user SET uname = ?, email = ?, password = ?, address = ? WHERE uid = ?";
        return DatabaseUtils.UpdateUser(sql,uname,email,password,address,uid);
    }

    public Boolean Seek_Email(String email){
        String sql = "SELECT uid FROM user WHERE email = ?";
        return DatabaseUtils.Seek_email(sql,email);
    }
}
