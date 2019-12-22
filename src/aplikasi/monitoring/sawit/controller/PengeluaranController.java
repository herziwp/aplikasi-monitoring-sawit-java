/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.controller;

import static aplikasi.monitoring.sawit.controller.PengeluaranController.pengeluaranImplement;
import static aplikasi.monitoring.sawit.controller.PengeluaranController.pengeluaranTableModel;
import aplikasi.monitoring.sawit.entity.PengeluaranEntity;
import aplikasi.monitoring.sawit.implement.PengeluaranImplement;
import aplikasi.monitoring.sawit.table.PengeluaranTableModel;
import aplikasi.monitoring.sawit.view.HomeView;
import aplikasi.monitoring.sawit.view.KebunCariView;
import aplikasi.monitoring.sawit.view.PengeluaranView;
import aplikasi.monitoring.sawit.view.PengeluaranView;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author it2-PC
 */
public class PengeluaranController {
    private static String className = "PengeluaranController";
     public static PengeluaranTableModel pengeluaranTableModel = new PengeluaranTableModel();
    public static PengeluaranImplement pengeluaranImplement = new PengeluaranImplement();

    public void setMaximumFrame(PengeluaranView pengeluaranView) {
        try {
            pengeluaranView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(pengeluaranView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
      public void setTableModel(PengeluaranView pengeluaranView) {
        try {
            PengeluaranView.tableData.setModel(pengeluaranTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }

    public void loadData(PengeluaranView pengeluaranView) {
        try {
            List<PengeluaranEntity> list = pengeluaranImplement.getListData();
            pengeluaranTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }
    
     public void refresh(PengeluaranView pengeluaranView) {
        try {
            PengeluaranView.labelStatus.setText("");
            PengeluaranView.labelID.setText("0");
            PengeluaranView.textIdKebun.setText("");
            PengeluaranView.textNama.setText("");
            PengeluaranView.textBiayaTanaman.setText("");
            PengeluaranView.textBiayaLain.setText("");
            PengeluaranView.textBiayaPanen.setText("");
            PengeluaranView.textTotal.setText("");
            PengeluaranView.textKet.setText("");
            
            PengeluaranView.textCari.setText("");
            PengeluaranView.tableData.clearSelection();

            PengeluaranView.textIdKebun.setEnabled(false);
            PengeluaranView.textNama.setEnabled(false);
            PengeluaranView.textBiayaLain.setEnabled(false);
            PengeluaranView.textBiayaPanen.setEnabled(false);
            PengeluaranView.textBiayaTanaman.setEnabled(false);
            PengeluaranView.textTotal.setEnabled(false);
            PengeluaranView.textKet.setEnabled(false);
            PengeluaranView.buttonCari.setEnabled(false);
            PengeluaranView.buttonSimpan.setEnabled(false);
            PengeluaranView.buttonBatal.setEnabled(false);
            PengeluaranView.textCari.setEnabled(true);
            PengeluaranView.tableData.setEnabled(true);
            PengeluaranView.buttonBaru.setEnabled(true);
            PengeluaranView.buttonUbah.setEnabled(true);
            PengeluaranView.buttonHapus.setEnabled(true);
            PengeluaranView.buttonMuatUlang.setEnabled(true);
            PengeluaranView.buttonKeluar.setEnabled(true);

            loadData(pengeluaranView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode refresh \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode refresh");
        }
    }

    public void searchData(PengeluaranView pengeluaranView) {
        try {
            String searchParameter = PengeluaranView.textCari.getText();

            List<PengeluaranEntity> list = pengeluaranImplement.getListDataByParameter(searchParameter);
            pengeluaranTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }

    public void buttonBaruAction(PengeluaranView pengeluaranView) {
        try {

           PengeluaranView.labelStatus.setText("INSERT");
            PengeluaranView.labelID.setText("0");
            PengeluaranView.textIdKebun.setText("");
            PengeluaranView.textIdKebun.setText("");
            PengeluaranView.textNama.setText("");
            PengeluaranView.textBiayaTanaman.setText("");
            PengeluaranView.textBiayaLain.setText("");
            PengeluaranView.textBiayaPanen.setText("");
            PengeluaranView.textTotal.setText("");
            PengeluaranView.textKet.setText("");
            
            PengeluaranView.textCari.setText("");
            PengeluaranView.tableData.clearSelection();

            PengeluaranView.textIdKebun.setEnabled(true);
            PengeluaranView.textIdKebun.setEnabled(true);
            PengeluaranView.textNama.setEnabled(true);
            PengeluaranView.textBiayaLain.setEnabled(true);
            PengeluaranView.textBiayaPanen.setEnabled(true);
            PengeluaranView.textBiayaTanaman.setEnabled(true);
            PengeluaranView.textTotal.setEnabled(true);
            PengeluaranView.textKet.setEnabled(true);
            PengeluaranView.buttonCari.setEnabled(true);
            PengeluaranView.buttonSimpan.setEnabled(true);
            PengeluaranView.buttonBatal.setEnabled(true);
            PengeluaranView.textCari.setEnabled(false);
            PengeluaranView.tableData.setEnabled(false);
            PengeluaranView.buttonBaru.setEnabled(false);
            PengeluaranView.buttonUbah.setEnabled(false);
            PengeluaranView.buttonHapus.setEnabled(false);
            PengeluaranView.buttonMuatUlang.setEnabled(false);
            PengeluaranView.buttonKeluar.setEnabled(false);

            PengeluaranView.textBiayaTanaman.requestFocus();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBaruAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode buttonBaruAction");
        }
    }

    public void buttonUbahAction(PengeluaranView pengeluaranView) {
        try {
            int rowSelected = PengeluaranView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(pengeluaranView, "Silahkan seleksi data yang ingin diubah");
            } else {
                PengeluaranView.labelStatus.setText("UPDATE");

              PengeluaranView.textIdKebun.setEnabled(true);
           PengeluaranView.textIdKebun.setEnabled(true);
            PengeluaranView.textIdKebun.setEnabled(true);
            PengeluaranView.textNama.setEnabled(true);
            PengeluaranView.textBiayaLain.setEnabled(true);
            PengeluaranView.textBiayaPanen.setEnabled(true);
            PengeluaranView.textBiayaTanaman.setEnabled(true);
            PengeluaranView.textTotal.setEnabled(true);
            PengeluaranView.textKet.setEnabled(true);
            PengeluaranView.buttonCari.setEnabled(true);
            PengeluaranView.buttonSimpan.setEnabled(true);
            PengeluaranView.buttonBatal.setEnabled(true);
            PengeluaranView.buttonSimpan.setEnabled(true);
            PengeluaranView.buttonBatal.setEnabled(true);
                PengeluaranView.textCari.setEnabled(false);
                PengeluaranView.tableData.setEnabled(false);
                PengeluaranView.buttonBaru.setEnabled(false);
                PengeluaranView.buttonUbah.setEnabled(false);
                PengeluaranView.buttonHapus.setEnabled(false);
                PengeluaranView.buttonMuatUlang.setEnabled(false);
                PengeluaranView.buttonKeluar.setEnabled(false);
                PengeluaranView.textBiayaTanaman.requestFocus();
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonUbahAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode buttonUbahAction");
        }
    }

    public void buttonHapusAction(PengeluaranView pengeluaranView) {
        try {
            int rowSelected = PengeluaranView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(pengeluaranView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                int id = pengeluaranTableModel.get(rowSelected).getId();
                String nama = pengeluaranTableModel.get(rowSelected).getNamaKebun();

                int confirm = JOptionPane.showConfirmDialog(pengeluaranView, "Apakah anda yakin menghapus data "
                        + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = pengeluaranImplement.deleteData(id);
                    JOptionPane.showMessageDialog(pengeluaranView, message);
                }
                refresh(pengeluaranView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonHapusAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode buttonHapusAction");
        }
    }

    
    
        public void buttonSimpanAction(PengeluaranView pengeluaranView) {
        try {
            if (PengeluaranView.textIdKebun.getText().equals("")) {
                JOptionPane.showMessageDialog(pengeluaranView, "Cari Kebun dulu");
                PengeluaranView.textIdKebun.requestFocus();
            } else if(PengeluaranView.textBiayaTanaman.getText().equals("") &&
                    PengeluaranView.textBiayaLain.getText().equals("") && PengeluaranView.textBiayaPanen.getText().equals("")) {
                JOptionPane.showMessageDialog(pengeluaranView, "Harus ada biaya yang dikeluarkan.");
            } else {
                 PengeluaranEntity pengeluaranEntity = new PengeluaranEntity();

                java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                pengeluaranEntity.setCreatedAt(date);
                pengeluaranEntity.setUpdatedAt(date);
                
                pengeluaranEntity.setId(Integer.valueOf(PengeluaranView.labelID.getText()));
                pengeluaranEntity.setIdKebun(Integer.valueOf(PengeluaranView.textIdKebun.getText()));
                pengeluaranEntity.setBiayaTanaman(new BigDecimal(PengeluaranView.textBiayaTanaman.getText()));
                pengeluaranEntity.setBiayaPanen(new BigDecimal(PengeluaranView.textBiayaPanen.getText()));
                pengeluaranEntity.setBiayaLain(new BigDecimal(PengeluaranView.textBiayaLain.getText()));
                pengeluaranEntity.setTotalPengeluaran(new BigDecimal(PengeluaranView.textTotal.getText()));
                pengeluaranEntity.setKet(PengeluaranView.textKet.getText());

                String condition = PengeluaranView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = pengeluaranImplement.insertData(pengeluaranEntity);
                    JOptionPane.showMessageDialog(pengeluaranView, message);
                } else if (condition.equals("UPDATE")) {
                    String message = pengeluaranImplement.updateData(pengeluaranEntity);
                    JOptionPane.showMessageDialog(pengeluaranView, message);
                }
                refresh(pengeluaranView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }
        
        public static void setGrandTotal(PengeluaranView pengeluaranView) {
        try {
            BigDecimal biaya_tanaman = new BigDecimal(0);
            if(!PengeluaranView.textBiayaTanaman.getText().equals("")) {
                biaya_tanaman = new BigDecimal(PengeluaranView.textBiayaTanaman.getText());
            }
            
            BigDecimal biaya_panen = new BigDecimal(0);
            if(!PengeluaranView.textBiayaPanen.getText().equals("")) {
                biaya_panen = new BigDecimal(PengeluaranView.textBiayaPanen.getText());
            }
            
            BigDecimal biaya_lain = new BigDecimal(0);
            if(!PengeluaranView.textBiayaLain.getText().equals("")) {
                biaya_lain = new BigDecimal(PengeluaranView.textBiayaLain.getText());
            }
            
            
            //BigDecimal jumlah = new BigDecimal(PengeluaranView.textJumlahPanen.getText());
           // BigDecimal subTotal = new BigDecimal(PengeluaranView.textSubTotal.getText());
            BigDecimal grandTotal = biaya_tanaman.add(biaya_lain).add(biaya_panen);
            PengeluaranView.textTotal.setText(grandTotal.toString());
            
          //  setKembali(pengeluaranView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", function setGrandTotal \n Detail : "+error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class "+className+", function setGrandTotal");
        }
    }
    
    public void buttonKeluarAction(PengeluaranView pengeluaranView) {
        try {
            pengeluaranView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pengeluaranView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }
    
    public void tableDataAction(PengeluaranView pengeluaranView) {
        PengeluaranView.tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = PengeluaranView.tableData.getSelectedRow();
                if (row != -1) {
                    PengeluaranEntity pengeluaranEntity = pengeluaranTableModel.get(row);
                    
                    PengeluaranView.labelID.setText(Integer.toString(pengeluaranEntity.getId()));
                    PengeluaranView.textIdKebun.setText(Integer.toString(pengeluaranEntity.getIdKebun()));
                    PengeluaranView.textNama.setText(pengeluaranEntity.getNamaKebun());
                      PengeluaranView.textKet.setText(pengeluaranEntity.getKet());
                    PengeluaranView.textTotal.setText(pengeluaranEntity.getTotalPengeluaran().toString());
                    PengeluaranView.textBiayaPanen.setText(pengeluaranEntity.getBiayaPanen().toString());
                    PengeluaranView.textBiayaTanaman.setText(pengeluaranEntity.getBiayaTanaman().toString());
                    PengeluaranView.textBiayaLain.setText(pengeluaranEntity.getBiayaLain().toString());
                    
                }
            }
        });
    }
    
       public void cariKebunAction(PengeluaranView pendapatanView) {
        try {
            KebunCariView kebunCariView = new KebunCariView(null, true);
            KebunCariView.labelView.setText("PENGELUARAN");
            kebunCariView.setVisible(true);
        } catch (Exception e) {
            
        }
    }

}