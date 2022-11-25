/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import ViewModel.CTSPViewModel;
import ViewModel.HoaDonViewModel;
import ViewModel.SanPhamBanHangViewModel;
import ViewModel.TBGioHang;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DongSP;
import model.HoaDon;
import model.HoaDonCT;
import model.KhachHang;
import model.MauSac;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import repository.BanHangRepo;
import service.ChiTietSPService;
import service.DongSPService;
import service.HoaDonCTSer;
import service.HoaDonService;
import service.KhachHangService;
import service.MauSacSer;
import service.impl.ChiTietSPInteface;
import service.impl.DongSPInterface;
import service.impl.IHoaDonCT;
import service.impl.IHoaDonS;
import service.impl.IMauSac;
import service.impl.KhachHangInter;

/**
 *
 * @author Administrator
 */
public class BanHang extends javax.swing.JFrame {

    DefaultTableModel dtmCTSP = new DefaultTableModel();
    List<SanPhamBanHangViewModel> listSPCT = new ArrayList<>();
    ChiTietSPInteface ctspSevices;
    private ArrayList<TBGioHang> lishGH = new ArrayList<>();
    DefaultTableModel dtmHDCT = new DefaultTableModel();
    List<HoaDonCT> listHDCT = new ArrayList<>();
    IHoaDonCT hdctServices = new HoaDonCTSer();
    IHoaDonS qlhd = new HoaDonService();
    BanHangRepo qlbh = new BanHangRepo();
    DefaultComboBoxModel dfcb = new DefaultComboBoxModel();
    IMauSac qlms = new MauSacSer();
    DongSPInterface qldsp = new DongSPService();
    ChiTietSPInteface qlctsp = new ChiTietSPService();
    KhachHangInter qlkh = new KhachHangService();


    public BanHang() {

        initComponents();
        dtmCTSP = (DefaultTableModel) tblSP.getModel();
        ctspSevices = new ChiTietSPService();
        listSPCT = ctspSevices.getAllSPBH();
        showData(listSPCT);

        addCBMS();

        dtmHDCT = (DefaultTableModel) tblHDCT.getModel();
        listHDCT = hdctServices.getAll();
        loadTableHD(qlbh.getListHoaDon());
        addCbKh();
        cbTimKiem();
        addCBDSP();
        this.setLocationRelativeTo(null);
    }

    public void cbTimKiem() {
        cbKH.setEditable(true);
        AutoCompleteDecorator.decorate(cbKH);

    }

    void addCbKh() {
        dfcb = (DefaultComboBoxModel) cbKH.getModel();
        for (KhachHang kh : qlkh.getList()) {
            dfcb.addElement(kh);
        }
    }

    void addCBMS() {
        dfcb = (DefaultComboBoxModel) cbMau.getModel();
        for (MauSac ms : qlms.all()) {
            dfcb.addElement(ms);
        }
    }

    void addCBDSP() {
        dfcb = (DefaultComboBoxModel) cbDSP.getModel();
        for (DongSP dsp : qldsp.getAll()) {
            dfcb.addElement(dsp);
        }
    }


