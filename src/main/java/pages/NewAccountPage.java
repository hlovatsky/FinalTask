package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage extends BasePage {

    @FindBy(xpath = "//a[@class='account']//span[@class='hidden-sm-down']")
    private WebElement newAccountField;

    public NewAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String getTextFromNewAccountField() {
        return newAccountField.getText();
    }
}
