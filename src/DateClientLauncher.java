import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by chris on 26/11/2016.
 */
public class DateClientLauncher {

    public static void main(String[] args) {
        // if there is no security manager, start one
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Date";
            Registry registry = LocateRegistry.getRegistry("192.168.1.65");
            DateService dateService = (DateService) registry.lookup(name);
            LocalDate receivedDate = dateService.currentDate();
            System.out.println("Current date is: " + receivedDate.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}