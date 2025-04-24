package views;
import controllers.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.*;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel name,userIdLabel, passLabel;
    private JTextField userTF;
    private JPasswordField passPF;
    private JButton loginBtn, exitBtn, signUpBtn, forgetPassBtn;
    private JPanel panel;
    private Color panelColor;

    public LoginFrame() {
        super("Login Frame");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(panelColor);
        
        this.name = new JLabel("Log In ");
        this.name.setFont(new Font("Arial", Font.BOLD, 30));
        this.name.setBounds(500, 100, 500, 200);
        this.panel.add(name);
        
        this.userIdLabel = new JLabel("User Id:");
        this.userIdLabel.setFont(new Font("Arial", Font.BOLD, 19));
        this.userIdLabel.setBounds(300, 250, 150, 50);
        this.panel.add(userIdLabel);
        
        this.passLabel = new JLabel("Password:");
        this.passLabel.setFont(new Font("Arial", Font.BOLD, 19));
        this.passLabel.setBounds(300, 340, 150, 50);
        this.panel.add(passLabel);

        this.userTF = new JTextField();
        this.userTF.setBounds(420, 250, 300, 50);
        this.panel.add(userTF);
        
        this.passPF = new JPasswordField();
        this.passPF.setBounds(420,340,300,50);
        this.panel.add(passPF);
        
        this.loginBtn = new JButton("Login");
        this.loginBtn.setFont(new Font("Arial", Font.BOLD, 15));
        this.loginBtn.setBounds(300,420, 200, 50);
        this.loginBtn.addActionListener(this);
        this.panel.add(loginBtn);
        
        this.exitBtn = new JButton("Exit");
        this.exitBtn.setFont(new Font("Arial",Font.BOLD,15));
        this.exitBtn.setBounds(520,420,200,50);
        this.exitBtn.addActionListener(this);
        this.panel.add(exitBtn);
        
        this.signUpBtn = new JButton("Sign Up");
        this.signUpBtn.setFont(new Font("Arial",Font.BOLD,15));
        this.signUpBtn.setBounds(300,500, 200, 50);
        this.signUpBtn.addActionListener(this);
        this.panel.add(signUpBtn);
        
        this.forgetPassBtn = new JButton("Forget Password");
        this.forgetPassBtn.setFont(new Font("Arial",Font.BOLD,15));
        this.forgetPassBtn.setBounds(520,500,200,50);
        this.forgetPassBtn.addActionListener(this);
        this.panel.add(forgetPassBtn);
        
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        
        if (command.equals(loginBtn.getText())) {
            if (!userTF.getText().isEmpty() && !String.valueOf(passPF.getPassword()).isEmpty()) {
                String userTFValue = userTF.getText();
                String passPFValue = String.valueOf(passPF.getPassword());
                
                UserController uc = new UserController();
                User u = uc.searchUser(userTFValue);
                
                if (u != null) {
                    if (u.getPassword().equals(passPFValue)) {
                        if (u.getRole() == 1) {
                            AdminHomeFrame ahf = new AdminHomeFrame(u);
                            this.setVisible(false);
                            ahf.setVisible(true);
                        } else if (u.getRole() == 2) {
                            EmployeeHomeFrame empF = new EmployeeHomeFrame(u);
                            this.setVisible(false);
                            empF.setVisible(true);
                        } else if (u.getRole() == 3) {
                            CustomerHomeFrame chf = new CustomerHomeFrame();
                            this.setVisible(false);
                            chf.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Welcome Client");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong Password");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong UserID");
                }
            } 
            else {
                JOptionPane.showMessageDialog(this, "Please Fill up all the fields");
            }
        }
        
        if (command.equals(signUpBtn.getText())) {
            SignUpFrame suf = new SignUpFrame();
            this.setVisible(false);
            suf.setVisible(true);
        }
        
        if (command.equals(forgetPassBtn.getText())) {
            ForgetPassFrame fpf = new ForgetPassFrame();
            this.setVisible(false);
            fpf.setVisible(true);
        }
        
        if (command.equals(exitBtn.getText())) {
            System.exit(0);
        }
    }
}
