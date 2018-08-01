package ru.seet61.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.seet61.spring.client.Client;
import ru.seet61.spring.event.Event;
import ru.seet61.spring.event.EventType;
import ru.seet61.spring.logger.CacheFileEventLogger;
import ru.seet61.spring.logger.EventLogger;

import java.io.IOException;
import java.util.LinkedHashMap;

@Component
public class App {
    private Client client;
    private CacheFileEventLogger defaultLogger;
    private LinkedHashMap<EventType, EventLogger> loggers;

    public App(Client client, CacheFileEventLogger defaultLogger, LinkedHashMap<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = defaultLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        App app = (App) context.getBean("app");
        Event event1 = (Event) context.getBean("event");
        event1.setMsg("message1");
        app.logEvent(EventType.INFO, event1);
        /*Event event2 = (Event) context.getBean("event");
        event2.setMsg("message2");
        app.logEvent(EventType.TEST, event2);
        app.logEvent(EventType.TEST, event2);
        app.logEvent(EventType.TEST, event2);
        app.logEvent(EventType.TEST, event2);
        app.logEvent(EventType.TEST, event2);*/
        Event event3 = (Event) context.getBean("event");
        event3.setMsg("message3");
        app.logEvent(EventType.ERROR, event3);

        context.close();

    }

    private void logEvent(EventType type, Event event) throws IOException {
        EventLogger logger = loggers.get(type);
        if (logger == null){
            logger = (EventLogger) defaultLogger;
        }
        logger.logEvent(event);
    }
}
