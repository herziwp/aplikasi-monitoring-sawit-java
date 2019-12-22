/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.table;

import aplikasi.monitoring.sawit.entity.KaryawanEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class KaryawanTableModel extends AbstractTableModel {

    private List<KaryawanEntity> list = new ArrayList<>();

    public void insert(KaryawanEntity karyawanEntity) {
        list.add(karyawanEntity);
        fireTableDataChanged();
    }

    public void update(int row, KaryawanEntity karyawanEntity) {
        list.set(row, karyawanEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public KaryawanEntity get(int row) {
        return list.get(row);
    }

    public void setList(List<KaryawanEntity> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        switch (columnIndex) {
            case 0:
                return  list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getTglLahir();
            case 3:
                return list.get(rowIndex).getJenkel();
            case 4:
                return list.get(rowIndex).getNoHp();
            case 5:
                return list.get(rowIndex).getAlamat();
            case 6:
                return list.get(rowIndex).getJabatan();
            case 7:
                return list.get(rowIndex).getStatusAktif();
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
                return "Nama Karyawan";
            case 2:
                return "Tgl Lahir";
            case 3:
                return "Jenkel";
            case 4:
                return "No. Hp";
            case 5:
                return "Alamat";
            case 6:
                return "Jabatan";
            case 7:
                return "Status Aktif";
            default:
                return null;
        }
    }

}