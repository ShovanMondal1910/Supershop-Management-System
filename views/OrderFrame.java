/*package views;

import javax.swing.*;
import java.awt.event.*;
import models.*;

public class OrderFrame extends JFrame {
    private JTextField fullNameField, addressField, phoneNumberField, emailField;
    private JButton backButton, confirmOrderButton;
    private Product selectedProduct;
    private int quantity;  // Quantity of the selected product from CartOperationFrame

    // Constructor to receive selectedProduct and quantity
    public OrderFrame(Product selectedProduct, int quantity) {
        this.selectedProduct = selectedProduct;
        this.quantity = quantity;

        setTitle("Order Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setLocationRelativeTo(null);
        
        fullNameField = new JTextField();
        addressField = new JTextField();
        phoneNumberField = new JTextField();
        emailField = new JTextField();

        JLabel fullNameLabel = new JLabel("Full Name:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JLabel emailLabel = new JLabel("Email:");

        backButton = new JButton("Back");
        confirmOrderButton = new JButton("Confirm Order");

        fullNameLabel.setBounds(30, 30, 100, 25);
        fullNameField.setBounds(150, 30, 200, 25);
        addressLabel.setBounds(30, 70, 100, 25);
        addressField.setBounds(150, 70, 200, 25);
        phoneNumberLabel.setBounds(30, 110, 100, 25);
        phoneNumberField.setBounds(150, 110, 200, 25);
        emailLabel.setBounds(30, 150, 100, 25);
        emailField.setBounds(150, 150, 200, 25);

        backButton.setBounds(50, 200, 90, 30);
        confirmOrderButton.setBounds(180, 200, 150, 30);

        add(fullNameLabel);
        add(fullNameField);
        add(addressLabel);
        add(addressField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(emailLabel);
        add(emailField);
        add(backButton);
        add(confirmOrderButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Go back to CartOperationFrame with the selected product and quantity
                CartOperationFrame cartFrame = new CartOperationFrame(selectedProduct);
                cartFrame.setVisible(true);
                setVisible(false);
            }
        });

        confirmOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get customer details from the text fields
                String fullName = fullNameField.getText();
                String address = addressField.getText();
                String phoneNumber = phoneNumberField.getText();
                String email = emailField.getText();

                // Create a new order object with the details
                Order newOrder = new Order(1, selectedProduct, quantity, fullName, address, phoneNumber, email);

                // Show the order summary
                JOptionPane.showMessageDialog(OrderFrame.this, newOrder.getOrderSummary(), 
                        "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

                // After confirming, go back to the home screen or perform the next action
                // Here, you can navigate to a confirmation page or home page.
                // For now, I'll just reset the frame for simplicity.
                CartOperationFrame cartFrame = new CartOperationFrame(selectedProduct);
                cartFrame.setVisible(true);
                setVisible(false);
            }
        });

        setVisible(true);
    }

    
}
*/