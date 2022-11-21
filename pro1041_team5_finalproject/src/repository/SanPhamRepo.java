/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.SanPham;
import java.sql.Connection;
import java.util.ArrayList;
import JDBC.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SanPhamRepo {

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> list = new ArrayList<>();

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from SanPham";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String idSP = rs.getString(1);
                String maSP = rs.getString(2);
                String tenSP = rs.getString(3);
                String mauSac = rs.getString(4);
                String dongSP = rs.getString(5);
                String oCung = rs.getString(6);
                String manHinh = rs.getString(7);
                String congKN = rs.getString(8);
                String pin = rs.getString(9);
                double giaBan = rs.getDouble(10);
                int slTon = rs.getInt(11);
                int trangThai = rs.getInt(14);
                String serial = rs.getString(12);
                String hdh = rs.getString(13);
                String idCPU = rs.getString(15);
                String idRam = rs.getString(16);
                String idCard = rs.getString(17);
                SanPham sp = new SanPham(idSP, maSP, tenSP, mauSac, dongSP, oCung, manHinh, congKN, pin, giaBan, slTon, serial, hdh, trangThai, idRam, idCPU, idCard);
                list.add(sp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(SanPham sp) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "insert into SanPham "
                    + "(Ma, Ten, MauSac, Dongsp, OCung, ManHinh, CongKetNoi, Pin, GiaBan, SoLuongTon, SerialNumber, HeDieuHanh)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setString(3, sp.getMauSac());
            ps.setString(4, sp.getDongSP());
            ps.setString(5, sp.getoCung());
            ps.setString(6, sp.getManHinh());
            ps.setString(7, sp.getCongKetNoi());
            ps.setString(8, sp.getPin());
            ps.setDouble(9, sp.getGiaBan());
            ps.setInt(10, sp.getSoLuongTon());
            ps.setString(11, sp.getSerial());
            ps.setString(12, sp.getHeDieuHanh());
//            ps.setString(14, sp.getIdCPU());
//            ps.setString(15, sp.getIdRam());
//            ps.setString(16, sp.getIdCard());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void main(String[] args) {
        SanPham sp = new SanPham("", "sp02", "a", "a", "a", "a", "a", "a", "1234", 12, 0, "1234abcd", "11", 2, "", "", "");
        new SanPhamRepo().update(sp, "sp02");
    }

    public void update(SanPham sp, String maSP) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "update SanPham set Ma = ?, Ten = ?, MauSac = ?, Dongsp = ?, OCung = ?, ManHinh = ?, CongKetNoi = ?, Pin = ?, GiaBan = ?, SoLuongTon = ?, SerialNumber = ?, HeDieuHanh = ?, TrangThai = ? where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setString(3, sp.getMauSac());
            ps.setString(4, sp.getDongSP());
            ps.setString(5, sp.getoCung());
            ps.setString(6, sp.getManHinh());
            ps.setString(7, sp.getCongKetNoi());
            ps.setString(8, sp.getPin());
            ps.setDouble(9, sp.getGiaBan());
            ps.setInt(10, sp.getSoLuongTon());
            ps.setString(11, sp.getSerial());
            ps.setString(12, sp.getHeDieuHanh());
            ps.setInt(13, sp.getTrangThai());
//            ps.setString(14, sp.getIdCPU());
//            ps.setString(15, sp.getIdRam());
//            ps.setString(16, sp.getIdCard());
            ps.setString(14, maSP);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String maSP) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "delete from SanPham  where ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public SanPham getListByMa(String ma){
        try {
            Connection conn =JDBCUtil.getConnection();
            String sql = "select * from SanPham where Ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
                if (rs.next()) {
                String idSP = rs.getString(1);
                String maSP = rs.getString(2);
                String tenSP = rs.getString(3);
                String mauSac = rs.getString(4);
                String dongSP = rs.getString(5);
                String oCung = rs.getString(6);
                String manHinh = rs.getString(7);
                String congKN = rs.getString(8);
                String pin = rs.getString(9);
                double giaBan = rs.getDouble(10);
                int slTon = rs.getInt(11);
                int trangThai = rs.getInt(14);
                String serial = rs.getString(12);
                String hdh = rs.getString(13);
                String idCPU = rs.getString(15);
                String idRam = rs.getString(16);
                String idCard = rs.getString(17);
                SanPham sp = new SanPham(idSP, maSP, tenSP, mauSac, dongSP, oCung, manHinh, congKN, pin, giaBan, slTon, serial, hdh, trangThai, idRam, idCPU, idCard);
                return sp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public SanPham getListByTen(String ten){
        try {
            Connection conn =JDBCUtil.getConnection();
            String sql = "select * from SanPham where Ten = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ten);
            ps.execute();
            ResultSet rs = ps.getResultSet();
                if (rs.next()) {
                String idSP = rs.getString(1);
                String maSP = rs.getString(2);
                String tenSP = rs.getString(3);
                String mauSac = rs.getString(4);
                String dongSP = rs.getString(5);
                String oCung = rs.getString(6);
                String manHinh = rs.getString(7);
                String congKN = rs.getString(8);
                String pin = rs.getString(9);
                double giaBan = rs.getDouble(10);
                int slTon = rs.getInt(11);
                int trangThai = rs.getInt(14);
                String serial = rs.getString(12);
                String hdh = rs.getString(13);
                String idCPU = rs.getString(15);
                String idRam = rs.getString(16);
                String idCard = rs.getString(17);
                SanPham sp = new SanPham(idSP, maSP, tenSP, mauSac, dongSP, oCung, manHinh, congKN, pin, giaBan, slTon, serial, hdh, trangThai, idRam, idCPU, idCard);
                return sp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    

}
