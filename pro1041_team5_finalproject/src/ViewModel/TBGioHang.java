/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

/**
 *
 * @author Admin
 */
public class TBGioHang {
    
    private String maSP;
    private String tenSP;
    private int soLuong;
    private double donGia;
    private double tongTien;

    public TBGioHang() {
    }

    public TBGioHang(String maSP, String tenSP, int soLuong, double donGia, double tongTien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getTongTien() {
        return soLuong * donGia;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
    
}
