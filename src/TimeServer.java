import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author crkimberley on 28/11/2016.
 */
public class TimeServer extends UnicastRemoteObject implements TimeService {

    TimeServer() throws RemoteException {}

    @Override
    public LocalDate currentDate() throws RemoteException {
        return LocalDate.now();
    }

    @Override
    public LocalTime currentTime() throws RemoteException {
        return LocalTime.now();
    }

    @Override
    public String currentTimeAndDate() throws RemoteException {
        return "Current time, date: " + LocalTime.now() + ", " + LocalDate.now();
    }
}