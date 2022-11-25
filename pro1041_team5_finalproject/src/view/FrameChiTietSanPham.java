/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ViewModel.CTSPViewModel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.SanPham;

import service.impl.SanPhamInterface;

import service.SanPhamService;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.CPU;
import model.CardManHinh;
import model.ChiTietSP;
import model.CongKetNoi;
import model.DongSP;
import model.Hedieuhanh;
import model.MauSac;
import model.OCung;
import model.Pin;
import model.Ram;
import service.CPUService;
import service.CardMHService;
import service.ChiTietSPService;
import service.CongKetNoiSer;
import service.DongSPService;
import service.HeDHServices;
import service.MauSacSer;
import service.OCungService;
import service.PinSer;
import service.RamService;
import service.impl.CPUInterface;
import service.impl.CardMHinterFace;
import service.impl.ChiTietSPInteface;
import service.impl.DongSPInterface;
import service.impl.HeDHInterface;
import service.impl.ICongKetNoiS;
import service.impl.IMauSac;
import service.impl.IPinSer;
import service.impl.OCungInterface;
import service.impl.RamInterface;

/**
 *
 * @author Admin
 */
public class FrameChiTietSanPham extends javax.swing.JFrame {

    /**
     * Creates new form FrameChiTietSanPham
     */
    DefaultTableModel dftb = new DefaultTableModel();
    ChiTietSPInteface qlctsp = new ChiTietSPService();
    DongSPInterface qldsp = new DongSPService();
    OCungInterface qloc = new OCungService();
    RamInterface qlram = new RamService();
    IMauSac qlms = new MauSacSer();
    IPinSer qlpin = new PinSer();
    SanPhamInterface qlsp = new SanPhamService();
    HeDHInterface qlhdh = new HeDHServices();
    ICongKetNoiS qlkn = new CongKetNoiSer();
    CPUInterface qlcpu = new CPUService();
    CardMHinterFace qlcard = new CardMHService();
    DefaultComboBoxModel dcbmSP;
    DefaultComboBoxModel dcbmMS;
    DefaultComboBoxModel dcbmDSP;
    DefaultComboBoxModel dcbmOC;
    DefaultComboBoxModel dcbmPin;
    DefaultComboBoxModel dcbmhDH;
    DefaultComboBoxModel dcbmCKN;
    DefaultComboBoxModel dcbmRAM;
    DefaultComboBoxModel dcbmCPU;
    DefaultComboBoxModel dcbmCard;
    List<CTSPViewModel> listCTSP;
    List<SanPham> listSP;
    List<MauSac> listMS;
    List<DongSP> listDSP;
    List<OCung> listOC;
    List<Pin> listPin;
    List<Hedieuhanh> listhdh;
    List<CongKetNoi> listckn;
    List<Ram> listram;
    List<CPU> listcpu;
    List<CardManHinh> listCr;

    public FrameChiTietSanPham() {
        initComponents();
        this.setLocationRelativeTo(null);
        listCTSP = qlctsp.getListCTSPViewModel();

        loadTable();

        listram = qlram.getAll();
        addCBRam();

        listDSP = qldsp.getAll();
        addCBDongSP();

        listOC = qloc.getAll();
        addCBOCung();

        listcpu = qlcpu.getAll();
        addCBCPU();

        listCr = qlcard.getAll();
        addCBCard();

        listMS = qlms.all();
        addCBMS();

        listPin = qlpin.getList();
        addCBPin();

        listhdh = qlhdh.getAll();
        addCBHDH();

        listckn = qlkn.getall();
        addCBKN();

        listSP = qlsp.getAll();
        addCBSP(listSP);

    }

    void addCBCPU() {
        dcbmCPU = (DefaultComboBoxModel) cbCPU.getModel();
        for (CPU cpu : listcpu) {
            dcbmCPU.addElement(cpu);
        }
    }

    void addCBCard() {
        dcbmCard = (DefaultComboBoxModel) cbCard.getModel();
        for (CardManHinh ca : listCr) {
            dcbmCard.addElement(ca);
        }
    }

    void addCBDongSP() {
        dcbmDSP = (DefaultComboBoxModel) cbDongSP.getModel();
        for (DongSP dsp : listDSP) {
            dcbmDSP.addElement(dsp);
        }
    }

