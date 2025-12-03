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

    @BeforeTest
    public void setup() {
       // System.out.println("in setup method");
        in = new InitBrowser();
        Page page = in.initBrowser("firefox");
        loginpage = new LoginPage(page);
       addEmployeePIM = new AddEmployeePage(page);

    }
    @AfterTest
    public void tearDown() {
        loginpage.close();
    }
}
