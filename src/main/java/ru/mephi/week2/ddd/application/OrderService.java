package ru.mephi.week2.ddd.application;

import ru.mephi.week2.ddd.domain.event.DomainEventPublisher;
import ru.mephi.week2.ddd.domain.event.OrderConfirmedEvent;
import ru.mephi.week2.ddd.domain.model.Order;
import ru.mephi.week2.ddd.domain.repository.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void confirmOrder(String orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found.");
        }

        order.confirm();
        orderRepository.save(order);

        DomainEventPublisher.publish(new OrderConfirmedEvent(orderId));
    }
}