package views;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import models.*;
import controllers.*;

public class EmployeeOperationFrame extends JFrame implements ActionListener {
private JLabel userIdLabel, nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel, designationLabel, salaryLabel, securityAnsLabel, passwordLabel;
private JTextField userTF, nameTF, emailTF, phoneNoTF, ageTF, addressTF, designationTF, salaryTF, securityAnsTF;
private JPasswordField passwordTF;
private JRadioButton maleRB, femaleRB;
private ButtonGroup bg;
private JButton addBtn, removeBtn, updateBtn, resetBtn, searchBtn, backBtn;
private JTable employeeTable;
private JScrollPane employeeTableSP;
private JPanel panel;
private User u;


    public EmployeeOperationFrame(User u) {
    super("Employee Operation Frame");
    this.setSize(900, 700);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLocationRelativeTo(null);
    

    this.panel = new JPanel();
    this.panel.setLayout(null);

    this.userIdLabel = new JLabel("User ID:");
    this.userIdLabel.setBounds(50, 50, 80, 30);
    this.panel.add(userIdLabel);

    this.userTF = new JTextField();
    this.userTF.setBounds(140, 50, 150, 30);
    this.panel.add(userTF);

    this.nameLabel = new JLabel("Name:");
    this.nameLabel.setBounds(50, 100, 80, 30);
    this.panel.add(nameLabel);

    this.nameTF = new JTextField();
    this.nameTF.setBounds(140, 100, 150, 30);
    this.panel.add(nameTF);

    this.emailLabel = new JLabel("Email:");
    this.emailLabel.setBounds(50, 150, 80, 30);
    this.panel.add(emailLabel);

    this.emailTF = new JTextField();
    this.emailTF.setBounds(140, 150, 150, 30);
    this.panel.add(emailTF);

    this.phoneNoLabel = new JLabel("Phone No:");
    this.phoneNoLabel.setBounds(50, 200, 80, 30);
    this.panel.add(phoneNoLabel);

    this.phoneNoTF = new JTextField();
    this.phoneNoTF.setBounds(140, 200, 150, 30);
    this.panel.add(phoneNoTF);

    this.genderLabel = new JLabel("Gender:");
    this.genderLabel.setBounds(50, 250, 80, 30);
    this.panel.add(genderLabel);

    this.maleRB = new JRadioButton("Male");
    this.maleRB.setBounds(140, 250, 70, 30);
    this.panel.add(maleRB);

    this.femaleRB = new JRadioButton("Female");
    this.femaleRB.setBounds(210, 250, 80, 30);
    this.panel.add(femaleRB);

    this.bg = new ButtonGroup();
    this.bg.add(maleRB);
    this.bg.add(femaleRB);

    this.ageLabel = new JLabel("Age:");
    this.ageLabel.setBounds(50, 300, 80, 30);
    this.panel.add(ageLabel);

    this.ageTF = new JTextField();
    this.ageTF.setBounds(140, 300, 150, 30);
    this.panel.add(ageTF);

    this.addressLabel = new JLabel("Address:");
    this.addressLabel.setBounds(50, 350, 80, 30);
    this.panel.add(addressLabel);

    this.addressTF = new JTextField();
    this.addressTF.setBounds(140, 350, 150, 30);
    this.panel.add(addressTF);

    this.designationLabel = new JLabel("Designation:");
    this.designationLabel.setBounds(50, 400, 80, 30);
    this.panel.add(designationLabel);

    this.designationTF = new JTextField();
    this.designationTF.setBounds(140, 400, 150, 30);
    this.panel.add(designationTF);

    this.salaryLabel = new JLabel("Salary:");
    this.salaryLabel.setBounds(50, 450, 80, 30);
    this.panel.add(salaryLabel);

    this.salaryTF = new JTextField();
    this.salaryTF.setBounds(140, 450, 150, 30);
    this.panel.add(salaryTF);

    this.securityAnsLabel = new JLabel("Security Answer:");
    this.securityAnsLabel.setBounds(320, 400, 100, 30);
    this.panel.add(securityAnsLabel);

    this.securityAnsTF = new JTextField();
    this.securityAnsTF.setBounds(430, 400, 150, 30);
    this.panel.add(securityAnsTF);

    this.passwordLabel = new JLabel("Password:");
    this.passwordLabel.setBounds(320, 450, 100, 30);
    this.panel.add(passwordLabel);

    this.passwordTF = new JPasswordField();
    this.passwordTF.setBounds(430, 450, 150, 30);
    this.panel.add(passwordTF);

    this.addBtn = new JButton("Add Employee");
    this.addBtn.setBounds(320, 50, 150, 30);
    this.addBtn.addActionListener(this);
    this.panel.add(addBtn);

    this.updateBtn = new JButton("Update Employee");
    this.updateBtn.setBounds(320, 100, 150, 30);
    this.updateBtn.addActionListener(this);
    this.panel.add(updateBtn);

    this.removeBtn = new JButton("Remove Employee");
    this.removeBtn.setBounds(320, 150, 150, 30);
    this.removeBtn.addActionListener(this);
    this.panel.add(removeBtn);

    this.searchBtn = new JButton("Search Employee");
    this.searchBtn.setBounds(320, 200, 150, 30);
    this.searchBtn.addActionListener(this);
    this.panel.add(searchBtn);

    this.resetBtn = new JButton("Reset");
    this.resetBtn.setBounds(320, 250, 150, 30);
    this.resetBtn.addActionListener(this);
    this.panel.add(resetBtn);

    this.backBtn = new JButton("Back");
    this.backBtn.setBounds(320, 300, 150, 30);
    this.backBtn.addActionListener(this);
    this.panel.add(backBtn);
    EmployeeController ec = new EmployeeController();
    Employee[] employeeList = ec.getAllEmployee();

    String employeeData[][] = new String[employeeList.length][8];
    for (int i = 0; i < employeeList.length; i++) {
        if (employeeList[i] != null) {
            employeeData[i][0] = employeeList[i].getUserId();
            employeeData[i][1] = employeeList[i].getName();
            employeeData[i][2] = employeeList[i].getGender();
            employeeData[i][3] = String.valueOf(employeeList[i].getAge());
            employeeData[i][4] = employeeList[i].getEmail();
            employeeData[i][5] = employeeList[i].getPhoneNo();
            employeeData[i][6] = employeeList[i].getAddress();
            employeeData[i][7] = employeeList[i].getDesignation();
        }
    }

    String head[] = { "ID", "Name", "Gender", "Age", "Email", "Phone No", "Address", "Designation" };

    this.employeeTable = new JTable(employeeData, head);
    this.employeeTableSP = new JScrollPane(employeeTable);
    this.employeeTableSP.setBounds(50, 500, 800, 150);
    this.panel.add(employeeTableSP);

    this.add(panel);
    this.u = u;



}







public void actionPerformed(ActionEvent ae) {
    String command = ae.getActionCommand();

    EmployeeController ec = new EmployeeController();
    UserController uc = new UserController();

    if (command.equals(addBtn.getText())) {
        if (!userTF.getText().isEmpty() && !nameTF.getText().isEmpty() &&
            (maleRB.isSelected() || femaleRB.isSelected()) &&
            !ageTF.getText().isEmpty() && !emailTF.getText().isEmpty() &&
            !phoneNoTF.getText().isEmpty() && !addressTF.getText().isEmpty() &&
            !salaryTF.getText().isEmpty()) {

            String userId = userTF.getText();
            if (uc.searchUser(userId) != null || ec.searchEmployee(userId) != null) {
                JOptionPane.showMessageDialog(this, "User ID is already in use!");
            } else {
                String name = nameTF.getText();
                String gender = maleRB.isSelected() ? "Male" : "Female";
                int age, salary;

                try {
                    age = Integer.parseInt(ageTF.getText());
                    salary = Integer.parseInt(salaryTF.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid Age or Salary format!");
                    return;
                }

                String email = emailTF.getText();
                String phoneNo = phoneNoTF.getText();
                String address = addressTF.getText();

                Employee e = new Employee(userId, name, gender, age, email, phoneNo, address, salary, "unknown", "unkown", "unknown", salary);
                ec.insertEmployee(e);

                User u = new User(userId, 2, "defaultPass", "Employee"); 
                uc.insertUser(u);

                JOptionPane.showMessageDialog(this, "Employee added successfully!");
                this.setVisible(false);
                new EmployeeOperationFrame(u).setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields correctly!");
        }
    } 
    else if (command.equals(updateBtn.getText())) {
        if (!userTF.getText().isEmpty()) {
            String userId = userTF.getText();
            Employee e = ec.searchEmployee(userId);

            if (e != null) {
                String name = nameTF.getText();
                String gender = maleRB.isSelected() ? "Male" : "Female";
                int age, salary;

                try {
                    age = Integer.parseInt(ageTF.getText());
                    salary = Integer.parseInt(salaryTF.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid Age or Salary format!");
                    return;
                }

                String email = emailTF.getText();
                String phoneNo = phoneNoTF.getText();
                String address = addressTF.getText();

                e.setName(name);
                e.setGender(gender);
                e.setAge(age);
                e.setEmail(email);
                e.setPhoneNo(phoneNo);
                e.setAddress(address);
                e.setSalary(salary);

                ec.updateEmployee(e);
                JOptionPane.showMessageDialog(this, "Employee updated successfully!");

                this.setVisible(false);
                new EmployeeOperationFrame(u).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid User ID!");
        }
    } 
    else if (command.equals(removeBtn.getText())) {
        if (!userTF.getText().isEmpty()) {
            String userId = userTF.getText();
            Employee e = ec.searchEmployee(userId);

            if (e != null) {
                ec.deleteEmployee(userId);
                uc.deleteUser(userId);

                JOptionPane.showMessageDialog(this, "Employee removed successfully!");
                this.setVisible(false);
                new EmployeeOperationFrame(u).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid User ID!");
        }
    } 
    else if (command.equals(searchBtn.getText())) {
        if (!userTF.getText().isEmpty()) {
            String userId = userTF.getText();
            Employee e = ec.searchEmployee(userId);

            if (e != null) {
                nameTF.setText(e.getName());
                emailTF.setText(e.getEmail());
                phoneNoTF.setText(e.getPhoneNo());
                addressTF.setText(e.getAddress());
                salaryTF.setText(String.valueOf(e.getSalary()));

                if (e.getGender().equals("Male")) {
                    maleRB.setSelected(true);
                } else {
                    femaleRB.setSelected(true);
                }

                ageTF.setText(String.valueOf(e.getAge()));
                JOptionPane.showMessageDialog(this, "Employee found!");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid User ID!");
        }
    } 
    else if (command.equals(resetBtn.getText())) {
        userTF.setText("");
        nameTF.setText("");
        ageTF.setText("");
        emailTF.setText("");
        phoneNoTF.setText("");
        addressTF.setText("");
        salaryTF.setText("");
        maleRB.setSelected(false);
        femaleRB.setSelected(false);
    } 
  else if (command.equals(backBtn.getText())) {
    this.setVisible(false);
    new EmployeeHomeFrame(u).setVisible(true); 
}

}


}
