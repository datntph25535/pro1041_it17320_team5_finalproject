/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSP;
import model.HoaDon;
import model.HoaDonCT;
import service.ChiTietSPService;
import service.HoaDonCTSer;
import service.HoaDonService;
import service.impl.ChiTietSPInteface;
import service.impl.IHoaDonCT;
import service.impl.IHoaDonS;

/**
 *
 * @author Admin
 */
public class HoaDonF1 extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private IHoaDonS serr;
    private IHoaDonCT serCT;
    private ChiTietSPInteface serchi;
    private DefaultComboBoxModel cbb;

    /**
     * Creates new form HoaDonF
     */
    public HoaDonF1() {
        initComponents();
        serr = new HoaDonService();
        serCT = new HoaDonCTSer();
        serchi = new ChiTietSPService();
        defaultComboBoxModel = new DefaultComboBoxModel();
        defaultTableModel = new DefaultTableModel();
        loadTable(serr.getAll());
        loadTBHDCT();
        cbb = new DefaultComboBoxModel();
        loadComboboxCT();
        loadComboboxHD();
    }

    public void loadComboboxCT() {
        defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel = (DefaultComboBoxModel) cbIDCTSP.getModel();
        List<ChiTietSP> list = this.serchi.getAll();
        for (ChiTietSP sanPham : list) {
            cbIDCTSP.addItem(sanPham);
        }
    }

    public void loadComboboxHD() {
        defaultComboBoxModel = new DefaultComboBoxModel();
        defaultComboBoxModel = (DefaultComboBoxModel) cbMaHD.getModel();
        List<HoaDon> list = this.serr.getAll();
        for (HoaDon hoaDon : list) {
            cbMaHD.addItem(hoaDon);
        }
    }

    public void loadTable(List<HoaDon> lisst) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel = (DefaultTableModel) tbHoaDon.getModel();
        defaultTableModel.setRowCount(0);
        for (HoaDon hoaDon : lisst) {
            defaultTableModel.addRow(new Object[]{
                hoaDon.getMa(), hoaDon.getNgayTao(), hoaDon.getNgayThanhToan(), hoaDon.getNgayNhan(), hoaDon.getSdt(),
                hoaDon.getTrangThai(), 0
            }
            );
        }
    }

    public void loadTBHDCT() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) tbCTHD.getModel();
        dtm.setRowCount(0);
        for (HoaDonCT ct : serCT.getAll()) {
            dtm.addRow(new Object[]{
                ct.getIdHD(), ct.getIdCTSP(), "pana", ct.getSoLuong(), ct.getGia(), ct.getGia() * ct.getSoLuong()
            });
        }

    }

    public HoaDon getFormData() {
        String ma = txtMa.getText().trim();
        String ngaytt = txtNgayTT.getText().trim();
        String ngayt = txtNgayTao.getText().trim();
        String ngayn = txtNgayNhan.getText().trim();
        String sdt = txtSDT.getText().trim();
        String trangThai = cbTrangThai.getSelectedItem().toString();
        String thanhtien = txtThanhTien.getText().trim();
        txtThanhTien.setEditable(false);
        if (ma.length() == 0
                || ngaytt.length() == 0
                || ngayn.length() == 0
                || ngayt.length() == 0
                || sdt.length() == 0) {
            JOptionPane.showMessageDialog(this, "Kh??ng ????? tr???ng");
            return null;
        }
        Date date = null;
        try {
            date = Date.valueOf(ngaytt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nh???p l???i ng??y");
            return null;
        }
        Date ngaynhan = null;
        try {
            ngaynhan = Date.valueOf(ngayn);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nh???p l???i ng??y");
            return null;
        }
        Date ngaytao = null;
        try {
            ngaytao = Date.valueOf(ngayt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nh???p l???i ng??y");
            return null;
        }
        String REG = "^0[0-9]{9}";
        if (!sdt.matches(REG)) {
            JOptionPane.showMessageDialog(this, "Sai dinh dang Sdt. Nhap lai Sdt !");
            return null;
        }
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa(ma);
        hoaDon.setNgayThanhToan(date);
        hoaDon.setNgayNhan(ngaynhan);
        hoaDon.setNgayTao(ngaytao);
//        hoaDon.setDiaChi(dchi);
        hoaDon.setSdt(sdt);
        hoaDon.setTrangThai(trangThai);
        return hoaDon;
    }

    public HoaDonCT getHDCTF() {
        String soluong = txtSoLuongCT.getText().trim();
        String gia = txtGiaCT.getText().trim();
        HoaDon hd = (HoaDon) cbMaHD.getSelectedItem();
        ChiTietSP ctsp = (ChiTietSP) cbIDCTSP.getSelectedItem();
        if (soluong.length() == 0
                || gia.length() == 0) {
            JOptionPane.showMessageDialog(this, "kh??ng ????? tr???ng");
            return null;
        }
        int sl = -1;
        try {
            sl = Integer.parseInt(soluong);
            if (sl < 0) {
                JOptionPane.showMessageDialog(this, "Nh???p l???i s??? l?????ng");
                return null;
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Nh???p l???i s??? l?????ng");
            return null;

        }
        double donGia = -1;
        try {
            donGia = Double.parseDouble(gia);
            if (donGia < 0) {
                JOptionPane.showMessageDialog(this, "Nh???p l???i gia");
                return null;
            }
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(this, "Nh???p l???i gi??");
            return null;

        }
        HoaDonCT ct = new HoaDonCT();
        ct.setIdHD(hd.getId());
        ct.setIdCTSP(ctsp.getId());
        ct.setGia(donGia);
        ct.setSoLuong(sl);
        return ct;
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
        cbThang = new javax.swing.JComboBox<>();
        cbNam = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtNgayTT = new javax.swing.JTextField();
        txtNgayNhan = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        btnupdtae = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbTrangThai = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        btnInsertHDCT = new javax.swing.JButton();
        btnUpdateHDCT = new javax.swing.JButton();
        btnDeleteHDCT = new javax.swing.JButton();
        txtSoLuongCT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGiaCT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbMaHD = new javax.swing.JComboBox<HoaDon>();
        cbIDCTSP = new javax.swing.JComboBox<ChiTietSP>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("T??m theo th??ng - n??m"));

        cbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThangActionPerformed(evt);
            }
        });

        cbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023" }));
        cbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setText("Ng??y T???o");

        jLabel2.setText("M??");

        jLabel3.setText("Ng??y thanh to??n");

        jLabel4.setText("Ng??y nh???n");

        jLabel5.setText("SDT kh??ch h??ng");

        jLabel7.setText("Th??nh ti???n");

        txtSearch.setText("T??m ki???m ho?? ????n");

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "M??", "Ng??y t???o", "Ng??y thanh to??n", "Ng??y nh???n", "SDT Kh??ch h??ng", "Tr???ng th??i", "Th??nh ti???n"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnupdtae.setText("Update ");
        btnupdtae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdtaeActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel6.setText("Tr???ng Th??i");

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "???? thanh to??n", "Ch??a thanh to??n", "Ch??? thanh to??n" }));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("HoaDonChiTiet"));

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "M?? HD", "Id CTSP", "T??n S???n Ph???m", "S??? l?????ng", "Gi??", "Th??nh ti???n"
            }
        ));
        jScrollPane2.setViewportView(tbCTHD);

        btnInsertHDCT.setText("InsertHDCT");
        btnInsertHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertHDCTActionPerformed(evt);
            }
        });

        btnUpdateHDCT.setText("UpdateHDCT");
        btnUpdateHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateHDCTActionPerformed(evt);
            }
        });

        btnDeleteHDCT.setText("DeleteHDCT");
        btnDeleteHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHDCTActionPerformed(evt);
            }
        });

        jLabel8.setText("S??? l?????ng");

        jLabel9.setText("Gi?? ");

        cbMaHD.setModel(new javax.swing.DefaultComboBoxModel<HoaDon>());

        cbIDCTSP.setModel(new javax.swing.DefaultComboBoxModel<ChiTietSP>());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnInsertHDCT)
                                .addGap(63, 63, 63)
                                .addComponent(btnUpdateHDCT)
                                .addGap(54, 54, 54)
                                .addComponent(btnDeleteHDCT)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaCT, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtSoLuongCT))
                                .addGap(112, 112, 112)
                                .addComponent(cbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbIDCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(346, 346, 346)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIDCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertHDCT)
                    .addComponent(btnUpdateHDCT)
                    .addComponent(btnDeleteHDCT))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnupdtae)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMa)
                                            .addComponent(txtNgayTao)
                                            .addComponent(txtNgayTT)
                                            .addComponent(txtNgayNhan)
                                            .addComponent(txtSDT)
                                            .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                            .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNgayTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnupdtae)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        HoaDon hd = this.getFormData();
        if (hd == null) {
            return;
        }
        if (serr.insertHD(hd) <= -1) {
            JOptionPane.showMessageDialog(this, "Th??m th???t b???i");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng");
        }

        this.loadTable(serr.getAll());
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnupdtaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdtaeActionPerformed
        // TODO add your handling code here:
        int row = tbHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Ch???n d??ng ????? s???a");
            return;
        }
        HoaDon hd = this.getFormData();
        if (hd == null) {
            return;
        }
        if (serr.updateHD(hd, hd.getMa()) <= -1) {
            JOptionPane.showMessageDialog(this, "c???p nh???t th???t b???i");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
        }

        loadTable(serr.getAll());
    }//GEN-LAST:event_btnupdtaeActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tbHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Ch???n d??ng ????? xo??");
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n xo???");
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        Integer kq = serr.deleteHD(tbHoaDon.getValueAt(row, 0).toString());
        if (kq <= -1) {
            JOptionPane.showMessageDialog(this, "Xo?? th???t b???i");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Xo?? th??nh c??ng");
        }
        loadTable(serr.getAll());
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tbHoaDon.getSelectedRow();
        txtMa.setText(tbHoaDon.getValueAt(row, 0).toString());

        txtNgayTao.setText(tbHoaDon.getValueAt(row, 1).toString());
        txtNgayTT.setText(tbHoaDon.getValueAt(row, 2).toString());
        txtNgayNhan.setText(tbHoaDon.getValueAt(row, 3).toString());
        txtSDT.setText(tbHoaDon.getValueAt(row, 4).toString());
        cbTrangThai.setSelectedItem(tbHoaDon.getValueAt(row, 5).toString());
        txtThanhTien.setText(tbHoaDon.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtSearch.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Nh???p m?? ho???c t??n ????? t??m ki???m");
            return;
        } else {
            List<HoaDon> listHD = serr.searchHD(txtSearch.getText().trim());

            if (listHD.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y th??ng tin");

                return;
            } else {
                JOptionPane.showMessageDialog(this, "???? t??m th???y th??ng tin");
                loadTable(listHD);
            }

        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThangActionPerformed
        // TODO add your handling code here:
        int index = cbThang.getSelectedIndex();

        List<HoaDon> list = serr.searchThang(Integer.parseInt(cbThang.getItemAt(index)));

        if (list.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y");
            loadTable(list);
            return;
        } else {
//        JOptionPane.showMessageDialog(this, "???? t??m th???y");

            loadTable(list);
            return;
        }
    }//GEN-LAST:event_cbThangActionPerformed

    private void cbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamActionPerformed
        // TODO add your handling code here:
        int index = cbNam.getSelectedIndex();
        List<HoaDon> list = serr.searchNam(Integer.parseInt(cbNam.getItemAt(index)));
        if (list.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y");
            loadTable(list);
            return;
        } else {
//        JOptionPane.showMessageDialog(this, "???? t??m th???y");

            loadTable(list);
            return;
        }
    }//GEN-LAST:event_cbNamActionPerformed

    private void btnInsertHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertHDCTActionPerformed
        // TODO add your handling code here:
        HoaDonCT ct = this.getHDCTF();
        if (ct == null) {
            return;
        }
        Integer kq = serCT.insertHDCT(ct);
        if (kq <= -1) {
            JOptionPane.showMessageDialog(this, "Th??m Th???t b???i");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Th??m Th??nh c??ng");
            loadTBHDCT();
        }
    }//GEN-LAST:event_btnInsertHDCTActionPerformed

    private void btnUpdateHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateHDCTActionPerformed
        // TODO add your handling code here:
        int row = tbCTHD.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Ch???n d??ng ????? s???a");
            return;
        }
        HoaDonCT ct = this.getHDCTF();
        if (ct == null) {
            return;
        }
        Integer kq = serCT.updateHDCT(ct, ct.getId());
        if (kq <= -1) {
            JOptionPane.showMessageDialog(this, "S???a Th???t b???i");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "S???a Th??nh c??ng");
            loadTBHDCT();
        }
    }//GEN-LAST:event_btnUpdateHDCTActionPerformed

    private void btnDeleteHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHDCTActionPerformed
        // TODO add your handling code here:
        int row = tbCTHD.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Ch???n d??ng ????? xo??");
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c mu???n xo???");
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        Integer kq = serCT.deleteHDCT(tbCTHD.getValueAt(row, 0).toString());
        if (kq <= -1) {
            JOptionPane.showMessageDialog(this, "Xo?? Th???t b???i");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Xo?? Th??nh c??ng");
            loadTBHDCT();
        }
    }//GEN-LAST:event_btnDeleteHDCTActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonF1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonF1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonF1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonF1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonF1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteHDCT;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnInsertHDCT;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateHDCT;
    private javax.swing.JButton btnupdtae;
    private javax.swing.JComboBox<ChiTietSP> cbIDCTSP;
    private javax.swing.JComboBox<HoaDon> cbMaHD;
    private javax.swing.JComboBox<String> cbNam;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtGiaCT;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgayNhan;
    private javax.swing.JTextField txtNgayTT;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuongCT;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
