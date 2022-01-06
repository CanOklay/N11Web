package com.n11.stepImplementation;

import com.n11.page.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static com.n11.constant.Constants.EXPECTED_TITLE_TEXT;

public class LoginTest extends BasePage {

    //Give user is on the login page
    //When user enters correct username and password
    //Then user gets confirmation

    Logger logger = LogManager.getLogger(com.n11.stepImplementation.LoginTest.class.getName());

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        try {
            driver.getTitle();
        } catch (Exception e) {
            logger.error(e.getMessage());
            assertFail();
        }
        /*String title = getTitle();
        assertEquals(title, EXPECTED_TITLE_TEXT);
        logger.info("Title: " + title);*/
    }

    @When("user enters correct username and password")
    public void user_enters_correct_username_and_password() {
        try {
            driver.getTitle();
        } catch (Exception e) {
            logger.error(e.getMessage());
            assertFail();
        }
    }

    @When("user gets confirmation")
    public void user_gets_confirmation() {
        try {
            driver.getTitle();
        } catch (Exception e) {
            logger.error(e.getMessage());
            assertFail();
        }
    }
}
