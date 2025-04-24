package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.*;

public class CustomerHomeFrame extends JFrame implements ActionListener {
    private JButton viewProductBtn, updatePasswordBtn, updateProfileBtn, exitBtn;
    private JPanel panel;
    private User u;
    private Color panelColor;

    public CustomerHomeFrame() {
        super("Customer Home Frame");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.u = u;

        setLocationRelativeTo(null);

        this.panelColor = new Color(240, 216, 227);

        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(panelColor);

      
        this.viewProductBtn = new JButton("View Product");
        this.viewProductBtn.setBounds(325, 80, 250, 80); 
        this.viewProductBtn.setBackground(new java.awt.Color(0, 255, 0)); 
        this.viewProductBtn.setForeground(new java.awt.Color(255, 255, 255)); 
        this.viewProductBtn.addActionListener(this);
        Font buttonFont = new Font("Arial", Font.PLAIN, 30); 
        this.viewProductBtn.setFont(buttonFont);
        this.panel.add(viewProductBtn);

      
        this.updatePasswordBtn = new JButton("Update Password");
        this.updatePasswordBtn.setBounds(350, 200, 200, 50);
        this.updatePasswordBtn.addActionListener(this);
        this.panel.add(updatePasswordBtn);

        this.updateProfileBtn = new JButton("Update Profile");
        this.updateProfileBtn.setBounds(350, 300, 200, 50);
        this.updateProfileBtn.addActionListener(this);
        this.panel.add(updateProfileBtn);

       
        this.exitBtn = new JButton("Exit");
        this.exitBtn.setBounds(400, 400, 100, 50);
        this.exitBtn.setBackground(new java.awt.Color(255, 0, 0)); // Red
        this.exitBtn.setForeground(new java.awt.Color(255, 255, 255)); // White
        this.exitBtn.addActionListener(this);
        this.panel.add(exitBtn);

        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewProductBtn) {
            ProductHomeFrame productHomeFrame = new ProductHomeFrame(this);
            this.setVisible(false); 
            productHomeFrame.setVisible(true);
        } else if (e.getSource() == updatePasswordBtn) {
            CustomerUpdatePassFrame cupf = new CustomerUpdatePassFrame(this.u);
            this.setVisible(false);
            cupf.setVisible(true);
        } else if (e.getSource() == updateProfileBtn) {
            CustomerUpdateProfile customerUpdateProfile = new CustomerUpdateProfile();
            this.setVisible(false);  
            customerUpdateProfile.setVisible(true);
        } else if (e.getSource() == exitBtn) {
            LoginFrame lf = new LoginFrame(); 
            this.setVisible(false);
            lf.setVisible(true);
        }
    }
}

//okk    new add krsi user