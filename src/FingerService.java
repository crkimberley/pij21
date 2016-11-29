import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by chris on 29/11/2016.
 */
public interface FingerService extends Remote {

    String connectedUsers() throws RemoteException;
}