package domain.decorators;

import domain.models.Book;

public class ConcretePersonalizedMessageDecorator extends PersonalizedMessageDecorator {

    public ConcretePersonalizedMessageDecorator(Book book, String message) {
        super(book, message);
    }

    // Implement the getMessage() method
    @Override
    public String getMessage() {
        return super.message; // Return the personalized message
    }

    @Override
    public String getAuthor() {
        return null;
    }
}
