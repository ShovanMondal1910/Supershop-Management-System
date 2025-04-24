package views;
import controllers.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import models.*;

public class CartOperationFrame extends JFrame implements ActionListener 
{
    private JPanel panel;
    private JTable cartTable;
    private JScrollPane scrollPane;
    private JButton removeButton, increaseQuantityButton, decreaseQuantityButton, proceedButton, backButton;
    private JLabel totalPriceLabel;
    private CartController cartController;
    private ProductController productController;
    private Product selectedProduct; 
    private int quantity = 1; 
    private Color greenColor, redColor, panelColor,purpColor;

    public CartOperationFrame(Product selectedProduct) {
        super("Cart Operation Frame");
        this.setSize(900, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        this.greenColor = new Color(0, 128, 0);
        this.redColor = new Color(218, 177, 218);
        this.purpColor = new Color(240, 147, 147);
        this.panelColor = new Color(240, 216, 227);

        this.panel = new JPanel();
        this.panel.setLayout(null);  
        this.panel.setBackground(panelColor);



        this.selectedProduct = selectedProduct; 
        this.cartController = new CartController();
        this.productController = new ProductController();

        initializeComponents();

        this.panel.add(scrollPane);
        this.panel.add(removeButton);
        this.panel.add(increaseQuantityButton);
        this.panel.add(decreaseQuantityButton);
        this.panel.add(totalPriceLabel);
        this.panel.add(proceedButton);
        this.panel.add(backButton); 

        this.add(panel);
        loadCartData();
    }

    private void initializeComponents() 
    {
        String[] columnNames = { "Product ID", "Product Name", "Price", "Quantity", "Total Price" };
        Object[][] data = new Object[1][5]; 
        data[0][0] = selectedProduct.getProductId();
        data[0][1] = selectedProduct.getProductName();
        data[0][2] = selectedProduct.getPrice();
        data[0][3] = quantity;
        data[0][4] = selectedProduct.getPrice() * quantity; 

        this.cartTable = new JTable(data, columnNames);
        this.cartTable.setFillsViewportHeight(true);

        this.scrollPane = new JScrollPane(cartTable);
        this.scrollPane.setBounds(20, 20, 850, 400);

        this.removeButton = new JButton("Remove Product");
        this.removeButton.setBounds(20, 450, 150, 30);
        this.removeButton.addActionListener(this);
        this.removeButton.setBackground(purpColor);
        this.removeButton.setForeground(Color.WHITE);
        

        this.increaseQuantityButton = new JButton("Increase Quantity");
        this.increaseQuantityButton.setBounds(200, 450, 150, 30);
        this.increaseQuantityButton.addActionListener(this);
        this.increaseQuantityButton.setBackground(redColor);
        this.increaseQuantityButton.setForeground(Color.WHITE);

        this.decreaseQuantityButton = new JButton("Decrease Quantity");
        this.decreaseQuantityButton.setBounds(380, 450, 150, 30);
        this.decreaseQuantityButton.addActionListener(this);
        this.decreaseQuantityButton.setBackground(redColor);
        this.decreaseQuantityButton.setForeground(Color.WHITE);

        this.totalPriceLabel = new JLabel("Total Price: $" + selectedProduct.getPrice() * quantity);
        this.totalPriceLabel.setBounds(400, 500, 200, 30);

        this.proceedButton = new JButton("Proceed to Payment");
        this.proceedButton.setBounds(600, 450, 200, 30);
        this.proceedButton.addActionListener(this);
        this.proceedButton.setBackground(greenColor);
        this.proceedButton.setForeground(Color.WHITE);

        this.backButton = new JButton("Back");
        this.backButton.setBounds(20, 600, 100, 30);  
        this.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CartOperationFrame.this.setVisible(false);
                new ProductHomeFrame(new CustomerHomeFrame()).setVisible(true);
            }
        });
    }

    private void loadCartData() 
    {
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", selectedProduct.getPrice() * quantity));
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if (e.getSource() == removeButton) 
        {
          JOptionPane.showMessageDialog(this, "Product removed from cart.");
    
          CustomerHomeFrame customerHomeFrame = new CustomerHomeFrame();
          ProductHomeFrame phf = new ProductHomeFrame(customerHomeFrame);
          phf.setVisible(true);
          this.setVisible(false);
        }
          else if (e.getSource() == increaseQuantityButton) 
          {
            quantity++;
            loadCartData(); 
          } else if (e.getSource() == decreaseQuantityButton) 
            {
              if (quantity > 1) 
              {
                  quantity--;
                  loadCartData(); 
              } else 
              {
                  JOptionPane.showMessageDialog(this, "Quantity cannot be less than 1.");
              }
            } else if (e.getSource() == proceedButton) 
               { 
                 PaymentFrame omf = new PaymentFrame();
                 omf.setVisible(true);
                 this.setVisible(false);
               }
         

    }
}
   //okk     
   
  

   