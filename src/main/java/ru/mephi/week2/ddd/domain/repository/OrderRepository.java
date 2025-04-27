package ru.mephi.week1.week2.ddd.domain.repository;

import ru.mephi.week1.week2.ddd.domain.model.Order;

public interface OrderRepository {
    Order findById(String orderId);
    void save(Order order);
    void delete(Order order);
}

