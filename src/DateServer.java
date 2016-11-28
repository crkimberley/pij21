import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author crkimberley on 28/11/2016.
 */
public class DateServer implements DateService {

    public DateServer() throws RemoteException {}

    @Override
    public LocalDate currentDate() throws RemoteException {
        return LocalDate.now();
    }
}