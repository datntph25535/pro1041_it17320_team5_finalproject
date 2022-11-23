/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import model.PhieuBaoHanh;



import ViewModel.PhieuBaoHanhViewModel;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import service.BaoHanhServices;
import service.impl.BaoHanhInterface;

/**
 *
 * @author Administrator
 */
public class JFrameBH extends javax.swing.JFrame {

   
    private DefaultTableModel dtmBH = new DefaultTableModel();
   
    
    private BaoHanhInterface bhSer = new BaoHanhServices();
   
    private List<PhieuBaoHanhViewModel> listBH = bhSer.getAll();
   
    
    public JFrameBH() {
        initComponents();
        
        tblBH1.setModel(dtmBH);
        String [] bh = {"id"," ma", " ngayMuaHang"," ngayBH",  " thoiGianBH", "tenNguoiNhan"," id hdct",};
        dtmBH.setColumnIdentifiers(bh);
        showBH(bhSer.getAll());
        txtIDBH.disable();
       
        AutoCompleteDecorator.decorate(cboIDHDCT);
        
        
        
        
    }
     private void showBH(List<PhieuBaoHanhViewModel> list) {
        dtmBH.setRowCount(0);
         for (PhieuBaoHanhViewModel p : list) {
             dtmBH.addRow(p.toDataRow());
         }
    }

    
    private PhieuBaoHanh getDataBH(){
        String id = txtIDBH.getText();
     String ma = txtMaBH.getText();
     String ngayBH = txtNgayBH.getText();
     String ngayMuaHang = txtNgayMua.getText();
     String idHDCT = cboIDHDCT.getSelectedItem().toString();
     String thoiGianBH = txtThoiGianBH.getText();
    String tenNguoiNhan = txtTen.getText();
    Date date1 = null;
    Date date2 = null;
  
        try {
            date1 = Date.valueOf(ngayBH);
            date2 = Date.valueOf(ngayMuaHang);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi ngày sinh");
        }
        
    PhieuBaoHanh bh = new PhieuBaoHanh(null, ma, date2, date1,Integer.valueOf(thoiGianBH) , tenNguoiNhan, idHDCT);
    return bh;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtThoiGianBH = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtNgayBH = new javax.swing.JTextField();
        txtMaBH = new javax.swing.JTextField();
        txtNgayMua = new javax.swing.JTextField();
        txtIDBH = new javax.swing.JTextField();
        btnAddBH = new javax.swing.JButton();
        btnUpBH = new javax.swing.JButton();
        btnDelBH = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cboIDHDCT = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBH1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ma BH");

        jLabel2.setText("Id BH");

        jLabel3.setText("Ngay BH");

        jLabel4.setText("Ngay Mua hang");

        jLabel6.setText("thoi gian BH");

        jLabel7.setText("Ten nguoi nhan");

        btnAddBH.setText("Add");
        btnAddBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBHActionPerformed(evt);
            }
        });

        btnUpBH.setText("Update");
        btnUpBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpBHActionPerformed(evt);
            }
        });

        btnDelBH.setText("Delete");
        btnDelBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelBHActionPerformed(evt);
            }
        });

        jLabel13.setText("Id HDCT");

        cboIDHDCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13))
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNgayBH, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(txtTen)
                                .addComponent(txtIDBH)
                                .addComponent(txtMaBH)
                                .addComponent(txtThoiGianBH)
                                .addComponent(txtNgayMua))
                            .addComponent(cboIDHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnAddBH)
                        .addGap(38, 38, 38)
                        .addComponent(btnUpBH)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelBH)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIDBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtThoiGianBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cboIDHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBH)
                    .addComponent(btnUpBH)
                    .addComponent(btnDelBH))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBH1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBH1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBH1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBH1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBH1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBH1MouseClicked
        int row = tblBH1.getSelectedRow();
        PhieuBaoHanhViewModel bh = bhSer.getAll().get(row);
        txtIDBH.setText(bh.getId());
        txtMaBH.setText(bh.getMa());
        txtNgayBH.setText(String.valueOf(bh.getNgayBH()));
        txtTen.setText(bh.getTenKH());
        txtThoiGianBH.setText(bh.getThoiGianBH()+"");
        cboIDHDCT.setSelectedItem(bh.getIDhdct());
        txtNgayMua.setText(String.valueOf(bh.getNgayMuaHang()));
    }//GEN-LAST:event_tblBH1MouseClicked

    private void btnAddBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBHActionPerformed
        try {
            JOptionPane.showMessageDialog(this, bhSer.add(getDataBH()));
            listBH = bhSer.getAll();
            showBH(listBH);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi nut add");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddBHActionPerformed

    private void btnUpBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpBHActionPerformed
        try {
    int row = tblBH1.getSelectedRow();
    String selectIDBH = tblBH1.getValueAt(row, 0).toString();
            JOptionPane.showMessageDialog(this, bhSer.update(getDataBH(), selectIDBH));
            showBH(bhSer.getAll());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi nut update");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpBHActionPerformed

    private void btnDelBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelBHActionPerformed
        try {
    int row = tblBH1.getSelectedRow();
    String selectIDBH = tblBH1.getValueAt(row, 0).toString();
            JOptionPane.showMessageDialog(this, bhSer.delete(selectIDBH));
            showBH(bhSer.getAll());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi nut delete");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDelBHActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameBH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameBH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBH;
    private javax.swing.JButton btnDelBH;
    private javax.swing.JButton btnUpBH;
    private javax.swing.JComboBox<String> cboIDHDCT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblBH1;
    private javax.swing.JTextField txtIDBH;
    private javax.swing.JTextField txtMaBH;
    private javax.swing.JTextField txtNgayBH;
    private javax.swing.JTextField txtNgayMua;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtThoiGianBH;
    // End of variables declaration//GEN-END:variables
}
