package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver =  Driver.getDriver();
    LoginPage loginPage = new LoginPage();

    @Given("User navigates to Crater website")
    public void user_navigates_to_crater_website() {
        driver.manage().deleteAllCookies();
        driver.get("http://crater.primetech-apps.com/login");
        driver.manage().window().maximize();

    }

    @When("I enter {string} in the email field")
    public void i_enter_in_the_email_field(String email)  {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailInput));
        loginPage.emailInput.sendKeys(email);
    }

    @When("I enter {string} in the password field")
    public void i_enter_in_the_password_field(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @When("I click on the Login button")
    public void i_click_on_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("I should see the Settings page")
    public void i_should_see_the_settings_page() {
        String actualText = loginPage.settingPageHeading.getText();
        Assert.assertEquals("Settings", actualText);

    }

    @Then("I log out of crater application" )
    public void i_log_out_of_crater_application() {
        String text = loginPage.loginSuccessModal.getText();
        System.out.println(text);
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String expectedModalText = "Error\n" +
                "These credentials do not match our records.";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(loginPage.loginErrorModal,expectedModalText));
        String actualModalText = loginPage.loginErrorModal.getText();
        System.out.println("modalText: " + actualModalText);
        Assert.assertEquals(expectedModalText, actualModalText);
    }


}
