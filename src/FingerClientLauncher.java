import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by chris on 29/11/2016.
 */
public class FingerClientLauncher {

    public static void main(String[] args) {
        new FingerClientLauncher().launch();
    }
    
    private void launch() {
        try {
            FingerService fingerService = (FingerService) Naming.lookup("finger");
            System.out.println(fingerService.connectedUsers());
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}