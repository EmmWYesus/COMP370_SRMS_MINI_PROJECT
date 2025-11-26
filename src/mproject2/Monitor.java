package mproject2;

public class Monitor implements Observer {
    private static Monitor instance;
    private PrimaryServer primary;
    private BackupServer backup;

    // Private constructor (Singleton)
    private Monitor() {}

    // Global access (Singleton)
    public static synchronized Monitor getInstance() {
        if (instance == null) instance = new Monitor();
        return instance;
    }

    // System setup (called once)
    public void configure(PrimaryServer p, BackupServer b) {
        this.primary = p;
        this.backup = b;
    }

    @Override
    public void update(String message) {
        System.out.println("[Monitor] Event received: " + message);
        if (message.contains("Primary Server is now INACTIVE")) {
            System.out.println("[Monitor] Switching to backup...");
            backup.promoteToPrimary();
            primary.deactivate(); // Ensure consistency
        }
    }

    public ServerType getActiveServer() {
        return (primary != null && primary.isActive()) ? primary : backup;
    }
}
