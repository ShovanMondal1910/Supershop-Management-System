package views;

import controllers.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.*;

public class ProductOperationFrame extends JFrame implements ActionListener {

    private JLabel productIdLabel, productNameLabel, categoryLabel, brandLabel, priceLabel, availableQtyLabel, detailsLabel;
    private JTextField productIdField, productNameField, categoryField, brandField, priceField, availableQtyField, detailsField;
    private JButton addButton, updateButton, deleteButton, backButton;
    private ProductController productController;
    private User u;

    public ProductOperationFrame(User u) {
        this.u = u;
        
        setTitle("Product Operations");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        setLocationRelativeTo(null);

        productController = new ProductController(); 

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10)); 

        productIdLabel = new JLabel("Product ID:");
        productNameLabel = new JLabel("Product Name:");
        categoryLabel = new JLabel("Category:");
        brandLabel = new JLabel("Brand:");
        priceLabel = new JLabel("Price:");
        availableQtyLabel = new JLabel("Available Quantity:");
        detailsLabel = new JLabel("Details:");

        productIdField = new JTextField();
        productNameField = new JTextField();
        categoryField = new JTextField();
        brandField = new JTextField();
        priceField = new JTextField();
        availableQtyField = new JTextField();
        detailsField = new JTextField();

        addButton = new JButton("Add Product");
        addButton.addActionListener(this);
        updateButton = new JButton("Update Product");
        updateButton.addActionListener(this);
        deleteButton = new JButton("Delete Product");
        deleteButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this); 

        panel.add(productIdLabel);
        panel.add(productIdField);
        panel.add(productNameLabel);
        panel.add(productNameField);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(brandLabel);
        panel.add(brandField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(availableQtyLabel);
        panel.add(availableQtyField);
        panel.add(detailsLabel);
        panel.add(detailsField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(backButton); 

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Add Product")) {
            
            String productId = productIdField.getText().trim();
            String productName = productNameField.getText().trim();
            String category = categoryField.getText().trim();
            String brand = brandField.getText().trim();
            String priceStr = priceField.getText().trim();
            String availableQtyStr = availableQtyField.getText().trim();
            String details = detailsField.getText().trim();

            if (productId.isEmpty() || productName.isEmpty() || category.isEmpty() || brand.isEmpty() || priceStr.isEmpty() || availableQtyStr.isEmpty() || details.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                return;  
            }

            try {
                double price = Double.parseDouble(priceStr);
                int availableQty = Integer.parseInt(availableQtyStr);

                Product newProduct = new Product(productId, productName, category, brand, price, availableQty, details);

                productController.insertProduct(newProduct);

                productIdField.setText("");
                productNameField.setText("");
                categoryField.setText("");
                brandField.setText("");
                priceField.setText("");
                availableQtyField.setText("");
                detailsField.setText("");
                JOptionPane.showMessageDialog(this, "Product added successfully!");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format for price or available quantity.");
            }
        } else if (command.equals("Update Product")) {

            String productId = productIdField.getText().trim();
            Product existingProduct = productController.searchProduct(productId);

            if (existingProduct != null) {
                String productName = productNameField.getText().trim();
                String category = categoryField.getText().trim();
                String brand = brandField.getText().trim();
                String priceStr = priceField.getText().trim();
                String availableQtyStr = availableQtyField.getText().trim();
                String details = detailsField.getText().trim();
                                       
                if (productName.isEmpty() || category.isEmpty() || brand.isEmpty() || priceStr.isEmpty() || availableQtyStr.isEmpty() || details.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                    return; 
                }

                try {
                
                    double price = Double.parseDouble(priceStr);
                    int availableQty = Integer.parseInt(availableQtyStr);

                    existingProduct.setProductName(productName);
                    existingProduct.setCategory(category);
                    existingProduct.setBrand(brand);
                    existingProduct.setPrice(price);
                    existingProduct.setAvailableQuantity(availableQty);
                    existingProduct.setDetails(details);

                    productController.updateProduct(existingProduct);

                    productIdField.setText("");
                    productNameField.setText("");
                    categoryField.setText("");
                    brandField.setText("");
                    priceField.setText("");
                    availableQtyField.setText("");
                    detailsField.setText("");
                    JOptionPane.showMessageDialog(this, "Product updated successfully!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid number format for price or available quantity.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Product not found!");
            }
        } else if (command.equals("Delete Product")) {
         
            String productId = productIdField.getText().trim();
            Product existingProduct = productController.searchProduct(productId);

            if (existingProduct != null) {
                productController.delateProduct(productId);

                productIdField.setText("");
                productNameField.setText("");
                categoryField.setText("");
                brandField.setText("");
                priceField.setText("");
                availableQtyField.setText("");
                detailsField.setText("");
                JOptionPane.showMessageDialog(this, "Product deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Product not found!");
            }
        } else if (command.equals("Back")) {
            this.setVisible(false);

            if(u.getRole() == 1){
                // show admin frame
                AdminHomeFrame admFrame = new AdminHomeFrame(u);
                admFrame.setVisible(true);

            } else if(u.getRole() == 2){
                // show employe freame
                EmployeeHomeFrame empFrame = new EmployeeHomeFrame(u);
                empFrame.setVisible(true);
            }
        }
    }

   
}