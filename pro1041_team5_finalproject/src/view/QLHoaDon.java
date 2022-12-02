/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ViewModel.HoaDonCTViewModel;
import ViewModel.HoaDonVM;
import ViewModel.HoaDonViewModel;
import ViewModel.TBGioHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.KhachHang;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import repository.BanHangRepo;
import service.ChiTietSPService;
import service.HoaDonCTSer;
import service.HoaDonService;
import service.KhachHangService;
import service.impl.ChiTietSPInteface;
import service.impl.IHoaDonCT;
import service.impl.IHoaDonS;
import service.impl.KhachHangInter;

/**
 *
 * @author Admin
 */
public class QLHoaDon extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private IHoaDonS serr;
    private IHoaDonCT serCT;
    private ChiTietSPInteface serchi;
    private DefaultComboBoxModel cbb;
    private BanHangRepo qlbh = new BanHangRepo();
    private KhachHangInter qlkh = new KhachHangService();

    /**
     * Creates new form QlHoaDon
     */
    public QLHoaDon() {
        initComponents();
        serr = new HoaDonService();
        serCT = new HoaDonCTSer();
        serchi = new ChiTietSPService();
        defaultComboBoxModel = new DefaultComboBoxModel();
        defaultTableModel = new DefaultTableModel();
        loadTable(serr.getListHD());
        loadCBSDT();
        loadCBNam();
        cbTimKiem();
        loadCBThang();

    }

    public void loadTable(List<HoaDonVM> lisst) {
        defaultTableModel = (DefaultTableModel) tbHD.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDonVM hoaDon : lisst) {

            defaultTableModel.addRow(new Object[]{
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getManv(),
                hoaDon.getTennv(),
                hoaDon.getMakh(),
                hoaDon.getTenkh(),
                hoaDon.getSdt(),
                hoaDon.getTrangThai(),
                hoaDon.getTongTien()
            }
            );
        }
    }

    public void loadCBNam() {
        DefaultComboBoxModel def = (DefaultComboBoxModel) cbNam.getModel();

        for (int i = 2017; i <= 2023; i++) {

            def.addElement(String.valueOf(i));
        }
    }

    public void loadCBThang() {
        DefaultComboBoxModel defn = (DefaultComboBoxModel) cbThang.getModel();

        for (int i = 1; i <= 12; i++) {

            defn.addElement(String.valueOf(i));
        }

    }

    public void loadCBSDT() {

        DefaultComboBoxModel dcb = (DefaultComboBoxModel) cbSD.getModel();
        for (KhachHang hdon : serr.getSDTvm()) {
            dcb.addElement(hdon);
        }
    }

    public void loadCBtongTien() {

        DefaultComboBoxModel dcbh = (DefaultComboBoxModel) cbTongTien.getModel();
        for (KhachHang hh : serr.getHTenKH()) {
            dcbh.addElement(hh);
        }
    }

    public void loadTBHDCT() {

        int row = tbHD.getSelectedRow();
        if (row == -1) {
            return;
        }
        DefaultTableModel dftb = new DefaultTableModel();
        dftb = (DefaultTableModel) tbHDCT.getModel();

        ArrayList<TBGioHang> list = serr.getListHDCTVM(tbHD.getValueAt(row, 0).toString());
        if (list != null) {

            dftb.setRowCount(0);
            for (TBGioHang gh : list) {
                dftb.addRow(new Object[]{
                    gh.getMaSP(), gh.getTenSP(), gh.getDonGia(), gh.getSoLuong(), gh.getTongTien()
                });
            }
        } else {
            dftb.setRowCount(0);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        cbThang = new javax.swing.JComboBox<>();
        cbNam = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbSD = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbTongTien = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHDCT = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HOÁ ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Theo Tháng- Năm"));

        cbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThangActionPerformed(evt);
            }
        });

        cbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setText("SĐT Khách Hàng");

        cbSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSDActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng thái ");

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Đã huỷ", "Chờ thanh toán" }));
        cbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangThaiActionPerformed(evt);
            }
        });

        jLabel3.setText("Tổng tiền");

        cbTongTien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<100", "từ 100 - 500", "từ 500-1000", ">1000" }));
        cbTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTongTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cbSD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(cbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hoá Đơn", "Ngày Tạo", "Mã Nhân Viên", "Tên Nhân Viên", "Mã Khách Hàng", "Tên Khách Hàng", "SDT Khách Hàng", "Trạng Thái", "Tổng Tiền"
            }
        ));
        tbHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HOÁ ĐƠN CHI TIẾT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tbHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ));
        tbHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHDCT);

        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 358, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        //tìm kiếm theo tên hoặc mã sp
        int rowhdct = tbHDCT.getSelectedRow();
        int rowhd = tbHD.getSelectedRow();
        List<TBGioHang> listHCDT = serr.SearchMaSPVm(txtTimKiem.getText().trim(), tbHD.getValueAt(rowhd, 0).toString());
        List<TBGioHang> listHCDTw = serr.SearchTenSPVm(txtTimKiem.getText().trim(), tbHD.getValueAt(rowhd, 0).toString());
        if (txtTimKiem.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Nhập để tìm kiếm");

            return;
        }
        if (!listHCDT.isEmpty()) {
            JOptionPane.showMessageDialog(this, listHCDT);
        } else if (!listHCDTw.isEmpty()) {
            JOptionPane.showMessageDialog(this, listHCDTw);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
            return;
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tbHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDMouseClicked
        // TODO add your handling code here:

        loadTBHDCT();
    }//GEN-LAST:event_tbHDMouseClicked


    private void tbHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDCTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbHDCTMouseClicked

    private void cbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThangActionPerformed
        // TODO add your handling code here:
        int index = cbThang.getSelectedIndex();
        List<HoaDonVM> list = serr.searchThangVM(Integer.parseInt(cbThang.getItemAt(index)));

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin");
            loadTable(serr.getListHD());
            cbThang.setSelectedItem(null);
        } else {
            loadTable(list);
        }

    }//GEN-LAST:event_cbThangActionPerformed

    private void cbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamActionPerformed
        // TODO add your handling code here:

        int index = cbNam.getSelectedIndex();

        List<HoaDonVM> listhd = serr.searchNamVM(Integer.parseInt(cbNam.getItemAt(index)));
        if (listhd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin");
            loadTable(serr.getListHD());
            cbNam.setSelectedItem(null);
        } else {
            loadTable(listhd);
        }

    }//GEN-LAST:event_cbNamActionPerformed

    private void cbSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSDActionPerformed
        // TODO add your handling code here:
        String sdt = cbSD.getSelectedItem().toString();
        List<HoaDonVM> listvm = serr.searchSDTVM(sdt);
        if (listvm.isEmpty()) {
            loadTable(listvm);
        } else {
            loadTable(listvm);
        }

    }//GEN-LAST:event_cbSDActionPerformed
    public void cbTimKiem() {
        cbSD.setEditable(true);
        AutoCompleteDecorator.decorate(cbSD);

    }
    private void cbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangThaiActionPerformed
        // TODO add your handling code here:
        String trangthai = cbTrangThai.getSelectedItem().toString();
        List<HoaDonVM> listN = serr.SearchTrangThaiVM(trangthai);
        if (listN.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có thông tin");
            loadTable(serr.getListHD());
            cbTrangThai.setSelectedItem(null);
        } else {
            loadTable(listN);
        }
    }//GEN-LAST:event_cbTrangThaiActionPerformed

    private void cbTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTongTienActionPerformed
        // TODO add your handling code here:
        if (cbTongTien.getSelectedIndex() == 0) {
            List<HoaDonVM> listVm = serr.searchkhoangTien1();
            loadTable(listVm);
        } else if (cbTongTien.getSelectedIndex() == 1) {
            List<HoaDonVM> listVm2 = serr.searchkhoangTien2();
            loadTable(listVm2);
        } else if (cbTongTien.getSelectedIndex() == 2) {
            List<HoaDonVM> listVm3 = serr.searchkhoangTien3();
            loadTable(listVm3);
        } else if (cbTongTien.getSelectedIndex() == 3) {
            List<HoaDonVM> listVm4 = serr.searchkhoangTien4();
            loadTable(listVm4);
        } else {
            cbTongTien.setSelectedItem(null);
        }

    }//GEN-LAST:event_cbTongTienActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbNam;
    private javax.swing.JComboBox<String> cbSD;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JComboBox<String> cbTongTien;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tbHDCT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}