import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author crkimberley on 28/11/2016.
 */
public class CalculatorServerLauncher {
    public static void main(String[] args) {
        new CalculatorServerLauncher().launch();
    }

    private void launch() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            CalculatorServer server = new CalculatorServer();
            LocateRegistry.getRegistry().rebind("calculator", server);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}