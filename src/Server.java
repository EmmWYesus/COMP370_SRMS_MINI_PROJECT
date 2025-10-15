public class Server {
    protected String name;
    protected boolean isActive;
    
    public Server(String name) {
        this.name = name;
        this.isActive = false;
    }
    public void activate() {
        isActive = true;
        System.out.println(name + " has been activated and is now ready to handle requests.");
    }
    public void deactivate() {
        isActive = false;
        System.out.println(name + " has been deactivated and will no longer process requests.");
    }
    public void processRequest(String request) {
        if (isActive) {
            System.out.println(name + " processed request: " + request);
        } 
        else {
            System.out.println(name + " is inactive and cannot process the request.");
        }
    }
}
