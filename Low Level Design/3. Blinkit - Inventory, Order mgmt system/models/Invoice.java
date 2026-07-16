package blinit.models;

import java.util.Map;

public class Invoice {

    private int totalItemPrice;
    private int totalTax;
    private int totalFinalPrice;

    // Generate Invoice
    public void generateInvoice(Order order) {
        if (order == null || order.productCategoryAndCountMap == null) {
            System.out.println("Invalid order. Cannot generate invoice.");
            return;
        }

        totalItemPrice = 0;
        totalTax = 0;

        // Print table header
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-25s | %-10s | %-15s | %-12s | %-10s%n",
                "Product ID", "Category", "Quantity", "Price per unit", "Total Price", "Tax");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        for (Map.Entry<Integer, Integer> entry : order.productCategoryAndCountMap.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();

            ProductCategory productCategoryItem = order.warehouse.inventory.getProductCategoryFromID(productId);

            if (productCategoryItem == null) {
                System.out.println("Error: Product category not found for ID: " + productId);
                continue;
            }

            double itemPrice = productCategoryItem.price * quantity;
            int tax = (int) (itemPrice * 0.10); // Assuming 10% tax

            totalItemPrice += itemPrice;
            totalTax += tax;

            // Print formatted row
            System.out.printf("%-10d | %-25s | %-10d | %-15.2f | %-12.2f | %-10.2f%n",
                    productId, productCategoryItem.categoryName, quantity, (float) productCategoryItem.price,
                    (float) itemPrice, (float) tax);
        }

        totalFinalPrice = totalItemPrice + totalTax;

        // Print table footer
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-25s | %-10s | %-15s | %-12s | %-10s%n",
                "", "TOTAL", "", "", totalItemPrice, totalTax);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("Final Price: %.2f%n", (float) totalFinalPrice);
    }

    // Getters for private fields
    public int getTotalItemPrice() {
        return totalItemPrice;
    }

    public int getTotalTax() {
        return totalTax;
    }

    public int getTotalFinalPrice() {
        return totalFinalPrice;
    }
}