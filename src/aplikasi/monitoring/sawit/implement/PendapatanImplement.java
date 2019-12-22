/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.implement;

import aplikasi.monitoring.sawit.entity.PendapatanEntity;
import aplikasi.monitoring.sawit.setting.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author it2-PC
 */
public class PendapatanImplement {
    
    private String className = "PendapatanImplement";

    public List<PendapatanEntity> getListData() {
        List<PendapatanEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT pendapatan.*, kebun.nama, customer.nama_pt FROM pendapatan JOIN kebun ON pendapatan.kebun_id = kebun.id "
                    + "JOIN customer ON customer.id = pendapatan.customer_id "
                    + "ORDER BY pendapatan.id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                PendapatanEntity pendapatanEntity = new PendapatanEntity();

                pendapatanEntity.setId(resultSet.getInt("pendapatan.id"));
                pendapatanEntity.setIdCustomer(resultSet.getInt("pendapatan.customer_id"));
                pendapatanEntity.setIdKebun(resultSet.getInt("pendapatan.kebun_id"));
                pendapatanEntity.setNamaCustomer(resultSet.getString("customer.nama_pt"));
                pendapatanEntity.setNamaKebun(resultSet.getString("kebun.nama"));
                pendapatanEntity.setJumlahPanen(resultSet.getInt("pendapatan.jumlah_panen"));
                pendapatanEntity.setHargaKg(resultSet.getBigDecimal("pendapatan.harga_kg"));
                pendapatanEntity.setTotalPendapatan(resultSet.getBigDecimal("pendapatan.total_pendapatan"));
                pendapatanEntity.setKet(resultSet.getString("pendapatan.ket"));
                pendapatanEntity.setCreatedAt(resultSet.getTimestamp("pendapatan.created_at"));
                pendapatanEntity.setUpdatedAt(resultSet.getTimestamp("pendapatan.updated_at"));

                list.add(pendapatanEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode function getListGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudang");
        }
        return list;
    }

    public List<PendapatanEntity> getListDataByParameter(String searchParameter) {
        List<PendapatanEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT pendapatan.*, kebun.nama, customer.nama_pt FROM pendapatan JOIN kebun ON pendapatan.kebun_id = kebun.id "
                    + "JOIN customer ON customer.id = pendapatan.customer_id "
                    + "WHERE kebun.nama LIKE '%" + searchParameter + "%' OR customer.nama_pt LIKE '%" + searchParameter + "%' ORDER BY id";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                PendapatanEntity pendapatanEntity = new PendapatanEntity();

                 pendapatanEntity.setId(resultSet.getInt("pendapatan.id"));
                pendapatanEntity.setIdCustomer(resultSet.getInt("pendapatan.customer_id"));
                pendapatanEntity.setIdKebun(resultSet.getInt("pendapatan.kebun_id"));
                pendapatanEntity.setNamaCustomer(resultSet.getString("customer.nama_pt"));
                pendapatanEntity.setNamaKebun(resultSet.getString("kebun.nama"));
                pendapatanEntity.setJumlahPanen(resultSet.getInt("pendapatan.jumlah_panen"));
                pendapatanEntity.setHargaKg(resultSet.getBigDecimal("pendapatan.harga_kg"));
                pendapatanEntity.setTotalPendapatan(resultSet.getBigDecimal("pendapatan.total_pendapatan"));
                pendapatanEntity.setKet(resultSet.getString("pendapatan.ket"));
                pendapatanEntity.setCreatedAt(resultSet.getTimestamp("pendapatan.created_at"));
                pendapatanEntity.setUpdatedAt(resultSet.getTimestamp("pendapatan.updated_at"));

                list.add(pendapatanEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }

    public String insertData(PendapatanEntity pendapatanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO pendapatan VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, pendapatanEntity.getId());
            preparedStatement.setInt(2, pendapatanEntity.getIdKebun());
            preparedStatement.setInt(3, pendapatanEntity.getIdCustomer());
            preparedStatement.setInt(4, pendapatanEntity.getJumlahPanen());
            preparedStatement.setBigDecimal(5, pendapatanEntity.getHargaKg());
            preparedStatement.setBigDecimal(6, pendapatanEntity.getTotalPendapatan());
            preparedStatement.setString(7, pendapatanEntity.getKet());
            preparedStatement.setTimestamp(8, pendapatanEntity.getCreatedAt());
            preparedStatement.setTimestamp(9, pendapatanEntity.getUpdatedAt());
            
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

    public String updateData(PendapatanEntity pendapatanEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE pendapatan SET kebun_id = ?, customer_id = ?, jumlah_panen = ? "
                    + ", harga_kg = ?,total_pendapatan = ?,ket = ?, updated_at = ? WHERE id = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, pendapatanEntity.getIdKebun());
            preparedStatement.setInt(2, pendapatanEntity.getIdCustomer());
            preparedStatement.setInt(3, pendapatanEntity.getJumlahPanen());
            preparedStatement.setBigDecimal(4, pendapatanEntity.getHargaKg());
            preparedStatement.setBigDecimal(5, pendapatanEntity.getTotalPendapatan());
            preparedStatement.setString(6, pendapatanEntity.getKet());
            preparedStatement.setTimestamp(7, pendapatanEntity.getUpdatedAt());
            preparedStatement.setInt(8, pendapatanEntity.getId());
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
            String sqlDelete = "DELETE FROM pendapatan WHERE id = ?";

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
