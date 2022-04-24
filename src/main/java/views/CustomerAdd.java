/*
 * Created by JFormDesigner on Thu Apr 07 15:46:52 TRT 2022
 */

package views;

import models.CustomerImpl;
import models.UserImpl;
import props.Customer;
import utils.Util;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class CustomerAdd extends Base {
    CustomerImpl cus = new CustomerImpl();
    public CustomerAdd() {

        initComponents();
        tblCustomer.setModel(cus.model());
        lblName.setText("Merhaba, " + UserImpl.name);
    }
    private Customer fncDataValid(){
        String name=txtName.getText().trim();
        String surname=txtSurname.getText().trim();
        String email=txtEmail.getText().trim().toLowerCase();  //boşluk varsa al trimle sil
        String phone=txtPhone.getText().trim();
        String address=txtAddress.getText().trim();

        if (name.equals("")){
            lblError.setText("Name is Empty!!!");
            txtName.requestFocus();
        }else if (surname.equals("")){
            lblError.setText("Surname is Empty!!!");
            txtSurname.requestFocus();
        }else if (email.equals("")){
            lblError.setText("Email is Empty!!!");
            txtEmail.requestFocus();
        }else if(!Util.isValidEmailAddress(email)){ //fprmatı başkaysa
            lblError.setText("Email Validation Error!!!");
            txtEmail.requestFocus();
        }else if (phone.equals("")){ //boşşa sıfırsa
            lblError.setText("Phone is Empty!!!");
            txtPhone.requestFocus();//imleç otomatik olarak passwworde gelicek
        }
        else if (address.equals("")){ //boşşa sıfırsa
            lblError.setText("Adress is Empty!!!");
            txtAddress.requestFocus();//imleç otomatik olarak passwworde gelicek
        }else {
            lblError.setText("");
            Customer c = new Customer(0,name,surname,email,phone,address);
            return c;
        }
        return null; //olumsuz halinde

    }

    private void thisWindowClosing(WindowEvent e) {
        new Dashboard().setVisible(true);
    }


    private void tblCustomerMouseClicked(MouseEvent e) {
        rowVal();
    }

    private void tblCustomerKeyReleased(KeyEvent e) {
        rowVal();
    }

    int row = -1;
    int cid = 0;
    int column = 0;
    void rowVal(){
        row = tblCustomer.getSelectedRow();
        String name = (String) tblCustomer.getValueAt(row, 1);
        String surname = (String) tblCustomer.getValueAt(row, 2);
        String email = (String) tblCustomer.getValueAt(row, 3);
        String phone = (String) tblCustomer.getValueAt(row, 4);
        String address = (String) tblCustomer.getValueAt(row, 5);

        txtName.setText(name);
        txtSurname.setText(surname);
        txtEmail.setText(email);
        txtPhone.setText(phone);
        txtAddress.setText(address);




    }

    private void btnDeleteClick(ActionEvent e) {
        if(row != -1 ) {
            row = tblCustomer.getSelectedRow();
            cid = Integer.valueOf(tblCustomer.getModel().getValueAt(row,column).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Silmek istediginizden emin miisniz?", "Silme islemi", JOptionPane.YES_NO_OPTION);
            if(answer==0){
                cus.customerDelete(cid);
                tblCustomer.setModel(cus.model());
                row = -1;
            }
        } else{
            JOptionPane.showMessageDialog(this, "Lutfen secim yapiniz.");
        }
    }

    private void btnCustomerUpdateClick(ActionEvent e) {
        Customer c = fncDataValid();
        if(row != -1 ) {
            row = tblCustomer.getSelectedRow();
            cid = Integer.valueOf(tblCustomer.getModel().getValueAt(row,column).toString());
            int answer = JOptionPane.showConfirmDialog(this, "Guncellemek istediginizden emin misniz?", "Guncelleme islemi", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                cus.customerUpdate(c,cid);
                tblCustomer.setModel(cus.model());
                row = -1;
            }
        }else{
            JOptionPane.showMessageDialog(this, "Lutfen secim yapiniz.");
        }
    }

    private void btnCustomerAdd(ActionEvent e) {
        Customer c = fncDataValid();
        if(c!=null){
            int status = cus.customerInsert(c);
            if (status>0){
                System.out.println("Ekleme basarili");
                txtName.setText("");
                txtSurname.setText("");
                txtEmail.setText("");
                txtPhone.setText("");
                txtAddress.setText("");
                tblCustomer.setModel(cus.model() );
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



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblName = new JLabel();
        label3 = new JLabel();
        txtName = new JTextField();
        label4 = new JLabel();
        txtPhone = new JTextField();
        labell = new JLabel();
        txtSurname = new JTextField();
        label6 = new JLabel();
        txtEmail = new JTextField();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        txtAddress = new JTextArea();
        btnCustomerAdd = new JButton();
        btnCustomerUpdate = new JButton();
        btnCustomerDelete = new JButton();
        lblError = new JLabel();
        scrollPane2 = new JScrollPane();
        tblCustomer = new JTable();
        label8 = new JLabel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //---- label3 ----
        label3.setText("NAME:");

        //---- label4 ----
        label4.setText("PHONE:");

        //---- labell ----
        labell.setText("SURNAME:");

        //---- label6 ----
        label6.setText("E-MAIL:");

        //---- label1 ----
        label1.setText("ADDRESS:");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(txtAddress);
        }

        //---- btnCustomerAdd ----
        btnCustomerAdd.setIcon(new ImageIcon(getClass().getResource("/addService32.png")));
        btnCustomerAdd.setForeground(new Color(0, 102, 255));
        btnCustomerAdd.setBorder(null);
        btnCustomerAdd.setBackground(new Color(153, 255, 204));
        btnCustomerAdd.addActionListener(e -> btnCustomerAdd(e));

        //---- btnCustomerUpdate ----
        btnCustomerUpdate.setIcon(new ImageIcon(getClass().getResource("/update32.png")));
        btnCustomerUpdate.setBackground(new Color(153, 255, 204));
        btnCustomerUpdate.addActionListener(e -> btnCustomerUpdateClick(e));

        //---- btnCustomerDelete ----
        btnCustomerDelete.setIcon(new ImageIcon(getClass().getResource("/delete32.png")));
        btnCustomerDelete.setBackground(new Color(153, 255, 204));
        btnCustomerDelete.addActionListener(e -> btnDeleteClick(e));

        //======== scrollPane2 ========
        {

            //---- tblCustomer ----
            tblCustomer.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    tblCustomerMouseClicked(e);
                }
            });
            tblCustomer.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    tblCustomerKeyReleased(e);
                }
            });
            scrollPane2.setViewportView(tblCustomer);
        }

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
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                            .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(btnCustomerAdd, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                    .addGap(114, 114, 114)
                                    .addComponent(btnCustomerUpdate, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labell, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(lblError, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 79, Short.MAX_VALUE)
                                    .addComponent(btnCustomerDelete, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(lblName, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 5, Short.MAX_VALUE)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCustomerAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCustomerUpdate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCustomerDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(txtName, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(labell)
                        .addComponent(txtSurname, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6)
                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblError))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblName;
    private JLabel label3;
    private JTextField txtName;
    private JLabel label4;
    private JTextField txtPhone;
    private JLabel labell;
    private JTextField txtSurname;
    private JLabel label6;
    private JTextField txtEmail;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea txtAddress;
    private JButton btnCustomerAdd;
    private JButton btnCustomerUpdate;
    private JButton btnCustomerDelete;
    private JLabel lblError;
    private JScrollPane scrollPane2;
    private JTable tblCustomer;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
