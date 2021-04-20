package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage extends BasePage {

    @FindBy(xpath = "//span[@class='custom-radio']//input[@value='1']")
    private WebElement mrFieldWindow;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayField;

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement receiveOffersWindow;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerDataPrivacyWindow;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement signUpForOurNewsletterWindow;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement agreeWindow;

    @FindBy(xpath = "//button[contains(@class,'submit')]")
    private WebElement saveButton;

    @FindBy(xpath = "//button[contains(@class,'submit')]")
    private WebElement saveButtonWithInvalidData;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement errorMessage;

    public CreateNewAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CreateNewAccountPage clickOnMrFieldWindow() {
        mrFieldWindow.click();
        return this;
    }

    public CreateNewAccountPage clickOnFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public CreateNewAccountPage clickOnLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public CreateNewAccountPage clickOnEmailField(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public CreateNewAccountPage clickPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public CreateNewAccountPage clickOnBirthdayField(String email) {
        birthdayField.sendKeys(email);
        return this;
    }

    public CreateNewAccountPage clickOnReceiveOffersWindow() {
        receiveOffersWindow.click();
        return this;
    }

    public CreateNewAccountPage clickOnCustomerDataPrivacyWindow() {
        customerDataPrivacyWindow.click();
        return this;
    }

    public CreateNewAccountPage clickOnSignUpForOurNewsletterWindow() {
        signUpForOurNewsletterWindow.click();
        return this;
    }

    public CreateNewAccountPage clickOnAgreeWindow() {
        agreeWindow.click();
        return this;
    }

    public NewAccountPage clickOnSaveButton() {
        saveButton.click();
        return new NewAccountPage();
    }

    public CreateNewAccountPage clickOnSaveButtonWithInvalidData() {
        saveButtonWithInvalidData.click();
        return this;
    }

    public String getColorOfFirstNameField() {
        return firstNameField.getCssValue("outline");
    }

    public boolean isErrorMessageIsDisplayed() {
        return errorMessage.isDisplayed();
    }
}
