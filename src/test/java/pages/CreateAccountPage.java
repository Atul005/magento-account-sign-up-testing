package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    WebElement firstNamefield;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    WebElement lastNamefield;

    @FindBy(xpath = "//*[@id=\"email_address\"]")
    WebElement emailIdfield;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passfield;

    @FindBy(xpath = "//*[@id=\"password-confirmation\"]")
    WebElement cnfrmPassfield;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id=\"firstname-error\"]")
    WebElement missingFirstNameErrMsg;

    @FindBy(xpath = "//*[@id=\"lastname-error\"]")
    WebElement missingLastNameErrMsg;

    @FindBy(xpath = "//*[@id=\"email_address-error\"]")
    WebElement missingEmailErrMsg;

    @FindBy(xpath = "//*[@id=\"password-error\"]")
    WebElement missingPassErrMsg;

    @FindBy(xpath = "//*[@id=\"password-confirmation-error\"]")
    WebElement missingCnfrmPassErrMsg;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")
    WebElement existingEmailIdErrMsg;

    @FindBy(xpath = "//*[@id=\"password-confirmation-error\"]")
    WebElement misMatchPassErrMsg;

    @FindBy(xpath = "//*[@id=\"password-error\"]")
    WebElement passLengthLess8ErrMsg;

    @FindBy(xpath = "//*[@id=\"password-error\"]\n")
    WebElement passConditionNotFulfilledErrMsg;

    public CreateAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillFirstName(String firstName){
        firstNamefield.sendKeys(firstName);
    }

    public void fillLastName(String lastName){
        lastNamefield.sendKeys(lastName);
    }

    public void emailIdfield(String email){
        emailIdfield.sendKeys(email);
    }

    public void passField(String pass){
        passfield.sendKeys(pass);
    }

    public void cnfrmPassField(String pass){
        cnfrmPassfield.sendKeys(pass);
    }

    public void createAccountBtn(){
        createAccountBtn.click();
    }

    public String existingEmailIdErrMsg(){
        existingEmailIdErrMsg.isDisplayed();
        return existingEmailIdErrMsg.getText();
    }

    public String missingFirstNameErrMsg(){
        missingFirstNameErrMsg.isDisplayed();
        return  missingFirstNameErrMsg.getText();
    }

    public String missingLastNameErrMsg(){
        missingLastNameErrMsg.isDisplayed();
        return missingLastNameErrMsg.getText();
    }

    public String missingEmailErrMsg(){
        missingEmailErrMsg.isDisplayed();
        return missingEmailErrMsg.getText();
    }

    public String missingPassErrMsg(){
        missingPassErrMsg.isDisplayed();
        return missingPassErrMsg.getText();
    }

    public String missingCnfrmPassErrMsg(){
        missingCnfrmPassErrMsg.isDisplayed();
        return missingCnfrmPassErrMsg.getText();
    }

    public String setMisMatchPassErrMsg(){
        misMatchPassErrMsg.isDisplayed();
        return misMatchPassErrMsg.getText();
    }

    public String passLenLess8ErrMsg(){
        passLengthLess8ErrMsg.isDisplayed();
        return passLengthLess8ErrMsg.getText();
    }

    public String passConditionNotFulfilledErrMsg(){
        passConditionNotFulfilledErrMsg.isDisplayed();
        return passConditionNotFulfilledErrMsg.getText();
    }

}
