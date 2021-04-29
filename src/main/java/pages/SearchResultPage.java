package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//img[contains(@src,'brown-bear-notebook')]")
    private WebElement brownBearNotebookProduct;

    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public ProductPage clickOnBrownBearNotebookProduct() {
        brownBearNotebookProduct.click();
        return new ProductPage();
    }

}
