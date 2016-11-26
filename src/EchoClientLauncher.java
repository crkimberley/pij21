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
        System.out.print("String to transmit: ");
        String text = new Scanner(System.in).nextLine();

        // if there is no security manager, start one
        if (System.getSecurityManager() == null) {
            System.out.println(">1<");
            System.setSecurityManager(new SecurityManager());
            System.out.println(">2<");
        }

        try {
            String name = "Echo";
            Registry registry = LocateRegistry.getRegistry("localhost");
            EchoService echoService = (EchoService) registry.lookup(name);
            String receivedEcho = echoService.echo(text);
            System.out.println("receivedEcho is: " + receivedEcho);
        } catch (NotBoundException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}