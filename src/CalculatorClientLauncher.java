import java.rmi.Naming;

/**
 * Created by chris on 26/11/2016.
 */
public class CalculatorClientLauncher {

    public static void main(String[] args) {
        new CalculatorClientLauncher().launch();
    }

    private void launch() {
        try {
            CalculatorService calculatorService = (CalculatorService) Naming.lookup("calculator");
            System.out.println("13 + 29 = " + calculatorService.add(13, 29));
            System.out.println("79 - 53 = " + calculatorService.subtract(79, 53));
            System.out.println("17 * 31 = " + calculatorService.multiply(17, 31));
            System.out.println("31 / 11 = " + calculatorService.divide(31, 11));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}