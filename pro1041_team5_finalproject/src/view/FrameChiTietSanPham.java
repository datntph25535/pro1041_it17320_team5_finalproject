/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ViewModel.CTSPViewModel;
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
    DefaultComboBoxModel dfcb = new DefaultComboBoxModel();
    DefaultTableModel dftb = new DefaultTableModel();
    ChiTietSPInteface qlctsp = new ChiTietSPService();
    DongSPInterface qldsp = new DongSPService();
    OCungInterface qloc = new OCungService();
    RamInterface qlram = new RamService();
    IMauSac qlms = new MauSacSer();
    IPinSer qlpin = new PinSer();
    SanPhamInterface qlsp =new SanPhamService();
    HeDHInterface qlhdh = new HeDHServices();
    ICongKetNoiS qlkn = new CongKetNoiSer();
    CPUInterface qlcpu = new CPUService();
    CardMHinterFace qlcard = new CardMHService();
    public FrameChiTietSanPham() {
        initComponents();
        this.setLocationRelativeTo(null);
  
        loadTable();
        
        addCBRam();
        addCBDongSP();
        addCBOCung();
        addCBCPU();
        addCBCard();
        addCBMS();
        addCBPin();
        addCBSeri();
        addCBHDH();
        addCBKN();
        addCBSP();
        
    }
    
    void addCBCPU(){
        dfcb = (DefaultComboBoxModel) cbCPU.getModel();
        for(CPU cpu : qlcpu.getAll()){
            dfcb.addElement(cpu);
        }
    }
    
    void addCBCard(){
        dfcb = (DefaultComboBoxModel) cbCard.getModel();
        for(CardManHinh ca: qlcard.getAll()){
            dfcb.addElement(ca);
        }
    }
    
    void addCBDongSP(){
        dfcb = (DefaultComboBoxModel) cbDongSP.getModel();
        for(DongSP dsp:qldsp.getAll()){
            dfcb.addElement(dsp);
        }
    }
    
    void addCBOCung(){
        dfcb = (DefaultComboBoxModel) cbOCung.getModel();
        for(OCung oc : qloc.getAll()){
            dfcb.addElement(oc);
        }
    }

    

    void addCBRam() {
       dfcb = (DefaultComboBoxModel) cbRam.getModel();
       for(Ram ram : qlram.getAll()){
           dfcb.addElement(ram);
       }
    }
    
    void addCBMS(){
        dfcb = (DefaultComboBoxModel) cbMauSac.getModel();
        for(MauSac ms : qlms.all()){
            dfcb.addElement(ms);
        }
    }
    
    void addCBPin(){
        dfcb = (DefaultComboBoxModel) cbPin.getModel();
        for(Pin pin : qlpin.getList()){
            dfcb.addElement(pin);
        }
    }
    
    void addCBSeri(){
        dfcb = (DefaultComboBoxModel) cbSerial.getModel();
        for(SanPham sp : qlsp.getAll()){
            dfcb.addElement(sp.getSerial());
        }
    }
    void addCBSP(){
        dfcb = (DefaultComboBoxModel) cbMa.getModel();
        for(SanPham sp : qlsp.getAll()){
            dfcb.addElement(sp);
        }
    }
    
    void addCBHDH(){
        dfcb = (DefaultComboBoxModel) cbHDH.getModel();
        for(Hedieuhanh hdh : qlhdh.getAll()){
            dfcb.addElement(hdh);
        }
    }
    
    void addCBKN(){
        dfcb = (DefaultComboBoxModel) cbCKN.getModel();
        for(CongKetNoi kn : qlkn.getall()){
            dfcb.addElement(kn);
        }
    }

    void loadTable() {
        dftb = (DefaultTableModel) tb.getModel();
        dftb.setRowCount(0);
        for(CTSPViewModel sp: qlctsp.getListCTSPViewModel()){
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
        jLabel8 = new javax.swing.JLabel();
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
        cbSerial = new javax.swing.JComboBox<>();
        cbHDH = new javax.swing.JComboBox<>();
        lbTrangThai = new javax.swing.JLabel();
        cbCKN = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Màu sắc");

        jLabel2.setText("Dòng SP");

        jLabel3.setText("Ổ cứng");

        jLabel5.setText("Cổng kết nối");

        jLabel6.setText("Pin");

        jLabel7.setText("Giá bán");

        jLabel8.setText("Số serial");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(46, 46, 46)
                                .addComponent(cbMa, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbMauSac, 0, 134, Short.MAX_VALUE)
                                    .addComponent(cbDongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbOCung, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
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
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbHDH, 0, 134, Short.MAX_VALUE)
                                            .addComponent(txtSL))))
                                .addGap(116, 116, 116)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbCard, javax.swing.GroupLayout.Alignment.TRAILING, 0, 135, Short.MAX_VALUE)
                                    .addComponent(cbCPU, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbRam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbTrangThai)
                                    .addComponent(cbCKN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(cbCKN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbHDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(cbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(cbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(cbCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(lbTrangThai))))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(cbMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        // TODO add your handling code here:
        int row = tb.getSelectedRow();
        

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
        
        System.out.println(idSP);
        
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
        String serial = cbSerial.getSelectedItem().toString();
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameChiTietSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
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
    private javax.swing.JComboBox<String> cbSerial;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
