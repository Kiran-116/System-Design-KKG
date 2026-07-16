package blinkit.models;

import java.util.*;

public class ProductCategory {

    public int productCategoryId;
    public String categoryName;
    List<Product> products = new ArrayList<>();
    double price;


    public void addProduct(Product product){
        products.add(product);
    }

    //remove products
    public void removeProduct(int count){
        for(int i=1;i<=count;i++){
            products.remove(0);
        }
    }

    public int getStock(){
        return products.size();
    }
    //get products
}