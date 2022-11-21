/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonS {
    
    private HoaDonRepo repo;
    
    public HoaDonService() {
        repo = new HoaDonRepo();
    }
    
    @Override

    public List<HoaDon> getAll() {
        return this.repo.all();
    }
    
    @Override
    public Integer insertHD(HoaDon hd) {
        return repo.insertHDR(hd);
    }
    
    @Override
    public Integer updateHD(HoaDon hd, String ma) {
      return  repo.upadteHDR(hd, ma);
    }
    
    @Override
    public Integer deleteHD(String ma) {
       return repo.deleteHDR(ma);
    }
    
}
