import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by chris on 26/11/2016.
 */

/**
 * An implementation of the echo service.
 */
public interface EchoService extends Remote {
    /**
     * Returns the same string passed as parameter
     *
     * @param s a string
     * @return the same string passed as parameter
     * @throws RemoteException (in case anything goes wrong with the network connectivity)
     */

    String echo(String s) throws RemoteException;
}