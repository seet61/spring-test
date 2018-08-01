package ru.seet61.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.seet61.spring.client.Client;
import ru.seet61.spring.console.ConsoleEventLogger;
import ru.seet61.spring.console.EventLogger;

@Component
public class App {
    private Client client;
    private ConsoleEventLogger eventLoger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLoger = eventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        App app = (App) context.getBean("app");
        app.logEvent("Some event for user 1");
        app.logEvent("Some event for user 2");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullname());
        eventLoger.logEvent(message);
    }
}
