package mproject2;

public class BackupServer extends ServerType {
    public BackupServer() {
        super("Backup Server");
    }

    @Override
    public void handleRequest(String request) {
        if (isActive) {
            System.out.println(name + " processed request: " + request);
        } else {
            System.out.println(name + " cannot process request (inactive).");
        }
    }

    public void promoteToPrimary() {
        System.out.println(name + " promoted to Primary!");
        activate();
    }
}
