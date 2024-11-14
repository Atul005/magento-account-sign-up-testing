package Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver webDriver, String browser, String url){

        switch (browser) {
            case "Chrome" -> {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
            case "FireFox" -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            case "Edge" -> {
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            }
        }
        webDriver.manage().window().maximize();
//        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return webDriver;
    }

}
