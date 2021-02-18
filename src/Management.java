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
