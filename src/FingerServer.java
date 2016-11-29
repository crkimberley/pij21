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
        String newLine = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder(newLine + "\t ••• Connected Users •••" + newLine);
        for (User user : users) {
            if (user.isConnected()) {
                sb.append(user.getName());
                sb.append(" connected to server at ");
                sb.append(user.getConnectTime());
                sb.append(newLine);
            }
        }
        return sb.toString();
    }
}