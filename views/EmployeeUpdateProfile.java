package views;

import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class EmployeeUpdateProfile extends JFrame {

    private JLabel nameLabel, emailLabel, phoneNoLabel, ageLabel, addressLabel;
    private JTextField nameTF, emailTF, phoneNoTF, ageTF, addressTF;
    private JButton updateBtn, backBtn;
    private JPanel panel;
    private User u; 

    public EmployeeUpdateProfile(User u)
     {
        this();
        this.u = u; 
     }


    public EmployeeUpdateProfile() {

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Employee Update Profile");

        setLocationRelativeTo(null);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.nameLabel = new JLabel("Name:");
        this.nameLabel.setBounds(50, 100, 60, 30);
        this.panel.add(nameLabel);

        this.nameTF = new JTextField();
        this.nameTF.setBounds(120, 100, 200, 30);
        this.panel.add(nameTF);

        this.emailLabel = new JLabel("Email:");
        this.emailLabel.setBounds(50, 150, 60, 30);
        this.panel.add(emailLabel);

        this.emailTF = new JTextField();
        this.emailTF.setBounds(120, 150, 200, 30);
        this.panel.add(emailTF);

        this.phoneNoLabel = new JLabel("Phone No:");
        this.phoneNoLabel.setBounds(50, 200, 80, 30);
        this.panel.add(phoneNoLabel);

        this.phoneNoTF = new JTextField();
        this.phoneNoTF.setBounds(120, 200, 150, 30);
        this.panel.add(phoneNoTF);

        this.ageLabel = new JLabel("Age:");
        this.ageLabel.setBounds(50, 250, 60, 30);
        this.panel.add(ageLabel);

        this.ageTF = new JTextField();
        this.ageTF.setBounds(120, 250, 100, 30);
        this.panel.add(ageTF);

        this.addressLabel = new JLabel("Address:");
        this.addressLabel.setBounds(50, 300, 80, 30);
        this.panel.add(addressLabel);

        this.addressTF = new JTextField();
        this.addressTF.setBounds(120, 300, 200, 30);
        this.panel.add(addressTF);

      
        this.updateBtn = new JButton("Update");
        this.updateBtn.setBounds(50, 450, 120, 30);
        this.updateBtn.setBackground(new java.awt.Color(0, 128, 0)); 
        this.updateBtn.setForeground(java.awt.Color.WHITE); 
        this.panel.add(updateBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(190, 450, 100, 30);
        this.backBtn.setBackground(new java.awt.Color(0, 0, 255)); 
        this.backBtn.setForeground(java.awt.Color.WHITE); 
        this.panel.add(backBtn);

       
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (nameTF.getText().isEmpty() || emailTF.getText().isEmpty() || phoneNoTF.getText().isEmpty() ||
                    ageTF.getText().isEmpty() || addressTF.getText().isEmpty()) {
                   
                    JOptionPane.showMessageDialog(EmployeeUpdateProfile.this, 
                            "Please fill in all the fields before updating.", 
                            "Update Failed", 
                            JOptionPane.WARNING_MESSAGE);
                } else {
                 
                    JOptionPane.showMessageDialog(EmployeeUpdateProfile.this, 
                            "Employee Details Updated Successfully", 
                            "Update Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                  
                }
            }
        });

        backBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        EmployeeHomeFrame employeeHomeFrame = new EmployeeHomeFrame(u);
        employeeHomeFrame.setVisible(true);
        EmployeeUpdateProfile.this.setVisible(false);
    }
});


      
        this.add(panel);
    }
}
