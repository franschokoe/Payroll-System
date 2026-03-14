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
//        String employeeNameScanner = scanner.nextLine();

        //runnign with while
        boolean active = true;
        while(active){
            try{
                if (paymentType == JOptionPane.YES_OPTION){
                    //user enter their salary here
                    try{
                        double employeeSalary = Double.parseDouble(JOptionPane.showInputDialog(
                                null,
                                "Enter Your annual salary:",
                                "Employee Salary",
                                JOptionPane.QUESTION_MESSAGE

                        ));
                        //input scanner for double
                        //double userSalary = scanner.nextDouble();

                        //calculating monthly bi-weekly , weekly salary
                        double userMonthlySalary = (employeeSalary/12); //output this
                        double userBieeklySalary = (userMonthlySalary / 31)* 14;
                        double userweeklySalary  = (userMonthlySalary/31)*7;

                    }catch (NumberFormatException e){
                        //null for not number input
                        JOptionPane.showMessageDialog(
                                null ,
                                "Invalid annual salary number only",
                                "Error ",
                                JOptionPane.ERROR
                        );
                        break;
                    }catch (NullPointerException e){
                        //error for null input
                        JOptionPane.showMessageDialog(
                                null,
                                "Please enter some value",
                                "Error",
                                JOptionPane.ERROR
                        );
                        break;
                    }

                } else if (paymentType == JOptionPane.NO_OPTION) {
                    // hourly employee sections
                    try{
                        double employeeWorkHour = Double.parseDouble(JOptionPane.showInputDialog(
                                null,
                                "Enter your woking hours",
                                "Employee Hours",
                                JOptionPane.QUESTION_MESSAGE
                        ));
                        double employeeHourRate = Double.parseDouble(JOptionPane.showInputDialog(
                                null,
                                "Enter your hourly rate",
                                "Employee Hours",
                                JOptionPane.QUESTION_MESSAGE
                        ));
                        // checking the number of hours to detect the extra hours
                        final int normalHours = 40;
                        if(employeeWorkHour == normalHours){
                            //normal hours = 40
                            double employeeWage = employeeWorkHour * employeeHourRate ; //output this

                        }
                        else if (employeeWorkHour > normalHours){
                            double extraTimeRate = 1.5;
                            //finding the difference
                            double extraHours = employeeWorkHour - normalHours;
                            //final etra hours amount
                            double extraHoursWage = extraHours * extraTimeRate; //output this
                        }
                    }
                    catch(NullPointerException e){
                        //catch for hours
                        JOptionPane.showMessageDialog(
                                null,
                                "INvalid Error enter something",
                                "Hourly Errors",
                                JOptionPane.ERROR
                        );
                    }
                }
                //results section in a formated way
                String summaryResults = String.format(
                        ""
                );
            }
            catch (NumberFormatException e){
                System.out.print("Error in first try" + e);
                break;
            }
        }
    }
}
