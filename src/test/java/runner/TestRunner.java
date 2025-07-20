package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/login.feature",
glue = {"stepdefinitions"}, plugin = {"pretty", "html:target/craterhtmlreport.html","json:target/craterreport.json"}


)
public class TestRunner {


    /*

    This class will run our step definitions.
     */
}
