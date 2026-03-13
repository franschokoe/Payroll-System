import javax.swing.JOptionPane;
import java.util.Scanner;

public class InteractivePayroll {
    public static void main(String [] args){
        //Initialize vairables
        Scanner scanner = new Scanner(System.in);
        String employeeName = JOptionPane.showInputDialog(
                null,
                "Enter your name",
                "Employee Name",
                JOptionPane.INFORMATION_MESSAGE
        );
        String employeeNameScanner = scanner.nextLine();

        int employeeId;
        boolean paymentType;


    }
}
