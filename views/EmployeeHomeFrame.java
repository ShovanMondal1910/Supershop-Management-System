package views;

import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.awt.Color;
import models.*;

public class EmployeeHomeFrame extends JFrame implements ActionListener {

    private JButton customerBtn, employeeBtn, productButton, profileBtn, passBtn, logOutBtn;
    private JPanel panel;
    private User u;
    private Color panelColor;

    public EmployeeHomeFrame(User u) {

        super("Employee Home Frame");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        this.panelColor = new Color(240, 216, 227);

        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(panelColor);

        this.employeeBtn = new JButton("Employee operation");
        this.employeeBtn.setBounds(100, 100, 150, 30);
        this.employeeBtn.addActionListener(this);
        this.panel.add(employeeBtn);

        this.customerBtn = new JButton("Customer operation");
        this.customerBtn.setBounds(270, 100, 150, 30);
        this.customerBtn.addActionListener(this);
        this.panel.add(customerBtn);

        this.productButton = new JButton("View All Product");
        this.productButton.setBounds(440, 100, 150, 30);
        this.productButton.addActionListener(this);
        this.panel.add(productButton);

        this.profileBtn = new JButton("Update Profile");
        this.profileBtn.setBounds(100, 200, 150, 30);
        this.profileBtn.addActionListener(this);
        this.panel.add(profileBtn);

        this.passBtn = new JButton("Update Password");
        this.passBtn.setBounds(270, 200, 150, 30);
        this.passBtn.addActionListener(this);
        this.panel.add(passBtn);

        this.logOutBtn = new JButton("Log Out");
        this.logOutBtn.setBounds(370, 300, 100, 30);
        this.logOutBtn.addActionListener(this);
        this.panel.add(logOutBtn);

        this.add(panel);
        this.u = u;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (profileBtn.getText().equals(command))
         {
            this.setVisible(false);
            EmployeeUpdateProfile eup = new EmployeeUpdateProfile(this.u);
            eup.setVisible(true);
         }



    
        if (logOutBtn.getText().equals(command)) {
            LoginFrame lf = new LoginFrame();
            this.setVisible(false);
            lf.setVisible(true);
        }

        if (employeeBtn.getText().equals(command))
         {
            EmployeeOperationFrame eof = new EmployeeOperationFrame(this.u);
            this.setVisible(false);
            eof.setVisible(true);
         }

         if (passBtn.getText().equals(command)) 
         {
            EmployeeUpdatePassFrame eupf = new EmployeeUpdatePassFrame(this.u);
            this.setVisible(false);
            eupf.setVisible(true);
         }

         if (customerBtn.getText().equals(command)) 
         {
            ProductOperationFrame pof = new ProductOperationFrame(this.u);
            this.setVisible(false);
            pof.setVisible(true);
         }
         if (productButton.getText().equals(command)) 
          {
            ProductHomeFrame phf = new ProductHomeFrame(this);
            this.setVisible(false);
            phf.setVisible(true);
        }


    }
}
