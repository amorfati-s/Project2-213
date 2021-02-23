import java.text.DecimalFormat;

public class Parttime extends Employee {

    private double hoursWorked;
    private double hourlyPay;
    protected double payment;

    public Parttime(Profile profile, double hourlyPay) {
        super(profile);
        this.hourlyPay = hourlyPay;
        payment = 0;
    }

    public Parttime(Profile profile){
        super(profile);
    }

    public void setHours(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHours() { //idk if this getter will be needed yet
        return hoursWorked;
    }


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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Parttime) {
            Parttime parttime = (Parttime) obj;
            return parttime.getProfile().equals(this.getProfile()); //used to be getprofile.getname
        }
        return false;
    }

    @Override
    public String toString() {
        String pattern = "###,##0.00";
        DecimalFormat df = new DecimalFormat(pattern);
        return super.toString() + "::Payment $" + df.format(payment) + "::PART TIME::Hourly Rate $" + df.format(hourlyPay) + "::Hours worked this period: " + hoursWorked;
    }

}
