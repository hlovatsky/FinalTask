package pages;

import blocks.MainPageProduct;
import blocks.SalePageProduct;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnSalePage extends BasePage {
    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productsOnSalePage;

    public OnSalePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public List<SalePageProduct> getProductsOnSalePage() {
        SalePageProduct salePageProduct = new SalePageProduct();
        List<SalePageProduct> allProductsOnSalePage = salePageProduct.getAllProductsOnSalePage(productsOnSalePage);
        return allProductsOnSalePage;
    }

}
