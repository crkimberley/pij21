import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by chris on 29/11/2016.
 */
public class CalculatorServer extends UnicastRemoteObject implements CalculatorService {

    CalculatorServer() throws RemoteException {}

    @Override
    public int add(int x, int y) throws RemoteException {
        return x + y;
    }

    @Override
    public int subtract(int x, int y) throws RemoteException {
        return x - y;
    }

    @Override
    public int multiply(int x, int y) throws RemoteException {
        return x * y;
    }

    @Override
    public double divide(int x, int y) throws RemoteException {
        return (double) x / y;
    }
}