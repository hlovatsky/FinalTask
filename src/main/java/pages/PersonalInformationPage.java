package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInformationPage extends BasePage {
    @FindBy(xpath = "//div[@class='col-md-6 form-control-valign']//input[@value='1']")
    private WebElement mrWindow;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//form[@id='customer-form']//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//form[@id='customer-form']//input[@name='birthday']")
    private WebElement birthdayField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='optin']")
    private WebElement receiveOffersWindow;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='customer_privacy']")
    private WebElement customerPrivacyWindow;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='newsletter']")
    private WebElement newsletterWindow;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='psgdpr']")
    private WebElement agreeWindow;

    @FindBy(xpath = "//footer[@class='form-footer clearfix']//button[@name='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='address1']")
    private WebElement addressField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='postcode']")
    private WebElement zipPostalCodeField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = "//footer[@class='form-footer clearfix']//button[@name='confirm-addresses']")
    private WebElement secondContinueButton;

    @FindBy(xpath = "//div[@class='row delivery-option']//input[@id='delivery_option_2']")
    private WebElement myCarrierWindow;

    @FindBy(xpath = "//button[@name='confirmDeliveryOption']")
    private WebElement thirdContinueButton;

    @FindBy(xpath = "//div[@id='payment-option-1-container']//input")
    private WebElement payByCheckWindow;

    @FindBy(xpath = "//div[@id='payment-option-1-additional-information']//dl//dd[contains(text(),'48.02')]")
    private WebElement amountTotalPrice;

    @FindBy(xpath = "//div[@class='cart-summary-line cart-total']//span[@class='value']")
    private WebElement totalPrice;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]']")
    private WebElement secondAgreeWindow;

    @FindBy(xpath = "//div[@class='ps-shown-by-js']//button[@class='btn btn-primary center-block']")
    WebElement placeOrderButton;

    public PersonalInformationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public PersonalInformationPage clickOnMrWindow() {
        mrWindow.click();
        return this;
    }

    public PersonalInformationPage inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public PersonalInformationPage inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public PersonalInformationPage inputEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public PersonalInformationPage inputBirthday(String birthday) {
        birthdayField.sendKeys(birthday);
        return this;
    }

    public PersonalInformationPage clickOnReceiveOffersWindow() {
        receiveOffersWindow.click();
        return this;
    }

    public PersonalInformationPage clickOnCustomerPrivacyWindow() {
        customerPrivacyWindow.click();
        return this;
    }

    public PersonalInformationPage clickOnNewsletterWindow() {
        newsletterWindow.click();
        return this;
    }

    public PersonalInformationPage clickOnAgreeWindow() {
        agreeWindow.click();
        return this;
    }

    public PersonalInformationPage clickOnContinueButton() {
        continueButton.click();
        return this;
    }

    public PersonalInformationPage inputAddress(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public PersonalInformationPage inputZipPostalCodeField(String code) {
        zipPostalCodeField.sendKeys(code);
        return this;
    }

    public PersonalInformationPage inputCityField(String city) {
        cityField.sendKeys(city);
        return this;
    }

    public PersonalInformationPage clickOnSecondContinueButton() {
        secondContinueButton.click();
        return this;
    }

    public PersonalInformationPage clickOnMyCarrierWindow() {
        myCarrierWindow.click();
        return this;
    }

    public PersonalInformationPage clickOnThirdContinueButton() {
        thirdContinueButton.click();
        return this;
    }

    public PersonalInformationPage clickOnPayByCheckWindow() {
        payByCheckWindow.click();
        return this;
    }

    public double parseAmountTotalPriceToDouble() {
        String price = amountTotalPrice.getAttribute("innerText");
        String[] s = price.split(" ");
        String newPrice = s[0].replace("€", "");
        double amountTotalPrice = Double.parseDouble(newPrice);
        return amountTotalPrice;
    }

    public double parseTotalPriceToDouble() {
        String price = totalPrice.getAttribute("innerText").replace("€", "");
        double totalPrice = Double.parseDouble(price);
        return totalPrice;
    }

    public PersonalInformationPage checkPrices() {
        if (parseAmountTotalPriceToDouble() == parseTotalPriceToDouble()) {
            secondAgreeWindow.click();
        } else {
            System.out.println("The prices are different");
        }
        return this;
    }

    public OrderConfirmPage clickOnPlaceOrderButton() {
        placeOrderButton.click();
        return new OrderConfirmPage();
    }
}
