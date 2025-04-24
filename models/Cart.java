package models;

public class Cart extends Product {
    private String productId;
    private int quantity;
    private String cartId;
    private String userId;

        public Cart()
        {
          
        }
        public Cart(String productId,int quantity,String cartId,String userId)
        {
            this.productId=productId;
            this.quantity=quantity;
            this.cartId=cartId;
            this.userId=userId;
        }
        public String getProductId() 
        {
            return productId;
        }
        public void setProductId(String productId) 
        {
            this.productId = productId;
        }
        public int getQuantity() 
        {
            return quantity;
        }
        public void setQuantity(int quantity) 
        {
            this.quantity = quantity;
        }
        public String getCartId() 
        {
            return cartId;
        }
        public void setCartId(String cartId) 
        {
            this.cartId = cartId;
        }
        public String getUserId() 
        {
            return userId;
        }
        public void setUserId(String userId) 
        {
            this.userId = userId;
        }



    public String toStringCart()
    {
        String str=this.productId+","+this.quantity+","+this.cartId+","+this.userId+"\n";
        return str;
    }
    
    public Cart fromCart(String str)
     {
        String data[]=str.split(",");
        Cart cr=new Cart();
        cr.setProductId(data[0]);
        cr.setQuantity(Integer.parseInt(data[1]));
        cr.setCartId(data[2]);
        cr.setUserId(data[3]);
        
        return cr;
     }

}
