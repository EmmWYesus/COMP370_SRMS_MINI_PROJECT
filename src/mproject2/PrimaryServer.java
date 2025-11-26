package mproject2;

public class PrimaryServer extends ServerType {
    public PrimaryServer(String host, int port) {
        super(host, port, "Primary Server");
    }

    @Override
    public void handleRequest() {
        System.out.println(name + " handling client request...");
    }
}
