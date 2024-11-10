package adapters;

// Adapter class that adapts ExternalPaymentProcessor to Payment interface
public class PaymentAdapter implements Payment {
    private ExternalPaymentProcessor externalProcessor;

    public PaymentAdapter(ExternalPaymentProcessor externalProcessor) {
        this.externalProcessor = externalProcessor;
    }

    @Override
    public void process(double amount) {
        externalProcessor.makePayment(amount);
    }
}