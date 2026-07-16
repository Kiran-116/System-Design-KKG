package blinkit.strategy.paymentStrategy;

import blinkit.strategy.PaymentMode;

public class CODPaymentMode implements PaymentMode {

    @Override
    public boolean makePayment() {

        return true;
    }
}