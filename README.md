# Creational Patterns


## Author: Barbarov Nadejda

----

## Objectives

- Get familiar with the **SOLID principles**.
- Implement at least **3 creational design patterns** for a chosen domain (Online Bookstore Management):
    1. **Factory Method**.
    2. **Singleton**.
    3. **Builder**.

---

## Used Design Patterns

* **Factory Method**: Centralizes object creation for different book types (`Ebook`, `Paperback`, `Hardcover`) via the `BookFactory`, ensuring that the client code only needs to specify the type of book without handling instantiation details.

* **Singleton**: Ensures that only one instance of `ShoppingCart` exists for the session, providing a global point of access to the cart and avoiding multiple carts in a single session.

* **Builder**: Facilitates the creation of `Order` objects with varying configurations (e.g., shipping and payment details) in a clear, step-by-step way, making it easier to manage complex object construction.

---

## Implementation

### Explanation

This project implements an **online bookstore management system** where users can select and manage different types of books, add books to a cart, and build an order with specific configurations. Using the **Factory Method**, **Singleton**, and **Builder** patterns allows to maintain clean, maintainable, and extendable code for managing object creation across the system.

### Code Snippets

#### 1. `BookFactory` Class (Factory Method)
```java
public class BookFactory {
    public static Book createBook(String type, String title, String author, double price, Object... extraParams) {
        switch (type.toLowerCase()) {
            case "ebook":
                return new Ebook(title, author, price, (String) extraParams[0]);
            case "paperback":
                return new Paperback(title, author, price, (int) extraParams[0]);
            case "hardcover":
                return new Hardcover(title, author, price, (int) extraParams[0], (String) extraParams[1]);
            default:
                throw new IllegalArgumentException("Unknown book type.");
        }
    }
}
```
The `BookFactory` centralizes object creation by encapsulating the instantiation logic for each book type. This uses the **Factory Method** to simplify client code and manage complex instantiation logic.

#### 2. `ShoppingCart` Class (Singleton)
```java
public class ShoppingCart {
    private static ShoppingCart instance;
    private List<Book> books;

    private ShoppingCart() {
        books = new ArrayList<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
```
The `ShoppingCart` class ensures only one cart exists per session, demonstrating the **Singleton** pattern. This allows global access to the single cart instance.

#### 3. `OrderBuilder` Class (Builder)
```java
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
```
The `OrderBuilder` allows for flexible and readable construction of complex `Order` objects. This class adheres to the **Builder** pattern by enabling step-by-step object configuration, with optional fields such as `shippingInfo` and `paymentMethod`.

### Example Usage

```java
// Factory Method for creating books
Book ebook = BookFactory.createBook("ebook", "1984", "George Orwell", 5.99, "pdf");
Book hardcover = BookFactory.createBook("hardcover", "To Kill a Mockingbird", "Harper Lee", 15.99, 281, "1kg");

// Singleton instance for ShoppingCart
ShoppingCart cart = ShoppingCart.getInstance();
cart.addBook(ebook);
cart.addBook(hardcover);

// Builder for creating an order
Order order = new OrderBuilder()
    .addBook(ebook)
    .addBook(hardcover)
    .setShippingInfo("123 Book St, Library City")
    .setPaymentMethod("Credit Card")
    .build();
```

## Conclusions

In this project, three essential **creational design patterns**—**Factory Method**, **Singleton**, and **Builder** were applied — to create a flexible and maintainable bookstore system. The use of these patterns enables to manage object creation efficiently, enforce single instances where needed, and build complex objects in a controlled and flexible manner. This design makes it easy to extend the system (e.g., adding new book types or order configurations) without modifying the existing code, increasing adaptability and maintainability.
