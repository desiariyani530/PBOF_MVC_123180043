

import java.sql.Statement;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author desii
 */
public class MhsView extends JFrame {
    
JLabel nama,nim,alamat;
    JTextField isinim,isinama;
    JTextArea isialamat;
    JButton simpan,delete;
    JTable tabel;
    DefaultTableModel tabelModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"NIM","NAMA","ALAMAT"}; 
    Statement statement;
    
    public MhsView()
    {
        setTitle("Form Pengisian Mahasiswa");
        
        tabelModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tabelModel);
        scrollPane = new JScrollPane (tabel);
        
        nama = new JLabel("Nama");
        nim = new JLabel("NIM");        
        alamat = new JLabel("Alamat");
        
        isinama = new JTextField();
        isinim = new JTextField();
        isialamat = new JTextArea();
        
        simpan = new JButton("Simpan");
        delete = new JButton("Delete");
        
        setLayout(null);
        add(nama);
        add(nim);
        add(alamat);
        add(isinama);
        add(isinim);
        add(isialamat);
        add(simpan);
        add(delete);
        add(scrollPane);
        
        nim.setBounds(75, 25, 30, 30);
        nama.setBounds(75, 50, 50, 30);
        alamat.setBounds(75, 75, 50, 30);
        isinim.setBounds(150, 25, 300, 20);
        isinama.setBounds(150, 50, 300, 20);
        isialamat.setBounds(150, 75, 300, 100);
        simpan.setBounds(200, 190, 90, 20);
        delete.setBounds(310, 190, 90, 20);
        scrollPane.setBounds(75, 225, 480, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setSize(600,500); 
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
     public String getNim()
    {
        return isinim.getText();
    }
     
     public String getNama()
    {
        return isinama.getText();
    }
     
     public String getAlamat()
    {
        return isialamat.getText();
    }
}

