package com.n11.test;

import com.n11.config.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    //protected static RemoteWebDriver driver; //for docker
    ConfigFileReader configFileReader = new ConfigFileReader();
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        if (configFileReader.getEnv().equals("local")) {
            if (configFileReader.getBrowser().equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("disable-translate");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("disable-translate");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
            }
            driver.navigate().to(configFileReader.getBaseUrl());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicityWait()));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageLoadTimeout()));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
    }

    @Test
    public void login() {

    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
