package Step_Definition;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateCucumberReport {
    public static void main(String[] args) {

        File reportOutputDirectory = new File("target/cucumber-report-Report-bug");

        File[] jsonFiles = new File("target/cucumber-report-Report-bug").listFiles((dir, name) -> name.endsWith(".json"));

        List<String> jsonFileNames = new ArrayList<>();
        for (File file : jsonFiles) {
            jsonFileNames.add(file.getAbsolutePath());
        }

        Configuration configuration = new Configuration(reportOutputDirectory, "Academy_Bugs_Test");
        configuration.setBuildNumber("1");
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFileNames, configuration);
        Reportable result = reportBuilder.generateReports();

        System.out.println("Le rapport Cucumber a été généré avec succès.");
    }
}


