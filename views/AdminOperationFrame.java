package views;

import controllers.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import models.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, adminTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox adminTypeCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private JPanel panel;
	private User u;
	private Color greenColor, redColor, panelColor;
	
	
	
	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
		this.setSize(900,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		this.greenColor = new Color(93, 66, 90);
        this.redColor = new Color(240, 147, 147);
       
        this.panelColor = new Color(240, 216, 227);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(panelColor);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,100,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(120,250,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,250,80,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(280,50,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(350,50,100,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(280,150,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,150,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,200,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		this.panel.add(passPF);
		
		this.adminTypeLabel=new JLabel("Admin Type:");
		this.adminTypeLabel.setBounds(280,250,100,30);
		this.panel.add(adminTypeLabel);
		
		String[] item={"Hr Admin", "Academic Admin"};
		this.adminTypeCMB=new JComboBox(item);
		this.adminTypeCMB.setBounds(390,250,200,30);
		this.panel.add(adminTypeCMB);
		
		this.addBtn=new JButton("Add Admin");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.addBtn.setBackground(greenColor);
		this.addBtn.setForeground(Color.WHITE);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("update Admin");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(greenColor);
		this.updateBtn.setForeground(Color.WHITE);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("remove Admin");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.removeBtn.setBackground(redColor);
		this.removeBtn.setForeground(Color.WHITE);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("search Admin");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(greenColor);
		this.searchBtn.setForeground(Color.WHITE);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.resetBtn.setBackground(redColor);
		this.removeBtn.setForeground(Color.WHITE);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(redColor);
		this.backBtn.setForeground(Color.WHITE);
		this.panel.add(backBtn);
		
		System.out.println("AdminOperationFrame");

		AdminController adc=new AdminController();
		Admin[] adminList=adc.getAllAdmin();
		
		String adminData1[][]=new String[adminList.length][8];
		for(int i=0;i<adminList.length;i++)
		{
		
			if(adminList[i]!=null)
			{
				System.out.println(adminList[i].toStringAdmin());
				adminData1[i][0]=adminList[i].getUserId();
				adminData1[i][1]=adminList[i].getName();
				adminData1[i][2]=adminList[i].getGender();
				adminData1[i][3]=String.valueOf(adminList[i].getAge());
				adminData1[i][4]=adminList[i].getEmail();
				adminData1[i][5]=adminList[i].getPhoneNo();
				adminData1[i][6]=adminList[i].getAddress();
				adminData1[i][7]=adminList[i].getAdminType();
			}
		}
		

		String head1[]={"Id","Name","Gender","Age","Email","Phone No","Adress","AdminType"};
		
		this.adminTable=new JTable(adminData1,head1);
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(50,380,700,200);
		this.adminTable.setEnabled(false);
		this.panel.add(adminTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			if(!userTF.getText().isEmpty() &&!nameTF.getText().isEmpty() &&((maleRB.isSelected()) || (femaleRB.isSelected())) && !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !passPF.getText().isEmpty())
			{
				UserController uc=new UserController();
				AdminController adc=new AdminController();
				User u=uc.searchUser(userTF.getText());
				if(u!=null)
				{
					JOptionPane.showMessageDialog(this,"User Id is already used");
				}	
				else
				{
					String userId=userTF.getText();
					String name=nameTF.getText();
					String gender="";
					if(maleRB.isSelected())
					{
						gender=maleRB.getText();
					}
					
					else
					{
						gender=femaleRB.getText();
					}
					
					int age=0;
					
					try
					{
						age=Integer.parseInt(ageTF.getText());
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String email=emailTF.getText();
					String phoneNo=phoneNoTF.getText();
					String address=addressTF.getText();
					int role=1;
					String securityAns=securityAnsTF.getText();
					String password=passPF.getText();
					String adminType=adminTypeCMB.getSelectedItem().toString();
					
					Admin a=new Admin(userId,name,gender,age,email,phoneNo,address,role,securityAns,password,adminType);
					uc.insertUser(a);
					adc.insertAdmin(a);
					JOptionPane.showMessageDialog(this,"Operation Successful");
					
					this.setVisible(false);
					AdminOperationFrame ahf=new AdminOperationFrame(u);
					ahf.setVisible(true);
				}
			}
			else
			{
			 JOptionPane.showMessageDialog(this,"Please fill up field properly");
			}
				
		}
		
		if(command.equals(updateBtn.getText()))
		{
			if (!userTF.getText().isEmpty()) {
				String userId = userTF.getText();
				AdminController adc = new AdminController();
				UserController uc = new UserController();
				Admin a = adc.searchAdmin(userId);
				if (a != null) {

					String name = nameTF.getText();
					String gender = maleRB.isSelected() ? "Male" : "Female";
					int age = 0;
		
					try {
						age = Integer.parseInt(ageTF.getText());
					} catch (Exception e) {
						e.printStackTrace();
					}
		
					String email = emailTF.getText();
					String phoneNo = phoneNoTF.getText();
					String address = addressTF.getText();
					String adminType = adminTypeCMB.getSelectedItem().toString();
		
					a.setName(name);
					a.setGender(gender);
					a.setAge(age);
					a.setEmail(email);
					a.setPhoneNo(phoneNo);
					a.setAddress(address);
					a.setAdminType(adminType);
		
					
					adc.updateAdmin(a);
					uc.updateUser(a);
		
					JOptionPane.showMessageDialog(this, "Admin updated successfully!");
		
					
					this.setVisible(false);
					AdminOperationFrame ahf = new AdminOperationFrame(u);
					ahf.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "Admin not found!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Please enter a valid User ID!");
			}
			

		}
		
		if(command.equals(removeBtn.getText()))
		{
			if (!userTF.getText().isEmpty()) {
				String userId = userTF.getText();
		
				AdminController adc = new AdminController();
				UserController uc = new UserController();
				Admin a = adc.searchAdmin(userId);
		
				if (a != null) {
					int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove Admin: " + userId + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
		
					if (confirmation == JOptionPane.YES_OPTION) {
						adc.deleteAdmin(userId);
						uc.deleteUser(userId);
		
						JOptionPane.showMessageDialog(this, "Admin removed successfully!");
		
						this.setVisible(false);
						AdminOperationFrame ahf = new AdminOperationFrame(u);
						ahf.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Admin not found!");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Please enter a valid User ID!");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			if(!userTF.getText().isEmpty())
			{
				AdminController adc=new AdminController();
				String userId=userTF.getText();
				Admin a=adc.searchAdmin(userId);
				
				if(a!=null)
				{
					userTF.setEnabled(false);
					nameTF.setText(a.getName());
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					else
					{
						femaleRB.setSelected(true);
					}
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Admin not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"please provide userId");
			}
		}
		
		if(command.equals(resetBtn.getText()))
		{
			userTF.setText("");
			nameTF.setText("");
			ageTF.setText("");
			emailTF.setText("");
			phoneNoTF.setText("");
			addressTF.setText("");
			passPF.setText("");
			securityAnsTF.setText("");
		}
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
			
		}
	}
	
}