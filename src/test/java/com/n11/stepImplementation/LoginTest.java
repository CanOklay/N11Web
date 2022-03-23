package com.n11.stepImplementation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    @Given("^user is on login page$")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translate");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver.get("https://www.n11.com/");
        driver.quit();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        System.out.println("asdb");
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        System.out.println("asdb");
    }

    @Then("user is navigated to the homepage")
    public void user_is_navigated_to_the_homepage() {
        System.out.println("asdb");
    }

}
