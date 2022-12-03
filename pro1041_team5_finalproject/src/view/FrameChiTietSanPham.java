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
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
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
    DefaultComboBoxModel dfcb = new DefaultComboBoxModel();
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
        
        addLocOcung();
        addLocCongKN();
        addLocPin();
        addLocHDH();
        addLocCPU();
        addLocRam();
        addLocCard();
        addLocDSP();
        addLocMS();
    }

    void addCBCPU() {
        dcbmCPU = (DefaultComboBoxModel) cbCPU.getModel();
        dcbmCPU.removeAllElements();
        for (CPU cpu : listcpu) {
            dcbmCPU.addElement(cpu.getTen());
        }
    }

    void addCBCard() {
        dcbmCard = (DefaultComboBoxModel) cbCard.getModel();
        dcbmCard.removeAllElements();
        for (CardManHinh ca : listCr) {
            dcbmCard.addElement(ca.getLoaiCard());
        }
    }

    void addCBDongSP() {
        dcbmDSP = (DefaultComboBoxModel) cbDongSP.getModel();
        dcbmDSP.removeAllElements();
        for (DongSP dsp : listDSP) {
            dcbmDSP.addElement(dsp.getTen());
        }
    }

    void addCBOCung() {
        dcbmOC = (DefaultComboBoxModel) cbOCung.getModel();
        dcbmOC.removeAllElements();
        for (OCung oc : listOC) {
            dcbmOC.addElement(oc.getDungLuong());
        }
    }

    void addCBRam() {
        dcbmRAM = (DefaultComboBoxModel) cbRam.getModel();
        dcbmRAM.removeAllElements();
        for (Ram ram : listram) {
            dcbmRAM.addElement(ram.getDungLuong());
        }
    }

    void addCBMS() {
        dcbmMS = (DefaultComboBoxModel) cbMauSac.getModel();
        dcbmMS.removeAllElements();
        for (MauSac ms : listMS) {
            dcbmMS.addElement(ms.getTen());
        }
    }

    void addCBPin() {
        dcbmPin = (DefaultComboBoxModel) cbPin.getModel();
        for (Pin pin : listPin) {
            dcbmPin.addElement(pin.getDungLuong());
        }
    }

    void addCBSP(List<SanPham> listSP) {
        dcbmSP = (DefaultComboBoxModel) cbMa.getModel();
        dcbmSP.removeAllElements();
        for (SanPham sanPham : listSP) {
            dcbmSP.addElement(sanPham.getMaSP());
        }
    }

    void addCBHDH() {
        dcbmhDH = (DefaultComboBoxModel) cbHDH.getModel();
        dcbmhDH.removeAllElements();
        for (Hedieuhanh hdh : listhdh) {
            dcbmhDH.addElement(hdh.getTenHDH());
        }
    }

    void addCBKN() {
        dcbmCKN = (DefaultComboBoxModel) cbCKN.getModel();
        dcbmCKN.removeAllElements();
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
    
    void addLocOcung(){
        dfcb = (DefaultComboBoxModel) cbLocOC.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(OCung oc : listOC){
            dfcb.addElement(oc.getDungLuong());
        }
    }
    void addLocCongKN(){
        dfcb = (DefaultComboBoxModel) cbLocCKN.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(CongKetNoi ckn : listckn){
            dfcb.addElement(ckn.getTen());
        }
    }
    void addLocPin(){
        dfcb = (DefaultComboBoxModel) cbLocPin.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(Pin pin : listPin){
            dfcb.addElement(pin.getDungLuong());
        }
    }
    void addLocHDH(){
        dfcb = (DefaultComboBoxModel) cbLocHDH.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(Hedieuhanh hdh : listhdh){
            dfcb.addElement(hdh);
        }
    }
    void addLocCPU(){
        dfcb = (DefaultComboBoxModel) cbLocCPU.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(CPU cpu : listcpu){
            dfcb.addElement(cpu.getTen());
        }
    }
    void addLocRam(){
        dfcb = (DefaultComboBoxModel) cbLocRam.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(Ram ram : listram){
            dfcb.addElement(ram.getDungLuong());
        }
    }
    void addLocCard(){
        dfcb = (DefaultComboBoxModel) cbLocCard.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(CardManHinh card : listCr){
            dfcb.addElement(card.getLoaiCard());
        }
    }
    void addLocMS(){
        dfcb = (DefaultComboBoxModel) cbLocMS.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(MauSac ms : listMS){
            dfcb.addElement(ms.getTen());
        }
    }
    void addLocDSP(){
        dfcb = (DefaultComboBoxModel) cbLocDSP.getModel();
        dfcb.removeAllElements();
        dfcb.addElement("");
        for(DongSP dsp : listDSP){
            dfcb.addElement(dsp.getTen());
        }
    }

    void clearForm() {
        
        lbID.setText("-");
        lbTrangThai.setText("-");
        txtGiaBan.setText("");
        txtSL.setText("");
        txtTimKiem.setText("");
        cbMa.setSelectedItem(0);
        cbMauSac.setSelectedItem(0);
        cbDongSP.setSelectedItem(0);
        cbOCung.setSelectedItem(0);
        cbPin.setSelectedItem(0);
        cbHDH.setSelectedItem(0);
        cbCKN.setSelectedItem(0);
        cbRam.setSelectedItem(0);
        cbCPU.setSelectedItem(0);
        cbCard.setSelectedItem(0);

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
        btnDSP = new javax.swing.JButton();
        btnOC = new javax.swing.JButton();
        btnPin = new javax.swing.JButton();
        btnCKN = new javax.swing.JButton();
        btnhdh = new javax.swing.JButton();
        btnCra = new javax.swing.JButton();
        btnRam = new javax.swing.JButton();
        btnCPu = new javax.swing.JButton();
        btnReLoad = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbLocDSP = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbLocOC = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbLocCKN = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbLocPin = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cbLocHDH = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbLocCPU = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbLocRam = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cbLocCard = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbLocMS = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Màu sắc");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 167, -1, -1));

        jLabel2.setText("Dòng SP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 196, -1, -1));

        jLabel3.setText("Ổ cứng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 225, -1, -1));

        jLabel5.setText("Cổng kết nối");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(736, 107, -1, -1));

        jLabel6.setText("Pin");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 107, -1, -1));

        jLabel7.setText("Giá bán");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 135, -1, -1));
        getContentPane().add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 132, 134, -1));

        jLabel9.setText("HDH");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 167, -1, -1));
        getContentPane().add(txtSL, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 192, 134, -1));

        jLabel10.setText("Sl tồn");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 195, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("CT SẢN PHẨM");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 11, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 366, 1030, 238));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 267, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 267, -1, -1));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 267, -1, -1));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 267, -1, -1));

        jLabel13.setText("Trạng thái");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 219, -1, -1));

        jLabel17.setText("Ram");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 141, -1, -1));

        getContentPane().add(cbRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 133, 135, -1));

        jLabel18.setText("CPU");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 165, -1, -1));

        getContentPane().add(cbCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 162, 135, -1));

        jLabel19.setText("Card màn hình");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 194, -1, -1));

        getContentPane().add(cbCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 191, 135, -1));
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 268, 178, -1));

        jLabel12.setText("Mã SP");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 133, -1, -1));

        getContentPane().add(cbMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 130, 134, -1));

        getContentPane().add(cbMauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 164, 134, -1));

        getContentPane().add(cbDongSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 193, 134, -1));

        getContentPane().add(cbOCung, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 222, 134, -1));

        getContentPane().add(cbPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 104, 134, -1));

        getContentPane().add(cbHDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 164, 134, -1));

        lbTrangThai.setText("-");
        getContentPane().add(lbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 219, -1, -1));

        getContentPane().add(cbCKN, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 104, 135, -1));

        jLabel4.setText("Id");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 101, -1, -1));

        lbID.setText("-");
        getContentPane().add(lbID, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 101, 200, -1));

        btnMS.setText("+");
        btnMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSActionPerformed(evt);
            }
        });
        getContentPane().add(btnMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 163, -1, -1));

        btnSP.setText("+");
        btnSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPActionPerformed(evt);
            }
        });
        getContentPane().add(btnSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 129, -1, -1));

        btnDSP.setText("+");
        btnDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSPActionPerformed(evt);
            }
        });
        getContentPane().add(btnDSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 192, -1, -1));

        btnOC.setText("+");
        btnOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOCActionPerformed(evt);
            }
        });
        getContentPane().add(btnOC, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 221, -1, -1));

        btnPin.setText("+");
        btnPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPinActionPerformed(evt);
            }
        });
        getContentPane().add(btnPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 103, -1, -1));

        btnCKN.setText("+");
        btnCKN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCKNActionPerformed(evt);
            }
        });
        getContentPane().add(btnCKN, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 103, -1, -1));

        btnhdh.setText("+");
        btnhdh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhdhActionPerformed(evt);
            }
        });
        getContentPane().add(btnhdh, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 163, -1, -1));

        btnCra.setText("+");
        btnCra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCraActionPerformed(evt);
            }
        });
        getContentPane().add(btnCra, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 190, -1, -1));

        btnRam.setText("+");
        btnRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRamActionPerformed(evt);
            }
        });
        getContentPane().add(btnRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 132, -1, -1));

        btnCPu.setText("+");
        btnCPu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPuActionPerformed(evt);
            }
        });
        getContentPane().add(btnCPu, new org.netbeans.lib.awtextra.AbsoluteConstraints(955, 161, -1, -1));

        btnReLoad.setText("Reload");
        btnReLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoadActionPerformed(evt);
            }
        });
        getContentPane().add(btnReLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(814, 267, -1, -1));

        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 267, -1, -1));

        cbLocDSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocDSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocDSPActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocDSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 70, -1));

        jLabel8.setText("Dòng SP");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 60, -1));

        cbLocOC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocOCActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocOC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 70, -1));

        jLabel11.setText("Ổ cứng");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        cbLocCKN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocCKN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocCKNActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocCKN, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 80, -1));

        jLabel14.setText("Cổng KN");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 60, -1));

        cbLocPin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocPinActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 90, -1));

        jLabel16.setText("Pin");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 50, -1));

        cbLocHDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocHDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocHDHActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocHDH, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 80, -1));

        jLabel20.setText("HDH");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 50, -1));

        cbLocCPU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocCPUActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 90, -1));

        jLabel21.setText("CPU");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        cbLocRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocRamActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 80, -1));

        jLabel22.setText("Ram");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 50, -1));

        cbLocCard.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocCardActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 90, -1));

        jLabel23.setText("Card");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, -1, -1));

        cbLocMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbLocMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocMSActionPerformed(evt);
            }
        });
        getContentPane().add(cbLocMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 330, 100, -1));

        jLabel24.setText("Màu Sắc");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 80, -1));

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
        
        String giaban = txtGiaBan.getText();
        String sluong = txtSL.getText();
        int indexCKN = cbCKN.getSelectedIndex();
        CongKetNoi ckn = listckn.get(indexCKN);
        int indexCPU = cbCPU.getSelectedIndex();
        CPU cpu = listcpu.get(indexCPU);
        int indexCr = cbCard.getSelectedIndex();
        CardManHinh cr = listCr.get(indexCr);
        int indexDSP = cbDongSP.getSelectedIndex();
        DongSP dsp = listDSP.get(indexDSP);
        int indexHDH = cbHDH.getSelectedIndex();
        Hedieuhanh hdh= listhdh.get(indexHDH);
        int indexSP = cbMa.getSelectedIndex();
        SanPham sp = listSP.get(indexSP);
        int indexMS = cbMauSac.getSelectedIndex();
        MauSac ms = listMS.get(indexMS);
        int indexOC = cbOCung.getSelectedIndex();
        OCung oc= listOC.get(indexOC);
        int indexPin = cbPin.getSelectedIndex();
        Pin pin = listPin.get(indexPin);
        int indexRam = cbRam.getSelectedIndex();
        Ram ram = listram.get(indexRam);

        String idSP = sp.getIdSP();
        String idms = ms.getId();
        String iddsp = dsp.getId();
        String idoc = oc.getId();
        String idkn = ckn.getId();
        String idpin = pin.getId();
        String idcpu = cpu.getId();
        String idram = ram.getId();
        String idcard = cr.getId();
        String idhdh = hdh.getId();

        ChiTietSP ctsp = new ChiTietSP("", Integer.parseInt(giaban), Integer.parseInt(sluong), 0, idms, iddsp, idoc, idkn, idpin, idcpu, idram, idcard, idhdh, idSP);
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
        String id = lbID.getText();
        String giaban = txtGiaBan.getText();
        String sluong = txtSL.getText();
        int indexCKN = cbCKN.getSelectedIndex();
        CongKetNoi ckn = listckn.get(indexCKN);
        int indexCPU = cbCPU.getSelectedIndex();
        CPU cpu = listcpu.get(indexCPU);
        int indexCr = cbCard.getSelectedIndex();
        CardManHinh cr = listCr.get(indexCr);
        int indexDSP = cbDongSP.getSelectedIndex();
        DongSP dsp = listDSP.get(indexDSP);
        int indexHDH = cbHDH.getSelectedIndex();
        Hedieuhanh hdh= listhdh.get(indexHDH);
        int indexSP = cbMa.getSelectedIndex();
        SanPham sp = listSP.get(indexSP);
        int indexMS = cbMauSac.getSelectedIndex();
        MauSac ms = listMS.get(indexMS);
        int indexOC = cbOCung.getSelectedIndex();
        OCung oc= listOC.get(indexOC);
        int indexPin = cbPin.getSelectedIndex();
        Pin pin = listPin.get(indexPin);
        int indexRam = cbRam.getSelectedIndex();
        Ram ram = listram.get(indexRam);

        String idSP = sp.getIdSP();
        String idms = ms.getId();
        String iddsp = dsp.getId();
        String idoc = oc.getId();
        String idkn = ckn.getId();
        String idpin = pin.getId();
        String idcpu = cpu.getId();
        String idram = ram.getId();
        String idcard = cr.getId();
        String idhdh = hdh.getId();

        ChiTietSP ctsp = new ChiTietSP("", Integer.parseInt(giaban), Integer.parseInt(sluong), 0, idms, iddsp, idoc, idkn, idpin, idcpu, idram, idcard, idhdh, idSP);
        qlctsp.update(ctsp, id);
        loadTable();
        clearForm();
        JOptionPane.showMessageDialog(this, "sửa thành công");
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
        
     
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnCPuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPuActionPerformed
        // TODO add your handling code here:
        JFrameCPU cpu = new JFrameCPU();
        cpu.setVisible(true);
        cpu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

    private void btnDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSPActionPerformed
        FrameDongSP dsp = new FrameDongSP();
        dsp.setVisible(true);
        dsp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addCBDongSP();
    }//GEN-LAST:event_btnDSPActionPerformed

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

    private void btnReLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoadActionPerformed
        // TODO add your handling code here:
        addCBRam();
        addCBDongSP();
        addCBOCung();
        addCBCPU();
        addCBCard();
        addCBMS();
        addCBPin();
        addCBHDH();
        addCBKN();
        addCBSP(listSP);
    }//GEN-LAST:event_btnReLoadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearForm();
        loadTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbLocDSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocDSPActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocDSP.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocDSPActionPerformed

    private void cbLocOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocOCActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocOC.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocOCActionPerformed

    private void cbLocCKNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocCKNActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocCKN.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocCKNActionPerformed

    private void cbLocPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocPinActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocPin.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocPinActionPerformed

    private void cbLocHDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocHDHActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocHDH.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocHDHActionPerformed

    private void cbLocCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocCPUActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocCPU.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocCPUActionPerformed

    private void cbLocRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocRamActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocRam.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocRamActionPerformed

    private void cbLocCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocCardActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocCard.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocCardActionPerformed

    private void cbLocMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocMSActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) tb.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter(String.valueOf(cbLocMS.getSelectedItem())));
        tb.setRowSorter(sorter);
    }//GEN-LAST:event_cbLocMSActionPerformed

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
    private javax.swing.JButton btnDSP;
    private javax.swing.JButton btnMS;
    private javax.swing.JButton btnOC;
    private javax.swing.JButton btnPin;
    private javax.swing.JButton btnRam;
    private javax.swing.JButton btnReLoad;
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
    private javax.swing.JComboBox<String> cbLocCKN;
    private javax.swing.JComboBox<String> cbLocCPU;
    private javax.swing.JComboBox<String> cbLocCard;
    private javax.swing.JComboBox<String> cbLocDSP;
    private javax.swing.JComboBox<String> cbLocHDH;
    private javax.swing.JComboBox<String> cbLocMS;
    private javax.swing.JComboBox<String> cbLocOC;
    private javax.swing.JComboBox<String> cbLocPin;
    private javax.swing.JComboBox<String> cbLocRam;
    private javax.swing.JComboBox<String> cbMa;
    private javax.swing.JComboBox<String> cbMauSac;
    private javax.swing.JComboBox<String> cbOCung;
    private javax.swing.JComboBox<String> cbPin;
    private javax.swing.JComboBox<String> cbRam;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
