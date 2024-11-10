package domain.decorators;

import domain.models.Book;

// Concrete decorator for gift wrapping
public abstract class GiftWrapDecorator extends BookDecorator {
    public GiftWrapDecorator(Book book) {
        super(book);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2.00; // Extra cost for gift wrap
    }
}