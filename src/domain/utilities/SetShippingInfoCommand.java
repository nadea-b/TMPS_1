package domain.utilities;

import domain.builder.OrderBuilder;

public class SetShippingInfoCommand implements Command {
    private final OrderBuilder orderBuilder;
    private final String shippingInfo;

    public SetShippingInfoCommand(OrderBuilder orderBuilder, String shippingInfo) {
        this.orderBuilder = orderBuilder;
        this.shippingInfo = shippingInfo;
    }

    @Override
    public void execute() {
        orderBuilder.setShippingInfo(shippingInfo);
    }
}