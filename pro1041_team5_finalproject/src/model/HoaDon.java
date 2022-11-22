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
<<<<<<< Updated upstream
    private String trangThai;
    private String idnv;
    private String idkh;
=======
    private double thanhTien;
    private String trangThai;
    private String idNV;
    private String idKH;
>>>>>>> Stashed changes

    public HoaDon() {
    }

<<<<<<< Updated upstream
    public HoaDon(String id, String ma, Date ngayThanhToan, Date ngayNhan, Date ngayTao, String sdt, String trangThai) {
=======
    public HoaDon(String id, String ma, Date ngayTao, Date ngaythanhToan, Date ngayNhan, String sdt, double thanhTien, String trangThai) {
>>>>>>> Stashed changes
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngaythanhToan = ngaythanhToan;
        this.ngayNhan = ngayNhan;
        this.sdt = sdt;
<<<<<<< Updated upstream
        this.trangThai = trangThai;
    }

    public HoaDon(String id, String ma, Date ngayThanhToan, Date ngayNhan, Date ngayTao, double thanhTien, String sdt, String trangThai) {
        this.id = id;
        this.ma = ma;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayNhan = ngayNhan;
        this.ngayTao = ngayTao;
        this.thanhTien = thanhTien;
        this.sdt = sdt;
=======
        this.thanhTien = thanhTien;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
        this.idkh = idkh;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
=======
    public void setNgaythanhToan(Date ngaythanhToan) {
        this.ngaythanhToan = ngaythanhToan;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
=======
    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
>>>>>>> Stashed changes
    }

}
