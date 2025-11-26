package mproject2;

public class MainTest {
    public static void main(String[] args) {
        Monitor monitor = Monitor.getInstance();

        PrimaryServer primary = new PrimaryServer("127.0.0.1", 8080);
        BackupServer backup = new BackupServer("127.0.0.2", 8081);
        Client client = new Client();

        primary.addObserver(monitor);
        backup.addObserver(monitor);

        client.sendRequest(primary);

        primary.simulateFailure();

        client.sendRequest(backup);
    }
}
