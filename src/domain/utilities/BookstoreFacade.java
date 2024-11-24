package domain.utilities;

import domain.builder.OrderBuilder;
import domain.factory.BookFactory;
import domain.models.Book;
import domain.models.Order;
import adapters.Payment;

public class BookstoreFacade {
    private final BookFactory bookFactory;
    private final Payment paymentProcessor;
    private final OrderBuilder orderBuilder;
    private final CommandInvoker commandInvoker;

    public BookstoreFacade(BookFactory factory, Payment paymentProcessor) {
        this.bookFactory = factory;
        this.paymentProcessor = paymentProcessor;
        this.orderBuilder = new OrderBuilder();
        this.commandInvoker = new CommandInvoker();
    }

    public void addBookToCart(String type, String title, String author, double price, String formatOrWeight) {
        if (type.equalsIgnoreCase("hardcover") && formatOrWeight == null) {
            throw new IllegalArgumentException("Weight must be provided for hardcover books.");
        }

        Book book = BookFactory.createBook(type, title, author, price, formatOrWeight);
        Command addBookCommand = new AddBookToCartCommand(orderBuilder, book);
        commandInvoker.executeCommand(addBookCommand);
    }

    public void setShippingInfo(String shippingInfo) {
        Command setShippingCommand = new SetShippingInfoCommand(orderBuilder, shippingInfo);
        commandInvoker.executeCommand(setShippingCommand);
    }

    public void setPaymentMethod(String paymentMethod) {
        Command setPaymentMethodCommand = new SetPaymentMethodCommand(orderBuilder, paymentMethod);
        commandInvoker.executeCommand(setPaymentMethodCommand);
    }


    public void checkout() {
        Command checkoutCommand = new CheckoutCommand(orderBuilder, paymentProcessor);
        commandInvoker.executeCommand(checkoutCommand);
    }

    public void viewCartDetails() {
        Order order = orderBuilder.build();
        for (Book book : order.getBooks()) {
            System.out.println(book.getTitle() + " - $" + book.getPrice());
        }
        System.out.println("Total: $" + order.getTotal());
    }

    public void viewCommandHistory() {
        System.out.println("Command History:");
        for (Command command : commandInvoker.getCommandHistory()) {
            System.out.println(command.getClass().getSimpleName());
        }
    }
}
