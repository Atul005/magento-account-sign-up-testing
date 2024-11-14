package base;


import Utilities.BrowserFactory;
import Utilities.ConfigDataProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class BaseClass {

//    public WebDriver webDriver;
//    ConfigDataProvider configDataProvider = new ConfigDataProvider();
//    String URL = "https://magento.softwaretestingboard.com/";
//
//    @Before
//    public void setUp(){
//        System.out.println("Set from @Before");
//        webDriver = BrowserFactory.startApplication(webDriver, configDataProvider.getBrowser(), configDataProvider.getURL());
//    }
//
//
//
//    // after every scenario, close the tab to put less load on machine PS im using low power machine, no need to do in production
//    @After
//    public void tearDown(Scenario scenario){
//        if(scenario.isFailed()){
//            captureScreenshot(scenario.getName());
//        }
//        webDriver.close();
//    }
//
//
//    private void captureScreenshot(String scenarioName){
//        File screenshot = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
//        try{
//            FileUtils.copyFile(screenshot, new File("." + "/Screenshots/" + scenarioName + ".png"));
//        } catch (Exception ex){
//            System.out.println("Exception while capturing screenshot -> "+scenarioName + " ");
//            ex.printStackTrace();
//        }
//    }



}