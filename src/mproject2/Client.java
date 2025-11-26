package mproject2;

public class Client {
    public void sendRequest(ServerType server) {
        System.out.println("Client sending request to: " + server.getName());
        server.handleRequest();
    }
}
