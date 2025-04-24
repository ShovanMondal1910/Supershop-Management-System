package controllers;
import models.*;

public class CustomerController
{
    public void insertCustomer(Customer c)
    {
        Customer customers[] = this.getAllCustomer();
        
        for(int i = 0; i < customers.length; i++)
        {
            if(customers[i] == null)
            {
                customers[i] = c;
                break;
            }
        }
        
        this.write(customers);
    }
    
    public void updateCustomer(Customer c)
    {
        Customer customers[] = this.getAllCustomer();
        
        for(int i = 0; i < customers.length; i++)
        {
            if(customers[i] != null)
            {
                if(customers[i].getUserId().equals(c.getUserId()))
                {
                    customers[i] = c;
                    break;
                }
            }
        }
        
        this.write(customers);
    }
    
    public void deleteCustomer(String userId)
    {
        Customer customers[] = this.getAllCustomer();
        
        for(int i = 0; i < customers.length; i++)
        {
            if(customers[i] != null)
            {
                if(customers[i].getUserId().equals(userId))
                {
                    customers[i] = null;
                    break;
                }
            }
        }
        
        this.write(customers);
    }
    
    public Customer searchCustomer(String userId)
    {
        Customer customers[] = this.getAllCustomer();
        
        for(int i = 0; i < customers.length; i++)
        {
            if(customers[i] != null)
            {
                if(customers[i].getUserId().equals(userId))
                {
                    return customers[i];
                }
            }
        }
        
        return null;
    }
    
    public Customer[] getAllCustomer()
    {
        String fileName = "controllers/data/Customers.txt";
        FileIO fio = new FileIO();
        String values[] = fio.readFile(fileName);
        
        Customer customers[] = new Customer[100];
        
        for(int i = 0; i < values.length; i++)
        {
            if(values[i] != null && !values[i].trim().isEmpty())
            {
                if(customers[i] == null)
                {
                    Customer c = new Customer();
                    customers[i] = c.formCustomer(values[i]);
                }
            }
        }
        
        return customers;
    }
    
    public void write(Customer customers[])
    {
        String data[] = new String[100];
        
        for(int i = 0; i < customers.length; i++)
        {
            if(customers[i] != null)
            {
                data[i] = customers[i].toStringCustomer();
            }
        }
        
        String fileName = "controllers/data/Customers.txt";
        FileIO fio = new FileIO();
        fio.writeFile(fileName, data);
    }
}
