import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Created by chris on 29/11/2016.
 */
public class FingerServer extends UnicastRemoteObject implements FingerService {
    private List<User> users;

    FingerServer(List<User> users) throws RemoteException {
        this.users = users;
    }

    @Override
    public String connectedUsers() throws RemoteException {
        String result = "\n\t ••• Connected Users •••\n";
        for (User user : users) {
            if (user.isConnected()) {
                result+= user.getName() + " connected to server at " + user.getConnectTime() + "\n";
            }
        }
        return result;
    }
}