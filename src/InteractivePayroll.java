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

        String employeeId = JOptionPane.showInputDialog(
                null,
                "Enter your id",
                "Employeee Id",
                JOptionPane.QUESTION_MESSAGE
                //if statement to control the digits entered
        );

        int paymentType = JOptionPane.showConfirmDialog(
                null,
                "Is your payment in a form of a salary?",
                "Payment Type",
                JOptionPane.YES_NO_OPTION
                //if yes the we continue to salary calculation
                //with no we contnue to hourly calculation
        );
        //for scanner
        String employeeNameScanner = scanner.nextLine();

        //runnign with while
        boolean active = true;
        while(active){
            try{
                if (paymentType == JOptionPane.YES_OPTION){
                    //user enter their salary here
                    double employeeSalary = Double.parseDouble(JOptionPane.showInputDialog(
                            null,
                            "Enter Your annual salary:",
                            "Employee Salary",
                            JOptionPane.QUESTION_MESSAGE

                    ));
                    //calculating monthly bi-weekly , weekly salary
                    double userMonthlySalary =
                    //input scanner for double
                    double userSalary = scanner.nextDouble();
                }
            }catch (NumberFormatException e){
                System.out.print("Error in first try" + e);
            }
        }
    }
}
