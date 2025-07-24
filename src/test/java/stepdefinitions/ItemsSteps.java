package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

public class ItemsSteps {
    WebDriver driver =  Driver.getDriver();
    ItemsPage itemsPage = new ItemsPage();
    LoginPage loginPage = new LoginPage();
    String itemName;

    @Given("User is logged in sucessfully")
    public void user_is_logged_in_sucessfully() {
       driver.get("http://crater.primetech-apps.com/login");
       loginPage.emailInput.sendKeys("ajay@primetechschool.com");
       loginPage.passwordInput.sendKeys("ptschool");
       loginPage.loginButton.click();
    }
    @When("User clicks on the Add Item button")
    public void user_clicks_on_the_add_item_button() {
        itemsPage.itemsPageLink.click();
        itemsPage.addItemButton.click();
    }
    @When("User enters the item name as {string}")
    public void user_enters_the_item_name_as(String name) {
        itemName = name;
        itemsPage.nameInputField.sendKeys(name);
    }
    @When("User enters the item description as {string}")
    public void user_enters_the_item_description_as(String string) {

        itemsPage.descriptionTextBox.sendKeys(string);
    }

    @When("User enters the item price {string}")
    public void user_enters_the_item_price(String price) {
        itemsPage.priceInputField.sendKeys(price);
    }
    @When("User enters the item unit {string}")
    public void user_enters_the_item_unit(String string) {
        itemsPage.unitDropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement option = driver.findElement(By.xpath("//ul/li[normalize-space()='string']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", option);
    }
    @When("User clicks on the Save Item button")
    public void user_clicks_on_the_save_item_button() {

        itemsPage.saveItemButton.click();
    }
    @Then("Item should be listed in the items table")
    public void item_should_be_listed_in_the_items_table() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(itemsPage.firstRowItemNameCell));
        String actualItemName = itemsPage.firstRowItemNameCell.getText().trim();
        System.out.println("Item name is " + actualItemName);
        System.out.println("Expected Item " + itemName);
    }

    @And("I should view the item added in the Database")
    public void i_should_view_the_item_added_in_the_database() throws SQLException {
            String query = "SELECT * FROM CraterDBS.items WHERE name = '" + itemName + "' ORDER BY id DESC LIMIT 1";
            String dbUrl = ConfigReader.getProperty("db.url");
            String dbUser = ConfigReader.getProperty("db.username");
            String dbPassword = ConfigReader.getProperty("db.password");

            DBUtils.connectToDB(dbUrl, dbUser, dbPassword);
            ResultSet rs = DBUtils.executeQuery(query);

        if (rs.next()) {
            String actualName = rs.getString("name");
            System.out.println("DB Item name: " + actualName);
            Assert.assertEquals("Item name in DB does not match!", itemName, actualName);
        } else {
            Assert.fail("No item found in the database.");
        }

            DBUtils.closeConnection();
        }
    }



