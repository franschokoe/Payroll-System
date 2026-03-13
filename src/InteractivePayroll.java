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
                JOptionPane.QUESTION_MESSAGE
        );

        int employeeId = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "Enter your id",
                "Employeee Id",
                JOptionPane.QUESTION_MESSAGE
        ));

        boolean paymentType = JOptionPane.showConfirmDialog(
                null,
                "Type of payment (Hourly or Salary)",
                "Payment Type",
                JOptionPane.QUESTION_MESSAGE
        );
        //for scanner
        String employeeNameScanner = scanner.nextLine();

    }
}
