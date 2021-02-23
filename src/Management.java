import java.text.DecimalFormat;

/**
 * This class defines the abstract data type Management which encapsulates the
 * data fields and methods for an employee.
 *
 */
public class Management extends Fulltime {

    private int role;
    private static final int MANAGER = 1;
    private static final int DEPT_HEAD = 2;
    private static final int DIRECTOR = 3;
    private double additionalComp;

    /**
     * This is a three parameter constructor that intializes a Management objet when
     * it is created.
     *
     * @param profile      attribute for a management object for an employee
     * @param annualSalary attribute for a management object for an employee
     * @param role         attribute for a management object for an employee
     */
    public Management(Profile profile, double annualSalary, int role) { // might have to change Date to a string ?? idk
                                                                        // if it'll work
        super(profile, annualSalary);
        this.role = role;
        if (role == 1) {
            additionalComp = 192.31;
        } else if (role == 2) {
            additionalComp = 365.38;
        } else if (role == 3) {
            additionalComp = 461.54;
        }
    }

    /**
     * Calculates payment for an employee with Management role.
     */
    public void calculatePayment() {
        super.calculatePayment();
        payment = payment + additionalComp;
    }

    /**
     * Returns a string representation of compensation for a management role.
     *
     * @return a string representation of compensation for a management role.
     */
    @Override
    public String toString() {
        return super.toString() + "::Manager Compensation $" + additionalComp;
    }

    /**
     * Compares name for an employee with management role.
     *
     * @param obj the other Management object
     * @return {@code true} if this management role employee has the same name as
     *         {@code obj} {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Management) {
            Management management = (Management) obj;
            return management.getProfile().getName().equals(this.getProfile().getName());

        }
        return false;
    }
}
