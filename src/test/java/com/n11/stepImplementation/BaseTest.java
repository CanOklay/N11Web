package com.n11.stepImplementation;

import com.n11.base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest extends BasePage {

    @Given("^User is navigated to the homepage$")
    public void user_is_on_home_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translate");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver.get("https://www.n11.com/");
    }

    @Then("Driver tears down")
    public void driver_tears_down() {
        if (driver != null) {
            driver.quit();
        }
    }

}
