/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.table;

import aplikasi.monitoring.sawit.entity.MonitoringDetailEntity;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class MonitoringDetailTableModel extends AbstractTableModel {
    
    private List<MonitoringDetailEntity> list = new ArrayList<>();

public void insert(MonitoringDetailEntity transaksiDetailEntity) {
    list.add(transaksiDetailEntity);
    fireTableDataChanged();
}

public void update(int row, MonitoringDetailEntity transaksiDetailEntity) {
    list.set(row, transaksiDetailEntity);
    fireTableDataChanged();
}

public void delete(int row) {
    list.remove(row);
    fireTableDataChanged();
}

public MonitoringDetailEntity get(int row) {
    return list.get(row);
}

public void setList(List<MonitoringDetailEntity> list) {
    this.list = list;
    fireTableDataChanged();
}

@Override
public int getRowCount() {
    return list.size();
}

@Override
public int getColumnCount() {
    return 5;
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    switch(columnIndex) {
        case 0:
            return rowIndex + 1;
        case 1:
            return list.get(rowIndex).getNama();
        case 2:
            return list.get(rowIndex).getProgressKebun();
        case 3:
            return list.get(rowIndex).getKet();
        case 4:
            return list.get(rowIndex).getTglUpdate();
        default:       
            return null;
    }
}

    @Override
    public String getColumnName(int column) {
        switch(column) {
        case 0:
            return "No.";
        case 1:
            return "Nama Kebun";
        case 2:
            return "Progress Kebun";
        case 3:
            return "Keterangan";
        case 4:
            return "Tgl Perubahan";
        default:
            return null;
        }
    }
}
