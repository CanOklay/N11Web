package com.n11.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",
                            "json:target/cucumber-reports/cucumber.json"},
        features="src/test/resources/features",
        glue = {"com.n11.stepImplementation"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}
