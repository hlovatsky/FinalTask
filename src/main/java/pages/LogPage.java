package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'create_account')]")
    private WebElement noAccountLink;

    public LogPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CreateNewAccountPage clickOnNoAccountButton() {
        noAccountLink.click();
        return new CreateNewAccountPage();
    }
}
