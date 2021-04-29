package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//select[@class='form-control form-control-select']")
    private WebElement paperTypeButton;

    @FindBy(xpath = "//option[@title='Doted']")
    private WebElement dotedType;

    @FindBy(xpath = "//i[@class='material-icons touchspin-up']")
    private WebElement quantityField;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addButton;

    @FindBy(xpath = "//h4[@class='modal-title h6 text-sm-center']")
    private WebElement newWindow;

    @FindBy(xpath = "//div[@id='blockcart-modal']//div[@class='row']//span[@class='paper type']")
    private WebElement paperType;

    @FindBy(xpath = "//span[@class='product-quantity']/strong")
    private WebElement quantity;

    @FindBy(xpath = "//div[@class='col-md-6']//p[@class='product-price']")
    private WebElement priceOfOneProduct;

    @FindBy(xpath = "//span[@class='subtotal value']")
    private WebElement totalPrice;

    public ProductPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ProductPage clickOnPaperTypeButton() {
        paperTypeButton.click();
        return this;
    }

    public ProductPage clickOnDotedType() throws InterruptedException {
        Thread.sleep(1000);
        dotedType.click();
        return this;
    }

    public ProductPage clickOnQuantityField() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            Thread.sleep(1000);
            quantityField.click();
        }
        return this;
    }

    public ProductPage clickOnAddButton() {
        addButton.click();
        return this;
    }

    public String getNewWindowsText() {
        return newWindow.getAttribute("innerText").replace("\uE876", "");

    }

    public String getPaperTypeText() {
        String[] s = paperType.getAttribute("innerText").split(":");
        return s[1];

    }

    public int getQuantityNum() {
        return Integer.parseInt(quantity.getAttribute("innerText"));

    }

    public double parsePriceIntoDouble() {
        String price = priceOfOneProduct.getAttribute("innerText").replace("€", "");
        double priceOfOneProduct = Double.parseDouble(price);
        return priceOfOneProduct;
    }

    public double getTotalPrice() {
        return parsePriceIntoDouble() * getQuantityNum();
    }

    public double parseTotalPriceToDouble() {
        return Double.parseDouble(totalPrice.getAttribute("innerText").replace("€", ""));
    }

}
