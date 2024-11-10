package domain.models;

import adapters.Payment;

public class CreditCardPayment implements Payment {
    public void process(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
    }
}
