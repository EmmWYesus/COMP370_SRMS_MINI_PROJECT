package mproject2;

import java.util.ArrayList;
import java.util.List;

public abstract class ServerType {
    protected String host;
    protected int port;
    protected String status;
    protected String name;

    private final List<Observer> observers = new ArrayList<>();

    public ServerType(String host, int port, String name) {
        this.host = host;
        this.port = port;
        this.name = name;
        this.status = "ACTIVE";
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    protected void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void simulateFailure() {
        this.status = "FAILED";
        notifyObservers(name + " has failed!");
    }

    public String getName() { return name; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public abstract void handleRequest();
}
