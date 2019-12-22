/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.table;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author it2-PC
 */
public class RenderTableWarnaWarni extends DefaultTableCellRenderer {
 
    private static final long serialVersionUID = 47612794125L;
 
    // warna background untuk baris ganjil
    private Color ganjil;
 
    // warna background untuk baris genap
    private Color genap;
 
    public RenderTableWarnaWarni(Color ganjil, Color genap) {
        this.ganjil = ganjil;
        this.genap = genap;
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // mendapatkan component superclass
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
        // cek ganjil ato genap
        if (row % 2 == 1) {
            // ganjil
            component.setBackground(ganjil);
        } else {
            // genap
            component.setBackground(genap);
        }
 
        // mengembalikan komponen
        return component;
    }
}