package domain.factory;

import domain.models.Book;
import domain.models.Ebook;
import domain.models.Paperback;
import domain.models.Hardcover;

// BookFactory class
public class BookFactory {
    public static Book createBook(String bookType, String title, String author, double price, Object... args) {
        switch (bookType.toLowerCase()) {
            case "ebook":
                return new Ebook(title, author, price, (String) args[0]);
            case "paperback":
                return new Paperback(title, author, price, (Integer) args[0]);
            case "hardcover":
                return new Hardcover(title, author, price, (Integer) args[0], (String) args[1]);
            default:
                throw new IllegalArgumentException("Unknown book type");
        }
    }
}