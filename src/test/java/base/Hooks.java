package base;

import Utilities.BrowserFactory;
import Utilities.ConfigDataProvider;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Hooks {

    public static WebDriver webDriver;
    static ConfigDataProvider configDataProvider = new ConfigDataProvider();
    String URL = "https://magento.softwaretestingboard.com/";

    @Before
    public static void onStart(){
        webDriver = BrowserFactory.startApplication(webDriver, configDataProvider.getBrowser(), configDataProvider.getURL());
    }

    @After
    public  static void afterScenario(Scenario scenario){
        System.out.println("In scenario @After");
        if(scenario.isFailed()){
            captureScreenshot(scenario.getName());
        }
        webDriver.quit();
    }

    @AfterAll
    public static void tearDown(){
        if(null != webDriver){
            webDriver.quit();
        }
    }


    private static void captureScreenshot(String scenarioName){
        File screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenshot, new File("." + "/Screenshots/" + scenarioName + ".png"));
        } catch (Exception ex){
            System.out.println("Exception while capturing screenshot -> "+scenarioName + " ");
            ex.printStackTrace();
        }
    }

}
