package com.n11.test;

import com.n11.page.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import static com.n11.constant.Constants.*;

public class LoginTest extends BasePage {

    Logger logger = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void login() {
        String title = getTitle();
        assertEquals(title, EXPECTED_TITLE_TEXT);
        logger.info("Title: " + title);
    }
}
