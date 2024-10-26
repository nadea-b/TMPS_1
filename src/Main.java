public class Main {
    public static void main(String[] args) {
        // Create books using BookFactory
        Book book1 = BookFactory.createBook("ebook", "1984", "George Orwell", 5.99, "pdf");
        Book book2 = BookFactory.createBook("hardcover", "To Kill a Mockingbird", "Harper Lee", 15.99, 281, "1kg");

        // Get the singleton shopping cart instance and add books
        ShoppingCart cart = ShoppingCart.getInstance();
        cart.addBook(book1);
        cart.addBook(book2);

        // Build an order with added books, shipping info, and payment details
        Order order = new Order.OrderBuilder()
                .addBook(book1)
                .addBook(book2)
                .setShippingInfo("123 Book St, Library City")
                .setPaymentMethod("Credit Card")
                .build();

        // Display order details
        System.out.println("Order Details:");
        System.out.println("Books in Order:");
        for (Book book : order.getBooks()) {
            System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println("Shipping Info: " + order.getShippingInfo());
        System.out.println("Payment Method: " + order.getPaymentMethod());
    }
}
