package stepDefinitions;

import Utilities.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;

public class HomePageStepDefinition {

    Context context;
    HomePage homePage;

    String CREATE_ACCOUNT_PAGE_URL = "https://magento.softwaretestingboard.com/customer/account/create/";
    String CREATE_ACCOUNT_PAGE_TITLE = "Create New Customer Account";
    String SIGN_IN_PAGE_URL = "https://magento.softwaretestingboard.com/customer/account/login";
    String SIGN_IN_PAGE_TITLE = "Customer Login";
    String BASE_URL = "https://magento.softwaretestingboard.com/";


    public HomePageStepDefinition(Context context) {
        this.context = context;
        homePage = context.getHomePage();
    }


    @Given("I am on Home Page")
    public void iAmOnHomePage() {
        context.getWebDriver().get(BASE_URL);
    }

    @When("I click on Create an Account link")
    public void iClickOnCreateAnAccountLink() {
        homePage.createNewAccount();
    }

    @Then("I am redirected to Create New User Account page")
    public void iAmRedirectedToCreateNewUserAccountPage() {
        Assert.assertTrue(context.getWebDriver().getTitle().equalsIgnoreCase(CREATE_ACCOUNT_PAGE_TITLE));
        Assert.assertTrue(CREATE_ACCOUNT_PAGE_URL.equalsIgnoreCase(context.getWebDriver().getCurrentUrl()));
    }

    @When("I click on SignIn link")
    public void iClickOnSignInLink() {
        homePage.signIn();
    }

    @Then("I am redirected to Customer Login page")
    public void iAmRedirectedToCustomerLoginPage() {
        Assert.assertTrue(context.getWebDriver().getTitle().equalsIgnoreCase(SIGN_IN_PAGE_TITLE));
        Assert.assertTrue(context.getWebDriver().getCurrentUrl().toLowerCase().contains(SIGN_IN_PAGE_URL.toLowerCase()));
    }

}
