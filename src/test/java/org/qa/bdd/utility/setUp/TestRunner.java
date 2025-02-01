package org.qa.bdd.utility.setUp;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(plugin = { "json:test-output/cucumber-report/report1.json",
        "html:test-output/cucumber-report/report1.html" },
        glue = {"org.qa.bdd.steps","org.qa.bdd.utility.setUp"},
        features = "src\\test\\java\\org\\qa\\bdd\\ui\\functionalTests")
public class TestRunner extends AbstractTestNGCucumberTests {



    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
