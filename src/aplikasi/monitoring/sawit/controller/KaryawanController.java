/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.controller;

import static aplikasi.monitoring.sawit.controller.KaryawanController.karyawanImplement;
import static aplikasi.monitoring.sawit.controller.KaryawanController.karyawanTableModel;
import aplikasi.monitoring.sawit.entity.KaryawanEntity;
import aplikasi.monitoring.sawit.implement.KaryawanImplement;
import aplikasi.monitoring.sawit.table.KaryawanTableModel;
import aplikasi.monitoring.sawit.view.KaryawanView;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Acer
 */
public class KaryawanController {

    private static String className = "KaryawanController";
    public static KaryawanTableModel karyawanTableModel = new KaryawanTableModel();
    public static KaryawanImplement karyawanImplement = new KaryawanImplement();

    public void setMaximumFrame(KaryawanView karyawanView) {
        try {
            karyawanView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(karyawanView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setTableModel(KaryawanView karyawanView) {
        try {
            KaryawanView.tableData.setModel(karyawanTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }

    public void loadData(KaryawanView karyawanView) {
        try {
            List<KaryawanEntity> list = karyawanImplement.getListData();
            karyawanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }

    public void refresh(KaryawanView karyawanView) {
        try {
            KaryawanView.labelStatus.setText("INSERT");
            KaryawanView.labelID.setText("0");
            KaryawanView.textNama.setText("");
            KaryawanView.textNoHp.setText("");
            KaryawanView.textAlamat.setText("");
            KaryawanView.tglLahir.setDate(new Date());
            KaryawanView.textCari.setText("");
            KaryawanView.tableData.clearSelection();
            KaryawanView.rA.setEnabled(false);
            KaryawanView.rTa.setEnabled(false);

            KaryawanView.textNama.setEnabled(false);
            KaryawanView.textNoHp.setEnabled(false);
            KaryawanView.textAlamat.setEnabled(false);
            KaryawanView.cmbJabatan.setEnabled(false);
            KaryawanView.cmbJenkel.setEnabled(false);
            KaryawanView.tglLahir.setEnabled(false);
            KaryawanView.buttonSimpan.setEnabled(false);
            KaryawanView.buttonBatal.setEnabled(false);
            KaryawanView.textCari.setEnabled(true);
            KaryawanView.tableData.setEnabled(true);
            KaryawanView.buttonBaru.setEnabled(true);
            KaryawanView.buttonUbah.setEnabled(true);
            KaryawanView.buttonHapus.setEnabled(true);
            KaryawanView.buttonMuatUlang.setEnabled(true);
            KaryawanView.buttonKeluar.setEnabled(true);

            loadData(karyawanView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode refresh \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode refresh");
        }
    }

    public void searchData(KaryawanView karyawanView) {
        try {
            String searchParameter = KaryawanView.textCari.getText();

            List<KaryawanEntity> list = karyawanImplement.getListDataByParameter(searchParameter);
            karyawanTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }

    public void buttonBaruAction(KaryawanView karyawanView) {
        try {

            KaryawanView.labelStatus.setText("INSERT");
            KaryawanView.labelID.setText("0");
            KaryawanView.textNama.setText("");
            KaryawanView.textNoHp.setText("");
            KaryawanView.textAlamat.setText("");
            KaryawanView.tglLahir.setDate(new Date());
            KaryawanView.textCari.setText("");
            KaryawanView.tableData.clearSelection();
            
            KaryawanView.rA.setEnabled(true);
            KaryawanView.rTa.setEnabled(true);

            KaryawanView.textNama.setEnabled(true);
            KaryawanView.textNoHp.setEnabled(true);
            KaryawanView.textAlamat.setEnabled(true);
            KaryawanView.cmbJabatan.setEnabled(true);
            KaryawanView.cmbJenkel.setEnabled(true);
            KaryawanView.tglLahir.setEnabled(true);
            KaryawanView.buttonSimpan.setEnabled(true);
            KaryawanView.buttonBatal.setEnabled(true);
            KaryawanView.textCari.setEnabled(false);
            KaryawanView.tableData.setEnabled(false);
            KaryawanView.buttonBaru.setEnabled(false);
            KaryawanView.buttonUbah.setEnabled(false);
            KaryawanView.buttonHapus.setEnabled(false);
            KaryawanView.buttonMuatUlang.setEnabled(false);
            KaryawanView.buttonKeluar.setEnabled(false);

            KaryawanView.textNama.requestFocus();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBaruAction \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode buttonBaruAction");
        }
    }

    public void buttonUbahAction(KaryawanView karyawanView) {
        try {
            int rowSelected = KaryawanView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(karyawanView, "Silahkan seleksi data yang ingin diubah");
            } else {
                KaryawanView.labelStatus.setText("UPDATE");

                KaryawanView.textNama.setEnabled(true);
                KaryawanView.textNoHp.setEnabled(true);
                KaryawanView.textAlamat.setEnabled(true);
                KaryawanView.cmbJabatan.setEnabled(true);
                KaryawanView.cmbJenkel.setEnabled(true);
                KaryawanView.tglLahir.setEnabled(true);
                KaryawanView.buttonSimpan.setEnabled(true);
                KaryawanView.buttonBatal.setEnabled(true);
                KaryawanView.rA.setEnabled(true);
            KaryawanView.rTa.setEnabled(true);
                KaryawanView.textCari.setEnabled(false);
                KaryawanView.tableData.setEnabled(false);
                KaryawanView.buttonBaru.setEnabled(false);
                KaryawanView.buttonUbah.setEnabled(false);
                KaryawanView.buttonHapus.setEnabled(false);
                KaryawanView.buttonMuatUlang.setEnabled(false);
                KaryawanView.buttonKeluar.setEnabled(false);
                KaryawanView.textNama.requestFocus();
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonUbahAction \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode buttonUbahAction");
        }
    }

    public void buttonHapusAction(KaryawanView karyawanView) {
        try {
            int rowSelected = KaryawanView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(karyawanView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                int id = karyawanTableModel.get(rowSelected).getId();
                String nama = karyawanTableModel.get(rowSelected).getNama();

                int confirm = JOptionPane.showConfirmDialog(karyawanView, "Apakah anda yakin menghapus data "
                        + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = karyawanImplement.deleteData(id);
                    JOptionPane.showMessageDialog(karyawanView, message);
                }
                refresh(karyawanView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonHapusAction \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode buttonHapusAction");
        }
    }

    public void buttonSimpanAction(KaryawanView karyawanView) {
        try {
            if (KaryawanView.textNama.getText().equals("")) {
                JOptionPane.showMessageDialog(karyawanView, "Lengkapi Nama");
                KaryawanView.textNama.requestFocus();
            } else if (KaryawanView.textNoHp.getText().equals("")) {
                JOptionPane.showMessageDialog(karyawanView, "Lengkapi No Hp");
                KaryawanView.textNoHp.requestFocus();
            } else if (KaryawanView.textAlamat.getText().equals("")) {
                JOptionPane.showMessageDialog(karyawanView, "Lengkapi Alamat");
                KaryawanView.textAlamat.requestFocus();
            } else {
                KaryawanEntity karyawanEntity = new KaryawanEntity();

                if (KaryawanView.tglLahir.getDate() == null) {
                    karyawanEntity.setTglLahir(null);
                } else {
                    Date d = KaryawanView.tglLahir.getCalendar().getTime();
                    java.sql.Date tglLahir = new java.sql.Date(d.getTime());
                    karyawanEntity.setTglLahir(tglLahir);
                }

                if (KaryawanView.rA.isSelected() == true) {
                    karyawanEntity.setStatusAktif("1");
                } else {
                    karyawanEntity.setStatusAktif("0");
                }

                if (KaryawanView.cmbJenkel.getSelectedIndex() == 0) {
                    karyawanEntity.setJenkel("l");
                } else {
                    karyawanEntity.setJenkel("p");
                }
                

                karyawanEntity.setId(Integer.valueOf(KaryawanView.labelID.getText()));
                karyawanEntity.setNama(KaryawanView.textNama.getText());
                karyawanEntity.setNoHp(KaryawanView.textNoHp.getText());
                karyawanEntity.setJabatan(KaryawanView.cmbJabatan.getSelectedItem().toString());
                karyawanEntity.setAlamat(KaryawanView.textAlamat.getText());

                String condition = KaryawanView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = karyawanImplement.insertData(karyawanEntity);
                    JOptionPane.showMessageDialog(karyawanView, message);
                } else if (condition.equals("UPDATE")) {
                    String message = karyawanImplement.updateData(karyawanEntity);
                    JOptionPane.showMessageDialog(karyawanView, message);
                }
                refresh(karyawanView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }

    public void buttonKeluarAction(KaryawanView karyawanView) {
        try {
            karyawanView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(karyawanView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }
    
    public void tableDataAction(KaryawanView karyawanView) {
        KaryawanView.tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = KaryawanView.tableData.getSelectedRow();
                if (row != -1) {
                    KaryawanEntity karyawanEntity = karyawanTableModel.get(row);
                    


                    KaryawanView.labelID.setText(Integer.toString(karyawanEntity.getId()));
                    KaryawanView.textNama.setText(karyawanEntity.getNama());
                    KaryawanView.textNoHp.setText(karyawanEntity.getNoHp());
                    KaryawanView.textAlamat.setText(karyawanEntity.getAlamat());
                    KaryawanView.tglLahir.setDate(karyawanEntity.getTglLahir());
                    KaryawanView.cmbJabatan.setSelectedItem(karyawanEntity.getJabatan());
                    
                    if(karyawanEntity.getJenkel().equals("l")) {
                        KaryawanView.cmbJenkel.setSelectedIndex(0);
                    } else {
                        KaryawanView.cmbJenkel.setSelectedIndex(1);                       
                    }
                    
                    if(karyawanEntity.getStatusAktif().equals("1")) {
                        KaryawanView.rA.setSelected(true);
                    } else {
                        KaryawanView.rTa.setSelected(true);
                    }
                    
                }
            }
        });
    }
}