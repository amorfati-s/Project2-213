/**
 * This class implements all the main methods.
 *
 * @author Siddhi Kasera, Sonal Madhok
 */
public class Company {
    private int numEmployee;
    private static final int CAPACITY = 4;
    private Employee[] emplist = new Employee[CAPACITY];
    private static final int NOT_FOUND = -1;
    private int empExists;

    /**
     * Private method is looks for an employee in an array.
     *
     * @param employee object that has to be found from the array
     * @return return 1 if an employee is there in the array and 0 when the employee
     *         is not there
     */
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

    /**
     * This method resizes the array by increasing the size by four everytime this
     * method called.
     */
    private void grow() {
        int oldLength = emplist.length;
        int newLength = oldLength + CAPACITY;
        Employee[] newEmployee = new Employee[newLength];
        for (int i = 0; i < oldLength; i++) {
            newEmployee[i] = emplist[i];
        }
        emplist = newEmployee;
    }

    /**
     * This method checks if an employee's profile already exists or not before they
     * are added to the array.
     *
     * @param employee object that has to be added in the array
     */
    public boolean add(Employee employee) {

        empExists = find(employee);
        if (empExists == 1) {
            return false;
            // system print that the employee exits already and we cannot add another
        }
        if ((numEmployee + 1) <= emplist.length) {
            emplist[numEmployee] = employee;
        } else {
            this.grow();
            emplist[numEmployee] = employee;
        }
        numEmployee++;

        return true;
    }

    /**
     * This is a helper method that traverses the employee array and returns the
     * index for the employee in the array.
     *
     * @param employee object that is to be found in the array
     * @return index number if the employee is found -1 otherwise
     */

    private int findIndex(Employee employee) {
        for (int i = 0; i < numEmployee; i++) {
            if (emplist[i].getProfile().equals(employee.getProfile())) {
                return i; // gives the index in the array
            }
        }
        return NOT_FOUND;
    }

    /**
     * Gets the number of employee in the array.
     *
     * @return the number of employee in the array.
     */
    public int getNumEmployee() {
        return numEmployee;
    }

    /**
     * Removes the employee from the array emplist
     *
     * @param employee object that has to be removed from the array.
     * @return true if the employee is successfully removed and false if it is not
     */
    public boolean remove(Employee employee) {

        // find the profile if it exists and then remove it
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
    } // maintain the original sequence

    /**
     * Sets hours for a parttime employee
     *
     * @param employee object whose hours have to be set
     * @return true if the hours is successfully set else false.
     */
    public boolean setHours(Employee employee) {
        // insert find method
        // if profile is found, we have a separate variable called hours that should be
        // accessed by parttime and company? it is different from hourlyPay
        if (numEmployee == 0) {
            // system print employee database is empty
            return false;
        }
        if (employee instanceof Parttime) {
            empExists = findIndex(employee); // 1 = true
            if (empExists >= 0) {// exists

                // emplist[empExists]

                return true;
            }
            return false;
        }
        return false;
    } // set working hours for a part time

    /**
     * Calculates payments for employee based on their role
     *
     */
    public void processPayments() {
        // not sure how to bring calculatePayment() into here but that's what we need to
        // do I think.
        if (numEmployee == 0) {
            // print out that the database is empty
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

    } // process payments for all employees

    /**
     * Prints the employees working in the company.
     */
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
    } // print earning statements for all employees

    /**
     * helper method implementing selection sort algorithm
     *
     * @param array WHAT ARE YOU STORING IN THE ARRAY??
     */
    private void selectionSort(String[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            // Find min: the index of the string reference that should go into cell j.
            // Look through the unsorted strings (those at j or higher) for the one that is
            // first in lexicographic order
            int min = j;
            for (int k = j + 1; k < array.length; k++)
                if (array[k].compareTo(array[min]) < 0)
                    min = k;

            // Swap the reference at j with the reference at min
            String temp = array[j];
            array[j] = array[min];
            array[min] = temp;
        }

    }

    /**
     * prints the earning statements by department
     *
     */
    public void printByDepartment() {

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

        }
        System.out.println("--End of list.");

    }

    /**
     * Helper method to sort the dates in ascending order
     *
     * @param sortDate is a copy of the book array so it doesn't affect the actual
     *                 positions in the emplist array
     */
    private void sortByDate(Employee[] sortDate) {

        for (int i = 0; i < numEmployee - 1; i++) {
            int index = i;
            for (int j = i + 1; j < numEmployee; j++) {
                if (sortDate[i + 1] == null) {
                    break;
                }
                if (sortDate[j].getProfile().getDateHired()
                        .compareTo((sortDate[index].getProfile().getDateHired())) == -1) {
                    index = j;
                }
            }
            Employee olderEmp = sortDate[index];
            sortDate[index] = sortDate[i];
            sortDate[i] = olderEmp;
        }

    }

    /**
     * Prints earning statements by date hired.
     */
    public void printByDate() {

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

    }
}
