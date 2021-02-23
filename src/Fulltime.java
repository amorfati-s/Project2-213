import java.text.DecimalFormat;

public class Fulltime extends Employee {

    private static final int payPeriod = 26;
    protected double payment;
    protected double annualSalary;

    public Fulltime(Profile profile, double annualSalary) {
        super(profile);
        this.annualSalary = annualSalary;
        payment = 0;

    }

    @Override
    public void calculatePayment() {
        payment = payment + (annualSalary / payPeriod);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fulltime) {
            Fulltime fulltime = (Fulltime) obj;
            return fulltime.getProfile().equals(this.getProfile());
        }
        return false;
    }

    @Override
    public String toString() {
        String pattern = "###,000.00";
        DecimalFormat df = new DecimalFormat(pattern);
        return String.format(super.toString() + "::Payment " + df.format(payment) + "::FULL TIME::Annual Salary $"
                + df.format(annualSalary));
    }
}