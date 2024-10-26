package domain.builder;

import domain.models.Book;
import domain.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private List<Book> books = new ArrayList<>();
    private String shippingInfo;
    private String paymentMethod;

    public OrderBuilder addBook(Book book) {
        books.add(book);
        return this;
    }

    public OrderBuilder setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
        return this;
    }

    public OrderBuilder setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public Order build() {
        return new Order(books, shippingInfo, paymentMethod);
    }
}
