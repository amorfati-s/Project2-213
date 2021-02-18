public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    public Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    Profile() {
    }

    @Override
    public String toString() {
        return ("Employee name: " + name + "department" + department + "date hired" + dateHired);
    }


    @Override
    public boolean equals(Object obj){
        if(obj instanceof Profile){
            Profile profile = (Profile) obj;
            return this.name.equals(profile.name);
        }
        return false;
    }


    public String getName(){
        return this.name;
    }
    public String getDepartment(){
        return this.department;
    }

    public Date getDateHired(){
        return this.dateHired;
    }




}


