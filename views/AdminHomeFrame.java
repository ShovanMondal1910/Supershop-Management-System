package views;

import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import models.*;

public class AdminHomeFrame extends JFrame implements ActionListener {

    private JButton adminBtn, customerBtn, employeeBtn, productButton, profileBtn, passBtn, logOutBtn;
    private JPanel panel;
    private User u;
    private Color greenColor, redColor, blueColor, panelColor;
    private Font font;

    public AdminHomeFrame(User u) {
        super("Admin Home Frame");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        this.greenColor = new Color(0, 128, 0);
        this.redColor = new Color(255, 0, 0);
        this.blueColor = new Color(0, 0, 255);
        this.panelColor = new Color(240, 148, 141);
        this.font = new Font("Arial", Font.BOLD, 12);
        
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(panelColor);
        
        this.adminBtn = new JButton("Admin operation");
        this.adminBtn.setBounds(100, 100, 150, 30);
        this.adminBtn.setBackground(greenColor);
        this.adminBtn.setForeground(Color.WHITE);
        this.adminBtn.setFont(font);
        this.adminBtn.addActionListener(this);
        this.panel.add(adminBtn);
        
        this.customerBtn = new JButton("Customer operation");
        this.customerBtn.setBounds(270, 100, 150, 30);
        this.customerBtn.setBackground(greenColor);
        this.customerBtn.setForeground(Color.WHITE);
        this.customerBtn.setFont(font);
        this.customerBtn.addActionListener(this);
        this.panel.add(customerBtn);
        
        this.employeeBtn = new JButton("Employee operation");
        this.employeeBtn.setBounds(440, 100, 150, 30);
        this.employeeBtn.setBackground(greenColor);
        this.employeeBtn.setForeground(Color.WHITE);
        this.employeeBtn.setFont(font);
        this.employeeBtn.addActionListener(this);
        this.panel.add(employeeBtn);
        
        this.productButton = new JButton("View All Product");
        this.productButton.setBounds(610, 100, 150, 30);
        this.productButton.setBackground(greenColor);
        this.productButton.setForeground(Color.WHITE);
        this.productButton.setFont(font);
        this.productButton.addActionListener(this);
        this.panel.add(productButton);
        
        this.profileBtn = new JButton("Update Profile");
        this.profileBtn.setBounds(270, 200, 150, 30);
        this.profileBtn.setBackground(blueColor);
        this.profileBtn.setForeground(Color.WHITE);
        this.profileBtn.setFont(font);
        this.profileBtn.addActionListener(this);
        this.panel.add(profileBtn);
        
        this.passBtn = new JButton("Update Password");
        this.passBtn.setBounds(440, 200, 150, 30);
        this.passBtn.setBackground(blueColor);
        this.passBtn.setForeground(Color.WHITE);
        this.passBtn.setFont(font);
        this.passBtn.addActionListener(this);
        this.panel.add(passBtn);
        
        this.logOutBtn = new JButton("Log Out");
        this.logOutBtn.setBounds(370, 300, 100, 30);
        this.logOutBtn.setBackground(redColor);
        this.logOutBtn.setForeground(Color.WHITE);
        this.logOutBtn.setFont(font);
        this.logOutBtn.addActionListener(this);
        this.panel.add(logOutBtn);
        
        this.add(panel);
        this.u = u;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (adminBtn.getText().equals(command)) {
            AdminOperationFrame aof = new AdminOperationFrame(u);
            this.setVisible(false);
            aof.setVisible(true);
        } else if (customerBtn.getText().equals(command)) {
            ProductOperationFrame pof = new ProductOperationFrame(this.u);
            this.setVisible(false);
            pof.setVisible(true);
        } else if (profileBtn.getText().equals(command)) {
            this.setVisible(false);
            UpdateProfileFrame upf = new UpdateProfileFrame(this.u);
            upf.setVisible(true);
        } else if (passBtn.getText().equals(command)) {
            AdminUpdatePassFrame aupf = new AdminUpdatePassFrame(this.u);
            this.setVisible(false);
            aupf.setVisible(true);
        } else if (logOutBtn.getText().equals(command)) {
            LoginFrame lf = new LoginFrame();
            this.setVisible(false);
            lf.setVisible(true);
        } else if (employeeBtn.getText().equals(command)) {
            EmployeeOperationFrame eof = new EmployeeOperationFrame(this.u);
            this.setVisible(false);
            eof.setVisible(true);
        } else if (productButton.getText().equals(command)) {
            ProductHomeFrame phf = new ProductHomeFrame(this);
            this.setVisible(false);
            phf.setVisible(true);
        }
    }
}
