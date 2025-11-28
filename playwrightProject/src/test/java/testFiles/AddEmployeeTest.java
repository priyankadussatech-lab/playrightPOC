package testFiles;

import Basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseTest {


    @Test
        public void addEmployeePageTitle()
        {
            String result = loginpage.doLogin("Admin", "admin123");
            String actualtitle=addEmployeePIM.getaddEmployeePIMTitle();
            Assert.assertEquals(actualtitle,"OrangeHRM");
        }

        @Test
        public void addEmployeePageValidation()
        {
            loginpage.doLogin("Admin", "admin123");
            String result = addEmployeePIM.addEmployee("Priyanka","","Dussa");
            System.out.println(result+" result is ");
           boolean flag = addEmployeePIM.validateemployeeName("Priyanka Dussa", result);
            Assert.assertEquals(flag, "Employee successfully create", "Employee not created");
        }
    }

