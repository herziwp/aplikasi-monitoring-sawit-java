/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.monitoring.sawit.controller;

import aplikasi.monitoring.sawit.entity.CustomerEntity;
import aplikasi.monitoring.sawit.implement.CustomerImplement;
import aplikasi.monitoring.sawit.table.CustomerTableModel;
import aplikasi.monitoring.sawit.view.CustomerCariView;
import aplikasi.monitoring.sawit.view.PendapatanView;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author it2-PC
 */
public class CustomerCariController {
     private static String className = "CustomerCariController";
         public static CustomerTableModel customerTableModel = new CustomerTableModel();
         public static CustomerImplement customerImplement = new CustomerImplement();
         
     public void setTableModel(CustomerCariView customerCariView) {
        try {
            customerCariView.tableCari.setModel(customerTableModel);
        } catch (Exception error) {
            System.err.println("Terjadi Kesacustomer pada class " + className + ", methode setTableModel \n Detail : " + error);
            JOptionPane.showMessageDialog(customerCariView, "Terjadi kesacustomer pada class " + className + ", methode setTableModel");
        }
    }
   public void loadData(CustomerCariView customerCariView) {
        try {
            List<CustomerEntity> list = customerImplement.getListData();
            customerTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesacustomer pada class " + className + ", methode loadData \n Detail : " + error);
            JOptionPane.showMessageDialog(customerCariView, "Terjadi kesacustomer pada class " + className + ", methode loadData");
        }
    }
     
    public void searchData(CustomerCariView customerCariView) {
        try {
            String searchParameter = CustomerCariView.textCari.getText();

            List<CustomerEntity> list = customerImplement.getListDataByParameter(searchParameter);
            customerTableModel.setList(list);
        } catch (Exception error) {
            System.err.println("Terjadi Kesacustomer pada class " + className + ", methode searchData \n Detail : " + error);
            JOptionPane.showMessageDialog(customerCariView, "Terjadi kesacustomer pada class " + className + ", methode searchData");
        }
    }
     
      public void refresh(CustomerCariView customerCariView) {
        try {
            CustomerCariView.textCari.setText("");
            CustomerCariView.textCari.requestFocus();

            loadData(customerCariView);
        } catch (Exception error) {
            System.err.println("Terjadi kesacustomer pada class " + className + "methode refresh \n Detail :" + error);
            JOptionPane.showMessageDialog(customerCariView, "Terjadi kesacustomer pada class" + className + ", methode refresh");

        }
    }

    public void tableCariAction(final CustomerCariView customerCariView) {
        CustomerCariView.tableCari.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = CustomerCariView.tableCari.getSelectedRow();

                if (row != -1) {
                    CustomerEntity customerEntity = customerTableModel.get(row);

                    
                    PendapatanView.textIdCustomer.setText(Integer.toString(customerEntity.getId()));
                    PendapatanView.textNamaCustomer.setText(customerEntity.getNamaPt());

                    customerCariView.dispose();
                }
            }
        });
    }
}
