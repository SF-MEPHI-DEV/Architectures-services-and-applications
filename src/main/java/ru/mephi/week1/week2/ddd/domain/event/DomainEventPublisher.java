package ru.mephi.week1.week2.ddd.domain.event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DomainEventPublisher {
    private static final List<Consumer<Object>> subscribers = new ArrayList<>();

    public static void subscribe(Consumer<Object> subscriber) {
        subscribers.add(subscriber);
    }

    public static void publish(Object event) {
        for (Consumer<Object> subscriber : subscribers) {
            subscriber.accept(event);
        }
    }
}