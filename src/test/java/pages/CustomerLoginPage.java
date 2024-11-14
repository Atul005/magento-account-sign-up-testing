package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {

    WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailField;

    @FindBy(xpath = "//*[@id=\"pass\"]")
    WebElement passField;

    @FindBy(xpath = "//*[@id=\"send2\"]")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
    WebElement incorrectEmailErrMsg;

    @FindBy(xpath = "//*[@id=\"email-error\"]")
    WebElement missingEmailErr;

    @FindBy(xpath = "//*[@id=\"pass-error\"]")
    WebElement missingPassErr;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[2]/div[2]/div/div/a")
    WebElement createAccountBtn;


    public CustomerLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillEmail(String email){
        emailField.isEnabled();
        emailField.sendKeys(email);
    }

    public void fillPass(String pass){
        passField.isEnabled();
        passField.sendKeys(pass);
    }

    public void signIn(){
        signInButton.isEnabled();
        signInButton.click();
    }

    public String readErrMsgForIncorrectEmail(){
        incorrectEmailErrMsg.isDisplayed();
        return incorrectEmailErrMsg.getText();
    }

    public String readMissingEmailErr(){
        missingEmailErr.isDisplayed();
        return missingEmailErr.getText();
    }

    public String readMissingPassErr(){
        missingPassErr.isDisplayed();
        return missingPassErr.getText();
    }

    public void createAccountBtnClick(){
        createAccountBtn.isEnabled();
        createAccountBtn.click();
    }

}
