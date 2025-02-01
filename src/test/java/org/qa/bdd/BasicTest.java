package org.qa.bdd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class BasicTest {

    @Test
    public void launchBrowser(){

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://www.flipkart.com/");
        try{
            Thread.sleep(10000);
        }catch (Exception e){
           e.printStackTrace();
        }

    }
}
