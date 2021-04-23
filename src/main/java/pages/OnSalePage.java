package pages;

import blocks.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnSalePage extends BasePage {
    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productsContainersOnSalePage;

    public OnSalePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<Product> getProductsOnPage() {
        Product product = new Product();
        List<Product> allProductsOnSalePage = product.getAllProductsOnPage(productsContainersOnSalePage);
        return allProductsOnSalePage;
    }






}