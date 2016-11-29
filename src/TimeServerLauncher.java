import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author crkimberley on 28/11/2016.
 */
public class TimeServerLauncher {
    public static void main(String[] args) {
        new TimeServerLauncher().launch();
    }

    private void launch() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry();
            TimeService server = new TimeServer();
            registry.rebind("Date", server);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}