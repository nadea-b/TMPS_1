package adapters;

public class CreditCardPayment implements Payment {
    public void process(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
    }
}