    void addCBOCung() {
        dcbmOC = (DefaultComboBoxModel) cbOCung.getModel();
        for (OCung oc : listOC) {
            dcbmOC.addElement(oc);
        }
    }

    void addCBRam() {
        dcbmRAM = (DefaultComboBoxModel) cbRam.getModel();
        for (Ram ram : listram) {
            dcbmRAM.addElement(ram);
        }
    }

    void addCBMS() {
        dcbmMS = (DefaultComboBoxModel) cbMauSac.getModel();
        for (MauSac ms : listMS) {
            dcbmMS.addElement(ms);
        }
    }

    void addCBPin() {
        dcbmPin = (DefaultComboBoxModel) cbPin.getModel();
        for (Pin pin : listPin) {
            dcbmPin.addElement(pin);
        }
    }

    void addCBSP(List<SanPham> listSP) {
        dcbmSP = (DefaultComboBoxModel) cbMa.getModel();
        for (SanPham sanPham : listSP) {
            dcbmSP.addElement(sanPham);
        }
    }

    void addCBHDH() {
        dcbmhDH = (DefaultComboBoxModel) cbHDH.getModel();
        for (Hedieuhanh hdh : listhdh) {
            dcbmhDH.addElement(hdh);
        }
    }

    void addCBKN() {
        dcbmCKN = (DefaultComboBoxModel) cbCKN.getModel();
        for (CongKetNoi kn : listckn) {
            dcbmCKN.addElement(kn);
        }
    }

    void loadTable() {
        dftb = (DefaultTableModel) tb.getModel();
        dftb.setRowCount(0);
        for (CTSPViewModel sp : qlctsp.getListCTSPViewModel()) {
            dftb.addRow(new Object[]{
                sp.getId(), sp.getMaSP(), sp.getDongsp(), sp.getOCung(), sp.getCongKetNoi(), sp.getPin(), sp.getGiaBan(), sp.getSoLuongTon(),
                sp.getSerial(), sp.getHeDH(), sp.getTrangThai(), sp.getCPU(), sp.getRam(), sp.getCardMH(), sp.getMauSac()
            });
        }

    }

    void clearForm() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbRam = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbCPU = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbCard = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbMa = new javax.swing.JComboBox<>();
        cbMauSac = new javax.swing.JComboBox<>();
        cbDongSP = new javax.swing.JComboBox<>();
        cbOCung = new javax.swing.JComboBox<>();
        cbPin = new javax.swing.JComboBox<>();
        cbHDH = new javax.swing.JComboBox<>();
        lbTrangThai = new javax.swing.JLabel();
        cbCKN = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        btnMS = new javax.swing.JButton();
        btnSP = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnOC = new javax.swing.JButton();
        btnPin = new javax.swing.JButton();
        btnCKN = new javax.swing.JButton();
        btnhdh = new javax.swing.JButton();
        btnCra = new javax.swing.JButton();
        btnRam = new javax.swing.JButton();
        btnCPu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Màu sắc");

        jLabel2.setText("Dòng SP");

        jLabel3.setText("Ổ cứng");

        jLabel5.setText("Cổng kết nối");

        jLabel6.setText("Pin");

        jLabel7.setText("Giá bán");

        jLabel9.setText("HDH");

