package pages;

import blocks.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllProductsPage extends BasePage {

    @FindBy(xpath = "//div[@class='col-md-6']//button[@class='btn-unstyle select-title']")
    public WebElement sortByButton;

    @FindBy (xpath = "//a[contains(text(),'Name, A to Z')]")
    public WebElement nameAToZLink;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    List<WebElement> productsContainersOnAllProductsPage;

    @FindBy (xpath = "//a[contains(text(),'Name, Z to A')]")
    public WebElement nameZToALink;

    @FindBy (xpath = "//a[contains(text(),'Price, low to high')]")
    public WebElement priceLowToHighLink;

    @FindBy (xpath = "//a[contains(text(),'Price, high to low')]")
    public WebElement priceHighToLowLink;

    public AllProductsPage() {
        PageFactory.initElements(getDriver(),this);
    }

    public AllProductsPage clickOnSortByButton() throws InterruptedException {
        scrollToElementWithJS(sortByButton);
        sortByButton.click();
        return this;
    }

    public AllProductsPage clickOnNameAToZLink() {
        nameAToZLink.click();
        return this;
    }

    public List<Product> getAllProductsOnPage() {
        Product product = new Product();
        List<Product> allProductsOnAllProductsPage = product.getAllProductsOnPage(productsContainersOnAllProductsPage);
        return allProductsOnAllProductsPage;
    }

    @FindBy(xpath = "//article[@class='product-miniature js-product-miniature']")
    private WebElement firstProduct;

    public ProductPage clickOnFirstProduct() {
        firstProduct.click();
        return new ProductPage();
    }



}




