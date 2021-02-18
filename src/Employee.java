public class Employee{
    private Profile profile;
    private double payment;

    public Employee(){
        this.profile = new Profile(null, null, null);
        this.payment =0;
    }
    public Employee(String name, String department, Date dateHired){
        this.profile = new Profile(name, department,dateHired);
        this.payment = 0;
    }
    public Profile getProfile(){
        return this.profile;
    }
    /*
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Employee){
            Employee employee = (Employee) obj;
            return Objects.equals(this.getName(), employee.getName());
        }
        return false;
    }
     */
}

