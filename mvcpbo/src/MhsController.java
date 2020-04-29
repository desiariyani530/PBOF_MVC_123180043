
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author desii
 */
public class MhsController {
     MhsModel mhsmodel;
    MhsView mhsview;
    MhsDao mhsdao;
    public MhsController(MhsModel mhsmodel,MhsView mhsview,MhsDao mhsdao)
    {
        this.mhsmodel = mhsmodel;
        this.mhsview = mhsview;
        this.mhsdao = mhsdao;
        
        if(mhsdao.getJmldata() != 0)
        {
            String dataMahasiswa[][] = mhsdao.readMahasiswa();
            mhsview.tabel.setModel((new JTable (dataMahasiswa, mhsview.namaKolom)).getModel());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        mhsview.simpan.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String nim =  mhsview.getNim();
                String nama = mhsview.getNama();
                String alamat = mhsview.getAlamat();
                        
                if(nim.isEmpty() || nama.isEmpty() || alamat.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Harap isi semua field");
                }
                else
                {
                    mhsmodel.setMhsModel(nim, nama, alamat);
                    
                    mhsdao.Insert(mhsmodel);
                    
                    String dataMahasiswa[][] = mhsdao.readMahasiswa();
                    mhsview.tabel.setModel((new JTable(dataMahasiswa, mhsview.namaKolom)).getModel());
                }
            }

        });
        
       mhsview.tabel.addMouseListener(new MouseAdapter(){
            private String dataTerpilih;
           @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = mhsview.tabel.getSelectedRow();
                int kolom = mhsview.tabel.getSelectedColumn();

               dataTerpilih = mhsview.tabel.getValueAt(baris,0).toString();
                mhsview.delete.setEnabled(true);
            }
        });
        
        mhsview.delete.addActionListener(new ActionListener(){
            private String dataTerpilih;
            @Override
            public void actionPerformed(ActionEvent e){
                
                int input = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus Data " + dataTerpilih + "?","Delete Contact",JOptionPane.YES_NO_OPTION);

                if (input == 0){
                    mhsmodel.setNim(dataTerpilih);
                    mhsdao.Delete(mhsmodel);
//                    mhsdao.Delete(dataTerpilih);
                    String dataMahasiswa[][] = mhsdao.readMahasiswa();
                    mhsview.tabel.setModel((new JTable (dataMahasiswa, mhsview.namaKolom)).getModel());
                }
            }
        });
    }
}
