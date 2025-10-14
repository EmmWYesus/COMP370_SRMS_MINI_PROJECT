public class Monitor {
    private PrimaryServer primary;
    private BackupServer backup;

    public Monitor(PrimaryServer primary, BackupServer backup) {
        this.primary = primary;
        this.backup = backup;
    }
    public void checkServers(boolean primaryAlive) {
        if (primaryAlive) {
            if (!primary.isActive) {
                primary.activate();
                backup.deactivate();
            }
        } else {
            System.out.println("Monitor detected failure! Promoting backup...");
            backup.activate();
            primary.deactivate();
        }
    }
    public Server getActiveServer() {
        return primary.isActive ? primary : backup;
    }
}
