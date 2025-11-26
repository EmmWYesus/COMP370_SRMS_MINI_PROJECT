package mproject2;

import java.util.ArrayList;
import java.util.List;

public abstract class ServerType {
    protected String name;
    protected boolean isActive;
    private final List<Observer> observers = new ArrayList<>();

    public ServerType(String name) {
        this.name = name;
        this.isActive = false;
    }

    public String getName() { return name; }
    public boolean isActive() { return isActive; }

    public void addObserver(Observer o) { observers.add(o); }

    protected void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void activate() {
        isActive = true;
        System.out.println(name + " is now ACTIVE.");
        notifyObservers(name + " is now ACTIVE");
    }

    public void deactivate() {
        isActive = false;
        System.out.println(name + " is now INACTIVE.");
        notifyObservers(name + " is now INACTIVE");
    }

    public abstract void handleRequest(String request);
}
