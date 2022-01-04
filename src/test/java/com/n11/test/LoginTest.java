package com.n11.test;

import com.n11.page.BasePage;
import org.testng.annotations.Test;

import static com.n11.constant.Constants.*;

public class LoginTest extends BasePage {

    @Test
    public void login() {
        String title = getTitle();
        assertEquals(title, EXPECTED_TITLE_TEXT);
    }
}
