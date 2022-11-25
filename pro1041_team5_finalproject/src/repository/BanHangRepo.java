/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import ViewModel.TBGioHang;
import java.sql.Connection;
import java.util.ArrayList;
import JDBC.JDBCUtil;
import ViewModel.HoaDonViewModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public class BanHangRepo {

    public ArrayList<TBGioHang> getListGioHang() {
        ArrayList<TBGioHang> list = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select Ma, Ten, GiaBan from SanPham join ChiTietSP on SanPham.Id = ChiTietSP.IdSP";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                double giaBan = rs.getDouble("GiaBan");
                TBGioHang gh = new TBGioHang(ma, ten, 0, giaBan, giaBan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BanHangRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<HoaDonViewModel> getListHoaDon() {
        ArrayList<HoaDonViewModel> listHD = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Select HoaDon.Ma as 'mahd',NgayTao,HoaDon.TrangThai as 'tt' From HoaDon";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                String mahd = rs.getString("mahd");

                Date ngaytao = rs.getDate("NgayTao");
                String tt = rs.getString("tt");
                HoaDonViewModel hd = new HoaDonViewModel(mahd, ngaytao, "nv01", tt);
                listHD.add(hd);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
       return listHD;
    }

    public void insertHDR(HoaDonViewModel hd) {

        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "Insert into HoaDon " + "(Ma,NgayTao,TrangThai)" + " Values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setDate(2, (java.sql.Date) hd.getNgayTao());
            ps.setString(3, hd.getTrangThai());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }

    public TBGioHang updateGH(ArrayList<TBGioHang> list, String ma) {
        TBGioHang ghsearch = null;
        for (TBGioHang gh : list) {
            if (gh.getMaSP().equals(ma)) {
                ghsearch = gh;
            }
        }
        return ghsearch;
    }
    
    public KhachHang getListSDT(String sdt) {
        KhachHang KH = null;
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from KhachHang where Sdt=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String hoTen = rs.getString("HoTen");
                Date ngaySinh = rs.getDate("NgaySinh");
                String gioiTinh = rs.getString("GioiTinh");
                String email = rs.getString("Email");
                KH = new KhachHang(id, ma, hoTen, ngaySinh, gioiTinh, sdt, email);
              
            }
        } catch (Exception ex) {
            Logger.getLogger(NhanVienRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return KH;
    }

}
