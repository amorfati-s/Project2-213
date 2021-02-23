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

    public int getNumEmployee() {
        return numEmployee;
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

                //emplist[empExists]

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


    private void selectionSort(String[] array) {
        for ( int j=0; j < array.length-1; j++ )
        {
            // Find min: the index of the string reference that should go into cell j.
            // Look through the unsorted strings (those at j or higher) for the one that is first in lexicographic order
            int min = j;
            for ( int k=j+1; k < array.length; k++ )
                if ( array[k].compareTo( array[min] ) < 0 ) min = k;

            // Swap the reference at j with the reference at min
            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }

    }


    public void printByDepartment() {

        //maybe create a compareTo for the string departments
        /*Employee[] CSDept = new Employee[CAPACITY];
        Employee[] ECEDept = new Employee[CAPACITY];
        Employee[] ITDept = new Employee[CAPACITY];

         */

        String[] arrayOfDept = new String[numEmployee];
        int j = 0;

        if (numEmployee == 0) {
            System.out.println("Employee database is empty.");
        }
        if (numEmployee > 0) {
            System.out.println("--Printing earning statements by department--");

            for (int i = 0; i < numEmployee; i++) {
                arrayOfDept[i] = emplist[i].getProfile().getDepartment();
            }

            selectionSort(arrayOfDept);

            for (String element : arrayOfDept) {
                for (int i = 0; i < arrayOfDept.length; i++) {
                if (element == String.valueOf(emplist[i].getProfile().getDepartment())) {
                    System.out.println(emplist[i]);
                }
                }
            }

            /*
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

             */

            }
            System.out.println("--End of list.");

        }
    //print earning statements by department

    private void sortByDate(Employee[] sortDate) {

        for (int i = 0; i < numEmployee - 1; i++) {
            int index = i;
            for (int j = i + 1; j < numEmployee; j++) {
                if (sortDate[i + 1] == null) {
                    break;
                }
                if (sortDate[j].getProfile().getDateHired().compareTo((sortDate[index].getProfile().getDateHired())) == -1) {
                    index = j;
                }
            }
            Employee olderEmp = sortDate[index];
            sortDate[index] = sortDate[i];
            sortDate[i] = olderEmp;
        }

    }

        public void printByDate () {

            Employee[] sortDate = new Employee[emplist.length];

            if (numEmployee == 0) {
                System.out.println("Library catalog is empty!");
            }
            if (numEmployee > 0) {
                System.out.println("**List of books by the date published.");
                for (int i = 0; i < numEmployee; i++) {
                    sortDate[i] = emplist[i];
                }
                sortByDate(sortDate);
                for (int i = 0; i < numEmployee; i++) {
                    System.out.println(sortDate[i]);
                }
                System.out.println("**End of list.");
            }

        } //print earning statements by date hired
    }
