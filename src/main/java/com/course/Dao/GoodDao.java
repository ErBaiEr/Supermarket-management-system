package com.course.Dao;

import com.course.bean.Good;
import com.course.bean.User;
import com.course.utils.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;

public class GoodDao {
    public List<Good> GetCurrentPageGoods(Integer count, Integer size){
        String sql = "SELECT gid, gname, price, stock, category, picture, enterdate FROM good";
        List<Good> list = new ArrayList<Good>();
        List<Good> now = new ArrayList<Good>();
        list = DatabaseUtils.getAll(sql, Good.class);

        for (int i = 0; i < list.size(); i++){
            if(i >= (count-1)*size && i < count*size){
                Good good = list.get(i);
                now.add(good);
            }
        }
        return now;
    }

    public Integer getCount(){
        String sql = "SELECT count(*) FROM good";
        return DatabaseUtils.getCount(sql);
    }

    public Good getGood(Integer gid){
        String sql = "SELECT gid, gname, price, stock, category, picture, enterdate FROM good WHERE gid = ?";
        return DatabaseUtils.getGood(sql, gid);
    }

    public List<Good> getAll(){
        String sql = "SELECT gid, gname, price, stock, category, picture, enterdate FROM good";
        return DatabaseUtils.GetAllGood(sql);
    }

    public Integer Add(Good good){
        String sql = "INSERT INTO good(gid, gname, price, stock, category, picture, enterdate) VALUES(?, ?, ?, ?, ?, ?, ?)";
        return DatabaseUtils.Add(sql, good.getGid(), good.getGname(), good.getPrice(), good.getStock(), good.getCategory(), good.getPicture(), good.getEnterdate());
    }

    public Boolean Update(Good good){
        String sql = "UPDATE good SET gname = ?, price = ?, stock = ?, category = ?, picture = ?, enterdate = ? WHERE gid = ?";
        return DatabaseUtils.UpdateGood(sql,good.getGname(),good.getPrice(),good.getStock(),good.getCategory(),good.getPicture(),good.getEnterdate(),good.getGid());
    }

    public Boolean Del(Integer gid){
        String sql = "DELETE FROM good WHERE gid = ?";
        return DatabaseUtils.DelGood(sql,gid);
    }
}
