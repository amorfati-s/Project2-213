import java.text.DecimalFormat;

/**
 * This class defines the abstract data type Fulltime which encapsulates the
 * datd fields and methods for an employee.
 */
public class Fulltime extends Employee {

    private static final int payPeriod = 26;
    protected double payment;
    protected double annualSalary;

    /**
     * A two parameter constructor that intializes a fulltime object for an employee
     * when created.
     * 
     * @param profile
     * @param annualSalary
     */
    public Fulltime(Profile profile, double annualSalary) {
        super(profile);
        this.annualSalary = annualSalary;
        payment = 0;

    }

    /**
     * Calculates payment for a fulltime employee
     */
    @Override
    public void calculatePayment() {
        payment = payment + (annualSalary / payPeriod);
    }

    /**
     * Returns true if this employee profile is equal to the arguement employee
     * profile.
     *
     * @param obj the other employee
     * @return {@code true} if this fulltime employee has the same profile as the
     *         {@code obj}; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fulltime) {
            Fulltime fulltime = (Fulltime) obj;
            return fulltime.getProfile().equals(this.getProfile());
        }
        return false;
    }

    /**
     * Returns the string representation of full time.
     * 
     * @return returns the string representation for fulltime.
     */
    @Override
    public String toString() {
        String pattern = "###,000.00";
        DecimalFormat df = new DecimalFormat(pattern);
        return String.format(super.toString() + "::Payment " + df.format(payment) + "::FULL TIME::Annual Salary $"
                + df.format(annualSalary));
    }
}