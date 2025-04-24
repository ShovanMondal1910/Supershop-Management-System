package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.*;
import controllers.*;

public class EmployeeUpdatePassFrame extends JFrame implements ActionListener {
    private JLabel oldPassLabel, newPassLabel, confirmPassLabel, messageLabel;
    private JPasswordField oldPassField, newPassField, confirmPassField;
    private JButton updateBtn, backBtn;
    private JPanel panel;
    private User u;

    public EmployeeUpdatePassFrame(User u) {
        super("Employee Update Password");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        this.u = u;

        panel = new JPanel();
        panel.setLayout(null);

        oldPassLabel = new JLabel("Old Password:");
        oldPassLabel.setBounds(50, 50, 150, 30);
        panel.add(oldPassLabel);

        oldPassField = new JPasswordField();
        oldPassField.setBounds(200, 50, 200, 30);
        panel.add(oldPassField);

        newPassLabel = new JLabel("New Password:");
        newPassLabel.setBounds(50, 100, 150, 30);
        panel.add(newPassLabel);

        newPassField = new JPasswordField();
        newPassField.setBounds(200, 100, 200, 30);
        panel.add(newPassField);

        confirmPassLabel = new JLabel("Confirm Password:");
        confirmPassLabel.setBounds(50, 150, 150, 30);
        panel.add(confirmPassLabel);

        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(200, 150, 200, 30);
        panel.add(confirmPassField);

        updateBtn = new JButton("Update Password");
        updateBtn.setBounds(150, 220, 150, 30);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(320, 220, 80, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 270, 400, 30);
        messageLabel.setForeground(Color.RED);
        panel.add(messageLabel);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) 
    {
        String command = ae.getActionCommand();

        if (command.equals("Update Password")) 
        {
            String oldPass = new String(oldPassField.getPassword());
            String newPass = new String(newPassField.getPassword());
            String confirmPass = new String(confirmPassField.getPassword());

            if (!u.getPassword().equals(oldPass)) 
            {
                messageLabel.setText("Old password is incorrect!");
            } else if (!newPass.equals(confirmPass)) 
            {
                messageLabel.setText("New password and confirm password do not match!");
            } else 
              {
                u.setPassword(newPass);
                UserController uc = new UserController();
                uc.updateUser(u);
                messageLabel.setForeground(Color.GREEN);
                messageLabel.setText("Password updated successfully!");
              }
        } else if (command.equals("Back")) 
            {
                EmployeeHomeFrame ehf = new EmployeeHomeFrame(u);
                this.setVisible(false);
                ehf.setVisible(true);
            }
    }
}
