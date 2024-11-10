package domain.decorators;

import domain.models.Book;

// Concrete decorator for adding a message
public abstract class PersonalizedMessageDecorator extends BookDecorator {
    protected String message;

    public PersonalizedMessageDecorator(Book book, String message) {
        super(book);
        this.message = message;
    }

    @Override
    public String getTitle() {
        return super.getTitle() + " (Message: " + message + ")";
    }

    public abstract String getMessage();
}