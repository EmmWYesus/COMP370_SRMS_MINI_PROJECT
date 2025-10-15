public class Client {
    public static void main(String[] args) {
        PrimaryServer primary = new PrimaryServer();
        BackupServer backup = new BackupServer();
        Monitor monitor = new Monitor(primary, backup);

        System.out.println("\n System initialization has begun. Preparing all necessary services and performing initial health checks");
        monitor.checkServers(true); // Primary is alive initially

        Server active = monitor.getActiveServer();
        active.processRequest("Get user data");

        System.out.println("\n [WARNING] Simulating a failure in the primary server to test failover and redundancy mechanisms");
        monitor.checkServers(false); // Primary fails

        active = monitor.getActiveServer();
        active.processRequest("Save new order");

        System.out.println("\n[SUCCESS] The system continues to operate normally. Redundancy is functioning correctly, and requests are being processed without interruption.");
    }
}
