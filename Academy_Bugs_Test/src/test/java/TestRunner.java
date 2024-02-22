
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.*;
import utils.TestConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@CucumberOptions(
        features = "src/test/resources/Features/ReportBugs.feature",
        plugin = {"json:target/cucumber-report-Report-bug/cucumber-report.json", "html:target/cucumber-html-report"},
        tags = "@reportBug")

public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters("browser")
    public void setting(@Optional("chrome")String name) {
        TestConfiguration.browserName = name;

    }

    @AfterSuite
    public void generateReport() {
        String outputDirectory = "target/cucumber-report-Report-bug";
        String reportName = "cucumber-report-Report-bug";

       // Add cucumber JSON report files to the list
        File reportOutputDirectory = new File(outputDirectory);
        File[] jsonFiles = reportOutputDirectory.listFiles((dir, name) -> name.endsWith(".json"));

        // Convert array of File objects to List of Strings
        List<String> jsonFilePaths = new ArrayList<>();
        assert jsonFiles != null;
        for (File file : jsonFiles) {
            jsonFilePaths.add(file.getAbsolutePath());
        }
        net.masterthought.cucumber.Configuration configuration = new net.masterthought.cucumber.Configuration(reportOutputDirectory, reportName);
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Browser", "Firefox");

        // Generate the cucumber report with a specific name
        ReportBuilder reportBuilder = new ReportBuilder(jsonFilePaths, configuration);
        reportBuilder.generateReports();


    }
}
