# Structural Design Patterns


## Author: Barbarov Nadejda

----

## Objectives

- To study and understand the **Structural Design Patterns**.
- As a continuation of the previous laboratory work, to think about the functionalities that the system will need to provide to the user.
- Implement at least **3 creational design patterns** for the project (Online Bookstore Management):
    1. **Facade Pattern**.
    2. **Adapter Pattern**.
    3. **Decorator Pattern**.

---
## Introduction
This report explains how **structural design patterns** are applied in the design of an online bookstore system. 
The main objective is to simplify the interaction between different components and make the system easier to extend and maintain.

### Used Design Patterns

* **Facade Pattern**: Simplifies interactions with a complex system.

* **Adapter Pattern**: Allows incompatible interfaces to work together.

* **Decorator Pattern**: Adds new behavior to objects dynamically.

---

## Implementation

By applying these new structural patterns, the system will be easier to manage, extend, and modify. These patterns help making it easier to add new features, such as new payment methods or book formats, without affecting the rest of the system.

### Code Snippets

#### 1. **Facade Pattern**
The **Facade** pattern provides a simplified interface to a complex subsystem. 
In this bookstore project, the `BookstoreFacade` class is a facade to the principal functionality, such as adding books to the cart, viewing cart details, and performing the checkout process. 
This hides the complexity of managing the `BookFactory`, `ShoppingCart`, and `Payment` systems.

```java
public class BookstoreFacade {
    private BookFactory bookFactory;
    private ShoppingCart cart;
    private Payment paymentProcessor;

    public BookstoreFacade(BookFactory factory, ShoppingCart cart, Payment paymentProcessor) {
        this.bookFactory = factory;
        this.cart = cart;
        this.paymentProcessor = paymentProcessor;
    }

    public void addBookToCart(String type, String title, String author, double price, String formatOrWeight) {
        Book book = bookFactory.createBook(type, title, author, price, formatOrWeight);
        cart.addBook(book);
    }

    public void checkout(double totalAmount) {
        paymentProcessor.process(totalAmount);
    }

    public void viewCartDetails() {
        for (Book book : cart.getBooks()) {
            System.out.println(book.getTitle() + " - $" + book.getPrice());
        }
        System.out.println("Total: $" + cart.getTotal());
    }
}
```
#### Location:
The `BookstoreFacade` class is located in the `domain.utilities` package.

#### Motivation:
The Facade pattern simplifies interactions by providing a single entry point to the complex system. 
Users don't need to worry about the underlying complexities of adding books, calculating totals, or processing payments—everything is abstracted through the facade.


#### 2. Adapter Pattern
The Adapter pattern is used to allow objects with incompatible interfaces to work together. 
In this system, the `PayPalAdapter` allows the `PayPalPayment` class, which has a different interface, to be used in the same way as other payment methods that implement the `Payment` interface.

```java
public class PayPalAdapter implements Payment {
  private PayPalPayment payPalPayment;

  public PayPalAdapter(PayPalPayment payPalPayment) {
    this.payPalPayment = payPalPayment;
  }

  @Override
  public void process(double amount) {
    payPalPayment.pay(amount);
  }
}
```
#### Location:
The `PayPalAdapter` class is located in the `adapters` package.

#### Motivation:
The **Adapter** pattern allows to integrate `PayPal` into the system without modifying the existing `Payment` interface or other payment methods.

#### 3. Decorator Pattern
The **Decorator** pattern is used to add new functionality to an object. 
In this project, the `PersonalizedMessageDecorator` adds personalized messages to books.

```java
public class PersonalizedMessageDecorator extends BookDecorator {
  private String message;

  public PersonalizedMessageDecorator(Book book, String message) {
    super(book);
    this.message = message;
  }

  @Override
  public String getTitle() {
    return super.getTitle() + " (Message: " + message + ")";
  }
}
```
#### Location:
The `PersonalizedMessageDecorator` class is located in the `domain.decorators` package.
#### Motivation:
The Decorator pattern is useful for adding features to objects without modifying the original class. 
In this project, a personalized message can be added to a book without changing the `Book` class itself.


## Conclusions

Using structural patterns (Facade, Adapter, and Decorator) in this online bookstore system made it easier to manage. 
The **Facade** pattern combined different tasks into one simple interface, so users can interact with the system without needing to worry about the details. 
The **Adapter** pattern made it possible to add PayPal as a payment option without changing much of the system. 
The **Decorator** pattern allowed us to add features, like personalized messages on books, without changing the main system. 
These patterns made the system more flexible, easier to maintain, and ready for future changes.