package views;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import models.*;
import controllers.*;

public class SignUpFrame extends JFrame implements ActionListener
{
	private JLabel name,userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, membershipLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF, membershipTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JButton addBtn, backBtn;
	
	private JPanel panel;
	
	
	public SignUpFrame()
	{
		super("Customer Registration Frame");
		this.setSize(1000,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.name=new JLabel("Customer SignUp");
		this.name.setFont(new Font("Arial",Font.BOLD,20));
		this.name.setBounds(380,50,200,50);
		this.panel.add(name);


		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setFont(new Font("Arial",Font.BOLD,16));
		this.userIdLabel.setBounds(100,120,100,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(170,120,150,30);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setFont(new Font("Arial",Font.BOLD,16));
		this.nameLabel.setBounds(100,170,100,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(170,170,150,30);
		this.panel.add(nameTF);
		
		this.emailLabel=new JLabel("Email:");
		this.emailLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.emailLabel.setBounds(100,220,60,30);
		this.panel.add(emailLabel);
		
		this.emailTF=new JTextField();
		this.emailTF.setBounds(170,220,150,30);
		this.panel.add(emailTF);
		
		this.phoneNoLabel=new JLabel("Phone Number:");
		this.phoneNoLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.phoneNoLabel.setBounds(28,270,200,30);
		this.panel.add(phoneNoLabel);
		
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(170,270,150,30);
		this.panel.add(phoneNoTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.genderLabel.setBounds(90,320,100,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setFont(new Font("Arial",Font.BOLD,15));
		this.maleRB.setBounds(170,320,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setFont(new Font("Arial",Font.BOLD,15));
		this.femaleRB.setBounds(240,320,80,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.ageLabel.setBounds(110,370,100,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(170,370,150,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.addressLabel.setBounds(80,420,100,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(170,420,150,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?");
		this.securityQuesLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.securityQuesLabel.setBounds(420,115,400,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.securityAnsLabel.setBounds(430,160,150,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(540,160,190,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.passLabel.setBounds(450,210,190,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(540,210,190,30);
		this.panel.add(passPF);
		
		this.membershipLabel=new JLabel("MembershipLabel:");
		this.membershipLabel.setFont(new Font("Arial",Font.BOLD,17));
		this.membershipLabel.setBounds(393,255,190,30);
		this.panel.add(membershipLabel);
		
		this.membershipTF=new JTextField();
		this.membershipTF.setBounds(540,255,190,30);
		this.panel.add(membershipTF);
		
		
		this.addBtn=new JButton("Submit");
		this.addBtn.setFont(new Font("Arial",Font.BOLD,17));
		this.addBtn.setBounds(410,320,190,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setFont(new Font("Arial",Font.BOLD,17));
		this.backBtn.setBounds(610,320,190,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.add(panel);

		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			if(!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() && !emailTF.getText().isEmpty() && !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !passPF.getText().isEmpty() && !securityAnsTF.getText().isEmpty() && !membershipTF.getText().isEmpty() && ((maleRB.isSelected()) || (femaleRB.isSelected())))
			{
				String userTFValue=userTF.getText();
				String nameValue=nameTF.getText();
				String genderValue="";
				if(maleRB.isSelected())
				{
					genderValue="male";
				}
				else
				{
					genderValue="female";
				}

				int ageValue=0;
				try
				{
					String inputAge=ageTF.getText();
					ageValue=Integer.parseInt(inputAge);
				}
				catch(Exception e)
				{
					e.printStackTrace();
					JOptionPane.showMessageDialog(this,"Age value should be int.");
				}
				
				String emailValue=emailTF.getText();
				String phoneNoValue=phoneNoTF.getText();
				String addressValue=addressTF.getText();
				String securityAnsValue=securityAnsTF.getText();
				String passwordValue=passPF.getText();
				int role=3;
				String membershipValue=membershipTF.getText();
				
				
				Customer c=new Customer(userTFValue,nameValue,genderValue,ageValue,emailValue,phoneNoValue,addressValue,role,securityAnsValue,passwordValue,membershipValue);
				
				UserController uc=new UserController();
				uc.insertUser(c);

				
				
				CustomerController cc=new CustomerController();
				cc.insertCustomer(c);
				
				JOptionPane.showMessageDialog(this, "Registration Success full");
				
				LoginFrame lf=new LoginFrame();
				this.setVisible(false);
				lf.setVisible(true);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please fill up all the field properly");
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
	}
}