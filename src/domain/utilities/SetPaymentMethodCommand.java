package domain.utilities;

import domain.builder.OrderBuilder;

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
