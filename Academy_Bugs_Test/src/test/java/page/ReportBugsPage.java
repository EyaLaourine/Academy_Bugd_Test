package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportBugsPage extends AbstractPage {
    @FindBy(name = "bug-title-1")
    private WebElement issueTitleDropdown;

    @FindBy(xpath = "//*[@id='frequency-form-group-1']/div/div/label[1]/div/input")
    private WebElement frequencyRadioButton;

    @FindBy(xpath = "//*[@id='bug-1-sortable-2']/li[1]")
    private WebElement sourceElement;

    @FindBy(xpath = "//*[@id='bug-1-sortable-12']")
    private WebElement targetElement;

    @FindBy(xpath = "//*[@id='reportBugImage2']")
    private WebElement imageRadioButton;

    @FindBy(xpath = "//*[@id='reportBugVideo1']")
    private WebElement videoRadioButton;

    @FindBy(xpath = "//*[@id='reportBugLog1']")
    private WebElement logRadioButton;

    @FindBy(xpath = "//*[@id='submit-bug-report-1']/span[2]")
    private WebElement submitButton;

    public ReportBugsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectionner_issue_title_de_la_liste_deroulante(String issueTitle) {
        issueTitleDropdown.sendKeys(issueTitle);
    }

    public void selectionner_frequency_dans_le_groupe_de_boutons_radio() {
        frequencyRadioButton.click();
    }

    public void drag_and_drop_les_etapes() {
        (new Actions(driver)).dragAndDrop(sourceElement, targetElement).perform();
    }

    public void  selectionner_l_imagee() {
        imageRadioButton.click();
    }

    public void selectionner_la_video() {
        videoRadioButton.click();
    }

    public void selectionner_du_fichier_journal() {
        logRadioButton.click();
    }

    public void utilisateur_soumet_le_rapport_de_bug() {
        submitButton.click();
    }

}

