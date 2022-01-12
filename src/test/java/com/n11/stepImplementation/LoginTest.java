package com.n11.stepImplementation;

import com.n11.page.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoginTest extends BasePage {

    Logger logger = LogManager.getLogger(com.n11.stepImplementation.LoginTest.class.getName());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("asdb");
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
