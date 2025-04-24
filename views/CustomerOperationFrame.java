package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

import controllers.*;
import models.*;

public class CustomerOperationFrame extends JFrame implements ActionListener {
    
    private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, securityAnsTF;
    private JPasswordField passPF;
    private JRadioButton maleRB, femaleRB;
    private JComboBox<String> membershipTypeCMB;
    private JButton addBtn, updateBtn, deleteBtn, searchBtn, resetBtn, backBtn;
    private ButtonGroup bg;
    private User u;
    private Color panelColor;
    
    
    private JTable customerTable;
    private DefaultTableModel tableModel;

    public CustomerOperationFrame(User u) {
        this.u = u;
        setTitle("Customer Operations");
        setSize(800, 600); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout());  
         this.panelColor = new Color(240, 216, 227);
         this.panel.setBackground(panelColor);

      
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(10, 2, 10, 10)); 
        JLabel userLabel = new JLabel("User ID:");
        userTF = new JTextField(20);
        JLabel nameLabel = new JLabel("Name:");
        nameTF = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        emailTF = new JTextField(20);
        JLabel phoneNoLabel = new JLabel("Phone No:");
        phoneNoTF = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        ageTF = new JTextField(20);
        JLabel addressLabel = new JLabel("Address:");
        addressTF = new JTextField(20);
        JLabel securityAnsLabel = new JLabel("Security Answer:");
        securityAnsTF = new JTextField(20);
        JLabel passLabel = new JLabel("Password:");
        passPF = new JPasswordField(20);
        JLabel genderLabel = new JLabel("Gender:");
        maleRB = new JRadioButton("Male");
        femaleRB = new JRadioButton("Female");
        bg = new ButtonGroup();
        bg.add(maleRB);
        bg.add(femaleRB);
        JLabel membershipLabel = new JLabel("Membership Type:");
        membershipTypeCMB = new JComboBox<>(new String[] {"Regular", "Premium", "Gold"});

       
        inputPanel.add(userLabel);
        inputPanel.add(userTF);
        inputPanel.add(nameLabel);
        inputPanel.add(nameTF);
        inputPanel.add(emailLabel);
        inputPanel.add(emailTF);
        inputPanel.add(phoneNoLabel);
        inputPanel.add(phoneNoTF);
        inputPanel.add(ageLabel);
        inputPanel.add(ageTF);
        inputPanel.add(addressLabel);
        inputPanel.add(addressTF);
        inputPanel.add(securityAnsLabel);
        inputPanel.add(securityAnsTF);
        inputPanel.add(passLabel);
        inputPanel.add(passPF);
        inputPanel.add(genderLabel);
        inputPanel.add(maleRB);
        inputPanel.add(femaleRB);
        inputPanel.add(membershipLabel);
        inputPanel.add(membershipTypeCMB);

        JPanel buttonPanel = new JPanel();
        addBtn = new JButton("Add Customer");
        updateBtn = new JButton("Update Customer");
        deleteBtn = new JButton("Delete Customer");
        searchBtn = new JButton("Search Customer");
        resetBtn = new JButton("Reset");
        backBtn = new JButton("Back");

        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        backBtn.addActionListener(this);

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(resetBtn);
        buttonPanel.add(backBtn);

        String[] columnNames = {"User ID", "Name", "Email", "Phone No", "Age", "Address", "Gender", "Membership"};
        tableModel = new DefaultTableModel(columnNames, 0);
        customerTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(customerTable);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(tableScrollPane, BorderLayout.SOUTH); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals(addBtn.getText())) {
           
            String userId = userTF.getText();
            String name = nameTF.getText();
            String email = emailTF.getText();
            String phoneNo = phoneNoTF.getText();
            int age = Integer.parseInt(ageTF.getText());
            String address = addressTF.getText();
            String securityAns = securityAnsTF.getText();
            String password = new String(passPF.getPassword());
            String gender = maleRB.isSelected() ? "Male" : "Female";
            String membershipType = (String) membershipTypeCMB.getSelectedItem();

            if (!userId.isEmpty() && !name.isEmpty() && !email.isEmpty()) {
                CustomerController cc = new CustomerController();
                Customer newCustomer = new Customer(userId, name, gender, email, phoneNo, address, securityAns, password, age, membershipType);
                cc.insertCustomer(newCustomer);

                tableModel.addRow(new Object[]{userId, name, email, phoneNo, age, address, gender, membershipType});

                JOptionPane.showMessageDialog(this, "Customer added successfully!");
                resetFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields!");
            }
        }
        
        if (command.equals(updateBtn.getText())) {
          
            String userId = userTF.getText();
            if (!userId.isEmpty()) {
                CustomerController cc = new CustomerController();
                Customer existingCustomer = cc.searchCustomer(userId);

                if (existingCustomer != null) {
                    existingCustomer.setName(nameTF.getText());
                    existingCustomer.setEmail(emailTF.getText());
                    existingCustomer.setPhoneNo(phoneNoTF.getText());
                    existingCustomer.setAge(Integer.parseInt(ageTF.getText()));
                    existingCustomer.setAddress(addressTF.getText());
                    existingCustomer.setSecurityAns(securityAnsTF.getText());
                    existingCustomer.setPassword(new String(passPF.getPassword()));
                    existingCustomer.setGender(maleRB.isSelected() ? "Male" : "Female");
                    existingCustomer.setMembershipType((String) membershipTypeCMB.getSelectedItem());

                    cc.updateCustomer(existingCustomer);
                    JOptionPane.showMessageDialog(this, "Customer details updated!");

                    
                    int row = findRowByUserId(userId);
                    if (row != -1) {
                        tableModel.setValueAt(existingCustomer.getName(), row, 1);
                        tableModel.setValueAt(existingCustomer.getEmail(), row, 2);
                        tableModel.setValueAt(existingCustomer.getPhoneNo(), row, 3);
                        tableModel.setValueAt(existingCustomer.getAge(), row, 4);
                        tableModel.setValueAt(existingCustomer.getAddress(), row, 5);
                        tableModel.setValueAt(existingCustomer.getGender(), row, 6);
                        tableModel.setValueAt(existingCustomer.getMembershipType(), row, 7);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Customer not found!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a User ID!");
            }
        }

        if (command.equals(deleteBtn.getText())) {
           
            String userId = userTF.getText();
            if (!userId.isEmpty()) {
                CustomerController cc = new CustomerController();
                String result = cc.deleteCustomer(userId);  // Now returning String

                if ("Customer deleted successfully!".equals(result)) {
                    JOptionPane.showMessageDialog(this, result);
                    resetFields();

                    
                    int row = findRowByUserId(userId);
                    if (row != -1) {
                        tableModel.removeRow(row);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, result);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a User ID!");
            }
        }
        
        if (command.equals(searchBtn.getText())) {
           
            String userId = userTF.getText();
            if (!userId.isEmpty()) {
                CustomerController cc = new CustomerController();
                Customer customer = cc.searchCustomer(userId);

                if (customer != null) {
                    nameTF.setText(customer.getName());
                    emailTF.setText(customer.getEmail());
                    phoneNoTF.setText(customer.getPhoneNo());
                    ageTF.setText(String.valueOf(customer.getAge()));
                    addressTF.setText(customer.getAddress());
                    securityAnsTF.setText(customer.getSecurityAns());
                    passPF.setText(customer.getPassword());
                    maleRB.setSelected("Male".equals(customer.getGender()));
                    femaleRB.setSelected("Female".equals(customer.getGender()));
                    membershipTypeCMB.setSelectedItem(customer.getMembershipType());

                    JOptionPane.showMessageDialog(this, "Customer found!");
                } else {
                    JOptionPane.showMessageDialog(this, "Customer not found!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a User ID to search!");
            }
        }
        
        if (command.equals(resetBtn.getText())) {
            resetFields();
        }
        
        if (command.equals(backBtn.getText())) {
           
            this.setVisible(false);
            AdminHomeFrame ahf = new AdminHomeFrame(u);
            ahf.setVisible(true);
        }
    }
    
    private void resetFields() {
        userTF.setText("");
        nameTF.setText("");
        emailTF.setText("");
        phoneNoTF.setText("");
        ageTF.setText("");
        addressTF.setText("");
        securityAnsTF.setText("");
        passPF.setText("");
        bg.clearSelection();
        membershipTypeCMB.setSelectedIndex(0);
    }

    private int findRowByUserId(String userId) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(userId)) {
                return i;
            }
        }
        return -1;
    }
}

