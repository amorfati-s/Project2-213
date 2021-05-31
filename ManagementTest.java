import companydb.*;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class ManagementTest {

    @Test
    void calculatePayment() {
        String pattern = "000.00";
        DecimalFormat df = new DecimalFormat(pattern);

        int role = Integer.parseInt(String.valueOf(1));
        Profile AMProfile = new Profile("Doe,Jane", "IT", "2/28/2012");
        Management mngmntEmp = new Management(AMProfile, 85000, role);
        mngmntEmp.calculatePayment();
        assertEquals(df.format(mngmntEmp.getPayment()), String.valueOf(3461.54)); // Test case#1: to test for management
        // role.

        String pattern1 = "000.0";
        DecimalFormat df1 = new DecimalFormat(pattern1);
        double hourlyPay = Double.parseDouble(String.valueOf(45.9));
        Profile APProfile = new Profile("Doe,Jane", "CS", "7/1/2005");
        Parttime parttimeEmp = new Parttime(APProfile, hourlyPay);
        parttimeEmp.setHours(100);
        parttimeEmp.calculatePayment();
        assertEquals(df1.format(parttimeEmp.getPayment()), String.valueOf(4590.0)); // Test case#2: to test for part
        // time role.

        Profile AFProfile = new Profile("Doe,Jane", "ECE", "7/1/2020");
        Fulltime fulltimeEmp = new Fulltime(AFProfile, 85000);
        fulltimeEmp.calculatePayment();
        assertEquals(df.format(fulltimeEmp.getPayment()), String.valueOf(3269.23)); // Test case#3: to test for full
        // time role.

        int role2 = Integer.parseInt(String.valueOf(3));
        Profile AMProfile2 = new Profile("Doe,Jane", "ECE", "2/28/2012");
        Management mngmntEmp2 = new Management(AMProfile2, 96756, role2);
        mngmntEmp2.calculatePayment();
        assertEquals(df.format(mngmntEmp2.getPayment()), String.valueOf(4182.92));

    }
}