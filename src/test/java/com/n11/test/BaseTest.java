package com.n11.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    //protected static RemoteWebDriver driver; //for docker
    //protected static String remoteUrl = "http://localhost:4444/wd/hub"; //for docker
    protected static WebDriver driver;
    protected static String baseUrl = "https://www.lolaflora.com/login";
    protected static WebDriverWait webDriverWait;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-translate");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        //driver = new RemoteWebDriver(new URL(remoteUrl), options); //for docker
        driver.navigate().to(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
