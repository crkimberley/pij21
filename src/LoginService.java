import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chris on 29/11/2016.
 */
public interface LoginService extends Remote {

    String logIn(String user, String password) throws RemoteException;

    String logOut(String user, String password) throws RemoteException;

    List<User> getUsers() throws RemoteException;
}
