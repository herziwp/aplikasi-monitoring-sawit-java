/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.implement;

import aplikasi.monitoring.sawit.entity.KaryawanEntity;
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
public class KaryawanImplement {
    
    private String className = "KaryawanImplement";

    public List<KaryawanEntity> getListData() {
        List<KaryawanEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT * FROM karyawan ORDER BY id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                KaryawanEntity karyawanEntity = new KaryawanEntity();

                karyawanEntity.setId(resultSet.getInt("id"));
                karyawanEntity.setNama(resultSet.getString("nama"));
                karyawanEntity.setTglLahir(resultSet.getDate("tgl_lahir"));
                karyawanEntity.setJenkel(resultSet.getString("jenkel"));
                karyawanEntity.setNoHp(resultSet.getString("no_hp"));
                karyawanEntity.setJabatan(resultSet.getString("jabatan"));
                karyawanEntity.setAlamat(resultSet.getString("alamat"));
                karyawanEntity.setStatusAktif(resultSet.getString("status_aktif"));

                list.add(karyawanEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode function getListGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudang");
        }
        return list;
    }

    public List<KaryawanEntity> getListDataByParameter(String searchParameter) {
        List<KaryawanEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT * FROM karyawan WHERE nama LIKE '%" + searchParameter + "%' OR alamat LIKE '%" + searchParameter + "%' ORDER BY id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                KaryawanEntity karyawanEntity = new KaryawanEntity();

                karyawanEntity.setId(resultSet.getInt("id"));
                karyawanEntity.setNama(resultSet.getString("nama"));
                karyawanEntity.setTglLahir(resultSet.getDate("tgl_lahir"));
                karyawanEntity.setJenkel(resultSet.getString("jenkel"));
                karyawanEntity.setNoHp(resultSet.getString("no_hp"));
                karyawanEntity.setJabatan(resultSet.getString("jabatan"));
                karyawanEntity.setAlamat(resultSet.getString("alamat"));
                karyawanEntity.setStatusAktif(resultSet.getString("status_aktif"));

                list.add(karyawanEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }

    public String insertData(KaryawanEntity karyawanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO karyawan VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, karyawanEntity.getId());
            preparedStatement.setString(2, karyawanEntity.getNama());
            preparedStatement.setDate(3, karyawanEntity.getTglLahir());
            preparedStatement.setString(4, karyawanEntity.getJenkel());
            preparedStatement.setString(5, karyawanEntity.getNoHp());
            preparedStatement.setString(6, karyawanEntity.getAlamat());
            preparedStatement.setString(7, karyawanEntity.getJabatan());
            preparedStatement.setString(8, karyawanEntity.getStatusAktif());
            
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

    public String updateData(KaryawanEntity karyawanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE karyawan SET nama = ?, tgl_lahir = ?,jenkel = ?,no_hp = ?,alamat = ?,jabatan = ?,status_aktif = ? WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, karyawanEntity.getNama());
            preparedStatement.setDate(2, karyawanEntity.getTglLahir());
            preparedStatement.setString(3, karyawanEntity.getJenkel());
            preparedStatement.setString(4, karyawanEntity.getNoHp());
            preparedStatement.setString(5, karyawanEntity.getAlamat());
            preparedStatement.setString(6, karyawanEntity.getJabatan());
            preparedStatement.setString(7, karyawanEntity.getStatusAktif());
            preparedStatement.setInt(8, karyawanEntity.getId());
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
            String sqlDelete = "DELETE FROM karyawan WHERE id = ?";

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