    private void showData(List<SanPhamBanHangViewModel> litSp) {
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel s : litSp) {
            dtmCTSP.addRow(s.toDataRow());
        }
    }


    private void showDataMau() {
        String mau = cbMau.getSelectedItem().toString();
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel s : qlctsp.getMau(mau)) {
            dtmCTSP.addRow(s.toDataRow());
        }
    }

    private void showDataDSP() {
        String dsp = cbDSP.getSelectedItem().toString();
        dtmCTSP.setRowCount(0);
        for (SanPhamBanHangViewModel s : qlctsp.getDongSP(dsp)) {
            dtmCTSP.addRow(s.toDataRow());
        }
    }


    void updateGH(TBGioHang gh) {
        TBGioHang ghSearch = qlbh.updateGH(lishGH, gh.getMaSP());
        if (ghSearch != null) {
            ghSearch.setSoLuong(gh.getSoLuong());
        }


    }

    void ghiFile() throws FileNotFoundException, IOException {
        File file = new File("dataObject.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (TBGioHang gh : lishGH) {
            oos.writeObject(gh);
        }
        fos.close();
        oos.close();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        cbMau = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbDSP = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbOCung = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbRam = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbHdh = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        btnXoaSP = new javax.swing.JButton();
        btnXoaTatCa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTaoHD = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        lbTienThua = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        cbKH = new javax.swing.JComboBox<>();
        txtKhachhang = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sp", "Tên sp", "Màu sắc", "Dòng sp", "Ô cứng", "Pin", "CPU", "Ram", "HeDH", "Số lượng tồn", "Giá bán"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMauMouseClicked(evt);
            }
        });
        cbMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMauActionPerformed(evt);
            }
        });
        cbMau.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbMauPropertyChange(evt);
            }
        });

        jLabel8.setText("Màu sắc");

        cbDSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDSPActionPerformed(evt);
            }
        });

        jLabel10.setText("Dòng SP");

        cbOCung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        jLabel11.setText("Ổ cứng");

        cbRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        jLabel12.setText("Ram");

        cbHdh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));

        jLabel13.setText("HDH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cbDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cbOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbHdh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHdh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sp", "Tên sp", "Giá", "Số lương", "Tổng tiền"
            }
        ));
        tblHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHDCT);

        btnXoaSP.setText("Xóa sản phẩm");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnXoaTatCa.setText("Xóa tất cả SP");
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaSP)
                    .addComponent(btnXoaTatCa))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnXoaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(59, 59, 59)
                        .addComponent(btnXoaTatCa))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Khách hàng :");

        jLabel3.setText("Nhân viên");

        btnTaoHD.setText("Tạo Hóa đơn chờ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jButton4.setText("In HD + thanh toán");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Tiền khách đưa : ");

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });

        jLabel7.setText("Tổng tiền hàng :");

        lbTongTien.setText("-");

        jLabel4.setText("Tiền thừa");

        jLabel5.setText("SĐT KH");

        jButton2.setText("Lưu HD");

        jLabel9.setText("Giảm giá");

        jButton3.setText("ClearForm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lbTienThua.setText("-");

        lbNhanVien.setText("-");

        jButton5.setText("Add KH mới");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cbKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        cbKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNhanVien)
                                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbKH, 0, 154, Short.MAX_VALUE)
                                    .addComponent(txtKhachhang))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 14, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTongTien)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(lbTienThua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton3)))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton5)
                    .addComponent(cbKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNhanVien)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbTongTien))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton3)
                    .addComponent(lbTienThua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoHD)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addGap(75, 75, 75))
        );

        tbHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã HD", "Ngày tạo", "Mã NV", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbHD);

        jTabbedPane1.addTab("Hóa Đơn Chờ", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(634, 634, 634)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDCTMouseClicked

     

    }//GEN-LAST:event_tblHDCTMouseClicked

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        int count = tblHDCT.getRowCount();
        String txtSoLuong = JOptionPane.showInputDialog("nhập số lượng");
        try {
            Integer.valueOf(txtSoLuong);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "nhập số");
            return;
        }
        int soLuong = Integer.valueOf(txtSoLuong);
        int row = tblSP.getSelectedRow();
        int slton = Integer.parseInt(tblSP.getValueAt(row, 9).toString());
