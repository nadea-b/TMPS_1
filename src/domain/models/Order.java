package domain.models;

import java.util.List;

public class Order {
    private List<Book> books;
    private String shippingInfo;
    private String paymentMethod;

    public Order(List<Book> books, String shippingInfo, String paymentMethod) {
        this.books = books;
        this.shippingInfo = shippingInfo;
        this.paymentMethod = paymentMethod;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Calculate and return the total price of all books in the order
    public double getTotal() {
        double total = 0.0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }
}
