package org.qa.bdd.utility.setUp;

import com.typesafe.config.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.qa.bdd.constants.ApplicationConstant;
import org.qa.bdd.driver.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {

    private static Logger LOGGER = LoggerFactory.getLogger(BaseTest.class.getName());
    public static Config config;
    public static String browser;
    public static WebDriver driver;

    static {
        loadConfig();
    }

    private static void loadConfig(){
        try {
            config = ConfigLoader.loadConfig();
            browser = config.getConfig(ApplicationConstant.BROWSER.toString()).getString(ApplicationConstant.NAME);
            driver = DriverManager.setDriver(browser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Before
    public void setUp() {
        LOGGER.info("TEST STARTED ...."+BaseTest.getCurrentDateAndTime());
        try {
            if (!driver.equals(null)) {
                driver.get(config.getConfig(ApplicationConstant.APPLICATION).getString(ApplicationConstant.URL).toString());
                LOGGER.info("The application is launched...");
                Thread.sleep(5000);
            } else {
                LOGGER.error("The driver is not initiated ...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public static void tearDown() {
        LOGGER.info("Closing the browser");
        driver.close();
        LOGGER.info("TEST END ...."+BaseTest.getCurrentDateAndTime());
    }
}
