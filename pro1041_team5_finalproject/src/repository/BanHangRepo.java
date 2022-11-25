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
import ViewModel.SanPhamBanHangViewModel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
    
    public List<SanPhamBanHangViewModel> searchMa(String ma) {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.MauSac.Ten AS Expr1, dbo.DongSP.Ten AS Expr2, dbo.OCung.DungLuong AS Expr3, dbo.Pin.DungLuong, dbo.CPU.Ten AS Expr4, dbo.Ram.DungLuong AS Expr5, dbo.HeDieuHanh.Ten AS Expr6, dbo.ChiTietSP.SoLuongTon, \n"
                + "             dbo.ChiTietSP.GiaBan\n"
                + "FROM   dbo.CPU INNER JOIN\n"
                + "             dbo.ChiTietSP ON dbo.CPU.Id = dbo.ChiTietSP.IdCPU INNER JOIN\n"
                + "             dbo.DongSP ON dbo.ChiTietSP.IdDongsp = dbo.DongSP.Id INNER JOIN\n"
                + "             dbo.HeDieuHanh ON dbo.ChiTietSP.IdHeDH = dbo.HeDieuHanh.Id INNER JOIN\n"
                + "             dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "             dbo.OCung ON dbo.ChiTietSP.IdOCung = dbo.OCung.Id INNER JOIN\n"
                + "             dbo.Pin ON dbo.ChiTietSP.IdPin = dbo.Pin.Id INNER JOIN\n"
                + "             dbo.Ram ON dbo.ChiTietSP.IdRam = dbo.Ram.Id INNER JOIN\n"
                + "             dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id Where SanPham.Ma=?";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();

            List<SanPhamBanHangViewModel> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new SanPhamBanHangViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getDouble(11)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamBanHangViewModel> searchTen(String ten) {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.MauSac.Ten AS Expr1, dbo.DongSP.Ten AS Expr2, dbo.OCung.DungLuong AS Expr3, dbo.Pin.DungLuong, dbo.CPU.Ten AS Expr4, dbo.Ram.DungLuong AS Expr5, dbo.HeDieuHanh.Ten AS Expr6, dbo.ChiTietSP.SoLuongTon, \n"
                + "             dbo.ChiTietSP.GiaBan\n"
                + "FROM   dbo.CPU INNER JOIN\n"
                + "             dbo.ChiTietSP ON dbo.CPU.Id = dbo.ChiTietSP.IdCPU INNER JOIN\n"
                + "             dbo.DongSP ON dbo.ChiTietSP.IdDongsp = dbo.DongSP.Id INNER JOIN\n"
                + "             dbo.HeDieuHanh ON dbo.ChiTietSP.IdHeDH = dbo.HeDieuHanh.Id INNER JOIN\n"
                + "             dbo.MauSac ON dbo.ChiTietSP.IdMauSac = dbo.MauSac.Id INNER JOIN\n"
                + "             dbo.OCung ON dbo.ChiTietSP.IdOCung = dbo.OCung.Id INNER JOIN\n"
                + "             dbo.Pin ON dbo.ChiTietSP.IdPin = dbo.Pin.Id INNER JOIN\n"
                + "             dbo.Ram ON dbo.ChiTietSP.IdRam = dbo.Ram.Id INNER JOIN\n"
+ "             dbo.SanPham ON dbo.ChiTietSP.IdSP = dbo.SanPham.Id Where SanPham.Ten=?";
        try (Connection con = JDBCUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();

            List<SanPhamBanHangViewModel> list = new ArrayList<>();

            while (rs.next()) {
                list.add(new SanPhamBanHangViewModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getDouble(11)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
