public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    public Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    public Profile(String name, String department, String date) {
        this.name = name;
        this.department = department;
        dateHired = new Date(date);
    }



    @Override
    public String toString() {
        return (name + "::" + department + "::" + String.valueOf(dateHired.getMonth()) + "/" + String.valueOf(dateHired.getDay()) + "/" + String.valueOf(dateHired.getYear()));
    }


    @Override
    public boolean equals(Object obj){
        if(obj instanceof Profile){
            Profile profile = (Profile) obj;
            if (this.name.equals(profile.name) && this.department.equals(profile.department) && this.dateHired.compareTo(profile.dateHired) == 0) {
                return true;
            }
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
