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
            System.out.println("System monitor has detected an issue with the primary server. Activating the backup server to maintain continuous service availability.");
            backup.activate();
            primary.deactivate();
        }
    }
    public Server getActiveServer() {
        return primary.isActive ? primary : backup;
    }
}
