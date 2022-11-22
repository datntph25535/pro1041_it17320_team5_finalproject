/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private String id;
    private String ma;
    private Date ngayTao;
    private Date ngaythanhToan;
    private Date ngayNhan;
    private String sdt;
    private double thanhTien;
    private String trangThai;
    private String idNV;
    private String idKH;

    public HoaDon() {
    }

    public HoaDon(String id, String ma, Date ngayTao, Date ngaythanhToan, Date ngayNhan, String sdt, double thanhTien, String trangThai) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngaythanhToan = ngaythanhToan;
        this.ngayNhan = ngayNhan;
        this.sdt = sdt;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaythanhToan() {
        return ngaythanhToan;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

}
