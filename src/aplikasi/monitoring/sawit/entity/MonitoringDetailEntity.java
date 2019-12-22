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
public class MonitoringDetailEntity {
    private int id;
    private String progressKebun;
    private String nama;
    private int kebunId;
    private Date tglUpdate;
    private String ket;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getKebunId() {
        return kebunId;
    }
    
    public void setKebunId(int kebunId) {
        this.kebunId = kebunId;
    }
    
    public String getProgressKebun() {
        return progressKebun;
    }
    
    public void setProgressKebun(String progressKebun) {
        this.progressKebun = progressKebun;
    }
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
  
    public String getKet() {
        return ket;
    }
    
    public void setKet(String ket) {
        this.ket = ket;
    }
    
    public Date getTglUpdate() {
        return tglUpdate;
    }
    
    public void setTglUpdate(Date tglUpdate) {
        this.tglUpdate = tglUpdate;
    }
    
}
