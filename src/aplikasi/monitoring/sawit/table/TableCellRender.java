/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.table;

/**
 *
 * @author it2-PC
 */
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
 
public class TableCellRender extends DefaultTableCellRenderer {
 
    private static final long serialVersionUID = 1L;
    private SimpleDateFormat format;
 
    public TableCellRender() {
        format = new SimpleDateFormat("dd/MM/yyyy");
    }
 
    @Override
    public Component getTableCellRendererComponent(JTable table,
        Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table,
                                         value, isSelected, hasFocus, row, column);
 
        if (value != null && value instanceof Date) {
            Date date = (Date) value;
            String text = format.format(date);
            label.setText(text);
        }
 
        return label;
    }
}