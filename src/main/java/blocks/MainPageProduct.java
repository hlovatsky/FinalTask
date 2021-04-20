package blocks;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class MainPageProduct {
    private WebElement image;
    private WebElement name;
    private String price;
    private WebElement wePrice;


    public MainPageProduct() {
    }

    public MainPageProduct(WebElement container) {
        this.image = container.findElement(By.xpath(".//img[contains(@data-full-size-image-url,'large_default')]"));
        this.name = container.findElement(By.xpath(".//h3[@class='h3 product-title']"));
        this.price = container.findElement(By.xpath(".//div[@class='product-price-and-shipping']//span[@class='price']")).getText();
        this.wePrice = container.findElement(By.xpath(".//div[@class='product-price-and-shipping']//span[@class='price']"));
    }

    public int getNumbersOfProducts(List<WebElement> containers) {
        List<MainPageProduct> allMainPageProduct = new ArrayList<>();
        for (WebElement container : containers) {
            allMainPageProduct.add(new MainPageProduct(container));
        }
        return allMainPageProduct.size();
    }

    public List<MainPageProduct> getAllProductsOnPage(List<WebElement> containers) {
        List<MainPageProduct> allMainPageProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allMainPageProducts.add(new MainPageProduct(container));
        }
        return allMainPageProducts;
    }
}
