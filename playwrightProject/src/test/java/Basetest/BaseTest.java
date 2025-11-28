package Basetest;

import com.microsoft.playwright.Page;
import orangepagefactory.InitBrowser;
import org.testng.annotations.*;
import page.pages.LoginPage;
import page.pages.AddEmployeePage;

public class BaseTest {

     InitBrowser in;
    public LoginPage loginpage;
    public AddEmployeePage addEmployeePIM;

    @BeforeSuite
    public void setup() {
        System.out.println("in setup method");
        in = new InitBrowser();
        Page page = in.initBrowser("chromium");
        loginpage = new LoginPage(page);
        addEmployeePIM = new AddEmployeePage(page);
        System.out.println(loginpage + " login page object");
    }
    @AfterSuite
    public void tearDown() {
        loginpage.close();
    }
}
