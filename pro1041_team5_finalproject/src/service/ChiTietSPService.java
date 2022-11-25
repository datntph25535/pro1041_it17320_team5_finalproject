/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ViewModel.CTSPViewModel;
import ViewModel.SanPhamBanHangViewModel;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSP;
import repository.ChiTietSPRepo;
import service.impl.ChiTietSPInteface;

/**
 *
 * @author Admin
 */
public class ChiTietSPService implements ChiTietSPInteface {

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

    @Override
    public List<SanPhamBanHangViewModel> getAllSPBH() {
        return repo.getAllSPBH();
    }

    @Override
    public boolean updateSoLuong(ChiTietSP ctsp, String id) {
        return repo.updateSoLuong(ctsp, id);
    }

    @Override

    public List<SanPhamBanHangViewModel> getMau(String mau) {
        return repo.getMau(mau);
    }

    @Override
    public List<SanPhamBanHangViewModel> getDongSP(String mau) {
        return repo.getDongSP(mau);
    }

    @Override
    public List<SanPhamBanHangViewModel> getOCung(String mau) {
        return repo.getOCung(mau);
    }

    @Override
    public List<SanPhamBanHangViewModel> getRam(String mau) {
        return repo.getRam(mau);
    }

    @Override
    public List<SanPhamBanHangViewModel> getHDH(String mau) {
        return repo.getHDH(mau);

    public List<SanPhamBanHangViewModel> searchTenSP(String ten) {
        return repo.searchTen(ten);
    }

    @Override
    public List<SanPhamBanHangViewModel> searchMa(String ma) {
        return repo.searchMa(ma);

    }

}
