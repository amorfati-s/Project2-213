import org.junit.jupiter.api.Test;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    // company = new Company();

    /*
     * @BeforeEach public void setUp() throws Exception{ company= new Company(); }
     */

    @Test

    public void testAdd() {
        Company company = new Company();

        Double hourlyPay = Double.parseDouble(String.valueOf(45.9));
        Profile APProfile = new Profile("Doe,Jane", "CS", "7/1/2005");
        Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);
        assertTrue(company.add(parttimeEmp)); // Test case#1: testing to add an employee with a part time role

        Double hourlyPay1 = Double.parseDouble(String.valueOf(35.9));
        Profile APProfile1 = new Profile("Doe,Jane", "CS", "7/1/2005");
        Parttime parttimeEmp1 = new Parttime(APProfile1, hourlyPay1);
        assertFalse(company.add(parttimeEmp1)); // Test case#2: testing to add an already existing employee.

        Profile AFProfile = new Profile("Doe,Jane", "ECE", "7/1/2020");
        Fulltime fulltimeEmp = new Fulltime(AFProfile, 850000);
        assertTrue(company.add(fulltimeEmp)); // Test case#3: testing to add an employee wuth a full time role

        int role = Integer.parseInt(String.valueOf(1));
        Profile AMProfile = new Profile("Doe,Jane", "IT", "2/28/2012");
        Management mngmntEmp = new Management(AMProfile, 85000, role);
        assertTrue(company.add(mngmntEmp)); // Test case#4: testing to add an employee with a manager role.

        int role2 = Integer.parseInt(String.valueOf(3));
        Profile AMProfile2 = new Profile("Doe,Jane", "ECE", "2/28/2012");
        Management mngmntEmp2 = new Management(AMProfile2, 96756, role2);
        assertTrue(company.add(mngmntEmp2)); // Test case#5: testing to add an employee with the role of Director

    }

    @Test
    public void testRemove() {
        Company company = new Company();

        Double hourlyPay = Double.parseDouble(String.valueOf(45.9));
        Profile APProfile = new Profile("Doe,Jane", "CS", "7/1/2005");
        Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);
        assertFalse(company.remove(parttimeEmp)); // Test case#1: testing to remove an employee that does not exist.
        assertTrue(company.add(parttimeEmp));
        assertTrue(company.remove(parttimeEmp)); // Test case#2: testing to remove an employee that exists

        Profile AFProfile = new Profile("Doe,Jane", "ECE", "7/1/2020");
        Fulltime fulltimeEmp = new Fulltime(AFProfile, 850000);
        assertTrue(company.add(fulltimeEmp));

        int role = Integer.parseInt(String.valueOf(1));
        Profile AMProfile = new Profile("Doe,Jane", "IT", "2/28/2012");
        Management mngmntEmp = new Management(AMProfile, 85000, role);
        assertTrue(company.add(mngmntEmp));

        int role2 = Integer.parseInt(String.valueOf(3));
        Profile AMProfile2 = new Profile("Doe,Jane", "ECE", "2/28/2012");
        Management mngmntEmp2 = new Management(AMProfile2, 96756, role2);
        assertTrue(company.add(mngmntEmp2));

        assertTrue(company.remove(fulltimeEmp)); // Test case#3 testing to remove an employee with fulltime role
        assertTrue(company.remove(mngmntEmp)); // Test case#4 testing to remove an employee with a manager role
        assertTrue(company.remove(mngmntEmp2)); // Test case#5 testing to remove an employee with director role.
    }

    @Test
    public void testSetHours() {
        Company company = new Company();
        double hours = Double.parseDouble(String.valueOf(100));
        Profile setHrsProfile = new Profile("Doe,Jane", "ECE", "7/1/20202");
        Parttime setHrsEmp = new Parttime(setHrsProfile);
        assertFalse(company.setHours(setHrsEmp)); // Test case#1: to set hours for an employee that does not exist.
        assertTrue(company.add(setHrsEmp));
        assertTrue(company.setHours(setHrsEmp)); // Test case#2: to set hours for an employee that exists.

    }

}