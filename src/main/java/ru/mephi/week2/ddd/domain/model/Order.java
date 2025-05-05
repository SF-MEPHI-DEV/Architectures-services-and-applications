package ru.mephi.week2.ddd.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Entity
// Aggregate
public class Order {
    private final String orderId;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = OrderStatus.NEW;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void confirm() {
        if (status == OrderStatus.NEW) {
            status = OrderStatus.CONFIRMED;
        } else {
            throw new IllegalStateException("Order is already confirmed or completed.");
        }
    }

    public void complete() {
        if (status == OrderStatus.CONFIRMED) {
            status = OrderStatus.COMPLETED;
        } else {
            throw new IllegalStateException("Order must be confirmed before completion.");
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public OrderStatus getStatus() {
        return status;
    }
}