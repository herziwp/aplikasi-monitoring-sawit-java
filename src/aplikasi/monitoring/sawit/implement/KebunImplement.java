/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.implement;

import aplikasi.monitoring.sawit.entity.KebunEntity;
import aplikasi.monitoring.sawit.setting.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class KebunImplement {
      
    private String className = "KebunImplement";

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

    public String insertData(KebunEntity kebunEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO kebun VALUES (?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, kebunEntity.getId());
            preparedStatement.setString(2, kebunEntity.getNama());
            preparedStatement.setInt(3, kebunEntity.getLahanId());
            preparedStatement.setString(4, kebunEntity.getVarietas());
            preparedStatement.setInt(5, kebunEntity.getTotalPohon());
            preparedStatement.setDate(6, kebunEntity.getTglTanam());
            preparedStatement.setDate(7, kebunEntity.getTglPerkiraanPanen());
            
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

    public String updateData(KebunEntity kebunEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE kebun SET nama = ?, lahan_id = ?,varietas = ?,total_pohon = ?,tgl_tanam = ?,tgl_perkiraan_panen = ? WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, kebunEntity.getNama());
            preparedStatement.setInt(2, kebunEntity.getLahanId());
            preparedStatement.setString(3, kebunEntity.getVarietas());
            preparedStatement.setInt(4, kebunEntity.getTotalPohon());
            preparedStatement.setDate(5, kebunEntity.getTglTanam());
            preparedStatement.setDate(6, kebunEntity.getTglPerkiraanPanen());
            preparedStatement.setInt(7, kebunEntity.getId());
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data berhasil diubah";
            } else {
                message = "Data gagal diubah";
            }
            preparedStatement.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function updateGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function updateGudang");
        }
        return message;
    }

    public String deleteData(int id) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM kebun WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setInt(1, id);
            int isSuccess = preparedStatement.executeUpdate();

            if (isSuccess == 1) {
                message = "Data berhasil dihapus";
            } else {
                message = "Data gagal dihapus";
            }
            preparedStatement.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function deleteGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function deleteGudang");
        }
        return message;
    }
}