/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.report;

import aplikasi.monitoring.sawit.setting.Koneksi;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author it2-PC
 */
public class LaporanController {
    public void buttonCetakPendapatanAction() throws JRException {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("ReportPendapatan.jasper"), null, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
    }
    public void buttonCetakPengeluaranAction() throws JRException {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportPengeluaran.jasper"), null, Koneksi.getConnection());
        JasperViewer.viewReport(jp, false);
    }
}
