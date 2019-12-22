/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.implement;

import aplikasi.monitoring.sawit.entity.LahanEntity;
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
public class LahanImplement {
    
    private String className = "LahanImplement";

    public List<LahanEntity> getListData() {
        List<LahanEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT  * FROM lahan ORDER BY id ASC";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                LahanEntity lahanEntity = new LahanEntity();

                lahanEntity.setId(resultSet.getInt("id"));
                lahanEntity.setKoordinat(resultSet.getString("koordinat"));
                lahanEntity.setLuas(resultSet.getString("luas"));
                lahanEntity.setLokasi(resultSet.getString("lokasi"));
                list.add(lahanEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode function getListGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudang");
        }
        return list;
    }

    public List<LahanEntity> getListDataByParameter(String searchParameter) {
        List<LahanEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
                String sqlSelect = "SELECT * FROM lahan WHERE lokasi LIKE '%" + searchParameter + "%' OR koordinat LIKE '%" + searchParameter + "%' ORDER BY id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                LahanEntity lahanEntity = new LahanEntity();

                lahanEntity.setId(resultSet.getInt("id"));
                lahanEntity.setKoordinat(resultSet.getString("koordinat"));
                lahanEntity.setLuas(resultSet.getString("luas"));
                lahanEntity.setLokasi(resultSet.getString("lokasi"));

                list.add(lahanEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }

    public String insertData(LahanEntity lahanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO lahan VALUES (?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, lahanEntity.getId());
            preparedStatement.setString(2, lahanEntity.getLokasi());
            preparedStatement.setString(3, lahanEntity.getKoordinat());
            preparedStatement.setString(4, lahanEntity.getLuas());
            
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

    public String updateData(LahanEntity lahanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE lahan SET lokasi = ?, koordinat = ?,luas = ? WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, lahanEntity.getLokasi());
            preparedStatement.setString(2, lahanEntity.getKoordinat());
            preparedStatement.setString(3, lahanEntity.getLuas());
            preparedStatement.setInt(4, lahanEntity.getId());
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
            String sqlDelete = "DELETE FROM lahan WHERE id = ?";

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
