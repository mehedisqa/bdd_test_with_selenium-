package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"steps"}
        , monochrome = true
        , plugin = {"pretty", "html:target/htmlReports/reports.html"
        , "json:target/JSONReports/reports.json"
        , "junit:target/JUnitReport/reports.xml"}
        , tags = "@sanity"
)

public class TestRunner { }
