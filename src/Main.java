public class Main {
    public static void main(String[] args) {
        // Assuming you have created Book objects, book1 and book2
        Book book1 = BookFactory.createBook("ebook", "1984", "George Orwell", 5.99, "pdf");
        Book book2 = BookFactory.createBook("hardcover", "To Kill a Mockingbird", "Harper Lee", 15.99, 281, "1kg");

        // Create an order using the OrderBuilder
        Order order = new OrderBuilder()
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
