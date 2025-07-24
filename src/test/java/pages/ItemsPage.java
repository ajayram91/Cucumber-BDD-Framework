package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ItemsPage {

    //Constructor for Login Page
    public ItemsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //********************* ELEMENTS **********************

    @FindBy(xpath = "//a[@href='/admin/items']")
    public WebElement itemsPageLink;

    @FindBy(xpath = "//button[text()=' Add Item']")
    public WebElement addItemButton;

    @FindBy(xpath = "(//input[contains(@class,'rounded-md')])[2]")
    public WebElement nameInputField;

    @FindBy(xpath = "(//input[contains(@class,'rounded-md')])[3]")
    public WebElement priceInputField;

    @FindBy(xpath = "(//input[contains(@class,'rounded-md')])[4]")
    public WebElement unitDropdown;

    @FindBy(xpath = "(//textarea)[1]")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "(//form//button)[last()]")
    public WebElement saveItemButton;

    @FindBy(xpath = "//table//tbody//tr[1]//td[2]//a")
    public WebElement firstRowItemNameCell;

}
