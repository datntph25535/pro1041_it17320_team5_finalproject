/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ViewModel.CTSPViewModel;
import java.util.ArrayList;
import model.ChiTietSP;
import repository.ChiTietSPRepo;
import service.impl.ChiTietSPInteface;

/**
 *
 * @author Admin
 */
public class ChiTietSPService implements ChiTietSPInteface{
    
    ChiTietSPRepo repo = new ChiTietSPRepo();

    @Override
    public ArrayList<ChiTietSP> getAll() {
        return repo.getAll();
    }

    @Override
    public void insert(ChiTietSP ctsp) {
        repo.insert(ctsp);
    }

    @Override
    public void update(ChiTietSP ctsp, String id) {
        repo.update(ctsp, id);
    }

    @Override
    public void delete(String id) {
        repo.delete(id);
    }

    @Override
    public ArrayList<CTSPViewModel> getListCTSPViewModel() {
        return repo.getListCTSPViewModel();
    }
    
}
