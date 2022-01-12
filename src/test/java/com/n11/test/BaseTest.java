package com.n11.test;

import com.n11.config.ConfigFileReader;
import com.n11.utility.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest extends DriverFactory {

    ConfigFileReader configFileReader = new ConfigFileReader();

    @Before
    public void setup() throws MalformedURLException {
        if (configFileReader.getEnv().equals("local")) {
            if (configFileReader.getBrowser().equals("opera")) {
                operaDriver();
            } else if (configFileReader.getEnv().equalsIgnoreCase("firefox")) {
                firefoxDriver();
            } else {
                chromeDriver();
            }
        } else {
            remoteWebDriver();
        }
        driver.navigate().to(configFileReader.getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicityWait()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageLoadTimeout()));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configFileReader.getWebDriverWait()));
    }

    @After
    public void after() {
        if (driver != null) {
            driver.close();
            //driver.quit();
        }
    }
}
