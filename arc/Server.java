public class Server {
  protected String name;
  protected boolean isActive;

  public Server(String name) {
    this.name = name;
    this.isActive = false;
  }
  public void activate (){ 
    isActive = true;
    System.out.println(name + "is now active.");
  }
  public void deactivate() {
    isActive = false;
    System.out.println ( name + "is now inactive.");
  }
  public void processRequest(String request) {
    if (isActive) {
      System.out.println(name + "processed request: " + request);
    } else { 
      System.out.println(name + "cannot process request (inactive).");
    }
  }
}
