# COMP370_SRMS_MINI_PROJECT
Java based Server Redundancy Management System.
# Server Redundancy Management System

This project simulates a simple primary–backup server redundancy system using object-oriented design principles.

## How It Works
- The **Primary Server** handles client requests.
- The **Backup Server** waits to take over if the primary fails.
- The **Monitor** checks which server is alive.
- The **Client** sends requests and automatically switches to the new server if failover happens.

## How to Run
1. Go to the `src` folder.
2. Open `Client.java` and run it.
3. You’ll see heartbeats, failover, and request logs printed to the console.
