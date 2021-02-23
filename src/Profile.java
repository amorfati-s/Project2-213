/**
 * This class defines the abstract data type Profile which encapsulates the data
 * field and methods for an employee.
 *
 * @author Siddhi Kasera, Sonal Madhok
 */

public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    // ARE WE USING THIS CONSTRUCTOR??
    public Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    /**
     * A three parameter Profile Constructor that initializes an Profile object when
     * it is created.
     *
     * @param name       attribute for an employee
     * @param department attribute for an employee in the dept they work
     * @param date       attribute for an employee when they were hired.
     */
    public Profile(String name, String department, String date) {
        this.name = name;
        this.department = department;
        dateHired = new Date(date);
    }

    /**
     * Returns a String representation of profile
     *
     * @return a string representation of profile
     */
    @Override
    public String toString() {
        return (name + "::" + department + "::" + dateHired);
    }

    /**
     * Returns true if this profile for an employee is equal is equal to the
     * argument profile.
     *
     * @param obj the other employee profile
     * @return {@code true} if this profile for an employee is sames as {@code obj}
     *         {@code false} otherwise
     */

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profile) {
            Profile profile = (Profile) obj;
            return this.name.equals(profile.name);
            // return this.profile.equals(profile)
        }
        return false;
    }

    /**
     * Returns the name for a profile of an employee.
     *
     * @return name attribute for a profile of an employee
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the department for a profile of an employee.
     *
     * @return department for a profile of an employee
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Returns the date hired for a profile of an employee.
     *
     * @return date hired for a profile of an employee
     */
    public Date getDateHired() {
        return this.dateHired;
    }

}