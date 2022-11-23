/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewModel;

import model.ChiTietSP;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonCTViewModel {

    private String id;
    private int soLuong;
    private double gia;

    private double thanhTien;
    private HoaDon idHD;
//    private LinhKien idLK;
    private ChiTietSP idCTSP;

    public HoaDonCTViewModel() {
    }

    public HoaDonCTViewModel(String id, int soLuong, double gia, double thanhTien, HoaDon idHD) {
        this.id = id;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
        this.idHD = idHD;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public HoaDon getIdHD() {
        return idHD;
    }

    public void setIdHD(HoaDon idHD) {
        this.idHD = idHD;
    }

}
