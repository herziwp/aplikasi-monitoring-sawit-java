/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.table;

import aplikasi.monitoring.sawit.entity.LahanEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class LahanTableModel extends AbstractTableModel {

    private List<LahanEntity> list = new ArrayList<>();

    public void insert(LahanEntity lahanEntity) {
        list.add(lahanEntity);
        fireTableDataChanged();
    }

    public void update(int row, LahanEntity lahanEntity) {
        list.set(row, lahanEntity);
        fireTableDataChanged();
    }

    public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }

    public LahanEntity get(int row) {
        return list.get(row);
    }

    public void setList(List<LahanEntity> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return  list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getLokasi();
            case 2:
                return list.get(rowIndex).getKoordinat();
            case 3:
                return list.get(rowIndex).getLuas();
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
                return "Lokasi";
            case 2:
                return "Koordinat";
            case 3:
                return "Luas";
            default:
                return null;
        }
    }

}
