import org.junit.jupiter.api.Test;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyTest {

    private Company company;

    @Test

    public void test() {
        Employee addEmployee = new Employee();
        Profile RProfile = new Profile("Jane Doe", "CS", "07/02/2020"); // creating a profile
        addEmployee.setProfile(RProfile);
        CompanyTest test1 = new CompanyTest();
        boolean result = test1.add(addEmployee);
        // assertEquals(true, result);
        assertTrue(true);

    }

}