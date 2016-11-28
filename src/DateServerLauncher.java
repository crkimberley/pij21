import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author crkimberley on 28/11/2016.
 */
public class DateServerLauncher {
    public static void main(String[] args) {
        new DateServerLauncher().launch();
    }

    private void launch() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // LocateRegistry.createRegistry(1099); (KEITH)
            Registry registry = LocateRegistry.getRegistry();
            DateServer dateServer = new DateServer();
            // String registryHost = "//localhost/"; (KEITH)
            // String serviceName = "date"; (KEITH)
            // Naming.rebind(registryHost + serviceName, server); (KEITH)
            registry.rebind("Date", dateServer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}