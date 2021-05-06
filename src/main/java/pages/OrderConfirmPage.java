package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage extends BasePage {
    @FindBy(xpath = "//div[@class='col-md-12']//h3[@class='h1 card-title']")
    private WebElement confirmMassageField;

    public OrderConfirmPage() {
        PageFactory.initElements(getDriver(), this);

    }

    public String getText() {
        return confirmMassageField.getAttribute("innerText").replace("\uE876", "");

    }
}
