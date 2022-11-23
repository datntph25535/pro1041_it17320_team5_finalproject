/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.HoaDonCT;
import service.impl.IHoaDonCT;

/**
 *
 * @author Admin
 */
public class HoaDonCTSer implements IHoaDonCT{
private HoaDonCTSer repo;

    public HoaDonCTSer() {
        repo=new HoaDonCTSer();
    }

    @Override
    public List<HoaDonCT> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer insertHDCT(HoaDonCT ct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer updateHDCT(HoaDonCT ct, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer deleteHDCT(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
