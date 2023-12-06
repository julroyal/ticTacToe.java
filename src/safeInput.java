import java.sql.SQLOutput;
import java.util.Scanner;
public class safeInput {
    public static int getRangedInt(Scanner scanner, String enterYourMove, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + enterYourMove + "[" + low + "-" + high + "]: ");
            if (scanner.hasNextInt()) {
                retVal = scanner.nextInt();
                scanner.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = scanner.nextLine();
                System.out.println("You must enter a valid number: " + trash);
            }
        } while (!done);
        return retVal;
    }
    public static boolean getYNConfirm(Scanner scanner, String prompt) {
        String response = "";
        while(true){
            System.out.print("\n" + prompt + " [Y/N] ");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                return true;
            } else if (response.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("You must answer [Y/N]! Not " + response);
            }
        }
    }
}