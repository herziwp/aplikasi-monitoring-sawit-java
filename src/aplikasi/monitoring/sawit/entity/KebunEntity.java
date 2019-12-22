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
public class KebunEntity { 
    
    private int id;
    private String nama;
    private int lahanId;
    private String varietas;
    private String lokasi;
    private int totalPohon;
    private Date tglTanam;
    private Date tglPerkiraanPanen;
    private int userId;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getLahanId() {
        return lahanId;
    }
    
    public void setLahanId(int lahanId) {
        this.lahanId = lahanId;
    }
    
    public int getTotalPohon() {
        return totalPohon;
    }
    
    public void setTotalPohon(int totalPohon) {
        this.totalPohon = totalPohon;
    }
    
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
  
    public String getLokasi() {
        return lokasi;
    }
    
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
    public Date getTglTanam() {
        return tglTanam;
    }
    
    public void setTglTanam(Date tglTanam) {
        this.tglTanam = tglTanam;
    }
    
    public Date getTglPerkiraanPanen() {
        return tglPerkiraanPanen;
    }
    
    public void setTglPerkiraanPanen(Date tglPerkiraanPanen) {
        this.tglPerkiraanPanen = tglPerkiraanPanen;
    }
            
    public String getVarietas() {
        return varietas;
    }
    
    public void setVarietas(String varietas) {
        this.varietas = varietas;
    }       
}
    
