import java.rmi.Naming;

/**
 * Created by chris on 26/11/2016.
 */
public class FileClientLauncher {

    public static void main(String[] args) {
        new FileClientLauncher().launch();
    }

    private void launch() {
        try {
            FileService fileService = (FileService) Naming.lookup("file");
            System.out.println(fileService.accessFile("/Users/chris/Desktop/copyOfGui.txt"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}