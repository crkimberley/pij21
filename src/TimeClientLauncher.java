import java.rmi.Naming;

/**
 * Created by chris on 26/11/2016.
 */
public class TimeClientLauncher {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            TimeService timeService = (TimeService) Naming.lookup("Date");
            System.out.println("Current time: " + timeService.currentTime() + ", " + timeService.currentDate());
            System.out.println(timeService.currentTimeAndDate());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


// From Java API...

// Naming...URL String...//host:port/name
// If host is omitted, the host defaults to the local host
// If port is omitted, then the port defaults to 1099,
// the "well-known" port that RMI's registry, rmiregistry, uses.

// // IN ABOVE CODE WE COULD USE...Naming.lookup("//127.0.0.1:1099/Date")...or "///Date"...

// From stackoverflow...

// the name arguments you pass to java.rmi.Naming are in URL format,
// and include the location of the registry,
// whereas with java.rmi.registry.Registry, the name is just the name.
// Also, the methods on Naming are static.
// Naming is really just a convenience class that saves you having to look up the Registry manually

// Could have used Registry again (as with EchoClientLauncher)...

// Registry registry = LocateRegistry.getRegistry();
// Remote service = registry.lookup("Date");

// instead of (now condensed)...

// Remote service = Naming.lookup("Date");
// TimeService dateService = (TimeService) service;