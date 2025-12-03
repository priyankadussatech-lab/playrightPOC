package testFiles;

import Basetest.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class AddEmployeeTest extends BaseTest {

    @Test
        public void addEmployeePageTitle()
        {
            loginpage.doLogin("Admin", "admin123");
            String actualtitle=addEmployeePIM.getaddEmployeePIMTitle();
            Assert.assertEquals(actualtitle,"OrangeHRM");
            Reporter.log("addEmployeePage -TestCase1: Add Employee ", true);
        }


    }

