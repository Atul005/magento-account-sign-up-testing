package stepDefinitions;

import Utilities.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CustomerLoginPage;

public class CustomerLoginPageStepDefinitions {

    Context context;
    CustomerLoginPage customerLoginPage;
    String CUSTOMER_LOGIN_PAGE_URL = "https://magento.softwaretestingboard.com/customer/account/login";
    String MY_ACCOUNT_URL = "https://magento.softwaretestingboard.com/customer/account/login";
    String MY_ACCOUNT_PAGE_TITLE = "My Account";
    String CREATE_NEW_ACCOUNT_URL = "https://magento.softwaretestingboard.com/customer/account/create/";


    public CustomerLoginPageStepDefinitions(Context context) {
        this.context = context;
        customerLoginPage = context.getCustomerLoginPage();
    }


    @Given("I am on Customer Login page")
    public void iAmOnCustomerLoginPage() {
        context.getWebDriver().get(CUSTOMER_LOGIN_PAGE_URL);
    }

    @When("I enter an Email {string}")
    public void iEnterAnEmail(String email) {
        customerLoginPage.fillEmail(email);
    }

    @And("I enter the Password {string}")
    public void iEnterThePasswordValidPassword(String pass) {
        customerLoginPage.fillPass(pass);
    }

    @And("I click on Sign In")
    public void iClickOnSignIn() {
        customerLoginPage.signIn();
    }

    @Then("I am successfully signed in my account")
    public void iAmSuccessfullySignedInMyAccount() {
        //Assert.assertTrue(MY_ACCOUNT_URL.equalsIgnoreCase(context.getWebDriver().getCurrentUrl()));
    }

    @And("I am redirected to My Account page")
    public void iAmRedirectedToMyAccountPage() {
        Assert.assertTrue(MY_ACCOUNT_URL.equalsIgnoreCase(context.getWebDriver().getCurrentUrl()));
       // Assert.assertEquals(MY_ACCOUNT_PAGE_TITLE, context.getWebDriver().getTitle());
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String errMessage) {
        Assert.assertEquals(customerLoginPage.readErrMsgForIncorrectEmail(), errMessage);
    }

    @And("I enter correct {string}")
    public void iEnterCorrectPassword(String pass) {
    }

    @When("I click on Create An Account")
    public void iClickOnCreateAnAccount() {
        customerLoginPage.createAccountBtnClick();
    }

    @Then("I should be redirected to Create New Customer Account page")
    public void iShouldBeRedirectedToCreateNewCustomerAccountPage() {
        Assert.assertTrue(context.getWebDriver().getCurrentUrl().equalsIgnoreCase(CREATE_NEW_ACCOUNT_URL));
    }

    @Then("I should see an error message below Email {string}.")
    public void iShouldSeeAnErrorMessageBelowEmail(String errMsg) {
        Assert.assertTrue(errMsg.equalsIgnoreCase(customerLoginPage.readMissingEmailErr()));
    }

    @Then("I should see an error message below Password {string}.")
    public void iShouldSeeAnErrorMessageBelowPassword(String errMsg) {
        Assert.assertTrue(errMsg.equalsIgnoreCase(customerLoginPage.readMissingPassErr()));
    }

}
