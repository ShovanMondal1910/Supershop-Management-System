package views;

import controllers.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import models.*;

public class UpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel,adminTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF, adminTypeTF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	private Admin admin;
	private Color greenColor, redColor, panelColor;
	
	
	
	public UpdateProfileFrame(User u)
	{
		super("Admin update profile Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		this.greenColor = new Color(93, 66, 90);
        this.redColor = new Color(240, 147, 147);
       
        this.panelColor = new Color(240, 216, 227);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(panelColor);
		
		AdminController adc=new AdminController();
		this.admin=adc.searchAdmin(u.getUserId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(admin.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(admin.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,150,30);
		this.emailTF.setText(admin.getEmail());
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.phoneNoTF.setText(admin.getPhoneNo());
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		this.panel.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(120,250,100,30);
		this.genderTF.setText(admin.getGender());
		this.genderTF.setEditable(false);
		this.panel.add(genderTF);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.ageTF.setText(String.valueOf(admin.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(120,350,100,30);
		this.addressTF.setText(admin.getAddress());
		this.panel.add(addressTF);
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(50,400,100,30);
		this.panel.add(adminTypeLabel);
		
		this.adminTypeTF=new JTextField();
		this.adminTypeTF.setBounds(160,400,100,30);
		this.adminTypeTF.setText(admin.getAdminType());
		this.adminTypeTF.setEditable(false);
		this.panel.add(adminTypeTF);
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,450,120,30);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(greenColor);
		this.updateBtn.setForeground(Color.WHITE);
		this.panel.add(updateBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,450,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(redColor);
		this.backBtn.setForeground(Color.WHITE);
		this.panel.add(backBtn);
		
		this.add(panel);
		
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(updateBtn.getText()))
		{
			if((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				admin.setEmail(emailTF.getText());
				admin.setPhoneNo(phoneNoTF.getText());
				admin.setAddress(addressTF.getText());
				AdminController addc=new AdminController();
				addc.updateAdmin(admin);
				JOptionPane.showMessageDialog(this,"admin updated Successfully");
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}