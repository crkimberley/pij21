import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author crkimberley on 28/11/2016.
 */
public class FileServerLauncher {
    public static void main(String[] args) {
        new FileServerLauncher().launch();
    }

    private void launch() {
        try {
            FileServer server = new FileServer();
            LocateRegistry.getRegistry().rebind("file", server);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}