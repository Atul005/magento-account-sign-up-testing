package stepDefinitions;

import Utilities.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CustomerLoginPage;
import pages.MyAccountPage;

public class MyAccountPageStepDefinition {

    Context context;
    MyAccountPage myAccountPage;
    CustomerLoginPage customerLoginPage;
    String LOGIN_URL = "https://magento.softwaretestingboard.com/customer/account/login";
    String MY_ACCOUNT_URL = "https://magento.softwaretestingboard.com/customer/account/";
    String MY_ACCOUNT_PAGE_TITLE = "My Account";
    String LOG_OUT_PAGE_URL = "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";
    String LOG_OUT_PAGE_TITLE = "You are signed out";


    public MyAccountPageStepDefinition(Context context) {
        this.context = context;
        customerLoginPage = context.getCustomerLoginPage();
        myAccountPage = context.getMyAccountPage();
    }

    @Given("I am on Customer Login Page")
    public void iAmOnCustomerLoginPage() {
        context.getWebDriver().get(LOGIN_URL);
    }

    @When("I enter a valid {string} and {string}")
    public void iEnterAValidEmailAndPassword(String email, String pass) {
        customerLoginPage.fillEmail(email);
        customerLoginPage.fillPass(pass);
        customerLoginPage.signIn();
    }

    @Then("I should be redirected to My Account Page")
    public void iShouldBeRedirectedToMyAccountPage() {
        Assert.assertTrue(MY_ACCOUNT_URL.equalsIgnoreCase(context.getWebDriver().getCurrentUrl()));
       // Assert.assertEquals(MY_ACCOUNT_PAGE_TITLE, context.getWebDriver().getTitle());
    }

    @When("I click on User Action Button menu")
    public void iClickOnUserActionButtonMenu() {
        myAccountPage.userActionButtonClick();
    }

    @And("I click on Sign Out option")
    public void iClickOnSignOutOption() {
        myAccountPage.signOutButtonClick();
    }

    @Then("I should be able to sign out of My Account")
    public void iShouldBeAbleToSignOutOfMyAccount() {
            Assert.assertTrue(context.getWebDriver().getCurrentUrl().equalsIgnoreCase(LOG_OUT_PAGE_URL));
            //Assert.assertTrue(context.getWebDriver().getCurrentUrl().equalsIgnoreCase("https://magento.softwaretestingboard.com/"));
    }

}
