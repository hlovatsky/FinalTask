package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage {

    //Test #1
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//p[contains(@class,'alert')]")
    private WebElement textFromMessage;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage inputEmail(String email) throws InterruptedException {
        scrollToElementWithJS(emailInput);
        emailInput.sendKeys(email);
        return this;
    }

    public MainPage subscribeButton() {
        subscribeButton.click();
        return this;
    }

    public boolean isErrorMessageExistInEmailField() {
        return isErrorExist(emailInput);
    }

    //Test #2
    @FindBy(xpath = "//button[@aria-label='Language dropdown']")
    private WebElement languageButton;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]")
    private List<WebElement> languages;

    public MainPage clickOnLanguageButton() {
        languageButton.click();
        return this;
    }

    //Test #3 and #4
    @FindBy(xpath = "//div[@class='user-info']//span[@class='hidden-sm-down']")
    private WebElement signInButton;

    public LogPage clickOnSignInButton() {
        signInButton.click();
        return new LogPage();
    }






}
