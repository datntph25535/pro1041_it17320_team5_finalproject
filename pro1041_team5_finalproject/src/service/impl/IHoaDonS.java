/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import model.HoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonS {

    List<HoaDon> getAll();

    List<HoaDon> searchHD(String ma);

    List<HoaDon> searchHDTT(String tinhTrang);

    Integer insertHD(HoaDon hd);

    Integer updateHD(HoaDon hd, String ma);

    Integer deleteHD(String ma);
}
