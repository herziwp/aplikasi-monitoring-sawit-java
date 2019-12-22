/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.implement;

import aplikasi.monitoring.sawit.entity.KebunEntity;
import aplikasi.monitoring.sawit.entity.MonitoringDetailEntity;
import aplikasi.monitoring.sawit.setting.Koneksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class MonitoringImplement {
     private String className = "BelanjaImplement";
    
     public List<KebunEntity> getListData() {
        List<KebunEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT kebun.*, lahan.lokasi FROM kebun JOIN lahan ON kebun.lahan_id = lahan.id ORDER BY kebun.id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                KebunEntity kebunEntity = new KebunEntity();

                kebunEntity.setId(resultSet.getInt("kebun.id"));
                kebunEntity.setNama(resultSet.getString("kebun.nama"));
                kebunEntity.setLahanId(resultSet.getInt("kebun.lahan_id"));
                kebunEntity.setTglTanam(resultSet.getDate("kebun.tgl_tanam"));
                kebunEntity.setTglPerkiraanPanen(resultSet.getDate("kebun.tgl_perkiraan_panen"));
                kebunEntity.setVarietas(resultSet.getString("kebun.varietas"));
                kebunEntity.setTotalPohon(resultSet.getInt("kebun.total_pohon"));
                kebunEntity.setLokasi(resultSet.getString("lahan.lokasi"));

                list.add(kebunEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode function getListGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudang");
        }
        return list;
    }
    
   public List<KebunEntity> getListDataByParameter(String searchParameter) {
        List<KebunEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT kebun.*, lahan.lokasi FROM kebun JOIN lahan ON kebun.lahan_id = lahan.id "
                    + "WHERE kebun.nama LIKE '%" + searchParameter + "%' OR lahan.lokasi LIKE '%" + searchParameter + "%' ORDER BY id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                KebunEntity kebunEntity = new KebunEntity();

                kebunEntity.setId(resultSet.getInt("kebun.id"));
                kebunEntity.setNama(resultSet.getString("kebun.nama"));
                kebunEntity.setLahanId(resultSet.getInt("kebun.lahan_id"));
                kebunEntity.setTglTanam(resultSet.getDate("kebun.tgl_tanam"));
                kebunEntity.setTglPerkiraanPanen(resultSet.getDate("kebun.tgl_perkiraan_panen"));
                kebunEntity.setVarietas(resultSet.getString("kebun.varietas"));
                kebunEntity.setTotalPohon(resultSet.getInt("kebun.total_pohon"));
                kebunEntity.setLokasi(resultSet.getString("lahan.lokasi"));

                list.add(kebunEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }
    
public String insertData(MonitoringDetailEntity monitoringDetailEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO kebun_detail VALUES (?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, monitoringDetailEntity.getId());
            preparedStatement.setInt(2, monitoringDetailEntity.getKebunId());
            preparedStatement.setString(3, monitoringDetailEntity.getProgressKebun());
            preparedStatement.setDate(4, monitoringDetailEntity.getTglUpdate());
            preparedStatement.setString(5, monitoringDetailEntity.getKet());
            
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data Berhasil ditambah";
            } else {
                message = "Data gagal ditambah";
            }
            preparedStatement.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function insertGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function insertGudang");
        }
        return message;
    }
    
    public List<MonitoringDetailEntity> getListMonitoringDetail(int idKebun) {
        List<MonitoringDetailEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT kebun_detail.*, kebun.nama "
                    + "FROM kebun_detail JOIN kebun ON kebun_detail.kebun_id =  kebun.id "
                    + "WHERE kebun_detail.kebun_id = '"+idKebun+"' "
                    + "ORDER BY kebun_detail.id";
            
            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);
            
            while(resultSet.next()) {
                MonitoringDetailEntity monitoringDetailEntity = new MonitoringDetailEntity();
                
                monitoringDetailEntity.setId(resultSet.getInt("kebun_detail.id"));
                monitoringDetailEntity.setKebunId(resultSet.getInt("kebun_detail.kebun_id"));
                monitoringDetailEntity.setNama(resultSet.getString("kebun.nama"));
                monitoringDetailEntity.setProgressKebun(resultSet.getString("kebun_detail.progress_kebun"));
                monitoringDetailEntity.setTglUpdate(resultSet.getDate("kebun_detail.tgl_update"));
                monitoringDetailEntity.setKet(resultSet.getString("kebun_detail.ket"));

                list.add(monitoringDetailEntity);
            }
            
            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", function getListTransaksiDetail \n Detail : "+error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class "+className+", function getListTransaksiDetail");
        } return list;
    }
    
    
    public String deleteData(int kebunId) {
        String message = "";
        PreparedStatement preparedStatementTransaksi = null;
        PreparedStatement preparedStatementTransaksiDetail  = null;
        try {
            String sqlDeleteKebun = "DELETE FROM kebun WHERE id = ?";
            String sqlDeleteKebunDetail = "DELETE FROM kebun_detail WHERE kebun_id = ?";
            
            preparedStatementTransaksiDetail = Koneksi.getConnection().prepareStatement(sqlDeleteKebunDetail);
            preparedStatementTransaksiDetail.setInt(1, kebunId);
            preparedStatementTransaksiDetail.executeUpdate();
            
            preparedStatementTransaksi = Koneksi.getConnection().prepareStatement(sqlDeleteKebun);
            preparedStatementTransaksi.setInt(1, kebunId);
            int isSuccess1 = preparedStatementTransaksi.executeUpdate();
            
            if(isSuccess1 ==1) {
                message = "Data berhasil dihapus";
            } else {
                message = "Data gagal dihapus";
            } preparedStatementTransaksi.close();
        }  catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", function deleteKasir \n Detail : "+error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class "+className+", function deleteKasir");
        } return message;
    }
}