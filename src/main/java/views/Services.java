/*
 * Created by JFormDesigner on Thu Apr 14 15:49:21 TRT 2022
 */

package views;

import java.awt.event.*;
import models.ServiceImpl;
import models.UserImpl;
import props.Service;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author unknown
 */
public class Services extends Base {
    ServiceImpl service = new ServiceImpl();
    public Services() {
        initComponents();
        lblName.setText("Merhaba, " + UserImpl.name);
        tblServiceCustomer.setModel(service.serviceCustomerTable(null));
        tblServiceService.setModel(service.serviceServiceTable());
    }
    int row = -1; //tblCars.getSelectedRow();
    int cid = 0;
    int sid = 0;
    int column = 0;
    int scolumn = 0;

    private Service fncDataValid(){
        row = tblServiceCustomer.getSelectedRow();
        String title=txtTitle.getText().trim();
        String info=txtDetail.getText().trim();
        int days= Integer.parseInt(txtDays.getText().trim());  //boşluk varsa al trimle sil
        String date = txtDate.getText().trim();
        int status = Integer.parseInt(txtStatus.getText().trim());
        cid = Integer.valueOf(tblServiceCustomer.getModel().getValueAt(row,column).toString());

        if (title.equals("")){
            lblError.setText("Title is Empty!!!");
            txtTitle.requestFocus();
        }else if (info.equals("")){
            lblError.setText("Surname is Empty!!!");
            txtDetail.requestFocus();
        }else if (days == 0){
            lblError.setText("Days is Empty!!!");
            txtDays.requestFocus();
        }
        else if (date.equals("")){
            lblError.setText("Date is Empty!!!");
            txtDate.requestFocus();
        }
        else if (status > 3){
            lblError.setText("Gecerli bir status degeri giriniz.");
            txtStatus.requestFocus();
        }
        else {
            lblError.setText("");
            Service s = new Service(0,cid,title,info,days,date,status);
            return s;
        }
        return null; //olumsuz halinde

    }

    private void thisWindowClosing(WindowEvent e) {
        new Dashboard().setVisible(true);
    }

    private void saveCustomerButtonClick(ActionEvent e) {
        // TODO add your code here
    }

    private void txtCustomerSearchKeyReleased(KeyEvent e) {
        String txtSearch = txtCustomerSearch.getText().trim();
        tblServiceCustomer.setModel(service.serviceCustomerTable(txtSearch));
    }

    private void btnDeleteClick(ActionEvent e) {
        // TODO add your code here
    }

    private void btnCustomerUpdateClick(ActionEvent e) {
        // TODO add your code here
    }

    private void btnAddServiceClick(ActionEvent e) {
        Service s = fncDataValid();
        if(s!=null){
            int status = service.serviceInsert(s);
            if (status>0){
                System.out.println("Ekleme basarili");
                txtTitle.setText("");
                txtDetail.setText("");
                txtDate.setText("");
                txtDays.setText("");
                txtStatus.setText("");
                tblServiceService.setModel(service.serviceServiceTable());
            }
            else {
                if (status == -1){
                    lblError.setText("E-mail or Phone have already used");
                }
                else {
                    lblError.setText("Insert Error");
                }
            }
        }
    }

    private void tblServiceServiceKeyReleased(KeyEvent e) {
        rowVal();
    }

    private void tblServiceServiceMouseClicked(MouseEvent e) {
        rowVal();
    }
    void rowVal(){/////////////
        row = tblServiceService.getSelectedRow();
        String title = (String) tblServiceService.getValueAt(row, 2);
        String info = (String) tblServiceService.getValueAt(row, 3);
        int days = (int) tblServiceService.getValueAt(row, 4);
        String date = (String) tblServiceService.getValueAt(row, 5);
        int status = (int) tblServiceService.getValueAt(row, 6);

        txtTitle.setText(title);
        txtDetail.setText(info);
        txtDays.setText(String.valueOf(days));
        txtDate.setText(date);
        txtStatus.setText(String.valueOf(status));

    }

