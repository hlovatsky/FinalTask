package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//img[contains(@src,'brown-bear-notebook')]")
    private WebElement brownBearNotebookProduct;

    @FindBy(xpath = "//img[@alt='Customizable mug']")
    private WebElement customizableMug;

    @FindBy (xpath = "//img[@alt='Hummingbird printed t-shirt']")
    private WebElement tShirtProduct;

    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ProductPage clickOnBrownBearNotebookProduct() {
        brownBearNotebookProduct.click();
        return new ProductPage();
    }

    public ProductPage clickOnCustomizableMug() {
        customizableMug.click();
        return new ProductPage();
    }

    public ProductPage clickOnTShirtProduct() {
        tShirtProduct.click();
        return new ProductPage();
    }

}
