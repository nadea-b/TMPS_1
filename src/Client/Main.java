package client;

import domain.factory.BookFactory;
import domain.utilities.BookstoreFacade;
import domain.models.Book;
import adapters.PayPalAdapter;
import adapters.Payment;
import domain.models.CreditCardPayment;
import domain.models.PayPalPayment;

public class Main {

    public static void main(String[] args) {

        // Create a BookFactory and Payment method
        BookFactory bookFactory = new BookFactory();
        Payment creditCardPayment = new CreditCardPayment();  // Existing payment method
        Payment payPalPayment = new PayPalAdapter(new PayPalPayment());  // New payment method adapted

        // Create facade for checkout using credit card
        BookstoreFacade facade = new BookstoreFacade(bookFactory, creditCardPayment);

        // Add books to the cart via the facade using the builder
        facade.addBookToCart("ebook", "1984", "George Orwell", 5.99, "pdf");

        // Set shipping and payment info using the builder
        facade.setShippingInfo("123 Main St, City, Country");
        facade.setPaymentMethod("Credit Card");

        // View the cart details
        System.out.println("Viewing Cart Details using Credit Card Payment:");
        facade.viewCartDetails();

        // Checkout using credit card
        facade.checkout();

        // Now, let's use PayPal via Adapter
        BookstoreFacade facadeWithPayPal = new BookstoreFacade(bookFactory, payPalPayment);
        System.out.println("\nViewing Cart Details using PayPal Payment:");
        facadeWithPayPal.viewCartDetails();

        // Set shipping and payment info for PayPal
        facadeWithPayPal.setShippingInfo("456 Another St, City, Country");
        facadeWithPayPal.setPaymentMethod("PayPal");

        // Checkout using PayPal
        facadeWithPayPal.checkout();
    }
}