    private void btnServiceUpdateClick(ActionEvent e) {
        Service s = fncDataValid();
        if(row != -1 ) {
            row = tblServiceService.getSelectedRow();
            sid = Integer.valueOf(tblServiceService.getModel().getValueAt(row,scolumn).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Guncellemek istediginizden emin misniz?", "Guncelleme islemi", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                service.serviceUpdate(s,sid);
                tblServiceService.setModel(service.serviceServiceTable());
                row = -1;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Lutfen secim yapiniz.");
        }
    }

    private void btnDeleteServiceClick(ActionEvent e) {
        if(row != -1 ) {
            row = tblServiceService.getSelectedRow();
            sid = Integer.valueOf(tblServiceService.getModel().getValueAt(row,scolumn).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Silmek istediginizden emin misiniz?", "Silme islemi", JOptionPane.YES_NO_OPTION);
            if(answer==0){
                service.serviceDelete(sid);
                tblServiceService.setModel(service.serviceServiceTable());
                row = -1;
            }
        } else{
            JOptionPane.showMessageDialog(this, "Lutfen secim yapiniz.");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblName = new JLabel();
        label3 = new JLabel();
        txtCustomerSearch = new JTextField();
        scrollPane1 = new JScrollPane();
        tblServiceCustomer = new JTable();
        panel1 = new JPanel();
        label4 = new JLabel();
        txtTitle = new JTextField();
        label5 = new JLabel();
        txtDays = new JTextField();
        label6 = new JLabel();
        scrollPane2 = new JScrollPane();
        txtDetail = new JTextArea();
        lblError = new JLabel();
        scrollPane3 = new JScrollPane();
        tblServiceService = new JTable();
        btnServiceUpdate = new JButton();
        btnDeleteService = new JButton();
        btnAddService = new JButton();
        label2 = new JLabel();
        txtDate = new JTextField();
        label7 = new JLabel();
        txtStatus = new JTextField();
        label9 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- lblName ----
        lblName.setText("text");
        lblName.setForeground(Color.black);
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);

        //---- label3 ----
        label3.setText("Customer Search:");

        //---- txtCustomerSearch ----
        txtCustomerSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                txtCustomerSearchKeyReleased(e);
            }
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tblServiceCustomer);
        }

        //======== panel1 ========
        {

            //---- label4 ----
            label4.setText("Title:");

            //---- label5 ----
            label5.setText("Days:");

            //---- label6 ----
            label6.setText("Detail");

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(txtDetail);
            }

            //---- lblError ----
            lblError.setForeground(Color.red);
            lblError.setText(" ");

            //======== scrollPane3 ========
            {

                //---- tblServiceService ----
                tblServiceService.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        tblServiceServiceKeyReleased(e);
                    }
                });
                tblServiceService.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tblServiceServiceMouseClicked(e);
                    }
                });
                scrollPane3.setViewportView(tblServiceService);
            }

            //---- btnServiceUpdate ----
            btnServiceUpdate.setIcon(new ImageIcon(getClass().getResource("/update32.png")));
            btnServiceUpdate.addActionListener(e -> btnServiceUpdateClick(e));

            //---- btnDeleteService ----
            btnDeleteService.setIcon(new ImageIcon(getClass().getResource("/delete32.png")));
            btnDeleteService.addActionListener(e -> btnDeleteServiceClick(e));

            //---- btnAddService ----
            btnAddService.setIcon(new ImageIcon(getClass().getResource("/addService32.png")));
            btnAddService.addActionListener(e -> btnAddServiceClick(e));

            //---- label2 ----
            label2.setText("Date");

            //---- label7 ----
            label7.setText("Status:");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lblError, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(104, 104, 104))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollPane2))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDays, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnAddService, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStatus, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(btnServiceUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDeleteService, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                .addGap(48, 48, 48))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnServiceUpdate)
                            .addComponent(btnAddService))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(scrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addComponent(label6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDeleteService))
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                        .addGap(359, 359, 359)
                        .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
            );
        }

        //---- label9 ----
        label9.setText("TechN\u0131ke");
        label9.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        label9.setForeground(new Color(102, 0, 0));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                            .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
                    .addGap(14, 14, 14))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 137, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(lblName)
                        .addComponent(label9, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCustomerSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(435, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblName;
    private JLabel label3;
    private JTextField txtCustomerSearch;
    private JScrollPane scrollPane1;
    private JTable tblServiceCustomer;
    private JPanel panel1;
    private JLabel label4;
    private JTextField txtTitle;
    private JLabel label5;
    private JTextField txtDays;
    private JLabel label6;
    private JScrollPane scrollPane2;
    private JTextArea txtDetail;
    private JLabel lblError;
    private JScrollPane scrollPane3;
    private JTable tblServiceService;
    private JButton btnServiceUpdate;
    private JButton btnDeleteService;
    private JButton btnAddService;
    private JLabel label2;
    private JTextField txtDate;
    private JLabel label7;
    private JTextField txtStatus;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
