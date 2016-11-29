import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by chris on 29/11/2016.
 */
public class LoginClientLauncher {

    public static void main(String[] args) {
        new LoginClientLauncher().launch();
    }
    
    private void launch() {
        try {
            LoginService loginService = (LoginService) Naming.lookup("login");
            System.out.println();
            System.out.println("claire logging in: " + loginService.logIn("claire", "clairePassword"));
            System.out.println("amy logging in: " + loginService.logIn("amy", "amyPassword"));
            System.out.println("beth logging in: " + loginService.logIn("beth", "bethPassword"));
            System.out.println("sid logging in: " + loginService.logIn("sid", "sidPassword"));
            System.out.println("claire logging out: " + loginService.logOut("claire", "clairePassword"));
            System.out.println("ella logging in " + loginService.logIn("ella", "wrongPassword"));
            System.out.println("demi logging in " + loginService.logIn("demi", "demiPassword"));
            System.out.println("ella logging in " + loginService.logIn("ella", "ellaPassword"));
            System.out.println();
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}