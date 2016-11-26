import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by chris on 26/11/2016.
 */
public class EchoServer extends UnicastRemoteObject implements EchoService {

    public EchoServer() throws RemoteException {
        // nothing to initialise for this server
        //(must have a constructor that throws RemoteException)
    }

    @Override
    public String echo(String s) throws RemoteException {
        // This println is not necessary, but helps verifying whether
        // the server has received the call or not on the remote machine
        System.out.println("Replied to some client saying ’" + s + "’");
        return ("Hello!: " + s);
    }
}