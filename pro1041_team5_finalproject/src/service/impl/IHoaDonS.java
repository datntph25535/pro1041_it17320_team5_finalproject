/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.List;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public interface IHoaDonS {

    List<HoaDon> getAll();

    Integer insertHD(HoaDon hd);

<<<<<<< Updated upstream
    List<HoaDon> searchHD(String ma);

    List<HoaDon> searchHDTT(String tinhTrang);

=======
>>>>>>> Stashed changes
    Integer updateHD(HoaDon hd, String ma);

    Integer deleteHD(String ma);

    List<HoaDon> searchMaHDS(String ma);

    List<HoaDon> searchTrangthai(String trangThai);
}
