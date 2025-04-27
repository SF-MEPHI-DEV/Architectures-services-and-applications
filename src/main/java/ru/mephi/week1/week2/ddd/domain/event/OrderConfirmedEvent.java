package ru.mephi.week1.week2.ddd.domain.event;

public class OrderConfirmedEvent {
    private final String orderId;

    public OrderConfirmedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
