import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by chris on 29/11/2016.
 */
public interface CalculatorService extends Remote {

    int add(int x, int y) throws RemoteException;

    int subtract(int x, int y) throws RemoteException;

    int multiply(int x, int y) throws RemoteException;

    double divide(int x, int y) throws RemoteException;
}
