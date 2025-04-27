package ru.mephi.week1.lesson2;

// Интерфейс стратегии
interface PaymentStrategy {
    void pay(int amount);
}

// Конкретные стратегии
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.printf("Оплата картой %s: $%d\n", cardNumber, amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.printf("Оплата через PayPal (%s): $%d\n", email, amount);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Установка стратегии
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    // Выполнение оплаты
    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Выбор стратегии в runtime
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100); // Оплата картой 1234-5678-9012-3456: $100

        // Смена стратегии
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(50); // Оплата через PayPal (user@example.com): $50
    }
}
