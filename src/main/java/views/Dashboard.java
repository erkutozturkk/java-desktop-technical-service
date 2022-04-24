/*
 * Created by JFormDesigner on Wed Apr 06 18:23:36 TRT 2022
 */

package views;

import java.awt.event.*;

import models.DashboardImpl;
import models.UserImpl;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Dashboard extends Base {
    DashboardImpl dash = new DashboardImpl();
    public Dashboard() {
        initComponents();
        lblName.setText("Hello, " + UserImpl.name);
        tblServiceDeliver.setModel(dash.serviceDeliverTable());
        tblServiceNew.setModel(dash.serviceNewTable());
    }



    private void btnAddServiceClick(ActionEvent e) {
        Services services = new Services();
        services.setVisible(true);
        System.out.println(".............");
        dispose();
    }

    private void btnArchiveClick(ActionEvent e) {
        Archive archive = new Archive();
        archive.setVisible(true);
        dispose();
    }


    private void btnCustomerAddClick(ActionEvent e) {
        CustomerAdd customer = new CustomerAdd();
        customer.setVisible(true);
        dispose();
    }

    private void btnLogOutClick(ActionEvent e) {
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblName = new JLabel();
        btnAddCustomer = new JButton();
        btnAddService = new JButton();
        btnArchive = new JButton();
        scrollPane1 = new JScrollPane();
        tblServiceDeliver = new JTable();
        scrollPane2 = new JScrollPane();
        tblServiceNew = new JTable();
        btnLogOut = new JButton();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label8 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        Container contentPane = getContentPane();

        //---- btnAddCustomer ----
        btnAddCustomer.setIcon(new ImageIcon(getClass().getResource("/UserAddIcon.png")));
        btnAddCustomer.setToolTipText("Add Customer");
        btnAddCustomer.setFocusable(false);
        btnAddCustomer.addActionListener(e -> btnCustomerAddClick(e));

        //---- btnAddService ----
        btnAddService.setIcon(new ImageIcon(getClass().getResource("/technical icon.png")));
        btnAddService.setToolTipText("Service Add");
        btnAddService.setFocusable(false);
        btnAddService.addActionListener(e -> btnAddServiceClick(e));

        //---- btnArchive ----
        btnArchive.setIcon(new ImageIcon(getClass().getResource("/archive icon.png")));
        btnArchive.setToolTipText("Archive");
        btnArchive.setFocusable(false);
        btnArchive.addActionListener(e -> btnArchiveClick(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(tblServiceDeliver);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(tblServiceNew);
        }

        //---- btnLogOut ----
        btnLogOut.setText("LogOut");
        btnLogOut.setIcon(new ImageIcon(getClass().getResource("/loginBtn icon.png")));
        btnLogOut.addActionListener(e -> btnLogOutClick(e));

        //---- textField2 ----
        textField2.setText("Completed:");
        textField2.setFont(new Font("Segoe UI", Font.BOLD, 12));
        textField2.setBackground(new Color(51, 255, 51));

        //---- textField3 ----
        textField3.setText("Waiting:");
        textField3.setFont(new Font("Segoe UI", Font.BOLD, 12));
        textField3.setBackground(new Color(204, 0, 0));

        //---- label8 ----
        label8.setText("TechN\u0131ke");
        label8.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        label8.setForeground(new Color(102, 0, 0));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                        .addComponent(scrollPane2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                            .addComponent(btnAddCustomer, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnAddService, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(162, 162, 162))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                            .addGap(352, 352, 352)
                                            .addComponent(btnArchive, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)))
                            .addComponent(btnLogOut)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblName)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddCustomer))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLogOut, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(btnAddService, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(btnArchive, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblName;
    private JButton btnAddCustomer;
    private JButton btnAddService;
    private JButton btnArchive;
    private JScrollPane scrollPane1;
    private JTable tblServiceDeliver;
    private JScrollPane scrollPane2;
    private JTable tblServiceNew;
    private JButton btnLogOut;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
