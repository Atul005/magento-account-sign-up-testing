package stepDefinitions;

import Utilities.Context;
import Utilities.FakeNameGenerator;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateAccountPage;
import pages.MyAccountPage;

public class CreateAccountPageStepDefinition {

    Context context;
    CreateAccountPage createAccountPage;
    MyAccountPage myAccountPage;
    FakeNameGenerator fakeNameGenerator = new FakeNameGenerator();
    String[] fakeProfile = fakeNameGenerator.fakeProfile();
    String CREATE_ACCOUNT_URL = "https://magento.softwaretestingboard.com/customer/account/create";
    String REDIRECTED_ACCOUNT_PAGE_URL = "https://magento.softwaretestingboard.com/customer/account/";


    public CreateAccountPageStepDefinition(Context context) {
        this.context = context;
        createAccountPage = context.getCreateAccountPage();
        myAccountPage = context.getMyAccountPage();
    }

    @Given("I am on Create New Customer Account page")
    public void iAmOnCreateNewCustomerAccountPage() {
        //context.openUrl(CREATE_ACCOUNT_URL);
        context.getWebDriver().get(CREATE_ACCOUNT_URL);
    }

    @When("I enter a valid First Name {string}")
    public void iEnterAValidFirstName(String string) {

        // this case is for creating a new account, same is in lastName, email, pass
        if (string.isEmpty()) {
            createAccountPage.fillFirstName(fakeProfile[0]);
        } else if (string.equals("null")) {
            createAccountPage.fillFirstName(""); // this case is for missing first name, same for lastName, email, pass
        } else {
            createAccountPage.fillFirstName(string); // this case is for other cases ex. create account with existing emailId
        }
    }

    @And("I enter a valid Last Name {string}")
    public void iEnterAValidLastName(String string) {
        if (string.isEmpty()) {
            createAccountPage.fillLastName(fakeProfile[1]);
        } else if (string.equals("null")) {
            createAccountPage.fillLastName(""); // this case is for missing field case, same for lastName, email, pass
        } else {
            createAccountPage.fillLastName(string);
        }
    }

    @And("I enter a valid Email {string}")
    public void iEnterAValidEmail(String string) {
        if (string.isEmpty()) {
            createAccountPage.emailIdfield(fakeProfile[2]);
        } else if (string.equals("null")) {
            createAccountPage.emailIdfield(""); // this case is for missing field case, same for lastName, email, pass
        } else {
            createAccountPage.emailIdfield(string);
        }
    }

    @And("I enter a valid Password {string}")
    public void iEnterAValidPassword(String string) {
        if (string.isEmpty()) {
            createAccountPage.passField(fakeProfile[3]);
        } else if (string.equals("null")) {
            createAccountPage.passField(""); // this case is for missing first name, same for lastName, email, pass
        } else {
            createAccountPage.passField(string);
        }
    }


    @And("I confirm a valid Password {string}")
    public void iConfirmAValidPassword(String string) {
        if (string.isEmpty()) {
            createAccountPage.cnfrmPassField(fakeProfile[4]);
        } else if (string.equals("null")) {
            createAccountPage.cnfrmPassField(""); // this case is for missing first name, same for lastName, email, pass
        } else {
            createAccountPage.cnfrmPassField(string);
        }
    }


    @And("I click on Create An Account icon")
    public void iClickOnCreateAnAccountIcon() {
        createAccountPage.createAccountBtn();
    }

    @Then("I should be able to successfully create an account and redirected to My Account page")
    public void iShouldBeAbleToSuccessfullyCreateAnAccountAndRedirectedToMyAccountPage() {
        Assert.assertTrue(REDIRECTED_ACCOUNT_PAGE_URL.equalsIgnoreCase(context.getWebDriver().getCurrentUrl()));
    }

    @And("I should see a message {string}")
    public void iShouldSeeAMessageThankYouForRegisteringWithMainWebsiteStore(String message) {
        Assert.assertTrue(message.equalsIgnoreCase(myAccountPage.getWelcomeMsgForNewCustmer()));
    }

    @Then("I should be not be able to create an account")
    public void iShouldBeNotBeAbleToCreateAnAccount() {
        //empty statement
    }


    @And("I enter password with {string}")
    public void iEnterPasswordWithPass(String pass) {
    }

    @And("I should see an existing email error message {string}")
    public void iShouldSeeAnExistingEmailErrorMessage(String errMsg) {
        Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.existingEmailIdErrMsg()));
    }


    @And("I should see a missing field error message {string} under {string}")
    public void iShouldSeeAMissingFieldErrorMessage(String errMsg, String missingField) {
        switch (missingField) {
            case "First Name" -> Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.missingFirstNameErrMsg()));
            case "Last Name" -> Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.missingLastNameErrMsg()));
            case "Email" -> Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.missingEmailErrMsg()));
            case "Password" -> Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.missingPassErrMsg()));
            case "Confirm Password" ->
                    Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.missingCnfrmPassErrMsg()));
        }
    }

    @And("I should see a mismatch password error message {string}")
    public void iShouldSeeAMismatchPasswordErrorMessage(String errMsg) {
        Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.setMisMatchPassErrMsg()));
    }

    @And("I should see a password length error message {string}")
    public void iShouldSeeAPasswordLengthErrorMessage(String errMsg) {
        Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.passLenLess8ErrMsg()));
    }


    @And("I should see a unsatisfy password condition error message {string}")
    public void iShouldSeeAUnsatisfyPasswordConditionErrorMessage(String errMsg) {
        Assert.assertTrue(errMsg.equalsIgnoreCase(createAccountPage.passConditionNotFulfilledErrMsg()));
    }
}
