/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.implement;

import aplikasi.monitoring.sawit.entity.CustomerEntity;
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
public class CustomerImplement {

    private String className = "CustomerImplement";

    public List<CustomerEntity> getListData() {
        List<CustomerEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT  * FROM customer ORDER BY kode_cust";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                CustomerEntity customerEntity = new CustomerEntity();

                customerEntity.setId(resultSet.getInt("id"));
                customerEntity.setKodeCustomer(resultSet.getString("kode_cust"));
                customerEntity.setNamaPt(resultSet.getString("nama_pt"));
                customerEntity.setNpwp(resultSet.getString("npwp"));
                customerEntity.setSppkp(resultSet.getString("sppkp"));
                customerEntity.setTglBergabung(resultSet.getDate("tgl_bergabung"));
                customerEntity.setTglHabisKontrak(resultSet.getDate("tgl_habis_kontrak"));
                customerEntity.setNoHp(resultSet.getString("no_hp"));
                customerEntity.setNoTelp(resultSet.getString("no_telp"));
                customerEntity.setAlamat(resultSet.getString("alamat"));

                list.add(customerEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode function getListGudang \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudang");
        }
        return list;
    }

    public List<CustomerEntity> getListDataByParameter(String searchParameter) {
        List<CustomerEntity> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlSelect = "SELECT * FROM customer WHERE nama_pt LIKE '%" + searchParameter + "%' OR kode_cust LIKE '%" + searchParameter + "%' ORDER BY kode_cust";

            statement = Koneksi.getConnection().createStatement();
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                CustomerEntity customerEntity = new CustomerEntity();

                customerEntity.setId(resultSet.getInt("id"));
                customerEntity.setKodeCustomer(resultSet.getString("kode_cust"));
                customerEntity.setNamaPt(resultSet.getString("nama_pt"));
                customerEntity.setNpwp(resultSet.getString("npwp"));
                customerEntity.setSppkp(resultSet.getString("sppkp"));
                customerEntity.setTglBergabung(resultSet.getDate("tgl_bergabung"));
                customerEntity.setTglHabisKontrak(resultSet.getDate("tgl_habis_kontrak"));
                customerEntity.setNoHp(resultSet.getString("no_hp"));
                customerEntity.setNoTelp(resultSet.getString("no_telp"));
                customerEntity.setAlamat(resultSet.getString("alamat"));

                list.add(customerEntity);
            }

            statement.close();
            resultSet.close();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", function getListGudangByParameter \n Detail : " + error);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada class " + className + ", function getListGudangByParameter");
        }
        return list;
    }

    public String insertData(CustomerEntity customerEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlInsert = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setInt(1, customerEntity.getId());
            preparedStatement.setString(2, customerEntity.getKodeCustomer());
            preparedStatement.setString(3, customerEntity.getNamaPt());
            preparedStatement.setString(4, customerEntity.getNpwp());
            preparedStatement.setString(5, customerEntity.getSppkp());
            preparedStatement.setDate(6, customerEntity.getTglBergabung());
            preparedStatement.setDate(7, customerEntity.getTglHabisKontrak());
            preparedStatement.setString(8, customerEntity.getNoHp());
            preparedStatement.setString(9, customerEntity.getNoTelp());
            preparedStatement.setString(10, customerEntity.getAlamat());
            
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

    public String updateData(CustomerEntity customerEntity) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlUpdate = "UPDATE customer SET nama_pt = ?, npwp = ?,sppkp = ?,tgl_bergabung = ?,tgl_habis_kontrak = ?,no_hp = ?,no_telp = ?,alamat = ? WHERE kode_cust = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, customerEntity.getNamaPt());
            preparedStatement.setString(2, customerEntity.getNpwp());
            preparedStatement.setString(3, customerEntity.getSppkp());
            preparedStatement.setDate(4, customerEntity.getTglBergabung());
            preparedStatement.setDate(5, customerEntity.getTglHabisKontrak());
            preparedStatement.setString(6, customerEntity.getNoHp());
            preparedStatement.setString(7, customerEntity.getNoTelp());
            preparedStatement.setString(8, customerEntity.getAlamat());
            preparedStatement.setString(9, customerEntity.getKodeCustomer());
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

    public String deleteData(String id) {
        String message = "";
        PreparedStatement preparedStatement = null;
        try {
            String sqlDelete = "DELETE FROM customer WHERE kode_cust = ?";

            preparedStatement = Koneksi.getConnection().prepareStatement(sqlDelete);
            preparedStatement.setString(1, id);
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