        jLabel10.setText("Sl tồn");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("CT SẢN PHẨM");

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã sp", "Dòng SP", "Ổ cứng", "Cổng kết nối", "Pin", "Giá bán", "Số lượng", "Serial", "Hệ điều hành", "Trạng thái", "CPU", "Ram", "Card MH", "Màu Sắc"
            }
        ));
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel13.setText("Trạng thái");

        jLabel17.setText("Ram");

        jLabel18.setText("CPU");

        jLabel19.setText("Card màn hình");

        jLabel12.setText("Mã SP");

        lbTrangThai.setText("-");

        jLabel4.setText("Id");

        lbID.setText("-");

        btnMS.setText("+");
        btnMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSActionPerformed(evt);
            }
        });

        btnSP.setText("+");
        btnSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnOC.setText("+");
        btnOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOCActionPerformed(evt);
            }
        });

        btnPin.setText("+");
        btnPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinActionPerformed(evt);
            }
        });

        btnCKN.setText("+");
        btnCKN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCKNActionPerformed(evt);
            }
        });

        btnhdh.setText("+");
        btnhdh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhdhActionPerformed(evt);
            }
        });

        btnCra.setText("+");
        btnCra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCraActionPerformed(evt);
            }
        });

        btnRam.setText("+");
        btnRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRamActionPerformed(evt);
            }
        });

        btnCPu.setText("+");
        btnCPu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(26, 26, 26)
                                .addComponent(btnSua))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbMauSac, 0, 134, Short.MAX_VALUE)
                                    .addComponent(cbDongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbOCung, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel4))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbMa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOC)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton3)
                                            .addComponent(btnSP)
                                            .addComponent(btnMS))
                                        .addGap(90, 90, 90)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbPin, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cbHDH, 0, 134, Short.MAX_VALUE)
                                                    .addComponent(txtSL))))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnhdh)
                                            .addComponent(btnPin))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbCard, javax.swing.GroupLayout.Alignment.TRAILING, 0, 135, Short.MAX_VALUE)
                                    .addComponent(cbCPU, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbRam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTrangThai)
                                    .addComponent(cbCKN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCKN)
                                    .addComponent(btnCra)
                                    .addComponent(btnRam)
                                    .addComponent(btnCPu)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel15)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(lbID)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cbCKN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCKN)
                                .addComponent(btnPin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbHDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnhdh))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRam)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(cbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCPu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(cbCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCra))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(lbTrangThai)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(btnSP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOC))))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        // TODO add your handling code here:

        int row = tb.getSelectedRow();
        CTSPViewModel ctsp = listCTSP.get(row);

        txtGiaBan.setText(ctsp.getGiaBan() + "");
        txtSL.setText(ctsp.getSoLuongTon() + "");
        lbID.setText(ctsp.getId());
        cbCKN.setSelectedItem(ctsp.getCongKetNoi());
        cbCPU.setSelectedItem(ctsp.getCPU());
        cbCard.setSelectedItem(ctsp.getCardMH());
        cbDongSP.setSelectedItem(ctsp.getDongsp());
        cbHDH.setSelectedItem(ctsp.getHeDH());
        cbMa.setSelectedItem(ctsp.getMaSP());
        cbMauSac.setSelectedItem(ctsp.getMauSac());
        cbOCung.setSelectedItem(ctsp.getOCung());
        cbPin.setSelectedItem(ctsp.getPin());
        cbRam.setSelectedItem(ctsp.getRam());
        if (Integer.parseInt(txtSL.getText()) == 0) {
            lbTrangThai.setText("Hết hàng");
        } else {

            lbTrangThai.setText("Còn hàng");
        }
    }//GEN-LAST:event_tbMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        SanPham sp = (SanPham) cbMa.getSelectedItem();
        double giaBan = Double.parseDouble(txtGiaBan.getText());
        int slt = Integer.parseInt(txtSL.getText());
        MauSac ms = (MauSac) cbMauSac.getSelectedItem();
        DongSP dsp = (DongSP) cbDongSP.getSelectedItem();
        OCung ocung = (OCung) cbOCung.getSelectedItem();
        CongKetNoi ckn = (CongKetNoi) cbCKN.getSelectedItem();
        Pin pin = (Pin) cbPin.getSelectedItem();
        CPU cpu = (CPU) cbCPU.getSelectedItem();
        Ram ram = (Ram) cbRam.getSelectedItem();
        CardManHinh card = (CardManHinh) cbCard.getSelectedItem();
        Hedieuhanh hdh = (Hedieuhanh) cbHDH.getSelectedItem();

        String idSP = sp.getIdSP();
        String idms = ms.getId();
        String iddsp = dsp.getId();
        String idoc = ocung.getId();
        String idkn = ckn.getId();
        String idpin = pin.getId();
        String idcpu = cpu.getId();
        String idram = ram.getId();
        String idcard = card.getId();
        String idhdh = hdh.getId();

        ChiTietSP ctsp = new ChiTietSP("", giaBan, slt, 0, idms, iddsp, idoc, idkn, idpin, idcpu, idram, idcard, idhdh, idSP);
        qlctsp.insert(ctsp);
        loadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn bản ghi cập nhật");
            return;
        }
        String masp = cbMa.getSelectedItem().toString();
        double giaBan = Double.parseDouble(txtGiaBan.getText());
        int slt = Integer.parseInt(txtSL.getText());
        String mau = cbMauSac.getSelectedItem().toString();
        String dongsp = cbDongSP.getSelectedItem().toString();
        String ocung = cbOCung.getSelectedItem().toString();
        String ckn = cbCKN.getSelectedItem().toString();
        String pin = cbPin.getSelectedItem().toString();
        String cpu = cbCPU.getSelectedItem().toString();
        String ram = cbRam.getSelectedItem().toString();
        String card = cbCard.getSelectedItem().toString();
        String hdh = cbHDH.getSelectedItem().toString();
        ChiTietSP ctsp = new ChiTietSP("", giaBan, slt, 0, mau, dongsp, ocung, ckn, pin, cpu, ram, card, hdh, masp);
        qlctsp.insert(ctsp);
        JOptionPane.showMessageDialog(this, "thêm thành công");
        loadTable();
        clearForm();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chọn bản ghi xóa");
            return;
        }
        String id = lbID.getText();
        qlctsp.delete(id);
        JOptionPane.showMessageDialog(this, "xóa thành công");
        loadTable();
        clearForm();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        DongSP dsp = (DongSP) cbDongSP.getSelectedItem();
        System.out.println(dsp.getId());
        OCung oc = (OCung) cbOCung.getSelectedItem();
        System.out.println(oc.getId());
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnCPuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCPuActionPerformed

    private void btnSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPActionPerformed
        // TODO add your handling code here:
        FrameSanpham sp = new FrameSanpham();
        sp.setVisible(true);
        sp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBSP(listSP);

    }//GEN-LAST:event_btnSPActionPerformed

    private void btnMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMSActionPerformed
        MauSacForm ms = new MauSacForm();
        ms.setVisible(true);
        ms.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBMS();
    }//GEN-LAST:event_btnMSActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FrameDongSP dsp = new FrameDongSP();
        dsp.setVisible(true);
        dsp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBDongSP();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOCActionPerformed
        FrameOCung oc = new FrameOCung();
        oc.setVisible(true);
        oc.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBDongSP();
    }//GEN-LAST:event_btnOCActionPerformed

    private void btnPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPinActionPerformed
        PinForm pin = new PinForm();
        pin.setVisible(true);
        pin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBPin();
    }//GEN-LAST:event_btnPinActionPerformed

    private void btnhdhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhdhActionPerformed
        HeDHFrame hdh = new HeDHFrame();
        hdh.setVisible(true);
        hdh.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBHDH();
    }//GEN-LAST:event_btnhdhActionPerformed

    private void btnCKNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCKNActionPerformed
        CongKetNoiFrame ckn = new CongKetNoiFrame();
        ckn.setVisible(true);
        ckn.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBKN();
    }//GEN-LAST:event_btnCKNActionPerformed

    private void btnRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRamActionPerformed
        JFrameRam ram = new JFrameRam();
        ram.setVisible(true);
        ram.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBRam();
    }//GEN-LAST:event_btnRamActionPerformed

    private void btnCraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCraActionPerformed
        JFrameCard cr = new JFrameCard();
        cr.setVisible(true);
        cr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBCard();
    }//GEN-LAST:event_btnCraActionPerformed

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
            java.util.logging.Logger.getLogger(FrameChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameChiTietSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrameChiTietSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCKN;
    private javax.swing.JButton btnCPu;
    private javax.swing.JButton btnCra;
    private javax.swing.JButton btnMS;
    private javax.swing.JButton btnOC;
    private javax.swing.JButton btnPin;
    private javax.swing.JButton btnRam;
    private javax.swing.JButton btnSP;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnhdh;
    private javax.swing.JComboBox<String> cbCKN;
    private javax.swing.JComboBox<String> cbCPU;
    private javax.swing.JComboBox<String> cbCard;
    private javax.swing.JComboBox<String> cbDongSP;
    private javax.swing.JComboBox<String> cbHDH;
    private javax.swing.JComboBox<String> cbMa;
    private javax.swing.JComboBox<String> cbMauSac;
    private javax.swing.JComboBox<String> cbOCung;
    private javax.swing.JComboBox<String> cbPin;
    private javax.swing.JComboBox<String> cbRam;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
