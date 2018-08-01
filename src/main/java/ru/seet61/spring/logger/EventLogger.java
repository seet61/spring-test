package ru.seet61.spring.logger;

import ru.seet61.spring.event.Event;

public interface EventLogger {
    public void logEvent(Event event);
}
