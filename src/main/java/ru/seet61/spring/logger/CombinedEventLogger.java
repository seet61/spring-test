package ru.seet61.spring.logger;

import ru.seet61.spring.event.Event;

import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements EventLogger {
    private List loggers;

    public CombinedEventLogger(List loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) throws IOException {
        for (int i = 0; i < loggers.size(); i++) {
            EventLogger log = (EventLogger) loggers.get(i);
            log.logEvent(event);
        }
    }
}
