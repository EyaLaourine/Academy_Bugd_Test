package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.io.File;


public class TestConfiguration {
    public static WebDriver driver;
    public static String browserName;

    @Before
    @Parameters("browser")
    public void before(io.cucumber.java.Scenario scenario) {

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", Configuration.getProperty("browser.chrome.driver"));
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", Configuration.getProperty("browser.firefox.driver"));
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser specified: " + browserName);
        }


    }

    @After
    public void after(io.cucumber.java.Scenario scenario) {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotName="ScreenShot" ;
            System.out.println("Screenshot captured: " + screenshotName);

    }


}}
