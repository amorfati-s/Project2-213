public class Company {

    private int numEmployee;
    private static final int CAPACITY = 4;
    private Employee[] emplist = new Employee[CAPACITY];
    private static final int NOT_FOUND = -1;
    private int empExists;


    private int find(Employee employee) {
        int flag = 0;
        for (int i = 0; i < numEmployee; i++) {
            if (emplist[i].getProfile().equals(employee.getProfile())) {
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


        empExists = find(employee);
        if (empExists == 1) {
            return false;
            //system print that the employee exits already and we cannot add another
        }
        if ((numEmployee + 1) <= emplist.length) {
            emplist[numEmployee] = employee;
        } else {
            this.grow();
            emplist[numEmployee] = employee;
        }
        numEmployee++;

        return true;
    } //check the profile before adding


    private int findIndex(Employee employee) {
        for (int i = 0; i < numEmployee; i++) {
            if (emplist[i].getProfile().equals(employee.getProfile())) {
                return i; //gives the index in the array
            }
        }
        return NOT_FOUND;
    }

    public boolean remove(Employee employee) {

        //find the profile if it exists and then remove it
        empExists = find(employee);
        int index = 0;
        if (empExists == 1) {
            index = findIndex(employee);
            for (int i = index; i < emplist.length - 1; i++) {
                emplist[i] = emplist[i + 1];
            }
            numEmployee--;
            return true;
        }
        return false;
    } //maintain the original sequence

    public boolean setHours(Employee employee) {
        //insert find method
        //if profile is found, we have a separate variable called hours that should be accessed by parttime and company? it is different from hourlyPay
        if (numEmployee == 0) {
            //system print employee database is empty
            return false;
        }
        if (employee instanceof Parttime) {
            empExists = findIndex(employee); //1 = true
            if (empExists >= 0) {//exists

                //the set hours from payroll works but the object loses its value of hourly rate which isn't good

                return true;
            }
            return false;
        }
        return false;
    } //set working hours for a part time

    public void processPayments() {
        //not sure how to bring calculatePayment() into here but that's what we need to do I think.
        if (numEmployee == 0) {
            //print out that the database is empty
        }

        if (numEmployee > 0) {
            for (int i = 0; i < numEmployee; i++) {
                if (emplist[i] instanceof Fulltime) {
                    if (emplist[i] instanceof Management) {
                        Management mngmntEmp = (Management) emplist[i];
                        mngmntEmp.calculatePayment();
                    } else {
                        Fulltime ftEmp = (Fulltime) emplist[i];
                        ftEmp.calculatePayment();
                    }
                } else if (emplist[i] instanceof Parttime) {
                    Parttime ptEmp = (Parttime) emplist[i];
                    ptEmp.calculatePayment();
                }
            }
        }

    } //process payments for all employees

    public void print() {

        if (numEmployee == 0) {
            System.out.println("Employee database is empty.");
        }
        if (numEmployee > 0) {
            System.out.println("--Printing earning statements for all employees--");
            for (int i = 0; i < numEmployee; i++) {
                System.out.println(emplist[i]);
            }
            System.out.println("--End of list.");
        }
    } //print earning statements for all employees

    public void printByDepartment() {

        Employee[] CSDept = new Employee[CAPACITY];
        Employee[] ECEDept = new Employee[CAPACITY];
        Employee[] ITDept = new Employee[CAPACITY];

        Employee[] empListCopy = new Employee[numEmployee];

        if (numEmployee == 0) {
            System.out.println("Employee database is empty.");
        }
        if (numEmployee > 0) {
            System.out.println("--Printing earning statements by department--");

            for (int i = 0; i < numEmployee; i++) {
                empListCopy[i] = emplist[i];
            }

            for (int i = 0; i < numEmployee; i++) {
                if (empListCopy[i].getProfile().getDepartment().equals("CS")) {

                    if ((numEmployee + 1) <= empListCopy.length) {
                        //empListCopy[numEmployee] = employee;
                        CSDept[i] = empListCopy[i];
                    } else {
                        this.grow();
                        CSDept[i] = empListCopy[i];
                    }
                    numEmployee++;
                    }
                else if (empListCopy[i].getProfile().getDepartment().equals("ECE")) {
                        ECEDept[i] = empListCopy[i];
                    }
                else if (empListCopy[i].getProfile().getDepartment().equals("CS")) {
                        ITDept[i] = empListCopy[i];
                    }
                }

            }

            for (int j = 0; j < numEmployee; j++) {
                System.out.println(CSDept[j]);
                System.out.println(ECEDept[j]);
                System.out.println(ITDept[j]);
            }
            System.out.println("--End of list.");

        }
    }//print earning statements by department

        public void printByDate () {


        } //print earning statements by date hired
    }
