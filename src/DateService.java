import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author crkimberley on 28/11/2016.
 */
public interface DateService extends Remote {

    LocalDate currentDate() throws RemoteException;
}
