public class Employee {
    private Profile profile;
    private double payment;

    public Employee() {

    }

    public Employee(Profile profile) {
        this.profile = profile;
        this.payment = 0;
    }


    public Profile getProfile() {
        return this.profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void calculatePayment() {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee employee = (Employee) obj;
            return employee.profile.equals(this.profile);
        }
        return false;
    }

    public String toString() {
        return profile.toString();
    }

}
