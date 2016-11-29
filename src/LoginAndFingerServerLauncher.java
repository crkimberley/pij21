import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by chris on 29/11/2016.
 */
public class LoginAndFingerServerLauncher {

    public static void main(String[] args) {
        new LoginAndFingerServerLauncher().launch();
    }

    private void launch() {
        try {
            LoginServer loginServer = new LoginServer();
            FingerServer fingerServer = new FingerServer(loginServer.getUsers());
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("login", loginServer);
            registry.rebind("finger", fingerServer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}