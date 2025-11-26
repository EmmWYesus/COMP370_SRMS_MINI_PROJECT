package mproject2;

public class Monitor implements Observer {
    private static Monitor instance;

    private Monitor() {}  // Private so only getInstance() can create

    public static synchronized Monitor getInstance() {
        if (instance == null) {
            instance = new Monitor();
        }
        return instance;
    }

    @Override
    public void update(String message) {
        System.out.println("Monitor received event: " + message);
        // Here you can later add failover logic (switch to backup)
    }

    public void checkServer(ServerType server) {
        System.out.println("Checking status of server: " + server.getName());
    }
}
