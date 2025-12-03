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

    @BeforeClass
    public void setup() {
       // System.out.println("in setup method");
        in = new InitBrowser();
        Page page = in.initBrowser("firefox");
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginpage = new LoginPage(page);
        addEmployeePIM = new AddEmployeePage(page);
    }
    @AfterTest
    public void tearDown() {
        loginpage.close();
    }
}
