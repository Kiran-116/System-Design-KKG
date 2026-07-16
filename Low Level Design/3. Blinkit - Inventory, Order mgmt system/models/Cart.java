package blinkit.models;

import java.util.*;

public class Cart {
    Map<Integer, Integer> productCategoryIdVsCountMap;

    Cart() {
        productCategoryIdVsCountMap = new HashMap<>();
    }

    // Add Item to Cart:
    public void addItemToCart(int productCategoryId, int count) {
        if (productCategoryIdVsCountMap.containsKey(productCategoryId)) {
            int noOfItemsInCart = productCategoryIdVsCountMap.get(productCategoryId);
            productCategoryIdVsCountMap.put(productCategoryId, noOfItemsInCart + count);
        }
        else {
            productCategoryIdVsCountMap.put(productCategoryId, count);
        }
    }

    // Remove Item from Cart:
    public void removeItemFromCart(int productCategoryId, int count) {

        if (productCategoryIdVsCountMap.containsKey(productCategoryId))
        {
            int noOfItemsInCart = productCategoryIdVsCountMap.get(productCategoryId);
            if (count - noOfItemsInCart == 0) {
                productCategoryIdVsCountMap.remove(productCategoryId);
            } else {
                productCategoryIdVsCountMap.put(productCategoryId, noOfItemsInCart - count);
            }
        }
    }

    //empty my cart
    public void emptyCart(){
        productCategoryIdVsCountMap = new HashMap<>();
    }

    //View Cart
    public  Map<Integer, Integer> getCartItems(){
        return productCategoryIdVsCountMap;
    }
}
