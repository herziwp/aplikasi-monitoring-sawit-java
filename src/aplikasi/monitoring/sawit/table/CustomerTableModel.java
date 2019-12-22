/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.table;

import aplikasi.monitoring.sawit.entity.CustomerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class CustomerTableModel extends AbstractTableModel {

    private List<CustomerEntity> list = new ArrayList<>();

    public void insert(CustomerEntity customerEntity) {
        list.add(customerEntity);
        fireTableDataChanged();
    }

    public void update(int row, CustomerEntity customerEntity) {
        list.set(row, customerEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public CustomerEntity get(int row) {
        return list.get(row);
    }

    public void setList(List<CustomerEntity> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return  list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getKodeCustomer();
            case 2:
                return list.get(rowIndex).getNamaPt();
            case 3:
                return list.get(rowIndex).getNpwp();
            case 4:
                return list.get(rowIndex).getSppkp();
            case 5:
                return list.get(rowIndex).getTglBergabung();
            case 6:
                return list.get(rowIndex).getTglHabisKontrak();
            case 7:
                return list.get(rowIndex).getNoHp();
            case 8:
                return list.get(rowIndex).getNoTelp();
            case 9:
                return list.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Kode Customer";
            case 2:
                return "Nama Perusahaan";
            case 3:
                return "NPWP";
            case 4:
                return "SPPKP";
            case 5:
                return "Tgl Bergabung";
            case 6:
                return "Tgl Habis Kontrak";
            case 7:
                return "No. Hp";
            case 8:
                return "No. Telp";
            case 9:
                return "Alamat";
            default:
                return null;
        }
    }

}
