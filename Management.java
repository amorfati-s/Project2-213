import java.text.DecimalFormat;

public class Management extends Fulltime {

    private int role;
    private static final int MANAGER = 1;
    private static final int DEPT_HEAD = 2;
    private static final int DIRECTOR = 3;
    private String roleStr;
    private double additionalComp;

    public Management(Profile profile, double annualSalary, int role) { //might have to change Date to a string ?? idk if it'll work
        super(profile, annualSalary);
        this.role = role;
        if (role == 1) {
            additionalComp = 192.31;
            roleStr = "Manager";
        } else if (role == 2) {
            additionalComp = 365.38;
            roleStr = "Department Head";
        } else if (role == 3) {
            additionalComp = 461.54;
            roleStr = "Director";
        }
    }

    public void calculatePayment() {
        super.calculatePayment();
        payment = payment + additionalComp;
    }

    @Override
    public String toString() {
        return super.toString() + "::" + roleStr + " Compensation $" + additionalComp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Management) {
            Management management = (Management) obj;
            return management.getProfile().getName().equals(this.getProfile().getName());

        }
        return false;
    }
}
  
