package ru.seet61.spring.logger;

import ru.seet61.spring.event.Event;

public class ConsoleEventLogger {

    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
