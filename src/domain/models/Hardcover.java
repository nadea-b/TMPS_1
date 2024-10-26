package domain.models;

// Hardcover class
public class Hardcover implements Book {
    private String title;
    private String author;
    private double price;
    private int pages;
    private String weight;

    public Hardcover(String title, String author, double price, int pages, String weight) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
        this.weight = weight;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getPages() { return pages; }
    public String getWeight() { return weight; }
}