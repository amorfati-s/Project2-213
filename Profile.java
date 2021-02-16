public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    public Profile (String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }


    @Override
    public String toString() {
        return null;
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    } //compare name, department and dateHired
}