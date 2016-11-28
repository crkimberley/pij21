import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Created by chris on 26/11/2016.
 */
public class EchoClientLauncher {

    public static void main(String[] args) {
        // macMiniServer IP is "192.168.1.65"
        // String host = "192.168.1.65";
        String host = "";
        System.out.print("String to transmit: ");
        String text = new Scanner(System.in).nextLine();

        // if there is no security manager, start one

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Echo";
            Registry registry = LocateRegistry.getRegistry(host);
            EchoService echoService = (EchoService) registry.lookup(name);
            String receivedEcho = echoService.echo(text);
            System.out.println("receivedEcho is: " + receivedEcho);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}