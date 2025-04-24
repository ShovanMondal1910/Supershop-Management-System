package controllers;
import models.*;

public class EmployeeController {

    public void insertEmployee(Employee e) {
        Employee employee[] = this.getAllEmployee();
        
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = e;
                break;
            }
        }
        
        this.write(employee);
    }
    
    public void updateEmployee(Employee e) {
        Employee employee[] = this.getAllEmployee();
        
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                if (employee[i].getUserId().equals(e.getUserId())) {
                    employee[i] = e;
                }
            }
        }
        
        this.write(employee);
    }
    
    public void deleteEmployee(String userId) {
        Employee employee[] = this.getAllEmployee();
        
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                if (employee[i].getUserId().equals(userId)) {
                    employee[i] = null;
                }
            }
        }
        
        this.write(employee);
    }
    
    public Employee searchEmployee(String userId) {
        Employee employee[] = this.getAllEmployee();
        
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                if (employee[i].getUserId().equals(userId)) {
                    return employee[i];
                }
            }
        }
        
        return null;
    }
    
    public Employee[] getAllEmployee() {
        String fileName = "controllers/data/Employees.txt";
        FileIO fio = new FileIO();
        String values[] = fio.readFile(fileName);
        
        Employee employee[] = new Employee[100];
        
        Employee e = new Employee();
        
        for (int i = 0; i < values.length; i++) {
            if(values[i] != null && !values[i].trim().isEmpty()){
                if (employee[i] == null) {
                    employee[i] = e.formEmployee(values[i]);
                }
            }
        }
        
        return employee;
    }
    
    public void write(Employee employee[]) {
        String data[] = new String[100];
        
        for (int i = 0; i < data.length; i++) {
            if (employee[i] != null) {
                data[i] = employee[i].toStringEmployee();
            }
        }
        
        String fileName = "controllers/data/Employees.txt";
        
        FileIO fio = new FileIO();
        fio.writeFile(fileName, data);
    }
}
