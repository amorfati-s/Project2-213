public class Fulltime extends Employee{
    public String manager;
    public  String deptHead;
    public  String director;
    private static final int payPeriod = 26;

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
    public void calculatePayment(){


    }

 */
        /*
        @Override
        public boolean equals(Object obj){
        }*/


}