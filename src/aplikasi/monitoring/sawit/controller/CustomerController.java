/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.controller;import aplikasi.monitoring.sawit.entity.CustomerEntity;
import aplikasi.monitoring.sawit.implement.CustomerImplement;
import aplikasi.monitoring.sawit.table.CustomerTableModel;
import aplikasi.monitoring.sawit.table.TableCellRender;
import aplikasi.monitoring.sawit.view.CustomerView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Acer
 */
public class CustomerController {

    private static String className = "CustomerController";
    public static CustomerTableModel customerTableModel = new CustomerTableModel();
    public static CustomerImplement customerImplement = new CustomerImplement();

    public void setMaximumFrame(CustomerView customerView) {
        try {
            customerView.setMaximum(true);
        } catch (Exception error) {
            System.err.println("Error At : Class = " + className + ", Methode = setMaximumFrame \n& " + error);
            JOptionPane.showMessageDialog(customerView, error.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setTableModel(CustomerView customerView) {
        try {
            CustomerView.tableData.setModel(customerTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode setTableModel");
        }
    }

    public void loadData(CustomerView customerView) {
        try {
            List<CustomerEntity> list = customerImplement.getListData();
            customerTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode loadData");
        }
    }

    public void refresh(CustomerView customerView) {
        try {
            CustomerView.labelStatus.setText("INSERT");
            CustomerView.textKode.setText("");
            CustomerView.textNama.setText("");
            CustomerView.textNpwp.setText("");
            CustomerView.textSppkp.setText("");
            CustomerView.textNoHp.setText("");
            CustomerView.textNoTelp.setText("");
            CustomerView.textAlamat.setText("");
            CustomerView.tglBergabung.setDate(new Date());
            CustomerView.textCari.setText("");
            CustomerView.tableData.clearSelection();

            CustomerView.textKode.setEnabled(false);
            CustomerView.textNama.setEnabled(false);
            CustomerView.textNpwp.setEnabled(false);
            CustomerView.textSppkp.setEnabled(false);
            CustomerView.textNoHp.setEnabled(false);
            CustomerView.textNoTelp.setEnabled(false);
            CustomerView.textAlamat.setEnabled(false);
            CustomerView.tglBergabung.setEnabled(false);
            CustomerView.tglHabisKontrak.setEnabled(false);
            CustomerView.buttonSimpan.setEnabled(false);
            CustomerView.buttonBatal.setEnabled(false);
            CustomerView.textCari.setEnabled(true);
            CustomerView.tableData.setEnabled(true);
            CustomerView.buttonBaru.setEnabled(true);
            CustomerView.buttonUbah.setEnabled(true);
            CustomerView.buttonHapus.setEnabled(true);
            CustomerView.buttonMuatUlang.setEnabled(true);
            CustomerView.buttonKeluar.setEnabled(true);

            loadData(customerView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode refresh \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode refresh");
        }
    }

    public void searchData(CustomerView customerView) {
        try {
            String searchParameter = CustomerView.textCari.getText();

            List<CustomerEntity> list = customerImplement.getListDataByParameter(searchParameter);
            customerTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode searchData");
        }
    }

    public void buttonBaruAction(CustomerView customerView) {
        try {

            int rowCount = CustomerView.tableData.getRowCount();
            String id;
            if (rowCount == 0) {
                id = "CST01";
            } else {
                String id1 = (String) CustomerView.tableData.getValueAt(rowCount - 1, 1);
                int last = Integer.parseInt(id1.substring(3, id1.length()));

                if (last >= 0 && last < 9) {
                    id = "CST0" + (last + 1);
                } else {
                    id = "CST" + (last + 1);
                }
            }

            CustomerView.labelStatus.setText("INSERT");
            CustomerView.textKode.setText(id);
            CustomerView.textNama.setText("");
            CustomerView.textNpwp.setText("");
            CustomerView.textSppkp.setText("");
            CustomerView.textNoHp.setText("");
            CustomerView.textNoTelp.setText("");
            CustomerView.textAlamat.setText("");
            CustomerView.tglBergabung.setDate(new Date());
            CustomerView.textCari.setText("");
            CustomerView.tableData.clearSelection();

            CustomerView.textKode.setEnabled(true);
            CustomerView.textNama.setEnabled(true);
            CustomerView.textNpwp.setEnabled(true);
            CustomerView.textSppkp.setEnabled(true);
            CustomerView.textNoHp.setEnabled(true);
            CustomerView.textNoTelp.setEnabled(true);
            CustomerView.textAlamat.setEnabled(true);
            CustomerView.tglBergabung.setEnabled(true);
            CustomerView.tglHabisKontrak.setEnabled(true);
            CustomerView.buttonSimpan.setEnabled(true);
            CustomerView.buttonBatal.setEnabled(true);
            CustomerView.textCari.setEnabled(false);
            CustomerView.tableData.setEnabled(true);
            CustomerView.buttonBaru.setEnabled(false);
            CustomerView.buttonUbah.setEnabled(false);
            CustomerView.buttonHapus.setEnabled(false);
            CustomerView.buttonMuatUlang.setEnabled(false);
            CustomerView.buttonKeluar.setEnabled(false);

            CustomerView.textNama.requestFocus();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBaruAction \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode buttonBaruAction");
        }
    }

    public void buttonUbahAction(CustomerView customerView) {
        try {
            int rowSelected = CustomerView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(customerView, "Silahkan seleksi data yang ingin diubah");
            } else {
                CustomerView.labelStatus.setText("UPDATE");
                CustomerView.textKode.setEnabled(true);
                CustomerView.textNama.setEnabled(true);
                CustomerView.textNpwp.setEnabled(true);
                CustomerView.textSppkp.setEnabled(true);
                CustomerView.textNoHp.setEnabled(true);
                CustomerView.textNoTelp.setEnabled(true);
                CustomerView.textAlamat.setEnabled(true);
                CustomerView.tglBergabung.setEnabled(true);
                CustomerView.tglHabisKontrak.setEnabled(true);
                CustomerView.buttonSimpan.setEnabled(true);
                CustomerView.buttonBatal.setEnabled(true);
                CustomerView.textCari.setEnabled(false);
                CustomerView.tableData.setEnabled(true);
                CustomerView.buttonBaru.setEnabled(false);
                CustomerView.buttonUbah.setEnabled(false);
                CustomerView.buttonHapus.setEnabled(false);
                CustomerView.buttonMuatUlang.setEnabled(false);
                CustomerView.buttonKeluar.setEnabled(false);

                CustomerView.textNama.requestFocus();
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonUbahAction \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode buttonUbahAction");
        }
    }

    public void buttonHapusAction(CustomerView customerView) {
        try {
            int rowSelected = CustomerView.tableData.getSelectedRow();

            if (rowSelected == -1) {
                JOptionPane.showMessageDialog(customerView, "Silahkan seleksi data yang ingin dihapus");
            } else {
                String id = customerTableModel.get(rowSelected).getKodeCustomer();
                String nama = customerTableModel.get(rowSelected).getNamaPt();

                int confirm = JOptionPane.showConfirmDialog(customerView, "Apakah anda yakin menghapus data "
                        + nama + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    String message = customerImplement.deleteData(id);
                    JOptionPane.showMessageDialog(customerView, message);
                }
                refresh(customerView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonHapusAction \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode buttonHapusAction");
        }
    }

    public void buttonSimpanAction(CustomerView customerView) {
        try {
            if (CustomerView.textNama.getText().equals("")) {
                JOptionPane.showMessageDialog(customerView, "Lengkapi Nama");
                CustomerView.textNama.requestFocus();
            } else if(CustomerView.textNpwp.getText().equals("")) {
                JOptionPane.showMessageDialog(customerView, "Lengkapi Npwp");
                CustomerView.textNpwp.requestFocus();
            } else if(CustomerView.textSppkp.getText().equals("")) {
                JOptionPane.showMessageDialog(customerView, "Lengkapi Sppkp");
                CustomerView.textSppkp.requestFocus();
            } else if(CustomerView.textNoHp.getText().equals("")) {
               JOptionPane.showMessageDialog(customerView, "Lengkapi NoHp");
                CustomerView.textNoHp.requestFocus(); 
            } else if(CustomerView.textAlamat.getText().equals("")) {
                JOptionPane.showMessageDialog(customerView, "Lengkapi Alamat");
                CustomerView.textAlamat.requestFocus();
            } else {
                CustomerEntity customerEntity = new CustomerEntity();
                
                if(CustomerView.tglBergabung.getDate() == null){
                    customerEntity.setTglBergabung(null);
                } else {
                    Date d = CustomerView.tglBergabung.getCalendar().getTime();
                    java.sql.Date tglBergabung = new java.sql.Date(d.getTime());
                    customerEntity.setTglBergabung(tglBergabung);
                }
                
                if(CustomerView.tglHabisKontrak.getDate() == null){
                    customerEntity.setTglHabisKontrak(null);
                } else {
                    Date dd = CustomerView.tglHabisKontrak.getCalendar().getTime();
                    java.sql.Date tglHabisKontrak = new java.sql.Date(dd.getTime());
                    customerEntity.setTglHabisKontrak(tglHabisKontrak);
                }

                
                customerEntity.setKodeCustomer(CustomerView.textKode.getText());
                customerEntity.setNamaPt(CustomerView.textNama.getText());
                customerEntity.setNpwp(CustomerView.textNpwp.getText());
                customerEntity.setSppkp(CustomerView.textSppkp.getText());
                customerEntity.setNoHp(CustomerView.textNoHp.getText());
                customerEntity.setNoTelp(CustomerView.textNoTelp.getText());
                customerEntity.setAlamat(CustomerView.textAlamat.getText());
                

                String condition = CustomerView.labelStatus.getText();
                if (condition.equals("INSERT")) {
                    String message = customerImplement.insertData(customerEntity);
                    JOptionPane.showMessageDialog(customerView, message);
                } else if (condition.equals("UPDATE")) {
                    String message = customerImplement.updateData(customerEntity);
                    JOptionPane.showMessageDialog(customerView, message);
                }
                refresh(customerView);
            }
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonSimpanAction \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode buttonSimpanAction");
        }
    }

    public void buttonBatalAction(CustomerView customerView) {
        try {
            refresh(customerView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonBatalAction \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode buttonBatalAction");
        }
    }

    public void buttonMuatUlangAction(CustomerView customerView) {
        try {
            refresh(customerView);
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonMuatUlangAction \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode buttonMuatUlangAction");
        }
    }

    public void buttonKeluarAction(CustomerView customerView) {
        try {
            customerView.dispose();
        } catch (Exception error) {
            System.err.println("Terjadi Kesalahan pada class " + className + ", methode buttonKeluarAction \n Detail : " + error);
            JOptionPane.showMessageDialog(customerView, "Terjadi kesalahan pada class " + className + ", methode buttonKeluarAction");
        }
    }

    public void tableDataAction(CustomerView customerView) {
        CustomerView.tableData.getColumnModel().getColumn(6).setCellRenderer(new TableCellRender());
        CustomerView.tableData.getColumnModel().getColumn(5).setCellRenderer(new TableCellRender());
        CustomerView.tableData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = CustomerView.tableData.getSelectedRow();
                if (row != -1) {
                    CustomerEntity customerEntity = customerTableModel.get(row);

                    CustomerView.textKode.setText(customerEntity.getKodeCustomer());
                    CustomerView.textNama.setText(customerEntity.getNamaPt());
                    CustomerView.textNpwp.setText(customerEntity.getNpwp());
                    CustomerView.textSppkp.setText(customerEntity.getSppkp());
                    CustomerView.textNoHp.setText(customerEntity.getNoHp());
                    CustomerView.textNoTelp.setText(customerEntity.getNoTelp());
                    CustomerView.textAlamat.setText(customerEntity.getAlamat());
                    CustomerView.tglBergabung.setDate(customerEntity.getTglBergabung());
                    CustomerView.tglHabisKontrak.setDate(customerEntity.getTglHabisKontrak());
                    
                }
            }
        });
    }
}
