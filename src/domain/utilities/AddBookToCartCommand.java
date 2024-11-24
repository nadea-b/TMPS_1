package domain.utilities;

import domain.builder.OrderBuilder;
import domain.models.Book;

public class AddBookToCartCommand implements Command {
    private final OrderBuilder orderBuilder;
    private final Book book;

    public AddBookToCartCommand(OrderBuilder orderBuilder, Book book) {
        this.orderBuilder = orderBuilder;
        this.book = book;
    }

    @Override
    public void execute() {
        orderBuilder.addBook(book);
    }
}