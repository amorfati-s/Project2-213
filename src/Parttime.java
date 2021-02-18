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