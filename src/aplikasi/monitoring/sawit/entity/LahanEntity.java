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
public class LahanEntity {
    private int id;
    private String lokasi;
    private String koordinat;
    private String luas;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLokasi() {
        return lokasi;
    }
    
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
    
    public String getKoordinat() {
        return koordinat;
    }
    
    public void setKoordinat(String koordinat) {
        this.koordinat = koordinat;
    }
    
    public String getLuas() {
        return luas;
    }
    
    public void setLuas(String luas) {
        this.luas = luas;
    }
        
    
}
