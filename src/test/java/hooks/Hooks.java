package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class

Hooks {

    @Before
    public void setUp() {
        // Initialize WebDriver instance before each scenario
        Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot if scenario fails
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }

        // Quit browser after each scenario
        Driver.quitDriver();
    }
}