package page.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    //locators
    private String username="input[placeholder='Username']";
    private String password="input[placeholder='Password']";
    private String login="button[type='submit']";
    private String dashboardHeader=".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module";
    private String invalidCredentials = ".oxd-text.oxd-text--p.oxd-alert-content-text";


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
    public void doLogin(String enterUserName, String enterpassword)
    {
        //System.out.println(page);
        //page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //page.navigate("https://www.google.com");
        page.waitForSelector(username);
        page.fill(username,enterUserName);
        page.fill(password,enterpassword);
        page.click(login);
       // return page.textContent(dashboardHeader);

    }


    public void close() {
        page.close();
    }

    public boolean validatePageTitle(String actualTitle) {
        return actualTitle.equals("OrangeHRM");
    }

    public String getSuccessLoginPageTitle() {
        return page.textContent(dashboardHeader);
    }


    public String getErrorLoginPageTitle() {
        return page.textContent(invalidCredentials);
    }

    public boolean validateLoginErrorPageTitle(String actualErrorPageTitle) {
        return actualErrorPageTitle.equals("Invalid credentials");
    }

    public boolean validateLoginSuccessPageTitle(String actualSuccessPageTitle) {
        return actualSuccessPageTitle.equals("Dashboard");
    }
}

