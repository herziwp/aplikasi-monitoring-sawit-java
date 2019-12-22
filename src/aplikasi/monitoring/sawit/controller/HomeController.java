/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.controller;

import aplikasi.monitoring.sawit.view.HomeView;
import aplikasi.monitoring.sawit.view.CustomerView;
import aplikasi.monitoring.sawit.view.KaryawanView;
import aplikasi.monitoring.sawit.view.KebunView;
import aplikasi.monitoring.sawit.view.LahanView;
import aplikasi.monitoring.sawit.view.MonitoringView;
import aplikasi.monitoring.sawit.view.PendapatanView;
import aplikasi.monitoring.sawit.view.PengeluaranView;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class HomeController {
    
    private final static String className = "HomeController";
    
    public void maximazieWindows(HomeView homeView) {
        try {
            homeView.setExtendedState(MAXIMIZED_BOTH);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = maximazieWindows \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void menuItemKeluarAction(HomeView homeView) {
        try {
            int confirm = JOptionPane.showConfirmDialog(homeView, "Apakah Anda Yakin Ingin Keluar Dari Aplikasi Ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(homeView, "Terimakasih Telah Menggunakan Aplikasi Ini");
                System.exit(0);
            }
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemKeluarAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void menuItemCustomerAction(HomeView homeView) {
        try {
                CustomerView customerView = new CustomerView();
                homeView.panelMain.removeAll();
                HomeView.panelMain.add(customerView);
                customerView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemPenggunaAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
      public void menuItemLahanAction(HomeView homeView) {
        try {
                LahanView lahanView = new LahanView();
                homeView.panelMain.removeAll();
                HomeView.panelMain.add(lahanView);
                lahanView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemPenggunaAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
      
      
    public void menuItemKaryawanAction(HomeView homeView) {
        try {
                KaryawanView karyawanView = new KaryawanView();
                homeView.panelMain.removeAll();
                HomeView.panelMain.add(karyawanView);
                karyawanView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemPenggunaAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void menuItemKebunAction(HomeView homeView) {
        try {
                KebunView kebunView = new KebunView();
                homeView.panelMain.removeAll();
                HomeView.panelMain.add(kebunView);
                kebunView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemKebunAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void menuItemMonitoringAction(HomeView homeView) {
        try {
                MonitoringView monitorView = new MonitoringView();
                homeView.panelMain.removeAll();
                HomeView.panelMain.add(monitorView);
                monitorView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemKebunAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void menuItemPendapatanAction(HomeView homeView) {
        try {
                PendapatanView pendapatanView = new PendapatanView();
                homeView.panelMain.removeAll();
                HomeView.panelMain.add(pendapatanView);
                pendapatanView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemKebunAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void menuItemPengeluaranAction(HomeView homeView) {
        try {
                PengeluaranView pengeluaranView = new PengeluaranView();
                homeView.panelMain.removeAll();
                HomeView.panelMain.add(pengeluaranView);
                pengeluaranView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = menuItemKebunAction \n& " + error);
            JOptionPane.showMessageDialog(homeView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
