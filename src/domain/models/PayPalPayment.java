package domain.models;

public class PayPalPayment {
    public void makePayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}
