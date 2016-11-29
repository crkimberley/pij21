import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chris on 29/11/2016.
 */
public class LoginServer extends UnicastRemoteObject implements LoginService {

    private List<User> users = new ArrayList<>();

    LoginServer() throws RemoteException {
        users.add(new User("amy", "amyPassword"));
        users.add(new User("beth", "bethPassword"));
        users.add(new User("claire", "clairePassword"));
        users.add(new User("demi", "demiPassword"));
        users.add(new User("ella", "ellaPassword"));
    }

    @Override
    public String logIn(String name, String password) throws RemoteException {
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                user.setConnected(true);
                user.setConnectTime(LocalDateTime.now());
                return name + " - you're now logged in at " + user.getConnectTime();
            }
        }
        return "Sorry " + name + " - failed to log you in";
    }

    @Override
    public String logOut(String name, String password) throws RemoteException {
        for (User user : users) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                user.setConnected(false);
                return name + " - you're now logged out";
            }
        }
        return name + " - couldn't log you out";
    }

    public List<User> getUsers() {
        return users;
    }
}