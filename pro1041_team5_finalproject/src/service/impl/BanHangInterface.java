/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import ViewModel.HoaDonViewModel;
import ViewModel.TBGioHang;
import java.util.ArrayList;
import model.KhachHang;

/**
 *
 * @author Admin
 */
public interface BanHangInterface {
    
    ArrayList<TBGioHang> getListGioHang();
    
    ArrayList<HoaDonViewModel> getListHoaDon();
    
    TBGioHang updateGH(ArrayList<TBGioHang> list, String ma);
    
    KhachHang getListSDT(String sdt);
    
    
    
}
