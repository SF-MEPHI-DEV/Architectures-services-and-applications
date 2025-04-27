package ru.mephi.week1.lesson2;

import java.util.ArrayList;
import java.util.List;

// Наблюдатель (подписчик)
interface Observer {
    void update(float temperature, float humidity);
}

// Субъект (издатель)
interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(temperature, humidity));
    }

    // Метод для изменения состояния
    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();  // Автоматическое уведомление
    }
}

// Дисплей для отображения данных
class Display implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.printf("Дисплей: Температура=%.1f°C, Влажность=%.1f%%\n", temperature, humidity);
    }
}

// Логгер для записи в файл
class Logger implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.printf("Лог: Данные записаны (%.1f°C, %.1f%%)\n", temperature, humidity);
    }
}

public class ObserverExample {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer display = new Display();
        Observer logger = new Logger();

        // Подписываем наблюдателей
        station.registerObserver(display);
        station.registerObserver(logger);

        // Изменяем состояние - все получат уведомление
        station.setMeasurements(25.5f, 65.0f);
    }
}
