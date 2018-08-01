package ru.seet61.spring.logger;

import ru.seet61.spring.event.Event;

import java.io.IOException;

public interface EventLogger {
    public void logEvent(Event event) throws IOException;
}
