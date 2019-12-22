/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasi.monitoring.sawit.controller;

import aplikasi.monitoring.sawit.entity.LahanEntity;
import aplikasi.monitoring.sawit.implement.LahanImplement;
import aplikasi.monitoring.sawit.table.LahanTableModel;
import aplikasi.monitoring.sawit.view.KebunView;
import aplikasi.monitoring.sawit.view.LahanCariView;
import aplikasi.monitoring.sawit.view.LahanView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Acer
 */
public class LahanController {
      private static String className = "LahanController";
         public static LahanTableModel lahanTableModel = new LahanTableModel();
         public static LahanImplement lahanImplement = new LahanImplement();
         
    public void setMaximumFrame(LahanView lahanView) {
        try {
            lahanView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(lahanView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void setTableModel(LahanView lahanView) {
        try {
            LahanView.tableData.setModel(lahanTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }

    public void loadData(LahanView lahanView) {
        try {
            List<LahanEntity> list = lahanImplement.getListData();
            lahanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }

    public void refresh(LahanView lahanView) {
        try {
            LahanView.labelStatus.setText("INSERT");
            LahanView.textKoordinat.setText("");
            LahanView.textLokasi.setText("");
            LahanView.textLuas.setText("");
            LahanView.textCari.setText("");
            LahanView.tableData.clearSelection();

            LahanView.textKoordinat.setEnabled(false);
            LahanView.textLokasi.setEnabled(false);
            LahanView.textLuas.setEnabled(false);
            LahanView.buttonSimpan.setEnabled(false);
            LahanView.buttonBatal.setEnabled(false);
            LahanView.textCari.setEnabled(true);
            LahanView.tableData.setEnabled(true);
            LahanView.buttonBaru.setEnabled(true);
            LahanView.buttonUbah.setEnabled(true);
            LahanView.buttonHapus.setEnabled(true);
            LahanView.buttonMuatUlang.setEnabled(true);
            LahanView.buttonKeluar.setEnabled(true);

            loadData(lahanView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode refresh \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode refresh");
        }
    }

    public void searchData(LahanView lahanView) {
        try {
            String searchParameter = LahanView.textCari.getText();

            List<LahanEntity> list = lahanImplement.getListDataByParameter(searchParameter);
            lahanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }

    public void buttonBaruAction(LahanView lahanView) {
        try {



            LahanView.labelStatus.setText("INSERT");
            LahanView.textKoordinat.setText("");
            LahanView.textLokasi.setText("");
            LahanView.textLuas.setText("");
            LahanView.textCari.setText("");
            LahanView.tableData.clearSelection();

            LahanView.textKoordinat.setEnabled(true);
            LahanView.textLokasi.setEnabled(true);
            LahanView.textLuas.setEnabled(true);
            LahanView.buttonSimpan.setEnabled(true);
            LahanView.buttonBatal.setEnabled(true);
            LahanView.buttonSimpan.setEnabled(true);
            LahanView.buttonBatal.setEnabled(true);
            LahanView.textCari.setEnabled(false);
            LahanView.tableData.setEnabled(true);
            LahanView.buttonBaru.setEnabled(false);
            LahanView.buttonUbah.setEnabled(false);
            LahanView.buttonHapus.setEnabled(false);
            LahanView.buttonMuatUlang.setEnabled(false);
            LahanView.buttonKeluar.setEnabled(false);

            LahanView.textKoordinat.requestFocus();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBaruAction \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode buttonBaruAction");
        }
    }

    public void buttonUbahAction(LahanView lahanView) {
        try {
            int rowSelected = LahanView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(lahanView, "Silahkan seleksi data yang ingin diubah");
            } else {
                LahanView.labelStatus.setText("UPDATE");
               LahanView.textKoordinat.setEnabled(true);
            LahanView.textLokasi.setEnabled(true);
            LahanView.textLuas.setEnabled(true);
            LahanView.buttonSimpan.setEnabled(true);
            LahanView.buttonBatal.setEnabled(true);
            LahanView.buttonSimpan.setEnabled(true);
            LahanView.buttonBatal.setEnabled(true);
            LahanView.textCari.setEnabled(false);
            LahanView.tableData.setEnabled(true);
            LahanView.buttonBaru.setEnabled(false);
            LahanView.buttonUbah.setEnabled(false);
            LahanView.buttonHapus.setEnabled(false);
            LahanView.buttonMuatUlang.setEnabled(false);
            LahanView.buttonKeluar.setEnabled(false);

                LahanView.textKoordinat.requestFocus();
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonUbahAction \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode buttonUbahAction");
        }
    }

    public void buttonHapusAction(LahanView lahanView) {
        try {
            int rowSelected = LahanView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(lahanView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                int id = lahanTableModel.get(rowSelected).getId();
                String nama = lahanTableModel.get(rowSelected).getKoordinat();

                int confirm = JOptionPane.showConfirmDialog(lahanView, "Apakah anda yakin menghapus data "
                        + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = lahanImplement.deleteData(id);
                    JOptionPane.showMessageDialog(lahanView, message);
                }
                refresh(lahanView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonHapusAction \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode buttonHapusAction");
        }
    }

    public void buttonSimpanAction(LahanView lahanView) {
        try {
            if (LahanView.textKoordinat.getText().equals("")) {
                JOptionPane.showMessageDialog(lahanView, "Lengkapi Nama");
                LahanView.textKoordinat.requestFocus();
            } else if(LahanView.textLokasi.getText().equals("")) {
                JOptionPane.showMessageDialog(lahanView, "Lengkapi Lokasi Lahan");
                LahanView.textLokasi.requestFocus();
            } else if(LahanView.textLuas.getText().equals("")) {
                JOptionPane.showMessageDialog(lahanView, "Lengkapi Luas Lahan");
                LahanView.textLuas.requestFocus();
            } else {
                 LahanEntity lahanEntity = new LahanEntity();
                
                lahanEntity.setId(Integer.valueOf(LahanView.labelID.getText()));
                lahanEntity.setKoordinat(LahanView.textKoordinat.getText());
                lahanEntity.setLuas(LahanView.textLuas.getText());
                lahanEntity.setLokasi(LahanView.textLokasi.getText());

                String condition = LahanView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = lahanImplement.insertData(lahanEntity);
                    JOptionPane.showMessageDialog(lahanView, message);
                } else if (condition.equals("UPDATE")) {
                    String message = lahanImplement.updateData(lahanEntity);
                    JOptionPane.showMessageDialog(lahanView, message);
                }
                refresh(lahanView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }
    
    public void buttonBatalAction(LahanView lahanView) {
        try {
            refresh(lahanView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBatalAction \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode buttonBatalAction");
        }
    }

    public void buttonMuatUlangAction(LahanView lahanView) {
        try {
            refresh(lahanView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonMuatUlangAction \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode buttonMuatUlangAction");
        }
    }
    
    public void buttonKeluarAction(LahanView lahanView) {
        try {
            lahanView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(lahanView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }
    
     public void tableDataAction(LahanView lahanView) {
        LahanView.tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = LahanView.tableData.getSelectedRow();
                if (row != -1) {
                    LahanEntity lahanEntity = lahanTableModel.get(row);
                    
                    LahanView.textKoordinat.setText(lahanEntity.getKoordinat());
                    LahanView.textLokasi.setText(lahanEntity.getLokasi());
                    LahanView.textLuas.setText(lahanEntity.getLuas());
                    LahanView.labelID.setText(Integer.toString(lahanEntity.getId()));
                    
                }
            }
        });
    }
     
}
