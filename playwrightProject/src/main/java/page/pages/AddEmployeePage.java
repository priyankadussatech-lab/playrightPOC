package page.pages;

import com.microsoft.playwright.Page;

public class AddEmployeePage {

     Page page;

    public AddEmployeePage(Page page) {
        this.page = page;
    }

    public  String getaddEmployeePIMTitle(){
        return page.title();
    }


}


