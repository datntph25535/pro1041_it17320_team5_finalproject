/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.Ram;
import JDBC.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RamRepository {
    
    public ArrayList<Ram> getAll(){
        ArrayList<Ram> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from Ram";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String loaiRam = rs.getString(3);
                double dungLuong = rs.getDouble(4);
                Ram ram = new Ram(id, ma, loaiRam, dungLuong);
                list.add(ram);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public void insert(Ram ram){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into Ram (Ma, LoaiRam, DungLuong) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ram.getMa());
            ps.setString(2, ram.getLoaiRam());
            ps.setDouble(3, ram.getDungLuong());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public void update(Ram ram, String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update Ram set Ma = ?, LoaiRam = ?, DungLuong = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ram.getMa());
            ps.setString(2, ram.getLoaiRam());
            ps.setDouble(3, ram.getDungLuong());
            ps.setString(4, ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public void delete(String ma){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from Ram where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
