package testFiles;

import Basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitle() {
        String actualTitle = loginpage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, "OrangeHRM");
    }
    @Test
    public void loginPageValidation() {
        String result = loginpage.doLogin("Admin", "admin123");
        Assert.assertEquals(result, "Dashboard");
    }
}
