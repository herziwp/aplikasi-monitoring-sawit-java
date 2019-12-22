/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.table;

import aplikasi.monitoring.sawit.entity.PendapatanEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author it2-PC
 */
public class PendapatanTableModel extends AbstractTableModel {

    private List<PendapatanEntity> list = new ArrayList<>();

    public void insert(PendapatanEntity karyawanEntity) {
        list.add(karyawanEntity);
        fireTableDataChanged();
    }

    public void update(int row, PendapatanEntity karyawanEntity) {
        list.set(row, karyawanEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public PendapatanEntity get(int row) {
        return list.get(row);
    }

    public void setList(List<PendapatanEntity> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        switch (columnIndex) {
            case 0:
                return  list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNamaKebun();
            case 2:
                return list.get(rowIndex).getNamaCustomer();
            case 3:
                return list.get(rowIndex).getJumlahPanen();
            case 4:
                return "Rp."+list.get(rowIndex).getHargaKg();
            case 5:
                return "Rp."+list.get(rowIndex).getTotalPendapatan();
            case 6:
                return list.get(rowIndex).getKet();
            case 7:
                return list.get(rowIndex).getCreatedAt();
            case 8:
                return list.get(rowIndex).getUpdatedAt();
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
                return "Kebun";
            case 2:
                return "Customer";
            case 3:
                return "Jumlah Panen";
            case 4:
                return "Harga /kg";
            case 5:
                return "Total Pendapatan";
            case 6:
                return "Keterangan";
            case 7:
                return "Created_at";
            case 8:
                return "Updated_at";
            default:
                return null;
        }
    }

}
