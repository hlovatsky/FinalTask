package pages;

import utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage extends BasePage {

    Utils utils = new Utils();

    @FindBy(xpath = "//div[@class='col-md-12']//h3[@class='h1 card-title']")
    private WebElement confirmMassageField;

    @FindBy(xpath = "//div[@class='row']//div[@class='col-xs-4 text-sm-center text-xs-left' and text()='€16.68']")
    private WebElement priceOfSecondProduct;

    @FindBy(xpath = "//div[@class='row']//div[@class='col-xs-4 text-sm-center text-xs-left' and text()='€22.94']")
    private WebElement priceOfFirstProduct;

    @FindBy(xpath = "//table//td[text()='€8.40']")
    private WebElement tax;

    @FindBy(xpath = "//tr[@class='total-value font-weight-bold']//td[text()='€48.02']")
    private WebElement totalPrice;

    public OrderConfirmPage() {
        PageFactory.initElements(getDriver(), this);

    }

    public String getTextFromConfirmField() {
        return confirmMassageField.getAttribute("innerText").replace("\uE876", "");

    }

    public double parsePriceOfFirstProductToDouble() {
        return utils.parseToDouble(priceOfFirstProduct);
    }

    public double parsePriceOfSecondProductToDouble() {
        return utils.parseToDouble(priceOfSecondProduct);
    }

    public double parseTaxToDouble() {
        return utils.parseToDouble(tax);
    }

    public double getSumOfPrice() {
        return parsePriceOfFirstProductToDouble() + parsePriceOfSecondProductToDouble() + parseTaxToDouble();
    }

    public double parseTotalPriceToDouble() {
        return utils.parseToDouble(totalPrice);
    }
}
