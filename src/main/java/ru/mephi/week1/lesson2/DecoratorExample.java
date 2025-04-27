package ru.mephi.week1.lesson2;

// Интерфейс компонента
interface Notification {
    void send();
}

// Конкретный компонент
class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Отправка email-уведомления");
    }
}

// Абстрактный декоратор
abstract class NotificationDecorator implements Notification {
    protected Notification wrappee;  // Обёртываемый объект

    public NotificationDecorator(Notification notification) {
        this.wrappee = notification;
    }

    @Override
    public void send() {
        wrappee.send();
    }
}

// Декоратор для SMS-уведомления
class SMSDecorator extends NotificationDecorator {
    public SMSDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        super.send();
        sendSMS();
    }

    private void sendSMS() {
        System.out.println("Отправка SMS-уведомления");
    }
}

// Декоратор для Facebook-уведомления
class FacebookDecorator extends NotificationDecorator {
    public FacebookDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        super.send();
        sendFacebookNotification();
    }

    private void sendFacebookNotification() {
        System.out.println("Отправка уведомления в Facebook");
    }
}


public class DecoratorExample {
    public static void main(String[] args) {
        // Простое email-уведомление
        Notification email = new EmailNotification();
        email.send();

        // Email + SMS
        Notification emailWithSms = new SMSDecorator(new EmailNotification());
        emailWithSms.send();

        // Email + SMS + Facebook
        Notification fullNotification = new FacebookDecorator(
                new SMSDecorator(
                        new EmailNotification()
                )
        );
        fullNotification.send();
    }
}