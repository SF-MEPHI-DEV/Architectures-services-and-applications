package ru.mephi.week2.ddd.infrastructure.persistence;

import ru.mephi.week2.ddd.domain.model.Order;
import ru.mephi.week2.ddd.domain.repository.OrderRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    @Override
    public Order findById(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public void save(Order order) {
        orders.put(order.getOrderId(), order);
    }

    @Override
    public void delete(Order order) {
        orders.remove(order.getOrderId());
    }
}