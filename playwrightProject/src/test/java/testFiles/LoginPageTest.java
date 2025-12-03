package testFiles;

import Basetest.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageValidataion() {
        String actualTitle = loginpage.getLoginPageTitle();
        boolean titleFlag = loginpage.validatePageTitle(actualTitle);
        Assert.assertEquals(titleFlag, true,"Your log in is failed");
        Reporter.log("LoginPage-TestCase1: Login Page — title verified: " + actualTitle, true);
    }

    @Test
    public void loginWithValidCredentials() {
         loginpage.doLogin("Admin", "admin123");
        String loginSuccessPageTitle = loginpage.getSuccessLoginPageTitle();
        boolean loginSuccessTitleFlag = loginpage.validateLoginSuccessPageTitle(loginSuccessPageTitle);
        Assert.assertEquals(loginSuccessTitleFlag, true, "Your login is failed");
        Reporter.log("LoginPage-TestCase2: Login successful — with valid credentials: " , true);
    }

    @Test
    public void loginWithInvalidPassword() {
        loginpage.doLogin("Admin", "abc123");
        String actualErrorPageTitle = loginpage.getErrorLoginPageTitle();
        boolean errorTitleFlag = loginpage.validateLoginErrorPageTitle(actualErrorPageTitle);
        Assert.assertEquals(errorTitleFlag, true,"Test Case failed with invalid credentials");
        Reporter.log("LoginPage-TestCase3: Login failed with invalid Password ", true);
    }
    @Test
    public void loginWithInvalidUserName() {
        loginpage.doLogin("abc", "admin123");
        String actualErrorPageTitle = loginpage.getErrorLoginPageTitle();
        boolean errorTitleFlag = loginpage.validateLoginErrorPageTitle(actualErrorPageTitle);
        Assert.assertEquals(errorTitleFlag, true,"Test Case failed with invalid credentials");
        Reporter.log("LoginPage-TestCase4: Login failed with invalid UserName ", true);
    }
}
