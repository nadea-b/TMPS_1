package adapters;

// External payment gateway (unmodifiable)
public class ExternalPaymentProcessor {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " with external processor.");
    }
}