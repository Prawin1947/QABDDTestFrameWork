package org.qa.bdd.steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.qa.bdd.utility.setUp.BaseTest;

public class navigationSteps {

    private WebDriver driver = BaseTest.driver;


    @Given("The user navigate to the URL")
    public void launchTheApplication(){
        System.out.println("The user lands on main page");
    }
}
