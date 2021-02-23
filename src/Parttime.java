import java.text.DecimalFormat;

/**
 * This class defines the abstract data type Parttime which encapsulates the
 * data and methods for a parttime employee.
 *
 * @author Siddhi Kasera, Sonal Madhok
 *
 */
public class Parttime extends Employee {

    protected float hoursWorked;
    protected double hourlyPay;
    protected double payment;

    /**
     * This is a two parameter constructor that intializes an object profile when it
     * is created.
     * 
     * @param profile   attribute of an employee that is defined in profile class
     * @param hourlyPay employees payment
     */
    public Parttime(Profile profile, double hourlyPay) {
        super(profile);
        this.hourlyPay = hourlyPay;
        payment = 0;
    }

    /**
     * this is a two parameter constructor that intializes an object profile when it
     * is created.
     *
     * @param profile     attribute of an employee that is defined in profile class.
     * @param hoursWorked hours a parttime employee has worked.
     */
    public Parttime(Profile profile, float hoursWorked) {
        super(profile);
        this.hoursWorked = hoursWorked;
        // payment = 0;
    }
    // ARE WE USING THIS??

    public void setHours(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /// ARE WE USING THIS?
    public double getHours() { // idk if this getter will be needed yet
        return hoursWorked;
    }

    /**
     * Calculates the payment for a parttime employee based on their hoursWorked and
     * hourlyPay
     */
    public void calculatePayment() {
        double MAX_HOURS = 80;
        double OVERTIME_RATE = 1.5;
        if (hourlyPay <= MAX_HOURS) {
            payment = payment + hoursWorked * hourlyPay;
        } else {
            payment = payment + MAX_HOURS * hourlyPay;
            payment = payment + OVERTIME_RATE * (hoursWorked - MAX_HOURS) * hourlyPay;
        }

    }

    /**
     * Compared the name attributes from a parttime employee's profile.
     * 
     * @param obj the other employee
     * @return {@code true} if this name for an employee is same as {@code obj}
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Parttime) {
            Parttime parttime = (Parttime) obj;
            return parttime.getProfile().getName().equals(this.getProfile().getName());
        }
        return false;
    }

    /**
     * Returns the string representation of parttime employee attributes.
     *
     * @return String representation of parttime employee attributes.
     */
    @Override
    public String toString() {
        String pattern = "###,000.00";
        DecimalFormat df = new DecimalFormat(pattern);
        return super.toString() + "::Payment " + df.format(payment) + "::PART TIME:: Hourly Rate $"
                + df.format(hourlyPay) + "::Hours worked this period: " + hoursWorked;
    }

}
