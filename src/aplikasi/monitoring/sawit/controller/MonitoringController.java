/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.controller;

import aplikasi.monitoring.sawit.entity.KebunEntity;
import aplikasi.monitoring.sawit.entity.MonitoringDetailEntity;
import aplikasi.monitoring.sawit.implement.MonitoringImplement;
import aplikasi.monitoring.sawit.table.MonitoringDetailTableModel;
import aplikasi.monitoring.sawit.table.MonitoringTableModel;
import aplikasi.monitoring.sawit.view.KebunCariView;
import aplikasi.monitoring.sawit.view.MonitoringView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author it2-PC
 */
public class MonitoringController {
     private static String className = "MonitoringController";
     private MonitoringTableModel monitoringTableModel = new MonitoringTableModel();
    private  MonitoringDetailTableModel monitoringDetailTableModel = new MonitoringDetailTableModel();
    private MonitoringImplement monitoringImplement = new MonitoringImplement();

    public void setMaximumFrame(MonitoringView monitoringView) {
        try {
            monitoringView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(monitoringView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
      public void buttonSimpanAction(MonitoringView monitoringView) {
        try {
            if (MonitoringView.textIdKebun.getText().equals("")) {
                JOptionPane.showMessageDialog(monitoringView, "Cari Kebun dulu");
                monitoringView.buttonCari.doClick();
            } else if(MonitoringView.tglUpdate.getDate() == null) {
                JOptionPane.showMessageDialog(monitoringView, "Tanggal update wajib diisi.");
                MonitoringView.tglUpdate.requestFocus();
            } else {
                 MonitoringDetailEntity monitoringDetailEntity = new MonitoringDetailEntity();

                if (MonitoringView.tglUpdate.getDate() == null) {
                    monitoringDetailEntity.setTglUpdate(null);
                } else {
                    Date d = MonitoringView.tglUpdate.getCalendar().getTime();
                    java.sql.Date tglUpdate = new java.sql.Date(d.getTime());
                    monitoringDetailEntity.setTglUpdate(tglUpdate);
                }
                
                if (MonitoringView.comboProgress.getSelectedIndex() == 1) {
                    monitoringDetailEntity.setProgressKebun("perawatan");
                } else if (MonitoringView.comboProgress.getSelectedIndex() == 2) {
                    monitoringDetailEntity.setProgressKebun("siap_panen");
                } else if  (MonitoringView.comboProgress.getSelectedIndex() == 3) {
                    monitoringDetailEntity.setProgressKebun("panen_gagal");
                } else if  (MonitoringView.comboProgress.getSelectedIndex() == 4) {
                    monitoringDetailEntity.setProgressKebun("penanaman_kembali");
                } else if  (MonitoringView.comboProgress.getSelectedIndex() == 5) {
                    monitoringDetailEntity.setProgressKebun("proses_panen");
                }  else if  (MonitoringView.comboProgress.getSelectedIndex() == 6) {
                    monitoringDetailEntity.setProgressKebun("selesai_panen");
                } else  {
                    monitoringDetailEntity.setProgressKebun("proses_tanam");
                }

                monitoringDetailEntity.setId(Integer.valueOf(MonitoringView.labelId.getText()));
                monitoringDetailEntity.setKebunId(Integer.valueOf(MonitoringView.textIdKebun.getText()));
               // monitoringDetailEntity.setProgressKebun(MonitoringView.comboProgress.getSelectedItem().toString());
                monitoringDetailEntity.setKet(MonitoringView.textKet.getText());

                String condition = MonitoringView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = monitoringImplement.insertData(monitoringDetailEntity);
                    JOptionPane.showMessageDialog(monitoringView, message);
                } 
                refresh(monitoringView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }
    
    public void buttonKeluarAction(MonitoringView monitoringView) {
        try {
            monitoringView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }

    
    public void setTableModelKebun(MonitoringView monitoringView) {
        try {
            MonitoringView.tabelKebun.setModel(monitoringTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode setTableModelTransaksi \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode setTableModelTransaksi");
        }
    }
    
    public void setTableModelDetail(MonitoringView monitoringView) {
        try {
            MonitoringView.tabelDetailKebun.setModel(monitoringDetailTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode setTableModelTransaksiDetail \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode setTableModelTransaksiDetail");
        }
    }
    
    private void clearTableDetail(MonitoringView monitoringView) {
        try {
            for(int i = monitoringDetailTableModel.getRowCount() - 1; i >= 0; i--) {
                monitoringDetailTableModel.delete(i);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode clearTableTransaksiDetail \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode clearTableTransaksiDetail");
        }
    }
   
    
    private void loadData(MonitoringView monitoringView) {
        try {
            List<KebunEntity> list = monitoringImplement.getListData();
            monitoringTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode loadData \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode loadData");
        }
        
    }
    
    public void refresh(MonitoringView monitoringView) {
        try {
            MonitoringView.tab.setEnabledAt(0, true);
            MonitoringView.tab.setEnabledAt(1, true);
            MonitoringView.tab.setSelectedIndex(0);
            
            MonitoringView.textCari.setText("");
            MonitoringView.tabelKebun.clearSelection();
            MonitoringView.tabelDetailKebun.clearSelection();
            
            MonitoringView.textIdKebun.setText("");
            MonitoringView.tglUpdate.setDate(new Date());
            MonitoringView.textNamaKebun.setText("");
            MonitoringView.textKet.setText("");
            MonitoringView.comboProgress.setSelectedIndex(0);
            MonitoringView.textIdKebun.setEnabled(false);
            MonitoringView.textNamaKebun.setEnabled(false);
            MonitoringView.tglUpdate.setEnabled(false);
            MonitoringView.comboProgress.setEnabled(false);
            MonitoringView.textKet.setEnabled(false);
            MonitoringView.buttonSimpan.setEnabled(false);
            MonitoringView.buttonBatal.setEnabled(false);
            MonitoringView.buttonCari.setEnabled(false);
            
            loadData(monitoringView);
            clearTableDetail(monitoringView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", fmethode refresh \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode refresh");
        }
    }
    
    public void searchData(MonitoringView monitoringView) {
        try {
            String seacrhParameter = MonitoringView.textCari.getText();
            
            
            List<KebunEntity> list = monitoringImplement.getListDataByParameter(seacrhParameter);
            monitoringTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode searchData \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+",methode searchData");
        }
    }
    
    public void buttonBaruAction(MonitoringView monitoringView) {
        try {
           MonitoringView.tab.setEnabledAt(0, false);
            MonitoringView.tab.setEnabledAt(1, true);
            MonitoringView.tab.setSelectedIndex(1);
             MonitoringView.labelStatus.setText("INSERT");
             
            
            MonitoringView.textCari.setText("");
            MonitoringView.tabelKebun.clearSelection();
            MonitoringView.tabelDetailKebun.clearSelection();
            
            MonitoringView.textIdKebun.setText("");
            MonitoringView.tglUpdate.setDate(new Date());
            MonitoringView.textNamaKebun.setText("");
            MonitoringView.textKet.setText("");
            MonitoringView.comboProgress.setSelectedIndex(0);
            MonitoringView.textIdKebun.setEnabled(true);
            MonitoringView.textNamaKebun.setEnabled(true);
            MonitoringView.tglUpdate.setEnabled(true);
            MonitoringView.comboProgress.setEnabled(true);
            MonitoringView.textKet.setEnabled(true);
            MonitoringView.buttonCari.setEnabled(true);
            MonitoringView.buttonSimpan.setEnabled(true);
            MonitoringView.buttonBatal.setEnabled(true);
            
            clearTableDetail(monitoringView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode buttonBaruAction \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode buttonBaruAction");
        }
    }
    
    public void buttonHapusAction(MonitoringView monitoringView) {
        try {
            int rowSelected = MonitoringView.tabelKebun.getSelectedRow();
            
            if(rowSelected == -1) {
                JOptionPane.showMessageDialog(monitoringView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                int kebunId = monitoringTableModel.get(rowSelected).getId();
                
                int confirm = JOptionPane.showConfirmDialog(monitoringView, "Apakah anda yakin ingin menghapus data "
                        +kebunId+"?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION) {
                    String message = monitoringImplement.deleteData(kebunId);
                    JOptionPane.showMessageDialog(monitoringView, message);
                } refresh(monitoringView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode buttonHapusAction \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode buttonHapusAction");
        }
    }
    
    
    public void buttnBatalAction(MonitoringView monitoringView) {
        try {
            refresh(monitoringView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode buttonBatalAction \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode buttonBatalAction");
        }
    }
    
    public void buttonMuatUlangAction(MonitoringView monitoringView) {
        try {
            refresh(monitoringView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode buttonMuatUlangAction \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode buttonMuatUlangAction");
        }
    }
    
    
    public void buttonCariKebunAction(MonitoringView monitoringView) {
        try {
            
            KebunCariView kebunCariView = new KebunCariView(null, true);
            KebunCariView.labelView.setText("MONITORING");
            kebunCariView.setVisible(true);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class "+className+", methode buttonCariKasirAction \n Detail : "+error);
            JOptionPane.showMessageDialog(monitoringView, "Terjadi kesalahan pada class "+className+", methode buttonCariKasirAction");
        }
    }
    
    public void tableAction(MonitoringView monitoringView) {
        MonitoringView.tabelKebun.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = MonitoringView.tabelKebun.getSelectedRow();
                //CEK APAKAH BARIS BENAR2 TERSELEKSI
                if(row != -1) {
                    //ISI METHOD DISINI
                    KebunEntity kebunEntity = monitoringTableModel.get(row);
                    
                    List<MonitoringDetailEntity> list = monitoringImplement.getListMonitoringDetail(kebunEntity.getId());
                    monitoringDetailTableModel.setList(list);
                    
                }
            }
        });
    }
}