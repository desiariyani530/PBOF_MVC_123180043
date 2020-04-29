/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author desii
 */
public class MhsModel {
    
     private String nim,nama,alamat;
    
    public void setMhsModel(String nnim,String nnama,String aalamat)
    {
        this.nim = nnim;
        this.nama = nnama;
        this.alamat = aalamat;
       
    }
    
    public String getNim()
    {
        return nim;
    }
    
    public void setNim(String nim)
    {
        this.nim = nim;
    }
    
    public String getNama()
    {
        return nama;
    }
    
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    
    public String getAlamat()
    {
        return alamat;
    }
    
    public void setAlamat(String alamat)
    {
        this.alamat = alamat;
    }
}
