/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUGAS6;

import java.awt.Color;                          //import untuk memasukkan warna kedalam program
import java.sql.*;                              //import untuk memasukkan ke databse
import javax.swing.JOptionPane;                 //import untuk memasukkan tampilan joption
import javax.swing.table.DefaultTableModel;     //import untuk memasukkan default tabel model

/**
 *
 * @author Hasyim_Asyari
 */
public class tugas6 extends javax.swing.JFrame {
    private DefaultTableModel model;                    //Tabel model yg dibuat
    private Connection con = koneksi.getConnection();   //mengkoneksikan ke database
    private Statement stt;                              //mengeksekusi queri
    private ResultSet rss;                              //menampung queri
    private int baris;                                  //mendeklarasikan baris
    
    
    public tugas6() {
        initComponents();
    }
    private void InitTable(){
        model = new DefaultTableModel();    //membuat tabel baru di model
        model.addColumn("ID");              //kolom id dalam model
        model.addColumn("JUDUL");           //kolom judul dalam model
        model.addColumn("PENULIS");         //kolom penulis dalam model
        model.addColumn("HARGA");           //kolom harga dalam model
        
        jTable1.setModel(model);            //tabel berisi data dari model
    }
    private void TampilData(){      //Methot untuk menampilkan data
        try{
            String sql = "SELECT * FROM buku";      // queriuntuk menampilkan isi tabel buku dari database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];         //membuat Objek 
                o[0] = rss.getInt("id");            //objek 0 menampung data id
                o[1] = rss.getString("judul");      //objek 1 menampung data judul
                o[2] = rss.getString("penulis");    //objek 2 menampung data penulis
                o[3] = rss.getInt("harga");         //objek 3 menampung data harga
                model.addRow(o);                    //baris pada model
            }
        }catch(SQLException e){
            System.out.printf(e.getMessage());
        }
    }
    private void TambahData( String judul, String penulis, String harga){                       //Methot untuk menambah data  
        try{
            String sql = "INSERT INTO buku VALUES (NULL,'"+judul+"','"+penulis+"',"+harga+")";  //query untuk menambah data dari database
            stt = con.createStatement();
            stt.executeUpdate(sql);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void UbahData( String id, String judul, String penulis, String harga){                                          //Methot untuk mengubah data
        try{
            String sql = "UPDATE buku SET judul='"+judul+"',"+"penulis='"+penulis+"', harga='"+harga+"' where id='"+id+"'"; //query untuk mengubah data dari database
            stt = con.createStatement();
            stt.executeUpdate(sql);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void HapusData( String id, int baris){                      //Methot untuk menghapus data
        try{
            String sqldelete = "DELETE from buku where id='"+id+"'";    //query untuk menghapus data dari database
            stt = con.createStatement();
            stt.executeUpdate(sqldelete);
            model.removeRow(baris);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariId(){                                                      //Methot untuk mencari id data
        try{
            String sql = "SELECT*from buku where id='"+txtCari.getText()+"'";   //query untuk mencari data dengan id dari database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];           //membuat Objek 
              o[0] = rss.getInt("id");              //objek 0 menampung data id
              o[1] = rss.getString("judul");        //objek 1 menampung data judul
              o[2] = rss.getString("penulis");      //objek 2 menampung data penulis
              o[3] = rss.getString("harga");        //objek 3 menampung data harga
              model.addRow(o);                      //baris pada model
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariJudul(){                                                       //Methot untuk mencari judul data
        try{
            String sql = "SELECT*from buku where judul='"+txtCari.getText()+"'";    //query untuk mencari data dengan judul dari database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];           //membuat Objek
              o[0] = rss.getInt("id");              //objek 0 menampung data id
              o[1] = rss.getString("judul");        //objek 1 menampung data judul
              o[2] = rss.getString("penulis");      //objek 2 menampung data penulis
              o[3] = rss.getString("harga");        //objek 3 menampung data harga
              model.addRow(o);                      //baris pada model
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariPenulis(){                                                         //Methot untuk mencari penulis data
        try{
            String sql = "SELECT*from buku where penulis='"+txtCari.getText()+"'";      //query untuk mencari data dengan penulis dari database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];           //membuat Objek
              o[0] = rss.getInt("id");              //objek 0 menampung data id
              o[1] = rss.getString("judul");        //objek 1 menampung data judul
              o[2] = rss.getString("penulis");      //objek 2 menampung data penulis
              o[3] = rss.getString("harga");        //objek 3 menampung data harga
              model.addRow(o);                      //baris pada model
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariHarga(){                                                       //Methot untuk mencari harga data
        try{
            String sql = "SELECT*from buku where harga='"+txtCari.getText()+"'";    //query untuk mencari data dengan harga dari database
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];           //membuat Objek
              o[0] = rss.getInt("id");              //objek 0 menampung data id
              o[1] = rss.getString("judul");        //objek 1 menampung data judul
              o[2] = rss.getString("penulis");      //objek 2 menampung data penulis
              o[3] = rss.getString("harga");        //objek 3 menampung data harga
              model.addRow(o);                      //baris pada model
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        comboPenulis = new javax.swing.JComboBox();
        txtHarga = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboBY = new javax.swing.JComboBox();
        txtCari = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnLihat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Data Buku");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(194, 194, 194))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));

        jLabel2.setText("Judul");

        jLabel3.setText("Penulis");

        jLabel4.setText("Harga");

        txtJudul.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtJudulCaretUpdate(evt);
            }
        });
        txtJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulActionPerformed(evt);
            }
        });

        comboPenulis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tere Liye", "W.S Rendra", "Felix Siauw", "Asma Nadia", "Dewi Lestari" }));

        txtHarga.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtHargaCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHarga)
                    .addComponent(comboPenulis, 0, 285, Short.MAX_VALUE)
                    .addComponent(txtJudul))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel6.setText("By  :");

        comboBY.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Judul", "Penulis", "Harga" }));

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        btnSearch.setText("Search  :");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnLihat.setText("Lihat");
        btnLihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(26, 26, 26)
                                .addComponent(btnUbah)
                                .addGap(26, 26, 26)
                                .addComponent(btnHapus)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLihat)
                                .addGap(29, 29, 29)
                                .addComponent(btnKeluar)))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnKeluar)
                    .addComponent(btnLihat))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboBY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "JUDUL", "PENULIS", "HARGA"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();    //untuk memanggil isi model
        TampilData();   //untuk menampilkan data
    }//GEN-LAST:event_formComponentShown

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String judul = txtJudul.getText();                          //untuk mengambil nilai di komponen pada txtJudul
        String penulis = comboPenulis.getSelectedItem().toString(); //untuk mengambil nilai di komponen pada comboPenulis
        String harga = txtHarga.getText();                          //untuk mengambil nilai di komponen pada txtHarga
        
        TambahData(judul,penulis,harga);
        InitTable();
        TampilData();
        
        JOptionPane.showMessageDialog(null, "DATA TELAH BERHASIL DISIMPAN", "Perhatian!!",WIDTH);  //pemberitahuan bahwa data telah di simpan
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
       int baris = jTable1.getSelectedRow();                            //baris untuk memilih baris pada tabel
       
       jTable1.setValueAt(txtJudul.getText(), baris, 1);                //baris 1 berisi data dari txtJudul
       jTable1.setValueAt(comboPenulis.getSelectedItem(), baris, 2);    //baris 2 berisi data dari comboPenulis
       jTable1.setValueAt(txtHarga.getText(), baris, 3);                //baris 3 berisi data dari txtHarga
       
       String id = jTable1.getValueAt(baris, 0).toString();             //untuk mengambil nilai id
       String judul = jTable1.getValueAt(baris, 1).toString();          //untuk mengambil nilai judul
       String penulis = jTable1.getValueAt(baris, 2).toString();        //untuk mengambil nilai penulis
       String harga = jTable1.getValueAt(baris, 3).toString();          //untuk mengambil nilai harga
       
       UbahData(id,judul,penulis,harga);
       
       txtJudul.setText(judul);
       comboPenulis.setSelectedItem(penulis);
       txtHarga.setText(harga);
       
      JOptionPane.showMessageDialog(null, "DATA TELAH BERHASIL DIUBAH");    //pemberitahuan bahwa data telah di simpan
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try{
            int baris = jTable1.getSelectedRow();                   //memilih baris pada tabel
            String id = jTable1.getValueAt(baris, 0).toString();    //mengambil id untuk dihapus
            HapusData(id,baris);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Mana Yang di HAPUS LOL!!!");        //pemberitahuan bahwa data harus diisi dulu
        }   
        JOptionPane.showMessageDialog(null, "DATA TELAH BERHASIL DIHAPUS", "Perhatian!!",WIDTH);    //pemberitahuan bahwa data telah dihapus
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);         //untuk keluar dari sistem
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(txtCari.getText().equals("")){                               //jika komponen txtCari kosong akan tampil pesan ISI dulu....
            JOptionPane.showMessageDialog(null,"ISI DULU GAN!!!");
        }
        else{                                                           //jika di isi
            model.getDataVector().removeAllElements();                  //maka model akan mengambil isi yang di inginkan
            model.fireTableDataChanged();                               
            if(comboBY.getSelectedItem().equals("Id")){                 //jika pilih id pada comboBox
             CariId();                                                  //maka akan tampil isi dari methot cariId
            }
            else if(comboBY.getSelectedItem().equals("Judul")){         //jika pilih judul pada comboBox
             CariJudul();                                               //maka akan tampil isi dari methot cariJudul
            }
            else if(comboBY.getSelectedItem().equals("Penulis")){       //jika pilih penulis pada comboBox
             CariPenulis();                                             //maka akan tampil isi dari methot cariPenulis
            }
            else if(comboBY.getSelectedItem().equals("Harga")){         //jika pilih penulis pada comboBox
             CariHarga();                                               //maka akan tampil isi dari methot cariHarga
             }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatActionPerformed
        // TODO add your handling code here:
        InitTable();    //untuk menampilkan isi tabel
        TampilData();
    }//GEN-LAST:event_btnLihatActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        btnSimpan.setEnabled(false);    //untuk menset tombol simpan agar gk bisa di klik
    }//GEN-LAST:event_formWindowActivated

    private void txtJudulCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtJudulCaretUpdate
        // TODO add your handling code here:
        if(txtJudul.getText().equals("")||txtHarga.getText().equals("")){   //jika komponen txtJudul atau komponen txtHarga kosong
            btnSimpan.setEnabled(false);                                    //maka tombol simpan gk bisa di klik
        }else {                                                             //jika ada
            btnSimpan.setEnabled(true);                                     //maka tombol simpan bisa di klik
        }
    
    }//GEN-LAST:event_txtJudulCaretUpdate

    private void txtHargaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtHargaCaretUpdate
        // TODO add your handling code here:
        if(txtJudul.getText().equals("")||txtHarga.getText().equals("")){   //jika komponen txtJudul atau komponen txtHarga kosong
            btnSimpan.setEnabled(false);                                    //maka tombol simpan gk bisa di klik
        }else {                                                             //jika ada
            btnSimpan.setEnabled(true);                                     //maka tombol simpan bisa di klik
        }
    }//GEN-LAST:event_txtHargaCaretUpdate

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // TODO add your handling code here:
        btnSearch.setBackground(Color.blue);                        //memberikan warna pada tombol search ketika mouse masuk ke tombol
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // TODO add your handling code here:
        btnSearch.setBackground(Color.white);                       //memberikan warna pada tombol search ketika mouse keluar ke tombol
    }//GEN-LAST:event_btnSearchMouseExited

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();                       //memilih baris yang akan dipilih dengan mouse
       
       String judul = jTable1.getValueAt(baris, 1).toString();      //untuk mengambil nilai judul
       String penulis = jTable1.getValueAt(baris, 2).toString();    //untuk mengambil nilai penulis
       String harga = jTable1.getValueAt(baris, 3).toString();      //untuk mengambil nilai harga
 
       txtJudul.setText(judul);
       comboPenulis.setSelectedItem(penulis);
       txtHarga.setText(harga);
       
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(tugas6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tugas6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tugas6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tugas6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
        
            public void run() {
                new tugas6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLihat;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox comboBY;
    private javax.swing.JComboBox comboPenulis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJudul;
    // End of variables declaration//GEN-END:variables
}
