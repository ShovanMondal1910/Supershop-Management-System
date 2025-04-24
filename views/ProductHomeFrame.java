package views;

import controllers.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import models.*;

public class ProductHomeFrame extends JFrame {
    private JPanel panel;
    private JButton buyButton, backButton;
    private JTable productTable;
    private JScrollPane scrollPane;
    private ProductController productController;
    private JFrame parentFrame; 
    private Color panelColor;

    public ProductHomeFrame(JFrame parentFrame) { 
        super("Product Home Frame");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        
        this.panelColor = new Color(240, 216, 227);
        this.panel = new JPanel();
        this.panel.setLayout(null);
         this.panel.setBackground(panelColor);

        this.parentFrame = parentFrame;
        this.productController = new ProductController();

        Product[] products = productController.getAllProduct();
        String[] columnNames = { "Product ID", "Product Name", "Category", "Brand", "Price", "Available Quantity", "Details" };
        Object[][] data = new Object[products.length][7];
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                data[i][0] = products[i].getProductId();
                data[i][1] = products[i].getProductName();
                data[i][2] = products[i].getCategory();
                data[i][3] = products[i].getBrand();
                data[i][4] = products[i].getPrice();
                data[i][5] = products[i].getAvailableQuantity();
                data[i][6] = products[i].getDetails();
            }
        }

        this.productTable = new JTable(data, columnNames);
        this.productTable.setFillsViewportHeight(true);

        this.scrollPane = new JScrollPane(productTable);
        this.scrollPane.setBounds(20, 20, 850, 500);
        this.panel.add(scrollPane);

        this.buyButton = new JButton("Next");
        this.buyButton.setBounds(350, 550, 200, 50);
        this.buyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = productTable.getSelectedRow();
                if (row != -1) {
                    String productId = (String) productTable.getValueAt(row, 0);
                    Product selectedProduct = productController.searchProduct(productId);

                    CartOperationFrame cof = new CartOperationFrame(selectedProduct);
                    cof.setVisible(true);
                    setVisible(false); 
                } else {
                    JOptionPane.showMessageDialog(panel, "Please select a product to proceed.");
                }
            }           
        });
        this.panel.add(buyButton);

        this.backButton = new JButton("Back");
        this.backButton.setBounds(20, 550, 100, 50);
        this.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductHomeFrame.this.setVisible(false);
                parentFrame.setVisible(true); 
            }
        });
        this.panel.add(backButton);

        this.add(panel);
    }
}
