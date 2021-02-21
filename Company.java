public class Company {
    private Employee[] emplist;
    private int numEmployee;
    private static final int CAPACITY = 4;
    private static final int NOT_FOUND = -1;

    private int find(Employee employee) {
        int flag = 0;
        for (int i = 0; i < numEmployee; i++) {
            if (emplist[i].getProfile().getName().equals(employee.getProfile().getName())) {
                flag = 1;
                return flag;
            }
        }
        flag = 0;
        return flag;
    }

    private void grow() {
        int oldLength = emplist.length;
        int newLength = oldLength + CAPACITY;
        Employee[] newEmployee = new Employee[newLength];
        for (int i = 0; i < oldLength; i++) {
            newEmployee[i] = emplist[i];
        }
        emplist = newEmployee;
    }

    public boolean add(Employee employee) {



        return false;
    } //check the profile before adding

    public boolean remove(Employee employee) {
        return false;
    } //maintain the original sequence

    public boolean setHours(Employee employee) {

        //insert find method
        //if profile is found, we have a separate variable called hours that should be accessed by parttime and company? it is different from hourlyPay


        return false;
    } //set working hours for a part time

    public void processPayments() {

        //not sure how to bring calculatePayment() into here but that's what we need to do I think.


    } //process payments for all employees

    public void print() {
    } //print earning statements for all employees

    public void printByDepartment() {
    } //print earning statements by department

    public void printByDate() {
    } //print earning statements by date hired
}
