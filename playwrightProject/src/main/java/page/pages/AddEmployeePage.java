package page.pages;

import com.microsoft.playwright.Page;
public class AddEmployeePage {
     //locators
     Page page;
    private String pim = ".oxd-text oxd-text--span oxd-main-menu-item--name";
    private  String addEmployee = ".oxd-topbar-body-nav-tab-item";
    private  String firstName = "input[placeholder='Username']";
    private  String middleName = "input[placeholder='Middle Name']";
    private  String lastName = "input[placeholder='Last Name']";
    private String employeeId = ".oxd-input oxd-input--active";

    private  String switchBox = ".oxd-input oxd-input--active";

    private  String saveButton = "button[type='submit']";
    private  String employeeListHeader = ".oxd-text.oxd-text--h6.--stron";
    String employee = "//div[contains(@class, 'edit-employee-name')]//h6";

    public AddEmployeePage(Page page) {
        this.page = page;
    }

    //Action methods
    public  String getaddEmployeePIMTitle(){
        return page.title();

    }
    public String getaddEmployeePIMURL() {
        return page.url();
    }

    public  String addEmployee(String first_Name, String middle_name, String last_name)
    {
        page.click(pim);
        page.waitForSelector(addEmployee);
        page.click(addEmployee);
        page.waitForSelector(firstName);
        page.fill(firstName,first_Name);
        page.fill(middleName,middle_name);
        page.fill(lastName,last_name);
        //page.click(switchBox);
        page.click(saveButton);
        return  page.textContent(employee);
    }

    public boolean validateemployeeName(String name, String actual){
        return  name.equals(actual);
    }


    public void close() {
        page.close();
    }


}


