package com.n11.test;

import com.n11.config.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    //protected static RemoteWebDriver driver; //for docker
    ConfigFileReader configFileReader = new ConfigFileReader();
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    @BeforeSuite
    public void setup() throws MalformedURLException {
        if (configFileReader.getEnv().equals("local")) {
            if (configFileReader.getBrowser().equals("opera")) {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                OperaOptions options = new OperaOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("disable-translate");
                capabilities.setCapability(OperaOptions.CAPABILITY, options);
                //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
            } else if (configFileReader.getEnv().equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("disable-translate");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
            }
            else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-popup-blocking");
                options.addArguments("disable-translate");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                //driver = new RemoteWebDriver(new URL(configFileReader.getRemoteUrl()), options);
            }
            driver.navigate().to(configFileReader.getBaseUrl());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicityWait()));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageLoadTimeout()));
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(configFileReader.getWebDriverWait()));
        }
    }

    @AfterSuite
    public void after() {
        if (driver != null) {
            driver.close();
            //driver.quit();
        }
    }
}
