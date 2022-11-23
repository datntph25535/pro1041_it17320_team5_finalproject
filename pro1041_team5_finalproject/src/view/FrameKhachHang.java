/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.KhachHang;
import service.KhachHangService;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class FrameKhachHang extends javax.swing.JFrame {

    KhachHangService khs = new KhachHangService();
    ButtonGroup buttonGroup = new ButtonGroup();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    private static final String P_EMAIL = "^\\w+@\\w+\\.\\w+.\\w+";

    public FrameKhachHang() {
        initComponents();
        gioiTinh();
        loadTable();
    }

    public void gioiTinh() {
        buttonGroup.add(rd_nu);
        buttonGroup.add(rd_nam);
    }

    public void loadTable() {
        defaultTableModel = (DefaultTableModel) tb_khachHang.getModel();
        defaultTableModel.setRowCount(0);
        for (KhachHang kh : khs.getList()) {
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getHoTen(), kh.getNgaySinh(), kh.getGioiTinh(), kh.getSdt(), kh.getEmail()
            });
        }
    }

    public boolean checkEmail() {
        Matcher matcher = Pattern.compile(P_EMAIL).matcher(txt_email.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        return true;
    }

    public boolean searchMa(String ma) {
        ArrayList<KhachHang> listKH = khs.getList();
        for (int i = 0; i < listKH.size(); i++) {
            if (listKH.get(i).getMa().equals(ma)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_id = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        btn_new = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_khachHang = new javax.swing.JTable();
        txt_hoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_id.setText("-");

        jLabel11.setText("Sđt");

        jLabel5.setText("Email");

        jLabel6.setText("Họ và tên");

        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        tb_khachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã khách hàng", "Họ và tên", "Ngày sinh", "Giới tính", "Sđt", "Email"
            }
        ));
        tb_khachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_khachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_khachHang);

        jLabel4.setText("Mã khách hàng");

        jLabel8.setText("Ngày sinh");

        jLabel3.setText("Giới tính");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Quản lý khách hàng");

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        rd_nam.setText("Nam");

        rd_nu.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addGap(89, 89, 89)
                        .addComponent(btn_save)
                        .addGap(62, 62, 62)
                        .addComponent(btn_update)
                        .addGap(88, 88, 88)
                        .addComponent(btn_delete)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)
                                .addGap(77, 77, 77)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_search))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_id))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rd_nam)
                                        .addGap(38, 38, 38)
                                        .addComponent(rd_nu))
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_search))))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_id)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(rd_nam)
                                    .addComponent(rd_nu))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_save)
                    .addComponent(btn_update)
                    .addComponent(btn_delete))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (searchMa(txt_ma.getText()) == true) {
            JOptionPane.showMessageDialog(this, "trùng mã");
            return;
        } else {
            if (checkEmail()) {
                KhachHang kh = this.addData();
                if (kh == null) {
                    return;
                }
                this.khs.insert(kh);
                this.loadTable();
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        int row = tb_khachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần cập nhật");
            return;
        }
        KhachHang kh = this.addData();
        khs.update(kh.getId(), kh);
        loadTable();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row = tb_khachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (con != JOptionPane.YES_OPTION) {
            return;
        }
        String id = tb_khachHang.getValueAt(row, 0).toString();
        khs.delete(id);
        loadTable();
        clearForm();

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tb_khachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_khachHangMouseClicked
        int row = tb_khachHang.getSelectedRow();
        lb_id.setText(tb_khachHang.getValueAt(row, 0).toString());
        txt_ma.setText(tb_khachHang.getValueAt(row, 1).toString());
        txt_hoTen.setText(tb_khachHang.getValueAt(row, 2).toString());
        txt_ngaySinh.setText(tb_khachHang.getValueAt(row, 3).toString());
        txt_sdt.setText(tb_khachHang.getValueAt(row, 5).toString());
        txt_email.setText(tb_khachHang.getValueAt(row, 6).toString());

        if (tb_khachHang.getValueAt(row, 4).equals("Nam")) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
    }//GEN-LAST:event_tb_khachHangMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String tim = txt_search.getText();
        KhachHang kh = khs.searchByMa(tim);
        KhachHang kha = khs.searchByTen(tim);
        if (kh != null) {
            System.out.println(tim);
            defaultTableModel = (DefaultTableModel) tb_khachHang.getModel();
            defaultTableModel.setRowCount(0);
            defaultTableModel.addRow(new Object[]{
                kh.getId(), kh.getMa(), kh.getHoTen(), kh.getNgaySinh(), kh.getGioiTinh(), kh.getSdt(), kh.getEmail()
            });
        } else if (kha != null) {
            defaultTableModel = (DefaultTableModel) tb_khachHang.getModel();
            defaultTableModel.setRowCount(0);
            defaultTableModel.addRow(new Object[]{
                kha.getId(), kha.getMa(), kha.getHoTen(), kha.getNgaySinh(), kha.getGioiTinh(), kha.getSdt(), kha.getEmail()
            });
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
            loadTable();
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private KhachHang addData() {
        String id = lb_id.getText();
        String ma = txt_ma.getText();
        String hoTen = txt_hoTen.getText();
        String ngaySinh = txt_ngaySinh.getText();
        String sdt = txt_sdt.getText();
        String gioiTinh = "";
        String email = txt_email.getText();
        if (ma.length() == 0 || hoTen.length() == 0 || ngaySinh.length() == 0 || sdt.length() == 0 || email.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
            return null;
        }
        Date date = null;
        try {
            date = Date.valueOf(ngaySinh);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh");
        }
        if (rd_nam.isSelected()) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        KhachHang kh = new KhachHang(id, ma, hoTen, date, gioiTinh, sdt, email);
        return kh;
    }

    private void clearForm() {
        lb_id.setText("");
        txt_ma.setText("");
        txt_hoTen.setText("");
        txt_ngaySinh.setText("");
        txt_search.setText("");
        txt_sdt.setText("");
        txt_email.setText("");
        buttonGroup.clearSelection();
    }

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
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_id;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tb_khachHang;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
