package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginsteps {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("User navigates to Crater website")
    public void user_navigates_to_crater_website() {

        driver.get("http://crater.primetech-apps.com/login");
        driver.manage().window().maximize();

    }

    @When("I enter {string} in the email field")
    public void i_enter_in_the_email_field(String email) throws InterruptedException {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")));
        System.out.println("Email visible: " + emailField.isDisplayed());
        System.out.println("Email enabled: " + emailField.isEnabled());
        emailField.click();
        Thread.sleep(500); // slight delay so JS focus/transition completes
        emailField.sendKeys(email);
    }

    @When("I enter {string} in the password field")
    public void i_enter_in_the_password_field(String password) throws InterruptedException {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        passwordField.click();
        Thread.sleep(500); // slight delay so JS focus/transition completes
        passwordField.sendKeys(password);
    }

    @When("I click on the Login button")
    public void i_click_on_the_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='loginForm']/button")));
        loginButton.click();
        WebElement element = driver.findElement(By.xpath("//div/p4"));
        String text = element.getText();
        System.out.println("Text inside p4: " + text);
    }

    @Then("I should see the Settings page")
    public void i_should_see_the_settings_page() {
        // Wait for the heading element to be visible
        WebElement settingsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3"))
        );

// Get the text from the heading
        String actualHeading = settingsHeader.getText();

// Define your expected heading text
        String expectedHeading = "Settings";

// Compare and verify
        if (actualHeading.equals(expectedHeading)) {
            System.out.println("✅ Heading matches expected text: " + actualHeading);
        } else {
            System.out.println("❌ Heading mismatch! Found: " + actualHeading);
        }

        driver.quit();
    }

}
