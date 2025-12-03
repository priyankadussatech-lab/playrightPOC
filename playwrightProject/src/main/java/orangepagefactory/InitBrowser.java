package orangepagefactory;

import com.microsoft.playwright.*;

public class InitBrowser {
    Playwright playwright;
    Browser browser;
    Page page;
    public Page initBrowser(String browserName) {
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
            default:
        }
        BrowserContext browsercontext = browser.newContext();

        page=browsercontext.newPage();

       // page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        return page;

    }

}
