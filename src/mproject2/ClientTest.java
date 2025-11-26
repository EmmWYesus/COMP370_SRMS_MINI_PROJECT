package mproject2;

public class ClientTest {
    public static void main(String[] args) {
        // Create servers
        PrimaryServer primary = new PrimaryServer();
        BackupServer backup = new BackupServer();

        // Get monitor (Singleton) and configure
        Monitor monitor = Monitor.getInstance();
        monitor.configure(primary, backup);

        // Register monitor as observer
        primary.addObserver(monitor);
        backup.addObserver(monitor);

        System.out.println("==== System Starting ====");
        primary.activate();
        primary.handleRequest("Fetch user data");

        System.out.println("\n--- Simulating primary failure ---");
        primary.deactivate();

        // Get active server and send a new request
        ServerType active = monitor.getActiveServer();
        active.handleRequest("Save transaction");
    }
}
