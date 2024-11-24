# Behavioral Design Patterns


## Author: Barbarov Nadejda

----

## Objectives

- To study and understand the **Behavioral Design Patterns**.
- As a continuation of the previous laboratory work, to think about what communication between software entities might be involed in the system.
- Implement at least 1 behavioral design pattern in the project (Online Bookstore Management):
    1. **Command Pattern**.

---
## Introduction
Behavioral design patterns focus on how objects interact and communicate. 
They define how responsibilities are distributed among objects to achieve flexibility and scalability.

### Used Design Pattern:

* **Command Pattern**: Is structured around three key components: the `Command`, which encapsulates an action as an object; 
the `Invoker`, which executes the command; 
and the `Receiver`, which performs the requested action. 
By separating the execution logic from the action, this pattern enables more modular and extensible code.

### Motivation:

In the `BookstoreFacade`, operations such as adding books to the cart or setting payment methods were tightly coupled with the business logic. 
This coupling made the system harder to extend and test. 
The **Command Pattern** introduces a layer of abstraction, making operations reusable, easier to modify, and traceable for debugging.

---

## Implementation

### 1. Command Interface
#### Location: `domain.utilities.Command`

The `Command` interface establishes a standard structure for all commands, mandating the implementation of an execute method. 
This ensures that all commands, regardless of their specific purpose, are invoked in a uniform manner.

```java
public interface Command {
    void execute();
}
```
By enforcing this uniformity, the interface simplifies the integration of new commands into the system, 
ensuring consistency and reducing the potential for errors.

### 2. AddBookToCartCommand
#### Location: `domain.utilities.AddBookToCartCommand`

The `AddBookToCartCommand` encapsulates the functionality for adding a book to the shopping cart. 
It interacts directly with the `OrderBuilder`, which manages the cart.
```java
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
```
This command takes an `OrderBuilder` and a `Book` as inputs during instantiation. 
When executed, it delegates the task of adding the book to the `OrderBuilder`, keeping the operation encapsulated and reusable.

### 3. SetPaymentMethodCommand
#### Location: `domain.utilities.SetPaymentMethodCommand`

This command sets the payment method for the current order by interacting with the `OrderBuilder`.

```java
public class SetPaymentMethodCommand implements Command {
    private final OrderBuilder orderBuilder;
    private final String paymentMethod;

    public SetPaymentMethodCommand(OrderBuilder orderBuilder, String paymentMethod) {
        this.orderBuilder = orderBuilder;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void execute() {
        orderBuilder.setPaymentMethod(paymentMethod);
    }
}
```
Its constructor initializes the command with an `OrderBuilder` instance and the desired payment method, 
which is then set when the execute method is invoked. 
This ensures that the payment method can be modified independently of the `BookstoreFacade`.


### 4. CheckoutCommand
#### Location: `domain.utilities.CheckoutCommand`

The `CheckoutCommand` encapsulates the process of finalizing an order. 
It uses the `OrderBuilder` to build the order and the `Payment` processor to complete the transaction.

```java
public class CheckoutCommand implements Command {
    private final OrderBuilder orderBuilder;
    private final Payment paymentProcessor;

    public CheckoutCommand(OrderBuilder orderBuilder, Payment paymentProcessor) {
        this.orderBuilder = orderBuilder;
        this.paymentProcessor = paymentProcessor;
    }

    @Override
    public void execute() {
        Order order = orderBuilder.build();
        paymentProcessor.process(order.getTotal());
        System.out.println("Order processed with " + order.getPaymentMethod() + " and shipping to " + order.getShippingInfo());
    }
}
```

The execution involves building the order from the current cart state, processing the payment based on the total cost, 
and displaying a confirmation message. 
This modular design allows the checkout functionality to be reused or extended as needed.

### 5. CommandInvoker
#### Location: `domain.utilities.CommandInvoker`

The `CommandInvoker` is responsible for executing commands and maintaining a history of executed commands.

```java
public class CommandInvoker {
    private final List<Command> commandHistory = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }

    public List<Command> getCommandHistory() {
        return commandHistory;
    }
}
```
This class ensures that commands are executed consistently while storing their history for potential debugging or undo functionality. 
By separating the execution logic from the commands themselves, the invoker simplifies the management of multiple operations.

## Conclusions
The refactored system now encapsulates all major operations into commands, 
making them reusable and easier to manage. 
For example, setting a payment method is no longer directly tied to the facade but handled by a dedicated command object. 
The use of `CommandInvoker` also enables tracking of executed commands, which can be useful for debugging.

The implementation of the **Command Pattern** in this project significantly improved modularity by encapsulating actions as objects. 
This allowed for better separation of concerns, making the system more extensible and maintainable. 
The introduction of a command invoker facilitated consistent execution and tracking of actions, enhancing the overall robustness of the application.
