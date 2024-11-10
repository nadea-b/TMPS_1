package domain.utilities;

import domain.builder.OrderBuilder;
import domain.factory.BookFactory;
import domain.models.Book;
import domain.models.Order;
import adapters.Payment;

public class BookstoreFacade {
    private final BookFactory bookFactory;
    private final Payment paymentProcessor;
    private final OrderBuilder orderBuilder;

    public BookstoreFacade(BookFactory factory, Payment paymentProcessor) {
        this.bookFactory = factory;
        this.paymentProcessor = paymentProcessor;
        this.orderBuilder = new OrderBuilder();
    }

    public void addBookToCart(String type, String title, String author, double price, String formatOrWeight) {
        // Check the book type and ensure the correct number of arguments are passed
        if (type.equalsIgnoreCase("hardcover") && formatOrWeight == null) {
            throw new IllegalArgumentException("Weight must be provided for hardcover books.");
        }

        Book book = BookFactory.createBook(type, title, author, price, formatOrWeight);
        orderBuilder.addBook(book);  // Add the book to the order using the builder
    }


    public void setShippingInfo(String shippingInfo) {
        orderBuilder.setShippingInfo(shippingInfo);  // Set shipping info
    }

    public void setPaymentMethod(String paymentMethod) {
        orderBuilder.setPaymentMethod(paymentMethod);  // Set payment method
    }

    public void checkout() {
        Order order = orderBuilder.build();  // Build the order
        paymentProcessor.process(order.getTotal());  // Process payment
        System.out.println("Order processed with " + order.getPaymentMethod() + " and shipping to " + order.getShippingInfo());
    }

    public void viewCartDetails() {
        Order order = orderBuilder.build();  // Build the order to view details
        for (Book book : order.getBooks()) {
            System.out.println(book.getTitle() + " - $" + book.getPrice());
        }
        System.out.println("Total: $" + order.getTotal());
    }
}
