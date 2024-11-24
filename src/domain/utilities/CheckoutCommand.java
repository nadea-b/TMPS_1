package domain.utilities;

import domain.builder.OrderBuilder;
import domain.models.Order;
import adapters.Payment;
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