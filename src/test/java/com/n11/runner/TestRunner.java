package com.n11.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/n11/features",
        glue = {"stepImplementation"},
        monochrome = true)
public class TestRunner {
}
