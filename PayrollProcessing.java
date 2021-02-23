import java.awt.*;
import java.util.Scanner;

//I will edit this tomorrow

/**
 * This class processes the commands entered in the command line.
 *
 * @author Siddhi Kasera, Sonal Madhok
 **/

public class PayrollProcessing {
    Scanner in = new Scanner(System.in);
    Company companyDB = new Company();
    public static String name;
    public static String deptName;
    public static String dateHiredStr;
    public static double annualSalary;
    private final int MANAGER_ROLE = 1;
    private final int DEPT_HEAD_ROLE = 2;
    private final int DIRECTOR_ROLE = 3;
    private final String CS_DEPT = "CS";
    private final String ECE_DEPT = "ECE";
    private final String IT_DEPT = "IT";
    private final int DEF_VAL = 0;
    private int numEmployee;
    Employee employee = new Employee();
    Date date = new Date();

    /**
     * This method reads from the command line, parses the input and calls the respective functions.
     */
    public void run() {
        System.out.println("Payroll Processing starts.");
        //Declare/Initialize variables
        String command = "";
        String line = null;
        boolean hasNextLine = in.hasNext();

        //Using Scanner for Getting input from user
        while (hasNextLine) {
            line = in.nextLine(); //nextLine reads
            String[] arrOfStr = line.split(" "); //Tokenizing the array from the Scanner
            command = arrOfStr[0];

            switch (command) {
                case "AF":  //handling command add
                    name = arrOfStr[1];
                    deptName = arrOfStr[2];
                    dateHiredStr = arrOfStr[3];
                    annualSalary = Double.parseDouble(arrOfStr[4]);
                    Profile AFProfile = new Profile(name, deptName, dateHiredStr);
                    Fulltime fulltimeEmp = new Fulltime(AFProfile, annualSalary);

                    if (annualSalary < 0) {
                        System.out.println("Salary cannot be negative.");
                    } else if (AFProfile.getDateHired().isValid()) {
                        if (companyDB.add(fulltimeEmp)) {
                            System.out.println("Employee added.");
                        } else {
                            System.out.println("Employee is already in the list.");
                        }

                    } else {
                        System.out.println(fulltimeEmp.getProfile().getDateHired() + " is not a valid date!");
                    }
                    break;
                case "AP":  //handling command add
                    name = arrOfStr[1];
                    deptName = arrOfStr[2];
                    dateHiredStr = arrOfStr[3];
                    Double hourlyPay = Double.parseDouble(arrOfStr[4]);
                    Profile APProfile = new Profile(name, deptName, dateHiredStr);
                    Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);

                    if (annualSalary < 0) {
                        System.out.println("Salary cannot be negative.");

                    } else if (APProfile.getDateHired().isValid()) {
                        if (companyDB.add(parttimeEmp)) {
                            System.out.println("Employee added.");
                        } else {
                            System.out.println("Employee is already in the list.");
                        }

                    } else {
                        System.out.println(String.valueOf(parttimeEmp.getProfile().getDateHired()) + " is not a valid date!");
                    }
                    break;

                case "AM":  //handling command add
                    name = arrOfStr[1];
                    deptName = arrOfStr[2];
                    dateHiredStr = arrOfStr[3];
                    annualSalary = Double.parseDouble(arrOfStr[4]);
                    int role = Integer.parseInt(arrOfStr[5]);
                    Profile AMProfile = new Profile(name, deptName, dateHiredStr);
                    Management mngmntEmp = new Management(AMProfile, annualSalary, role);

                    if (role > 3) {
                        System.out.println("Invalid management code.");
                    } else if (annualSalary < 0) {
                        System.out.println("Salary cannot be negative.");

                    } else if (AMProfile.getDateHired().isValid()) {
                        if (companyDB.add(mngmntEmp)) {
                            System.out.println("Employee added.");
                        } else {
                            System.out.println("Employee is already in the list.");
                        }
                    } else {
                        System.out.println(String.valueOf(mngmntEmp.getProfile().getDateHired()) + " is not a valid date!");
                    }
                    break;

                case "R":  //handling command remove employee
                    name = arrOfStr[1];
                    deptName = arrOfStr[2];
                    dateHiredStr = arrOfStr[3];
                    Profile RProfile = new Profile(name, deptName, dateHiredStr);
                    Employee removeEmp = new Employee(RProfile);
                    if (companyDB.remove(removeEmp)) {
                        System.out.println("Employee removed.");
                    } else if (numEmployee == 0) {
                        System.out.println("Employee database is empty.");
                    } else {
                        System.out.println("Employee does not exist.");
                    }
                    break;


                case "C": //handling commmand calculate
                    numEmployee = companyDB.getNumEmployee();
                    if (numEmployee == 0) {
                        System.out.println("Employee database is empty.");
                    }
                    companyDB.processPayments();
                    System.out.println("Calculation of employees is done.");
                    break;

                case "S": //handling setHours command for part time employee
                    name = arrOfStr[1];
                    deptName = arrOfStr[2];
                    dateHiredStr = arrOfStr[3];
                    double hours = Double.parseDouble(arrOfStr[4]);
                    Profile setHrsProfile = new Profile(name, deptName, dateHiredStr);
                    Parttime setHrsEmp = new Parttime(setHrsProfile);
                    numEmployee = companyDB.getNumEmployee();

                    if (numEmployee == 0) {
                        System.out.println("Employee database is empty.");
                    } else if (hours < 0) {
                        System.out.println("Working hours cannot be negative.");
                    } else if (hours > 100) {
                        System.out.println("Invalid hours: over 100.");
                    } else {
                        if (companyDB.setHours(setHrsEmp)) {
                            setHrsEmp.setHours(hours);
                            System.out.println("Working hours set.");
                        }
                    }

                    break;

                case "PA":  //printing the list of books
                    companyDB.print();
                    break;

                case "PH": //printing the list of books by date
                    companyDB.printByDate();
                    break;

                case "PD": //printing the list of books by serial number
                    companyDB.printByDepartment();
                    break;

                case "Q": //exiting a kiosk session
                    System.out.println("Payroll Processing completed.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Command " + "'" + line + "'" + " is not supported!");
                    break;
            }
        }

    }
}
