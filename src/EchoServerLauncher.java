/**
 * Created by chris on 26/11/2016.
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoServerLauncher {

    public static void main(String[] args) {
        // if there is no security manager, start one
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            //System.setProperty("java.rmi.server.hostname","192.168.1.65");
            //create the registry if there is not one
            Registry registry = LocateRegistry.getRegistry();

            //create the server object
            EchoServer server = new EchoServer();

            //register (bind) the server object on the registry
            //The registry may be on a different machine

            registry.rebind("Echo", server);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}