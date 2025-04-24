package controllers;
import models.*;

public class ProductController {

    public void insertProduct(Product p)
	{
		Product product[]=this.getAllProduct();
		
		for(int i=0;i<product.length;i++)
		{
			if(product[i]==null)
			{
				product[i]=p;
				break;
			}
		}
		
		this.write(product);
		
		
	}

    public void updateProduct(Product p)
	{
		Product product[]=this.getAllProduct();
		
		for(int i=0;i<product.length;i++)
		{
			if(product[i]!=null)
			{
				if(product[i].getProductId().equals(p.getProductId()))
				{
					product[i]=p;
				}
			}
		}
		
		this.write(product);
	}
    
    public void delateProduct(String productId)
    {
        Product product[]=this.getAllProduct();
		
		for(int i=0;i<product.length;i++)
		{
			if(product[i]!=null)
			{
				if(product[i].getProductId().equals(productId))
				{
					product[i]=null;
				}
			}
		}
		
		this.write(product);
    }

    public Product searchProduct(String productId)
    {
        Product product[]=this.getAllProduct();

        for(int i=0;i<product.length;i++)
        {
            if(product[i]!=null)
            {
                if(product[i].getProductId().equals(productId))
                {
                    return product[i];
                }

            }
        }
        return null;
    }

    public Product[] getAllProduct() {
        String fileName = "controllers/data/Products.txt";
        FileIO fio = new FileIO();
        String values[] = fio.readFile(fileName);


        Product product[] = new Product[100];
        Product p = new Product();

        for (int i = 0; i < values.length; i++) {
            if(values[i] != null && !values[i].trim().isEmpty()) {
                if (product[i] == null) {
                    product[i] = p.formProduct(values[i]);
                }
            }
        }

        return product;
    }

    public void write(Product products[])
    {
        String data[]=new String[100];

        for(int i=0;i<data.length;i++)
        {
            if(products[i]!=null)
            {
                data[i]=products[i].toStringProduct();
            }
        }

        String fileName="controllers/data/Products.txt";

        FileIO fio=new FileIO();
        fio.writeFile(fileName,data);
    }
}
