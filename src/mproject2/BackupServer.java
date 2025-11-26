package mproject2;

public class BackupServer extends ServerType {
    public BackupServer(String host, int port) {
        super(host, port, "Backup Server");
    }

    @Override
    public void handleRequest() {
        System.out.println(name + " handling client request.");
    }
}
