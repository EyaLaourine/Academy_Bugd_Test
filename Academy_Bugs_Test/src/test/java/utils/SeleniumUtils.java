package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;


public class SeleniumUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementToBeClickable(By name) {
        wait.until(ExpectedConditions.elementToBeClickable(name));
    }
    public void waitForElementToBeClickableByXpath(By xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }
    public void waitForElementToBeClickableByLinkText(By LinkText) {
        wait.until(ExpectedConditions.elementToBeClickable(LinkText));
    }
    public void waitForElementToBeVisible(By className) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(className));
    }
   public static void waitForNewWindow(WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        String parentWindowHandle = driver.getWindowHandle();

        while (windowHandles.size() != 1) {
            windowHandles = driver.getWindowHandles();
            windowHandles.remove(parentWindowHandle);
        }

        driver.switchTo().window(windowHandles.iterator().next());
    }
}
