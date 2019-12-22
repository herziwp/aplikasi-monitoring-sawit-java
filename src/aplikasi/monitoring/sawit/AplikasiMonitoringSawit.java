/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit;

import aplikasi.monitoring.sawit.view.HomeView;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class AplikasiMonitoringSawit {
     private static String className = "Aplikasi Monitoring Sawit";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException error) {
            System.err.println("Error At : Class = " + className + ", Methode = main \n& " + error.toString());
            JOptionPane.showMessageDialog(null, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException error) {
            System.err.println("Error At : Class = " + className + ", Methode = main \n& " + error.toString());
            JOptionPane.showMessageDialog(null, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException error) {
            System.err.println("Error At : Class = " + className + ", Methode = main \n& " + error.toString());
            JOptionPane.showMessageDialog(null, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (javax.swing.UnsupportedLookAndFeelException error) {
            System.err.println("Error At : Class = " + className + ", Methode = main \n& " + error.toString());
            JOptionPane.showMessageDialog(null, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new HomeView().setVisible(true);
            }
        });
    }
    
}
