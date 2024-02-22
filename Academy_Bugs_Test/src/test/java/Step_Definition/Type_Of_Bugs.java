package Step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.SeleniumUtils;

import java.util.concurrent.TimeUnit;
@Test
public class Type_Of_Bugs {

    private WebDriver driver;
    private String parentWindowHandle;
    private SeleniumUtils seleniumUtils;
@BeforeTest
    public void Set_up() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eya Laourine\\Desktop\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

@Given( "accéder à la page Type of bugs")
    public void accéder_à_la_page_Type_of_bugs() {
    seleniumUtils = new SeleniumUtils(driver);
    driver.get("https://academybugs.com/types/");
        parentWindowHandle = driver.getWindowHandle();
    accepterPopUpCookies();

}
    public void accepterPopUpCookies() {
        try {
            WebElement cookiePopup = driver.findElement(By.id("cc-window"));
            WebElement acceptButton = cookiePopup.findElement(By.id("functional only "));
            acceptButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Pop-up de consentement des cookies non trouvée ou déjà acceptée.");
        }
    }

@When("sélectionner  le conteneur du type de bug")
    public void sélectionner_le_conteneur_du_type_de_bug() {
    seleniumUtils.waitForElementToBeClickableByXpath(By.xpath("//*[@id=\"post-1081\"]/div/section/div/a[2]/div"));

    WebElement bugContainer = driver.findElement(By.xpath("//*[@id=\"post-1081\"]/div/section/div/a[2]/div"));
        bugContainer.click();

}
@Test
@When("cliquer sur mot cliquable pour accéder à la page convenante")
    public void cliquer_sur_mot_cliquable_pour_accéder_à_la_page_convenante() {
    seleniumUtils.waitForElementToBeClickableByLinkText(By.linkText("Articles"));

    WebElement articlesLink = driver.findElement(By.linkText("Articles"));
        articlesLink.click();
        SeleniumUtils.waitForNewWindow(driver);
    accepterPopUpCookies();

}

@When("Appuyer sur le bouton Read More")
    public void Appuyer_sur_le_bouton_Read_More() {
    seleniumUtils.waitForElementToBeClickableByLinkText(By.linkText("Read More"));

    WebElement readMoreButton = driver.findElement(By.linkText("Read More"));
        readMoreButton.click();
    }

@When("Retourner vers la page web précédente immédiate")
    public void Retourner_vers_la_page_web_précédente_immédiate()
{
        driver.navigate().back();
    }

    @Then("Fermer l'onglet et revenir à la page d'accueil du site")
    public void Fermer_longlet_et_revenir_à_la_page_daccueil_du_site() {
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    driver.switchTo().window(parentWindowHandle);
    driver.quit();
    }
}
