/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.table;

import aplikasi.monitoring.sawit.entity.PengeluaranEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author it2-PC
 */
public class PengeluaranTableModel extends AbstractTableModel {

    private List<PengeluaranEntity> list = new ArrayList<>();

    public void insert(PengeluaranEntity pengeluaranEntity) {
        list.add(pengeluaranEntity);
        fireTableDataChanged();
    }

    public void update(int row, PengeluaranEntity pengeluaranEntity) {
        list.set(row, pengeluaranEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public PengeluaranEntity get(int row) {
        return list.get(row);
    }

    public void setList(List<PengeluaranEntity> list) {
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
                return "Rp."+list.get(rowIndex).getBiayaTanaman();
            case 3:
                return "Rp."+list.get(rowIndex).getBiayaPanen();
            case 4:
                return "Rp."+list.get(rowIndex).getBiayaLain();
            case 5:
                return "Rp."+list.get(rowIndex).getTotalPengeluaran();
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
                return "Biaya Tanaman";
            case 3:
                return "Biaya Panen";
            case 4:
                return "Biaya Lainnya";
            case 5:
                return "Total Pengeluaran";
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

