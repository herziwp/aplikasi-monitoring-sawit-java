/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.controller;

import aplikasi.monitoring.sawit.entity.KebunEntity;
import aplikasi.monitoring.sawit.implement.KebunImplement;
import aplikasi.monitoring.sawit.table.KebunTableModel;
import aplikasi.monitoring.sawit.view.KebunCariView;
import aplikasi.monitoring.sawit.view.KebunView;
import aplikasi.monitoring.sawit.view.MonitoringView;
import aplikasi.monitoring.sawit.view.PendapatanView;
import aplikasi.monitoring.sawit.view.PengeluaranView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Acer
 */
public class KebunCariController {
      
    private static String className = "KebunCariController";
         public static KebunTableModel kebunTableModel = new KebunTableModel();
         public static KebunImplement kebunImplement = new KebunImplement();
         
     public void setTableModel(KebunCariView kebunCariView) {
        try {
            kebunCariView.tableCari.setModel(kebunTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesakebun pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunCariView, "Terjadi kesakebun pada class " + className + ", methode setTableModel");
        }
    }
   public void loadData(KebunCariView kebunCariView) {
        try {
            List<KebunEntity> list = kebunImplement.getListData();
            kebunTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesakebun pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunCariView, "Terjadi kesakebun pada class " + className + ", methode loadData");
        }
    }
     
    public void searchData(KebunCariView kebunCariView) {
        try {
            String searchParameter = KebunCariView.textCari.getText();

            List<KebunEntity> list = kebunImplement.getListDataByParameter(searchParameter);
            kebunTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesakebun pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunCariView, "Terjadi kesakebun pada class " + className + ", methode searchData");
        }
    }
     
      public void refresh(KebunCariView kebunCariView) {
        try {
            KebunCariView.textCari.setText("");
            KebunCariView.textCari.requestFocus();

            loadData(kebunCariView);
        } catch (Exception error) {
            System.err.println("Terjadi kesakebun pada class " + className + "methode refresh \n Detail :" + error);
            JOptionPane.showMessageDialog(kebunCariView, "Terjadi kesakebun pada class" + className + ", methode refresh");

        }
    }

    public void tableCariAction(final KebunCariView kebunCariView) {
        KebunCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = KebunCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    KebunEntity kebunEntity = kebunTableModel.get(row);

                    MonitoringView.textIdKebun.setText(Integer.toString(kebunEntity.getId()));
                    MonitoringView.textNamaKebun.setText(kebunEntity.getNama());
                    
                    kebunCariView.dispose();
                }
            }
        });
    }

    public void tableCariAction1(final KebunCariView kebunCariView) {
        KebunCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = KebunCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    KebunEntity kebunEntity = kebunTableModel.get(row);

                   
                    PendapatanView.textIdKebun.setText(Integer.toString(kebunEntity.getId()));
                    PendapatanView.textNamaKebun.setText(kebunEntity.getNama());

                    
                    kebunCariView.dispose();
                }
            }
        });
    }
    
    public void tableCariAction2(final KebunCariView kebunCariView) {
        KebunCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = KebunCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    KebunEntity kebunEntity = kebunTableModel.get(row);

                   
                    PengeluaranView.textIdKebun.setText(Integer.toString(kebunEntity.getId()));
                    PengeluaranView.textNama.setText(kebunEntity.getNama());

                    
                    kebunCariView.dispose();
                }
            }
        });
    }
}
