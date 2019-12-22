/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.controller;

import aplikasi.monitoring.sawit.entity.PendapatanEntity;
import aplikasi.monitoring.sawit.implement.PendapatanImplement;
import aplikasi.monitoring.sawit.table.PendapatanTableModel;
import aplikasi.monitoring.sawit.view.CustomerCariView;
import aplikasi.monitoring.sawit.view.HomeView;
import aplikasi.monitoring.sawit.view.KebunCariView;
import aplikasi.monitoring.sawit.view.PendapatanView;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author it2-PC
 */
public class PendapatanController {
    private static String className = "PendapatanController";
    public static PendapatanTableModel pendapatanTableModel = new PendapatanTableModel();
    public static PendapatanImplement pendapatanImplement = new PendapatanImplement();

    public void setMaximumFrame(PendapatanView pendapatanView) {
        try {
            pendapatanView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(pendapatanView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setTableModel(PendapatanView pendapatanView) {
        try {
            PendapatanView.tableData.setModel(pendapatanTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }

    public void loadData(PendapatanView pendapatanView) {
        try {
            List<PendapatanEntity> list = pendapatanImplement.getListData();
            pendapatanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }
    
     public void refresh(PendapatanView pendapatanView) {
        try {
            PendapatanView.labelStatus.setText("");
            PendapatanView.labelID.setText("0");
            PendapatanView.textIdKebun.setText("");
            PendapatanView.textNamaKebun.setText("");
            PendapatanView.textIdCustomer.setText("");
            PendapatanView.textNamaCustomer.setText("");
            PendapatanView.textJumlahPanen.setText("");
            PendapatanView.textHarga.setText("");
            PendapatanView.textTotal.setText("");
            PendapatanView.textKet.setText("");
            
            PendapatanView.textCari.setText("");
            PendapatanView.tableData.clearSelection();

            PendapatanView.textIdKebun.setEnabled(false);
            PendapatanView.textNamaKebun.setEnabled(false);
            PendapatanView.textIdCustomer.setEnabled(false);
            PendapatanView.textNamaCustomer.setEnabled(false);
            PendapatanView.textJumlahPanen.setEnabled(false);
            PendapatanView.textHarga.setEnabled(false);
            PendapatanView.textTotal.setEnabled(false);
            PendapatanView.textKet.setEnabled(false);
            PendapatanView.buttonCariCustomer.setEnabled(false);
            PendapatanView.buttonCariKebun.setEnabled(false);
            PendapatanView.buttonSimpan.setEnabled(false);
            PendapatanView.buttonBatal.setEnabled(false);
            PendapatanView.textCari.setEnabled(true);
            PendapatanView.tableData.setEnabled(true);
            PendapatanView.buttonBaru.setEnabled(true);
            PendapatanView.buttonUbah.setEnabled(true);
            PendapatanView.buttonHapus.setEnabled(true);
            PendapatanView.buttonMuatUlang.setEnabled(true);
            PendapatanView.buttonKeluar.setEnabled(true);

            loadData(pendapatanView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode refresh \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode refresh");
        }
    }

    public void searchData(PendapatanView pendapatanView) {
        try {
            String searchParameter = PendapatanView.textCari.getText();

            List<PendapatanEntity> list = pendapatanImplement.getListDataByParameter(searchParameter);
            pendapatanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }

    public void buttonBaruAction(PendapatanView pendapatanView) {
        try {

           PendapatanView.labelStatus.setText("INSERT");
            PendapatanView.labelID.setText("0");
            PendapatanView.textIdKebun.setText("");
            PendapatanView.textNamaKebun.setText("");
            PendapatanView.textIdCustomer.setText("");
            PendapatanView.textNamaCustomer.setText("");
            PendapatanView.textJumlahPanen.setText("");
            PendapatanView.textHarga.setText("");
            PendapatanView.textTotal.setText("");
            PendapatanView.textKet.setText("");
            
            PendapatanView.textCari.setText("");
            PendapatanView.tableData.clearSelection();

            PendapatanView.textIdKebun.setEnabled(true);
            PendapatanView.textNamaKebun.setEnabled(true);
            PendapatanView.textIdCustomer.setEnabled(true);
            PendapatanView.textNamaCustomer.setEnabled(true);
            PendapatanView.textJumlahPanen.setEnabled(true);
            PendapatanView.textHarga.setEnabled(true);
            PendapatanView.textTotal.setEnabled(true);
            PendapatanView.textKet.setEnabled(true);
            PendapatanView.buttonCariCustomer.setEnabled(true);
            PendapatanView.buttonCariKebun.setEnabled(true);
            PendapatanView.buttonSimpan.setEnabled(true);
            PendapatanView.buttonBatal.setEnabled(true);
            PendapatanView.textCari.setEnabled(false);
            PendapatanView.tableData.setEnabled(false);
            PendapatanView.buttonBaru.setEnabled(false);
            PendapatanView.buttonUbah.setEnabled(false);
            PendapatanView.buttonHapus.setEnabled(false);
            PendapatanView.buttonMuatUlang.setEnabled(false);
            PendapatanView.buttonKeluar.setEnabled(false);

            PendapatanView.textJumlahPanen.requestFocus();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBaruAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode buttonBaruAction");
        }
    }

    public void buttonUbahAction(PendapatanView pendapatanView) {
        try {
            int rowSelected = PendapatanView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(pendapatanView, "Silahkan seleksi data yang ingin diubah");
            } else {
                PendapatanView.labelStatus.setText("UPDATE");

              PendapatanView.textIdKebun.setEnabled(true);
            PendapatanView.textNamaKebun.setEnabled(true);
            PendapatanView.textIdCustomer.setEnabled(true);
            PendapatanView.textNamaCustomer.setEnabled(true);
            PendapatanView.textJumlahPanen.setEnabled(true);
            PendapatanView.textHarga.setEnabled(true);
            PendapatanView.textTotal.setEnabled(true);
            PendapatanView.textKet.setEnabled(true);
            PendapatanView.buttonCariCustomer.setEnabled(true);
            PendapatanView.buttonCariKebun.setEnabled(true);
            PendapatanView.buttonSimpan.setEnabled(true);
            PendapatanView.buttonBatal.setEnabled(true);
                PendapatanView.textCari.setEnabled(false);
                PendapatanView.tableData.setEnabled(false);
                PendapatanView.buttonBaru.setEnabled(false);
                PendapatanView.buttonUbah.setEnabled(false);
                PendapatanView.buttonHapus.setEnabled(false);
                PendapatanView.buttonMuatUlang.setEnabled(false);
                PendapatanView.buttonKeluar.setEnabled(false);
                PendapatanView.textJumlahPanen.requestFocus();
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonUbahAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode buttonUbahAction");
        }
    }

    public void buttonHapusAction(PendapatanView pendapatanView) {
        try {
            int rowSelected = PendapatanView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(pendapatanView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                int id = pendapatanTableModel.get(rowSelected).getId();
                String nama = pendapatanTableModel.get(rowSelected).getNamaKebun();

                int confirm = JOptionPane.showConfirmDialog(pendapatanView, "Apakah anda yakin menghapus data "
                        + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = pendapatanImplement.deleteData(id);
                    JOptionPane.showMessageDialog(pendapatanView, message);
                }
                refresh(pendapatanView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonHapusAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode buttonHapusAction");
        }
    }

    
    
      public void buttonSimpanAction(PendapatanView pendapatanView) {
        try {
            if (PendapatanView.textIdKebun.getText().equals("")) {
                JOptionPane.showMessageDialog(pendapatanView, "Cari Kebun dulu");
                PendapatanView.buttonCariKebun.doClick();
            } else if(PendapatanView.textIdCustomer.getText().equals("")) {
                JOptionPane.showMessageDialog(pendapatanView, "Cari Customer dulu!");
                PendapatanView.buttonCariCustomer.doClick();
            } else if(PendapatanView.textJumlahPanen.getText().equals("")) {
                JOptionPane.showMessageDialog(pendapatanView, "Lengkapi Jumlah Pohon");
                PendapatanView.textJumlahPanen.requestFocus();
            } else if(PendapatanView.textHarga.getText().equals("")) {
                JOptionPane.showMessageDialog(pendapatanView, "Lengkapi Harga");
                PendapatanView.textHarga.requestFocus();
            } else {
                PendapatanEntity pendapatanEntity = new PendapatanEntity();

                java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                pendapatanEntity.setCreatedAt(date);
                pendapatanEntity.setUpdatedAt(date);
                
                pendapatanEntity.setId(Integer.valueOf(PendapatanView.labelID.getText()));
                pendapatanEntity.setIdCustomer(Integer.valueOf(PendapatanView.textIdCustomer.getText()));
                pendapatanEntity.setIdKebun(Integer.valueOf(PendapatanView.textIdKebun.getText()));
                pendapatanEntity.setJumlahPanen(Integer.valueOf(PendapatanView.textJumlahPanen.getText()));
                pendapatanEntity.setHargaKg(new BigDecimal(PendapatanView.textHarga.getText()));
                pendapatanEntity.setTotalPendapatan(new BigDecimal(PendapatanView.textTotal.getText()));
                pendapatanEntity.setKet(PendapatanView.textKet.getText());

                String condition = PendapatanView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = pendapatanImplement.insertData(pendapatanEntity);
                    JOptionPane.showMessageDialog(pendapatanView, message);
                } else if (condition.equals("UPDATE")) {
                    String message = pendapatanImplement.updateData(pendapatanEntity);
                    JOptionPane.showMessageDialog(pendapatanView, message);
                }
                refresh(pendapatanView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }
      
    public static void setGrandTotal(PendapatanView pendapatanView) {
        try {
            BigDecimal harga_kg = new BigDecimal(0);
            if(!PendapatanView.textHarga.getText().equals("")) {
                harga_kg = new BigDecimal(PendapatanView.textHarga.getText());
            }
            
            BigDecimal jumlah = new BigDecimal(0);
            if(!PendapatanView.textJumlahPanen.getText().equals("")) {
                jumlah = new BigDecimal(PendapatanView.textJumlahPanen.getText());
            }
            //BigDecimal jumlah = new BigDecimal(PendapatanView.textJumlahPanen.getText());
           // BigDecimal subTotal = new BigDecimal(PendapatanView.textSubTotal.getText());
            BigDecimal grandTotal = harga_kg.multiply(jumlah);
            PendapatanView.textTotal.setText(grandTotal.toString());
            
          //  setKembali(pendapatanView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", function setGrandTotal \n Detail : "+error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class "+className+", function setGrandTotal");
        }
    }
    
    public void buttonKeluarAction(PendapatanView pendapatanView) {
        try {
            pendapatanView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(pendapatanView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }
    
    public void tableDataAction(PendapatanView pendapatanView) {
        PendapatanView.tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = PendapatanView.tableData.getSelectedRow();
                if (row != -1) {
                    PendapatanEntity pendapatanEntity = pendapatanTableModel.get(row);
                    
                    PendapatanView.labelID.setText(Integer.toString(pendapatanEntity.getId()));
                    PendapatanView.textIdKebun.setText(Integer.toString(pendapatanEntity.getIdKebun()));
                    PendapatanView.textNamaKebun.setText(pendapatanEntity.getNamaKebun());
                    PendapatanView.textIdCustomer.setText(Integer.toString(pendapatanEntity.getIdCustomer()));
                    PendapatanView.textJumlahPanen.setText(Integer.toString(pendapatanEntity.getJumlahPanen()));
                    PendapatanView.textNamaCustomer.setText(pendapatanEntity.getNamaCustomer());
                    PendapatanView.textKet.setText(pendapatanEntity.getKet());
                    PendapatanView.textTotal.setText(pendapatanEntity.getTotalPendapatan().toString());
                    PendapatanView.textHarga.setText(pendapatanEntity.getHargaKg().toString());
                    
                }
            }
        });
    }
    
      public void cariKebunAction(PendapatanView pendapatanView) {
        try {
            KebunCariView kebunCariView = new KebunCariView(null, true);
            KebunCariView.labelView.setText("PENDAPATAN");
            kebunCariView.setVisible(true);
        } catch (Exception e) {
            
        }
    }
     
      public void cariCustomerAction(PendapatanView pendapatanView) {
        try {
            CustomerCariView customerCariView = new CustomerCariView(null, true);
            customerCariView.setVisible(true);
        } catch (Exception e) {
            
        }
    }


}

