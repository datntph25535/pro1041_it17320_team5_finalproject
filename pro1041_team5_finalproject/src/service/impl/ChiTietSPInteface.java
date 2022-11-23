/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import ViewModel.CTSPViewModel;
import java.util.ArrayList;
import model.ChiTietSP;

/**
 *
 * @author Admin
 */
public interface ChiTietSPInteface {
    
    ArrayList<ChiTietSP> getAll();
    
    void insert(ChiTietSP ctsp);
    
    void update(ChiTietSP ctsp, String id);
    
    void delete(String id);
    
    ArrayList<CTSPViewModel> getListCTSPViewModel();
    
}
