package Step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.ReportBugsPage;
import utils.TestConfiguration;

public class Bug_Reporting_Feature {
        WebDriver driver;
        ReportBugsPage reportBugsPage;

        public Bug_Reporting_Feature() {
            this.driver = TestConfiguration.driver;
            reportBugsPage = new ReportBugsPage(driver);
     }

        @Given("accéder à la page Report Bugs")
        public void acceder_a_la_page_Report_Bugs() {
            driver.get("https://academybugs.com/report-bugs/");
        }

    @When("sélectionner Issue Title de la liste déroulante")
    public void selectionner_issue_title_de_la_liste_deroulante() {
        reportBugsPage.selectionner_issue_title_de_la_liste_deroulante("The product image is broken when zoomed in");
    }

    @When("sélectionner Frequency dans le groupe de boutons radio")
    public void selectionner_frequency_dans_le_groupe_de_boutons_radio() {
        reportBugsPage.selectionner_frequency_dans_le_groupe_de_boutons_radio();
    }

    @When("Drag and Drop les étapes")
    public void drag_and_drop_les_etapes() {
        reportBugsPage.drag_and_drop_les_etapes();
    }

    @When("sélectionner l'image")
    public void selectionner_l_image() {
        reportBugsPage.selectionner_l_imagee();
    }

    @When("sélectionner la vidéo")
    public void selectionner_la_video() {
        reportBugsPage.selectionner_la_video();
    }

    @When("sélectionner du fichier journal")
    public void selectionner_du_fichier_journal() {
        reportBugsPage.selectionner_du_fichier_journal();
    }

    @Then("l'utilisateur soumet le rapport de bug")
    public void utilisateur_soumet_le_rapport_de_bug() {
        reportBugsPage.utilisateur_soumet_le_rapport_de_bug();
    }

}
