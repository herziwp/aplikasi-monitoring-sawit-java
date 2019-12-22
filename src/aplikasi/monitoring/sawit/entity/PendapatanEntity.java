/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author it2-PC
 */
public class PendapatanEntity {
      public int id;
      public int idKebun;
      public int idCustomer;
      public int idUser;
      public int idKaryawan;
      public int jumlahPanen;
      public BigDecimal hargaKg;
      public BigDecimal totalPendapatan;
      public String namaKebun;
      public String namaCustomer;
      public String namaUser;
      public String ket;
      public Timestamp createdAt;
      public Timestamp updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKebun() {
        return idKebun;
    }

    public void setIdKebun(int idKebun) {
        this.idKebun = idKebun;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public int getJumlahPanen() {
        return jumlahPanen;
    }

    public void setJumlahPanen(int jumlahPanen) {
        this.jumlahPanen = jumlahPanen;
    }

    public BigDecimal getHargaKg() {
        return hargaKg;
    }

    public void setHargaKg(BigDecimal hargaKg) {
        this.hargaKg = hargaKg;
    }

    public BigDecimal getTotalPendapatan() {
        return totalPendapatan;
    }

    public void setTotalPendapatan(BigDecimal totalPendapatan) {
        this.totalPendapatan = totalPendapatan;
    }

    public String getNamaKebun() {
        return namaKebun;
    }

    public void setNamaKebun(String namaKebun) {
        this.namaKebun = namaKebun;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}