//             SanPhamBanHangViewModel sp = listSPCT.get(row);
        if (soLuong > slton) {
            JOptionPane.showMessageDialog(this, "không đủ sản phẩm");
            return;
        }
        String ma = tblSP.getValueAt(row, 0).toString();
        String ten = tblSP.getValueAt(row, 1).toString();
        double gia = Double.parseDouble(tblSP.getValueAt(row, 10).toString());
        TBGioHang gh = new TBGioHang(ma, ten, soLuong, gia, 0);
        lishGH.add(gh);
        tblSP.setValueAt(slton - soLuong, row, 9);
        loadTableGiahang(lishGH);


    }//GEN-LAST:event_tblSPMouseClicked

    void loadTableGiahang(ArrayList<TBGioHang> list) {
        DefaultTableModel dftb = new DefaultTableModel();
        dftb = (DefaultTableModel) tblHDCT.getModel();
        dftb.setRowCount(0);
        for (TBGioHang gh : list) {
            dftb.addRow(new Object[]{
                gh.getMaSP(), gh.getTenSP(), gh.getDonGia(), gh.getSoLuong(), gh.getTongTien()
            });
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        int hoaDonCho = tbHD.getRowCount();
        if (hoaDonCho > 4) {
            JOptionPane.showMessageDialog(this, "tối đa 5 hóa đơn chờ");
            return;
        }
        HoaDonViewModel hd = new HoaDonViewModel();
        Random ranDom = new Random();
        String ma = "HD" + ranDom.nextInt(1000);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        hd.setMaHD(ma);
        hd.setMaNV("nv01");
        hd.setNgayTao(date);
        hd.setTrangThai("Chưa thanh toán");
        qlbh.insertHDR(hd);
        loadTableHD(qlbh.getListHoaDon());
    }//GEN-LAST:event_btnTaoHDActionPerformed


    private void cbMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMauMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_cbMauMouseClicked

    private void cbMauPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbMauPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_cbMauPropertyChange

    private void cbMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMauActionPerformed
        // TODO add your handling code here:
        String mau = cbMau.getSelectedItem().toString();
        if (mau.equals("Tất cả")) {
            showData(listSPCT);
        } else {
            showDataMau();
        }

    }//GEN-LAST:event_cbMauActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // TODO add your handling code here:
        int coun = tblHDCT.getRowCount();
        if (coun == 0) {
            JOptionPane.showMessageDialog(this, "không có sản phẩm để xóa");
            return;
        }
        int row = tblHDCT.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn sản phẩm cần xóa");
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa sản phẩm khỏi giỏ hàng?", "", JOptionPane.YES_OPTION);
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        String slxoa = JOptionPane.showInputDialog("nhập số lượng sản phẩm muốn xóa");
        int sl = Integer.parseInt(tblHDCT.getValueAt(row, 3).toString());
        if (Integer.parseInt(slxoa) > sl) {
            JOptionPane.showMessageDialog(this, "không đủ số lượng để xóa");
            return;
        }
        try {
            Integer.parseInt(slxoa);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "nhập số");
            return;
        }
        if (choice == JOptionPane.YES_OPTION) {

            int slXoa = Integer.parseInt(slxoa);
            int count = tblSP.getRowCount();
            for (int i = 0; i < count; i++) {
                if (tblHDCT.getValueAt(row, 0).toString().equals(tblSP.getValueAt(i, 0))) {
                    int slton = Integer.parseInt(tblSP.getValueAt(i, 9).toString());
                    tblSP.setValueAt(slXoa + slton, i, 9);
                    tblHDCT.setValueAt(sl - slXoa, row, 3);
                    String ma = tblHDCT.getValueAt(row, 0).toString();
                    String ten = tblHDCT.getValueAt(row, 1).toString();
                    double gia = Double.parseDouble(tblHDCT.getValueAt(row, 2).toString());
                    int slsp = Integer.parseInt(tblHDCT.getValueAt(row, 3).toString());
                    TBGioHang gh = new TBGioHang(ma, ten, slsp, gia, 0);
                    updateGH(gh);
                    if (gh.getSoLuong() == 0) {
                        System.out.println(slsp);
                        lishGH.remove(gh);
                        loadTableGiahang(lishGH);
                    }

                }
            }

        }

    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaActionPerformed
        // TODO add your handling code here:
        int count = tblHDCT.getRowCount();
        System.out.println(count);
        if (count == 0) {
            JOptionPane.showMessageDialog(this, "không có sản phẩm để xóa");
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "xác nhận xóa tất cả sản phẩm", "xóa", JOptionPane.YES_OPTION);
        if (choice != JOptionPane.YES_OPTION) {
            return;
        }
        lishGH.removeAll(lishGH);
        loadTableGiahang(lishGH);
    }//GEN-LAST:event_btnXoaTatCaActionPerformed

    private void cbKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKHActionPerformed
        // TODO add your handling code here:
        String sdt = cbKH.getSelectedItem().toString();
        KhachHang kh = qlbh.getListSDT(sdt);
        if (kh != null) {
            txtKhachhang.setText(kh.getHoTen());
        } else {
            txtKhachhang.setText("");
        }
    }//GEN-LAST:event_cbKHActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Random rd = new Random();
        String sdt = cbKH.getSelectedItem().toString();
        String ten = txtKhachhang.getText();
        String ma = "KH" + rd.nextInt(1000);
        KhachHang kh = new KhachHang();
        kh.setMa(ma);
        kh.setHoTen(ten);
        kh.setSdt(sdt);
        qlkh.insert(kh);
        addCbKh();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtKhachhang.setText("");
        cbKH.setSelectedIndex(0);
        txtGiamGia.setText("");
        txtTienKhachDua.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDSPActionPerformed
        // TODO add your handling code here:
        String dsp = cbDSP.getSelectedItem().toString();
        if (dsp.equals("Tất cả")) {
            showData(listSPCT);
        } else {
            showDataDSP();
        }
    }//GEN-LAST:event_cbDSPActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        if (txtSearch.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập mã hoặc tên để tìm kiếm");
            showData(listSPCT);
            return;
        } else {
            ArrayList<SanPhamBanHangViewModel> listctsp = (ArrayList<SanPhamBanHangViewModel>) qlbh.searchMa(txtSearch.getText().trim());
            ArrayList<SanPhamBanHangViewModel> listct = (ArrayList<SanPhamBanHangViewModel>) qlbh.searchTen(txtSearch.getText().trim());

            if (!listctsp.isEmpty()) {
                showData(listctsp);
            } else if (!listct.isEmpty()) {
                showData(listct);
            } else {
                showData(listSPCT);
            }

        }
    }//GEN-LAST:event_btnTimKiemActionPerformed


    void loadTableHD(ArrayList<HoaDonViewModel> list) {
        DefaultTableModel dftb = new DefaultTableModel();
        dftb = (DefaultTableModel) tbHD.getModel();
        dftb.setRowCount(0);
        for (HoaDonViewModel hd : list) {
            dftb.addRow(new Object[]{
                hd.getMaHD(), hd.getNgayTao(), hd.getMaNV(), hd.getTrangThai()
            });
        }
    }

    public String maTuSinh() {
        String ma = null;
        Random ran = new Random();
        int ren = ThreadLocalRandom.current().nextInt();
        List<HoaDon> list = qlhd.getAll();
        for (int i = 0; i < list.size(); i++) {
            ma = "HD0" + ren;
        }
        return ma;
    }

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JButton btnXoaTatCa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbDSP;
    private javax.swing.JComboBox<String> cbHdh;
    private javax.swing.JComboBox<String> cbKH;
    private javax.swing.JComboBox<String> cbMau;
    private javax.swing.JComboBox<String> cbOCung;
    private javax.swing.JComboBox<String> cbRam;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbTienThua;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tbHD;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtKhachhang;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienKhachDua;
    // End of variables declaration//GEN-END:variables

}
