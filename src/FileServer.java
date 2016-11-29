import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by chris on 29/11/2016.
 */
public class FileServer extends UnicastRemoteObject implements FileService {

    public FileServer() throws RemoteException {}

    @Override
    public String accessFile(String filename) throws RemoteException {
        File file = new File(filename);
        String line;
        StringBuilder sb = new StringBuilder("");
        String newLine = System.getProperty("line.separator");
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while ((line = in.readLine()) != null) {
                sb.append(line + newLine);
            }
        } catch (FileNotFoundException ex) {
            return "File " + filename + " does not exist";
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
}
