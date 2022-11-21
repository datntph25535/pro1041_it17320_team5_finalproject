/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    
    private String idSP;
    private String maSP;
    private String tenSP;
    private String mauSac;
    private String dongSP;
    private String oCung;
    private String manHinh;
    private String congKetNoi;
    private String pin;
    private double giaBan;
    private int soLuongTon;
    private String serial;
    private String heDieuHanh;
    private int trangThai;
    private String idRam;
    private String idCPU;
    private String idCard;
    
    

    public SanPham() {
    }

    public SanPham(String idSP, String maSP, String tenSP, String mauSac, String dongSP, String oCung, String manHinh, String congKetNoi, String pin, double giaBan, int soLuongTon, String serial, String heDieuHanh, int trangThai, String idRam, String idCPU, String idCard) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.oCung = oCung;
        this.manHinh = manHinh;
        this.congKetNoi = congKetNoi;
        this.pin = pin;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.serial = serial;
        this.heDieuHanh = heDieuHanh;
        this.trangThai = trangThai;
        this.idRam = idRam;
        this.idCPU = idCPU;
        this.idCard = idCard;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
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

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getDongSP() {
        return dongSP;
    }

    public void setDongSP(String dongSP) {
        this.dongSP = dongSP;
    }

    public String getoCung() {
        return oCung;
    }

    public void setoCung(String oCung) {
        this.oCung = oCung;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getCongKetNoi() {
        return congKetNoi;
    }

    public void setCongKetNoi(String congKetNoi) {
        this.congKetNoi = congKetNoi;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public int getTrangThai() {
        
        if (soLuongTon > 0) {
           trangThai = 0; 
        }else{
            trangThai = 1;
        }
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdRam() {
        return idRam;
    }

    public void setIdRam(String idRam) {
        this.idRam = idRam;
    }

    public String getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(String idCPU) {
        this.idCPU = idCPU;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    
    
    
    
    
}
