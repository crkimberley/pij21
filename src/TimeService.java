import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author crkimberley on 28/11/2016.
 */
public interface TimeService extends Remote {

    LocalDate currentDate() throws RemoteException;

    LocalTime currentTime() throws RemoteException;

    String currentTimeAndDate() throws RemoteException;
}
