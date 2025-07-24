package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    //Constructor for Login Page

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //********************* ELEMENTS **********************

    @FindBy(xpath= "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath= "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath= "//h3[text()='Settings']")
    public WebElement settingPageHeading;

    @FindBy(xpath="//div[contains(@class, 'rounded-lg') and contains(@class, 'shadow-xs')]")
    public WebElement loginErrorModal;

    @FindBy(xpath = "//img[contains(@src, 'default-avatar.jpg')]")
    public WebElement signOutImage;

    @FindBy(xpath = "//a[@id='headlessui-menu-item-6']")
    public WebElement signOutLink;

    @FindBy(xpath = ("//button[contains(text(),'×')]"))
    public WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class, 'rounded-lg') and contains(@class, 'shadow-xs')]")
    public WebElement loginSuccessModal;


}
