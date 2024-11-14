package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement userActionButton;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    WebElement signOutButton;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement welcmeMsg;

    public MyAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void userActionButtonClick(){
        userActionButton.isEnabled();
        userActionButton.click();
    }

    public void signOutButtonClick(){
        signOutButton.isEnabled();
        signOutButton.click();
    }

    public String getWelcomeMsgForNewCustmer(){
        welcmeMsg.isDisplayed();
       return welcmeMsg.getText();
    }

}
