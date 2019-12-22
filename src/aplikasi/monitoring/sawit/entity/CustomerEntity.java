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
public class CustomerEntity {
    
    
    private int id;
    private String kodeCustomer;
    private String namaPt;
    private String npwp;
    private String sppkp;
    private Date tglBergabung;
    private Date tglHabisKontrak;
    private String noHp;
    private String noTelp;
    private String alamat;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getKodeCustomer() {
        return kodeCustomer;
    }
    
    public void setKodeCustomer(String kodeCustomer) {
        this.kodeCustomer = kodeCustomer;
    }
    
    public String getNamaPt() {
        return namaPt;
    }
    
    public void setNamaPt(String namaPt) {
        this.namaPt = namaPt;
    }
    
    public String getNpwp() {
        return npwp;
    }
    
    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }
        
    public String getSppkp() {
        return sppkp;
    }
    
    public void setSppkp(String sppkp) {
        this.sppkp = sppkp;
    }
       
    public Date getTglBergabung() {
        return tglBergabung;
    }
    
    public void setTglBergabung(Date tglBergabung) {
        this.tglBergabung = tglBergabung;
    }
         
    public Date getTglHabisKontrak() {
        return tglHabisKontrak;
    }
    
    public void setTglHabisKontrak(Date tglHabisKontrak) {
        this.tglHabisKontrak = tglHabisKontrak;
    }
            
    public String getNoHp() {
        return noHp;
    }
    
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }       
    public String getNoTelp() {
        return noTelp;
    }
    
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
            
    public String getAlamat() {
        return alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
    
    
}
