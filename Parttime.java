import java.text.DecimalFormat;

public class Parttime extends Employee {

    protected float hoursWorked;
    protected double hourlyPay;
    protected double payment;

    public Parttime(Profile profile, double hourlyPay) {
        super(profile);
        this.hourlyPay = hourlyPay;
        payment = 0;
    }

    public Parttime(Profile profile, float hoursWorked) {
        super(profile);
        this.hoursWorked = hoursWorked;
        //payment = 0;
    }

    public void setHours(float hoursWorked) {
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
            return parttime.getProfile().getName().equals(this.getProfile().getName());
        }
        return false;
    }

    @Override
    public String toString() {
        String pattern = "###,000.00";
        DecimalFormat df = new DecimalFormat(pattern);
        return super.toString() + "::Payment " + df.format(payment) + "::PART TIME:: Hourly Rate $" + df.format(hourlyPay) + "::Hours worked this period: " + hoursWorked;
    }

}


    /*public Parttime(int hourlyPay, String manager, String deptHead, String director) {
        //super(manager,deptHead,director);
        this.hourlyPay = hourlyPay;
    }

     */