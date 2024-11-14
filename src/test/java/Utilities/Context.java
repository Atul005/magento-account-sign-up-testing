package Utilities;

import base.Hooks;
import org.openqa.selenium.WebDriver;
import pages.CreateAccountPage;
import pages.CustomerLoginPage;
import pages.HomePage;
import pages.MyAccountPage;

public class Context extends Hooks {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private CustomerLoginPage customerLoginPage;
    private CreateAccountPage createAccountPage;

    public Context(){
        //onStart();
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public HomePage getHomePage(){
        if(homePage == null){
            homePage = new HomePage(webDriver);
        }
        return homePage;
    }

    public MyAccountPage getMyAccountPage(){
        if(myAccountPage == null){
            myAccountPage = new MyAccountPage(webDriver);
        }
        return myAccountPage;
    }

    public CustomerLoginPage getCustomerLoginPage(){
        if(customerLoginPage == null){
            customerLoginPage = new CustomerLoginPage(webDriver);
        }
        return customerLoginPage;
    }

    public CreateAccountPage getCreateAccountPage(){
        if(createAccountPage == null){
            createAccountPage = new CreateAccountPage(webDriver);
        }
        return createAccountPage;
    }

}
