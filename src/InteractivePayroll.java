import javax.swing.JOptionPane;
import java.util.Scanner;

public class InteractivePayroll {
    public static void main(String [] args){

        //runnign with while
        Scanner scanner = new Scanner(System.in);
        int userDecision = JOptionPane.showConfirmDialog(
                null,
                "Select Input Method:\n\nYes = GUI\nNo = Console",
                "Payroll",
                JOptionPane.YES_NO_CANCEL_OPTION
        );
        //declaring the calculation variables
        double userMonthlySalary = 0.00;
        double userBiweeklySalary = 0.00;
        double userweeklySalary = 0.00;
        double employeeWage = 0.00;
        double totalHoursWage = 0.00;

        boolean active = true;
        //Program surface

        //GUI
        if (userDecision == JOptionPane.YES_OPTION) {

            while (active) {
                //Initialize vairables

                String employeeName = JOptionPane.showInputDialog(
                        null,
                        "Enter your full names",
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

                try {

                    if (paymentType == JOptionPane.YES_OPTION) {
                        //user enter their salary here
                        try {
                            double employeeSalary = Double.parseDouble(JOptionPane.showInputDialog(
                                    null,
                                    "Enter Your annual salary:",
                                    "Employee Salary",
                                    JOptionPane.QUESTION_MESSAGE

                            ));


                            //calculating monthly bi-weekly , weekly salary
                            userMonthlySalary = (employeeSalary / 12);
                            userweeklySalary = (userMonthlySalary / 4.33);
                            userBiweeklySalary = (userweeklySalary*2) ;

                        } catch (NumberFormatException e) {
                            //null for not number input
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Invalid annual salary number only",
                                    "Error ",
                                    JOptionPane.ERROR
                            );
                            break;
                        } catch (NullPointerException e) {
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
                        final int normalHours = 40;
                        try {
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

                            if (employeeWorkHour == normalHours) {
                                //normal hours = 40
                                employeeWage = employeeWorkHour * employeeHourRate;

                            } else if (employeeWorkHour > normalHours) {
                                double extraTimeRate = 1.5;
                                //finding the difference
                                double extraHours = employeeWorkHour - normalHours;
                                //final etra hours amount
                                double extraHoursWage = extraHours * extraTimeRate; //output this
                                //total extra time earned
                                totalHoursWage = extraHoursWage * employeeHourRate;
                                employeeWage = employeeWorkHour * employeeHourRate; // for the output
                            } else if (employeeWorkHour < normalHours) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "No hours less than 40 hours\ntry again",
                                        "Hourly Error",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            } else {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Error orcured start",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE
                                );
                                break;
                            }
                        } catch (NullPointerException e) {
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
                                    "Full Names: %s\n " +
                                    "Employee ID: %s\n\n " +
                                    "----------------------------\n\n" +
                                    "SALARY EMPLOYEE\n\n" +
                                    "Monthly Salary:\tR %.2f\n " +
                                    "Bi-Weekly Salary:\tR %.2f\n " +
                                    "Week Salary:\tR %.2f\n\n " +
                                    "-------------------------------\n\n" +
                                    "HOURLY EMPLOYEE\n\n" +
                                    "Weekly amount(normal hours):\tR %.2f\n " +
                                    "Overtime amount:\tR %.2f ",
                            employeeName,
                            employeeId,
                            userMonthlySalary,
                            userBiweeklySalary,
                            userweeklySalary,
                            employeeWage,
                            totalHoursWage
                    );

                    JOptionPane.showMessageDialog(
                            null,
                            "" + summaryResults,
                            "Sumary Results",
                            JOptionPane.INFORMATION_MESSAGE

                    );

                } catch (NumberFormatException e) {
                    System.out.print("Error in first try" + e);
                    break;
                } finally {
                    //repetetive
                    int Decision = JOptionPane.showConfirmDialog(
                            null,
                            "Do you want to continue ?",
                            "Ending",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (Decision == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Thanks for using the Payrolls\n\nBye.",
                                "Thanks",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        break;
                    } else if (Decision == JOptionPane.YES_OPTION) {
                        continue;
                    }
                }
            }
        }
        //Console input
        else if (userDecision == JOptionPane.NO_OPTION) {

            while (active) {

                try {
                    System.out.print("Enter your full name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your ID: ");
                    String Id = scanner.nextLine();
                    System.out.print("Do you earn in Salary or hours:(Y=Salary | N=Hourly): ");
                    String paymentmethods = scanner.nextLine().toLowerCase();

                    if (name.isEmpty() || Id.isEmpty() || paymentmethods.isEmpty()) {
                        System.out.print("No empty input fill all the space\n");
                    } else {
                        if (paymentmethods.equals("y") || paymentmethods.equals("salary")) {
                            //yes input for salary
                            try {
                                System.out.print("Enter your annual salary: ");
                                double consoleAnnualSalary = scanner.nextDouble(); //output this
                                scanner.nextLine();

                                userMonthlySalary = (consoleAnnualSalary / 12);
                                userweeklySalary = (userMonthlySalary / 4.33);
                                userBiweeklySalary = (userweeklySalary * 2);

                                //testing output
                                //System.out.print(userweeklySalary);
                            } catch (NumberFormatException e) {
                                System.out.print("Invalid input, please only numbers\n");
                                active = false;
                            } catch (NullPointerException e) {
                                System.out.print("Enter something no empty input\n");
                                break;
                            }
                        } else if (paymentmethods.equals("n") || paymentmethods.equals("hourly")) {
                            //no input for hourly
                            final int normalHours = 40;
                            try {
                                System.out.print("Enter your working hours: ");
                                double workingHours = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Enter your hourly rate: ");
                                double hourlyRate = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("");
                                if (workingHours == normalHours) {

                                    employeeWage = workingHours * hourlyRate;
                                } else if (workingHours > normalHours) {
                                    double extraTimeRate = 1.5;

                                    double workingExtraHours = workingHours - normalHours;

                                    double workingHourFinal = workingExtraHours * extraTimeRate; //output

                                    totalHoursWage = workingHourFinal * hourlyRate;

                                    employeeWage = workingHours * hourlyRate;

                                } else if (workingHours < normalHours) {
                                    System.out.print("No hours less than 40 hours try again\n");
                                    break;
                                } else {
                                    System.out.print("Error occured\n");
                                    break;
                                }
                            } catch (NullPointerException e) {
                                System.out.print("Empty input not allowed\n");
                            }

                        } else {
                            System.out.print("Invalid input for Salary or hourly try again\n");
                            break;
                        }

                        String results = String.format(
                                "Full Names:\t %s\n" +
                                        "Employee ID:\t %s\n\n" +
                                        "----------------------------\n\n" +
                                        "SALARY EMPLOYEE\n\n" +
                                        "Monthly Salary:\tR %.2f\n" +
                                        "Bi-Weekly Salary:\tR %.2f\n" +
                                        "Week Salary:R %.2f\n\n" +
                                        "-------------------------------\n\n" +
                                        "HOURLY EMPLOYEE\n\n" +
                                        "Weekly amount(normal hours):\tR %.2f\n" +
                                        "Overtime amount:\tR %.2f ",
                                name,
                                Id,
                                userMonthlySalary,
                                userBiweeklySalary,
                                userweeklySalary,
                                employeeWage,
                                totalHoursWage
                        );

                        //outputting all
                        System.out.print(results + "\n\n");


                    }

                } catch (NumberFormatException e) {
                    System.out.print("Enter only values\n");
                }

                System.out.print("Do you want to continue?(1.Yes/2.No):");
                String recurring = scanner.nextLine().toLowerCase();

                if (recurring.equals("2") || recurring.equals("no")) {
                    System.out.print("Thanks for using the payroll\n\nBye.");
                    break;
                }
            }
        }
        //termination
        else {
            JOptionPane.showMessageDialog(
                    null,
                    "Thanks for Using our payroll",
                    "Closing",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }
}
