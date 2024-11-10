package domain.decorators;

import domain.models.Book;

// Base Book Decorator
public abstract class BookDecorator implements Book {
    protected Book decoratedBook;

    public BookDecorator(Book book) {
        this.decoratedBook = book;
    }

    @Override
    public String getTitle() {
        return decoratedBook.getTitle();
    }

    @Override
    public double getPrice() {
        return decoratedBook.getPrice();
    }
}