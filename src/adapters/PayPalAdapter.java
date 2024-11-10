package adapters;

import domain.models.PayPalPayment;

// Adapter class that adapts ExternalPaymentProcessor to Payment interface
public class PayPalAdapter implements Payment {
    private PayPalPayment paypalPayment;

    public PayPalAdapter(PayPalPayment paypalPayment) {
        this.paypalPayment = paypalPayment;
    }

    @Override
    public void process(double amount) {
        paypalPayment.makePayment(amount);  // Delegating to the PayPalPayment object
    }
}
