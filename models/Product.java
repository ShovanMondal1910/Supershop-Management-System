package models;

public class Product 
{
    private String productId;
    private String productName;
    private String category;
    private String brand;
    private double price;
    private int availableQuantity;
    private String details;

    public Product()
    {

    }

    public Product(String productId, String productName, String category, String brand, double price, int availableQuantity, String details) 
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.details = details;
    }


    public String getProductId()
     {
         return productId;
     }
    public void setProductId(String productId)
    {
         this.productId = productId;
    }

    public String getProductName() 
    {
         return productName;
    }
    public void setProductName(String productName) 
    {
         this.productName = productName; 
    }

    public String getCategory() 
    {
         return category; 
    }
    public void setCategory(String category) 
    {
         this.category = category; 
    }

    public String getBrand() 
    {
         return brand; 
    }
    public void setBrand(String brand) 
    {
         this.brand = brand; 
    }

    public double getPrice() 
    {
         return price; 
    }
    public void setPrice(double price) 
    {
         this.price = price; 
    }

    public int getAvailableQuantity() 
    {
         return availableQuantity; 
    }
    public void setAvailableQuantity(int availableQuantity) 
    {
         this.availableQuantity = availableQuantity; 
    }

    public String getDetails() 
    {
         return details; 
    }
    public void setDetails(String details) 
    {
         this.details = details;
    }

    public String toStringProduct() {
        return productId + "," + productName + "," + category + "," + brand + "," + price + "," + availableQuantity + "," + details;
    }

    
    public Product formProduct(String productData) 
    {
        if (productData == null || productData.trim().isEmpty()) 
         {
             return null; 
         }

        String[] parts = productData.split(",", -1);  

        if (parts.length < 6) 
        {
            return null;
        }
    
        try 
        {
            String productId = parts[0].trim();
            String productName = parts[1].trim();
            String category = parts[2].trim();
            String brand = parts[3].trim();
            double price = Double.parseDouble(parts[4].trim());
            int availableQuantity = Integer.parseInt(parts[5].trim());
            String details = parts.length > 6 ? parts[6].trim() : "N/A";
    
            return new Product(productId, productName, category, brand, price, availableQuantity, details);
        } catch (Exception e) 
           {
            return null;
           }
    }

}
