package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
glue = {"stepdefinitions", "hooks"}, plugin = {"pretty", "html:target/craterhtmlreport.html","json:target/craterreport.json"},
        dryRun = true

)
public class DryRunTestRunner {


    /*

    This class will run our step definitions.
     */
}
