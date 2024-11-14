package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]")
    WebElement signInClick;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
    WebElement createNewAccountClick;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void signIn(){
        signInClick.isEnabled();
        signInClick.click();
    }

    public void createNewAccount(){
        createNewAccountClick.isEnabled();
        createNewAccountClick.click();
    }


}
