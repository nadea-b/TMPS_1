package domain.models;

// Ebook class
public class Ebook implements Book {
    private String title;
    private String author;
    private double price;
    private String fileFormat;

    public Ebook(String title, String author, double price, String fileFormat) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.fileFormat = fileFormat;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public String getFileFormat() { return fileFormat; }
}