package com.course.Dao;

import com.course.bean.Sale;
import com.course.utils.DatabaseUtils;

import java.util.List;

public class SaleDao {
    public Integer Add(Sale sale){
        String sql = "insert into sale (uid, rname, gname, phone, raddress, remail, saledate) values (?, ?, ?, ?, ?, ?, ?)";
        return DatabaseUtils.Add(sql,sale.getUid(),sale.getRname(),sale.getGname(),sale.getPhone(),sale.getRaddress(),sale.getRemail(),sale.getSaledate());
    }

    public List<Sale> getAll(Integer uid){
        String sql = "SELECT sid, uid, rname, gname, phone, raddress, remail, saledate FROM sale WHERE uid = ?";
        return DatabaseUtils.getAll(sql, uid);
    }

    public List<Sale> getAllSale(){
        String sql= "SELECT sid, uid, rname, gname, phone, raddress, remail, saledate FROM sale";
        return DatabaseUtils.getAllSale(sql);
    }
}
