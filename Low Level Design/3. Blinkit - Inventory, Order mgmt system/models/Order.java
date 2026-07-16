package blinkit.models;

import blinkit.strategy.PaymentMode;
import blinkit.strategy.paymentStrategy.UPIPaymentMode;

import java.util.Map;

public class Order {

    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productCategoryAndCountMap;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus; // Track the order status

    public Order(User user, Warehouse warehouse) {
        this.user = user;
        this.productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.deliveryAddress = user.address;
        this.orderStatus = OrderStatus.PENDING;  // Initial order status

        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout() {
        System.out.println("Order Status: " + orderStatus);

        // Step 1: Update inventory
        orderStatus = OrderStatus.PROCESSING;
        System.out.println("Order Status Updated: " + orderStatus);
        warehouse.removeItemFromInventory(productCategoryAndCountMap);

        // Step 2: Make Payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        // Step 3: Handle Success/Failure Scenarios
        if (isPaymentSuccess) {
            orderStatus = OrderStatus.COMPLETED;
            user.getUserCart().emptyCart();
            System.out.println("Payment Successful! Order Status Updated: " + orderStatus);
        } else {
            orderStatus = OrderStatus.FAILED;
            warehouse.addItemToInventory(productCategoryAndCountMap);
            System.out.println("Payment Failed! Order Status Updated: " + orderStatus);
        }
    }

    public boolean makePayment(PaymentMode paymentMode) {
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice() {
        invoice.generateInvoice(this);
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void cancelOrder() {
        if (orderStatus == OrderStatus.COMPLETED) {
            System.out.println("Cannot cancel a completed order.");
        } else {
            orderStatus = OrderStatus.CANCELED;
            System.out.println("Order has been canceled.");
        }
    }
}