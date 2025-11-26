package mproject2;

public class PrimaryServer extends ServerType {
    public PrimaryServer() {
        super("Primary Server");
    }

    @Override
    public void handleRequest(String request) {
        if (isActive) {
            System.out.println(name + " processed request: " + request);
        } else {
            System.out.println(name + " cannot process request (inactive).");
        }
    }
}
