package blinkit.strategy.paymentStrategy;

import blinkit.strategy.PaymentMode;

public class CardPaymentMode implements PaymentMode {

    @Override
    public boolean makePayment() {

        return true;
    }
}