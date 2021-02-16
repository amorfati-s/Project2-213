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

    /*
    @Override
    public boolean equals(Object obj){
    }
*/

    public class Employee extends Profile {
        //super(name,department,dateHired);

    }

    public class Fulltime extends Employee{
       public String manager;
       public  String deptHead;
       public  String director;

        public Fulltime(String manager, String deptHead, String director){
            this.manager = manager;
            this.deptHead = deptHead;
            this.director = director;
        }
        @Override
        public String toString() {
            return ("Manager: " + manager + "department head" + deptHead + "director" + director);
        }
        /*
        @Override
        public boolean equals(Object obj){
        }*/


    }
    public class Parttime extends Employee{
        public int hourlyPay;
        public Parttime(int hourlyPay, String manager, String deptHead, String director){
            //super(manager,deptHead,director);
            this.hourlyPay = hourlyPay;
        }
        @Override
        public String toString() {
            return ("Hourly pay : " + hourlyPay);
        }
        /*
        @Override
        public boolean equals(Object obj){
        }*/

    }
    public class Management extends Fulltime{

        public Management(String manager, String deptHead, String director) {
            super(manager, deptHead, director);
        }
        @Override
        public String toString() {
            return ("Manager: " + manager + "department head" + deptHead + "director" + director);
        }

        /*
        @Override
        public boolean equals(Object obj){
        }*/
    }



}


