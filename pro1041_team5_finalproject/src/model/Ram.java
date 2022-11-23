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

public class Ram {


    private String id;
    private String ma;
    private double dungLuong;

    public Ram() {
    }

    public Ram(String id, String ma, double dungLuong) {
        this.id = id;
        this.ma = ma;
        this.dungLuong = dungLuong;
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


    public double getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(double dungLuong) {
        this.dungLuong = dungLuong;
    }

    @Override
    public String toString() {
        return "  "+dungLuong;
    }
    
    
}