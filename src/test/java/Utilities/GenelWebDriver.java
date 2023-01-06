package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenelWebDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void startingProcess() {
        System.out.println("Driver start...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));//anasayfa yüklenirken
    }
    @AfterClass
    public static void finishingProcess(){

        System.out.println("Driver stop...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //driver.quit();
    }

}
