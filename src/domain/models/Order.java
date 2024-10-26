package domain.models;

import java.util.List;

public class Order {
    private List<Book> books;
    private String shippingInfo;
    private String paymentMethod;

    // Private constructor to enforce the use of OrderBuilder
    public Order(List<Book> books, String shippingInfo, String paymentMethod) {
        this.books = books;
        this.shippingInfo = shippingInfo;
        this.paymentMethod = paymentMethod;
    }

    // Getters for Order properties
    public List<Book> getBooks() { return books; }
    public String getShippingInfo() { return shippingInfo; }
    public String getPaymentMethod() { return paymentMethod; }
}
