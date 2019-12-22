/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.controller;

import static aplikasi.monitoring.sawit.controller.KebunController.kebunImplement;
import static aplikasi.monitoring.sawit.controller.KebunController.kebunTableModel;
import aplikasi.monitoring.sawit.entity.KebunEntity;
import aplikasi.monitoring.sawit.implement.KebunImplement;
import aplikasi.monitoring.sawit.table.KebunTableModel;
import aplikasi.monitoring.sawit.view.HomeView;
import aplikasi.monitoring.sawit.view.KebunView;
import aplikasi.monitoring.sawit.view.LahanCariView;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author it2-PC
 */
public class KebunController {
     private static String className = "KebunController";
     public static KebunTableModel kebunTableModel = new KebunTableModel();
    public static KebunImplement kebunImplement = new KebunImplement();

    public void setMaximumFrame(KebunView kebunView) {
        try {
            kebunView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(kebunView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void setTableModel(KebunView kebunView) {
        try {
            KebunView.tableData.setModel(kebunTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }

    public void loadData(KebunView kebunView) {
        try {
            List<KebunEntity> list = kebunImplement.getListData();
            kebunTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }

    public void refresh(KebunView kebunView) {
        try {
            KebunView.labelStatus.setText("");
            KebunView.labelID.setText("0");
            KebunView.textNama.setText("");
            KebunView.textIdLahan.setText("");
            KebunView.textLokasi.setText("");
            KebunView.textVarietas.setText("");
            KebunView.textTotal.setText("");
            KebunView.tglTanam.setDate(null);
            KebunView.tglPerkiraanPanen.setDate(null);
            KebunView.textCari.setText("");
            KebunView.tableData.clearSelection();

            KebunView.textIdLahan.setEnabled(false);
            KebunView.textLokasi.setEnabled(false);
            KebunView.textNama.setEnabled(false);
            KebunView.textVarietas.setEnabled(false);
            KebunView.textTotal.setEnabled(false);
            KebunView.tglTanam.setEnabled(false);
            KebunView.tglPerkiraanPanen.setEnabled(false);
            KebunView.buttonCari.setEnabled(false);
            KebunView.buttonSimpan.setEnabled(false);
            KebunView.buttonBatal.setEnabled(false);
            KebunView.textCari.setEnabled(true);
            KebunView.tableData.setEnabled(true);
            KebunView.buttonBaru.setEnabled(true);
            KebunView.buttonUbah.setEnabled(true);
            KebunView.buttonHapus.setEnabled(true);
            KebunView.buttonMuatUlang.setEnabled(true);
            KebunView.buttonKeluar.setEnabled(true);

            loadData(kebunView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode refresh \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode refresh");
        }
    }

    public void searchData(KebunView kebunView) {
        try {
            String searchParameter = KebunView.textCari.getText();

            List<KebunEntity> list = kebunImplement.getListDataByParameter(searchParameter);
            kebunTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }

    public void buttonBaruAction(KebunView kebunView) {
        try {

           KebunView.labelStatus.setText("INSERT");
            KebunView.labelID.setText("0");
            KebunView.textNama.setText("");
            KebunView.textIdLahan.setText("");
            KebunView.textLokasi.setText("");
            KebunView.textVarietas.setText("");
            KebunView.textTotal.setText("");
            KebunView.tglTanam.setDate(null);
            KebunView.tglPerkiraanPanen.setDate(null);
            KebunView.textCari.setText("");
            KebunView.tableData.clearSelection();
            
            KebunView.buttonCari.setEnabled(true);
            KebunView.textIdLahan.setEnabled(true);
            KebunView.textLokasi.setEnabled(true);
            KebunView.textNama.setEnabled(true);
            KebunView.textVarietas.setEnabled(true);
            KebunView.textTotal.setEnabled(true);
            KebunView.tglTanam.setEnabled(true);
            KebunView.tglPerkiraanPanen.setEnabled(true);
            KebunView.buttonSimpan.setEnabled(true);
            KebunView.buttonBatal.setEnabled(true);
            KebunView.textCari.setEnabled(false);
            KebunView.tableData.setEnabled(false);
            KebunView.buttonBaru.setEnabled(false);
            KebunView.buttonUbah.setEnabled(false);
            KebunView.buttonHapus.setEnabled(false);
            KebunView.buttonMuatUlang.setEnabled(false);
            KebunView.buttonKeluar.setEnabled(false);

            KebunView.textNama.requestFocus();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBaruAction \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode buttonBaruAction");
        }
    }

    public void buttonUbahAction(KebunView kebunView) {
        try {
            int rowSelected = KebunView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(kebunView, "Silahkan seleksi data yang ingin diubah");
            } else {
                KebunView.labelStatus.setText("UPDATE");

               KebunView.textIdLahan.setEnabled(true);
            KebunView.textLokasi.setEnabled(true);
            KebunView.textNama.setEnabled(true);
            KebunView.textVarietas.setEnabled(true);
            KebunView.textTotal.setEnabled(true);
            KebunView.tglTanam.setEnabled(true);
            KebunView.tglPerkiraanPanen.setEnabled(true);
            KebunView.buttonCari.setEnabled(true);
                KebunView.buttonSimpan.setEnabled(true);
                KebunView.buttonBatal.setEnabled(true);
                KebunView.textCari.setEnabled(false);
                KebunView.tableData.setEnabled(false);
                KebunView.buttonBaru.setEnabled(false);
                KebunView.buttonUbah.setEnabled(false);
                KebunView.buttonHapus.setEnabled(false);
                KebunView.buttonMuatUlang.setEnabled(false);
                KebunView.buttonKeluar.setEnabled(false);
                KebunView.textNama.requestFocus();
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonUbahAction \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode buttonUbahAction");
        }
    }

    public void buttonHapusAction(KebunView kebunView) {
        try {
            int rowSelected = KebunView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(kebunView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                int id = kebunTableModel.get(rowSelected).getId();
                String nama = kebunTableModel.get(rowSelected).getNama();

                int confirm = JOptionPane.showConfirmDialog(kebunView, "Apakah anda yakin menghapus data "
                        + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = kebunImplement.deleteData(id);
                    JOptionPane.showMessageDialog(kebunView, message);
                }
                refresh(kebunView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonHapusAction \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode buttonHapusAction");
        }
    }

    
        public void buttonSimpanAction(KebunView kebunView) {
        try {
            if (KebunView.textNama.getText().equals("")) {
                JOptionPane.showMessageDialog(kebunView, "Lengkapi Nama Kebun");
                KebunView.textNama.requestFocus();
            } else if(KebunView.textIdLahan.getText().equals("")) {
                JOptionPane.showMessageDialog(kebunView, "Cari lahan dulu!");
                kebunView.buttonCari.doClick();
            } else if(KebunView.textVarietas.getText().equals("")) {
                JOptionPane.showMessageDialog(kebunView, "Lengkapi Varietas Sawit");
                KebunView.textVarietas.requestFocus();
            } else if(KebunView.textTotal.getText().equals("")) {
                JOptionPane.showMessageDialog(kebunView, "Lengkapi Total Pohon");
                KebunView.textTotal.requestFocus();
            } else {
                 KebunEntity kebunEntity = new KebunEntity();

                if (KebunView.tglTanam.getDate() == null) {
                    kebunEntity.setTglTanam(null);
                } else {
                    Date d = KebunView.tglTanam.getCalendar().getTime();
                    java.sql.Date tglTanam = new java.sql.Date(d.getTime());
                    kebunEntity.setTglTanam(tglTanam);
                }
                
                if (KebunView.tglPerkiraanPanen.getDate() == null) {
                    kebunEntity.setTglPerkiraanPanen(null);
                } else {
                    Date d = KebunView.tglPerkiraanPanen.getCalendar().getTime();
                    java.sql.Date tglPerkiraanPanen = new java.sql.Date(d.getTime());
                    kebunEntity.setTglPerkiraanPanen(tglPerkiraanPanen);
                }


                kebunEntity.setId(Integer.valueOf(KebunView.labelID.getText()));
                kebunEntity.setNama(KebunView.textNama.getText());
                kebunEntity.setLahanId(Integer.valueOf(KebunView.textIdLahan.getText()));
                kebunEntity.setVarietas(KebunView.textVarietas.getText());
                kebunEntity.setTotalPohon(Integer.valueOf(KebunView.textTotal.getText()));

                String condition = KebunView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = kebunImplement.insertData(kebunEntity);
                    JOptionPane.showMessageDialog(kebunView, message);
                } else if (condition.equals("UPDATE")) {
                    String message = kebunImplement.updateData(kebunEntity);
                    JOptionPane.showMessageDialog(kebunView, message);
                }
                refresh(kebunView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }
    
    public void buttonKeluarAction(KebunView kebunView) {
        try {
            kebunView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(kebunView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }
    
     public void tableDataAction(KebunView kebunView) {
        KebunView.tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = KebunView.tableData.getSelectedRow();
                if (row != -1) {
                    KebunEntity kebunEntity = kebunTableModel.get(row);
                    
                    KebunView.labelID.setText(Integer.toString(kebunEntity.getId()));
                    KebunView.textNama.setText(kebunEntity.getNama());
                    KebunView.textIdLahan.setText(Integer.toString(kebunEntity.getLahanId()));
                    KebunView.textLokasi.setText(kebunEntity.getLokasi());
                    KebunView.textVarietas.setText(kebunEntity.getVarietas());
                    KebunView.textTotal.setText(Integer.toString(kebunEntity.getTotalPohon()));
                    KebunView.tglTanam.setDate(kebunEntity.getTglTanam());
                    KebunView.tglPerkiraanPanen.setDate(kebunEntity.getTglPerkiraanPanen());
                    
                }
            }
        });
    }
    
      public void cariLahanAction(KebunView kebunView) {
        try {
            LahanCariView lahanCariView = new LahanCariView(null, true);
            lahanCariView.setVisible(true);
        } catch (Exception e) {
            
        }
    }

}
