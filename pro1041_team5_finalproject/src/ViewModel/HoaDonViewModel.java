/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HoaDonViewModel {
    
    private String maHD;
    private Date ngayTao;
    private String maNV;
    private String trangThai;

    public HoaDonViewModel() {
    }

    public HoaDonViewModel(String maHD, Date ngayTao, String maNV, String trangThai) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.maNV = maNV;
        this.trangThai = trangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTrangThai() {
        return "Chờ thanh toán";
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
