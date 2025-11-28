package page.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginPage {
    Page page;
    //locators
    private String username="input[placeholder='Username']";
    private String password="input[placeholder='Password']";
    private String login="button[type='submit']";
    private String dashboardHeader=".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module";


    //page constructor
    public LoginPage(Page page)
    {
        this.page=page;

    }
    //Action methods
    public String getLoginPageTitle(){
        return page.title();

    }
    public String getloginpageURL() {
        return page.url();
    }
    public String doLogin(String enterUserName, String enterpassword)
    {
        System.out.println(page);
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //page.navigate("https://www.google.com");
        page.waitForSelector(username);
        page.fill(username,enterUserName);
        page.fill(password,enterpassword);
        page.click(login);
        return page.textContent(dashboardHeader);

    }


    public void close() {
        page.close();
    }
}

