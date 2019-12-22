/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.entity;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class KaryawanEntity {
     
    private int id;
    private String nama;
    private String noHp;
    private String jenkel;
    private Date tglLahir;
    private String jabatan;
    private String alamat;
    private String statusAktif;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
    public Date getTglLahir() {
        return tglLahir;
    }
    
    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }
            
    public String getNoHp() {
        return noHp;
    }
    
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }       
    public String getJenkel() {
        return jenkel;
    }
    
    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }
    
            
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getJabatan() {
        return jabatan;
    }
    
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    
    public String getStatusAktif() {
        return statusAktif;
    }
    
    public void setStatusAktif(String statusAktif) {
        this.statusAktif = statusAktif;
    }
    
    
    
    
}
