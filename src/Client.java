public class Client {
    public static void main(String[] args) {
        PrimaryServer primary = new PrimaryServer();
        BackupServer backup = new BackupServer();
        Monitor monitor = new Monitor(primary, backup);

        System.out.println("\n=== System Starting ===");
        monitor.checkServers(true); // Primary is alive initially

        Server active = monitor.getActiveServer();
        active.processRequest("Get user data");

        System.out.println("\n--- Simulating Primary Failure ---");
        monitor.checkServers(false); // Primary fails

        active = monitor.getActiveServer();
        active.processRequest("Save new order");

        System.out.println("\nSystem running successfully with redundancy.");
    }
}
