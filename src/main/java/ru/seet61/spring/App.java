package ru.seet61.spring;

public class App {
    private Client client;
    private EventLogger eventLoger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLoger = (EventLogger) eventLogger;
    }

    public static void main(String[] args) {
        App app = new App();

/*        app.client = new Client("1", "John Smith");
        app.eventLoger = new ConsoleEventLoger();*/

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullname());
        eventLoger.logEvent(message);
    }
}
