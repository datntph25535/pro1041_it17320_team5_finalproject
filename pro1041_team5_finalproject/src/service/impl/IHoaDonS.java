/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import Model.HoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IHoaDonS {

    List<HoaDon> getAll();

    Integer insertHD(HoaDon hd);

    Integer updateHD(HoaDon hd, String ma);

    Integer deleteHD(String ma);
}
