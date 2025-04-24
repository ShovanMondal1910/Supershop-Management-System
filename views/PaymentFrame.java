package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import controllers.*;

public class PaymentFrame extends JFrame{

    private static JFrame frame;
    private static JPanel panel;
    private static JComboBox<String> paymentMethodCombo;
    private static JTextField cardNumberField, amountField;
    private static JPasswordField passwordField;
    private static JButton payButton;
    private static JLabel logoLabel;

    public PaymentFrame() {
        frame = new JFrame("Payment Gateway");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        frame.setSize(600, 800);
        frame.setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 30));
        panel.setBounds(0, 0, 420, 500);
        frame.add(panel);

        JLabel titleLabel = new JLabel("Secure Payment");
        titleLabel.setBounds(140, 10, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        logoLabel = new JLabel();
        logoLabel.setBounds(140, 50, 150, 60);
        panel.add(logoLabel);

        JLabel methodLabel = new JLabel("Select Payment Method:");
        methodLabel.setBounds(30, 120, 200, 25);
        methodLabel.setForeground(Color.WHITE);
        panel.add(methodLabel);

        String[] paymentMethods = {"Visa Card", "bKash", "Nagad"};
        paymentMethodCombo = new JComboBox<>(paymentMethods);
        paymentMethodCombo.setBounds(180, 120, 180, 30);
        paymentMethodCombo.setBackground(Color.LIGHT_GRAY);
        panel.add(paymentMethodCombo);

        JLabel numberLabel = new JLabel("Card/Mobile Number:");
        numberLabel.setBounds(30, 200, 150, 25);
        numberLabel.setForeground(Color.WHITE);
        panel.add(numberLabel);

        cardNumberField = new JTextField();
        cardNumberField.setBounds(180, 200, 180, 30);
        panel.add(cardNumberField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 240, 120, 25);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(180, 240, 180, 30);
        panel.add(passwordField);

        payButton = new JButton("Pay Now");
        payButton.setBounds(140, 300, 120, 40);
        payButton.setFont(new Font("Arial", Font.BOLD, 14));
        payButton.setBackground(new Color(0, 153, 76));
        payButton.setForeground(Color.WHITE);
        payButton.setBorderPainted(false);
        payButton.setFocusPainted(false);
        payButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(payButton);

        paymentMethodCombo.addActionListener(e -> updatePaymentFields());
        payButton.addActionListener(e -> processPayment());

        updateLogo("Visa Card");
        updatePaymentFields();
        frame.setVisible(true);
    }

    private static void updatePaymentFields() {
        String selectedMethod = (String) paymentMethodCombo.getSelectedItem();
        updateLogo(selectedMethod);

        cardNumberField.setText("");
        passwordField.setText("");

        switch (selectedMethod) {
            case "Visa Card":
                cardNumberField.setToolTipText("Enter 15-digit Visa Card Number");
                passwordField.setToolTipText("Enter 4-digit Password");
                break;
            case "bKash":
                cardNumberField.setToolTipText("Enter 11-digit Mobile Number");
                passwordField.setToolTipText("Enter 5-digit Password");
                break;
            case "Nagad":
                cardNumberField.setToolTipText("Enter 11-digit Mobile Number");
                passwordField.setToolTipText("Enter 4-digit Password");
                break;
        }

        panel.repaint();
    }

    private static void updateLogo(String method) {
        String imagePath = "";
        switch (method) {
            case "Visa Card":
                imagePath = "visa.png";
                break;
            case "bKash":
                imagePath = "bkash.png";
                break;
            case "Nagad":
                imagePath = "nagad.png";
                break;
        }

        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(150, 60, Image.SCALE_SMOOTH);
        logoLabel.setIcon(new ImageIcon(scaledImage));
    }

    private static void processPayment() {
        String selectedMethod = (String) paymentMethodCombo.getSelectedItem();
        String password = new String(passwordField.getPassword());
        String cardNumber = cardNumberField.getText().trim();
        boolean validPassword = false;
        boolean validCardNumber = false;

        switch (selectedMethod) {
            case "Visa Card":
                validPassword = password.length() == 4;
                validCardNumber = cardNumber.length() == 15;
                break;
            case "bKash":
                validPassword = password.length() == 5;
                validCardNumber = cardNumber.length() == 11;
                break;
            case "Nagad":
                validPassword = password.length() == 4;
                validCardNumber = cardNumber.length() == 11;
                break;
        }

        if (!validPassword) {
            JOptionPane.showMessageDialog(frame, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validCardNumber) {
            String errorMessage = "";
            switch (selectedMethod) {
                case "Visa Card":
                    errorMessage = "Visa card number must be 15 digits!";
                    break;
                case "bKash":
                case "Nagad":
                    errorMessage = "Mobile number must be 11 digits!";
                    break;
            }
            JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        frame.dispose();
        JFrame successFrame = new JFrame("Payment Successful");
        successFrame.setSize(300, 200);
        successFrame.setLayout(null);
        successFrame.getContentPane().setBackground(new Color(30, 30, 30));

        JLabel successLabel = new JLabel("Payment Successful!");
        successLabel.setBounds(80, 30, 200, 30);
        successLabel.setForeground(Color.GREEN);
        successFrame.add(successLabel);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 100, 200, 40);
        backButton.addActionListener(e -> {
            successFrame.dispose();
            new PaymentFrame(); 
        });
        successFrame.add(backButton);
        successFrame.setVisible(true);
    }
}
// ok