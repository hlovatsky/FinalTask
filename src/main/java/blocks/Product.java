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
public class Product {
    private WebElement image;
    private WebElement name;
    private String price;
    private WebElement wePrice;

    public Product() {
    }

    public Product(WebElement container) {
        this.image = container.findElement(By.xpath(".//img[contains(@data-full-size-image-url,'large_default')]"));
        this.name = container.findElement(By.xpath(".//h3[@class='h3 product-title']"));
        this.price = container.findElement(By.xpath(".//div[@class='product-price-and-shipping']//span[@class='price']")).getText();
        this.wePrice = container.findElement(By.xpath(".//div[@class='product-price-and-shipping']//span[@class='price']"));

        //this.regularPrice = container.findElement(By.xpath(".//div[@class='product-price-and-shipping']//span[@class='regular-price']"));
    }

    public int getNumbersOfProducts(List<WebElement> containers) {
        List<Product> allProduct = new ArrayList<>();
        for (WebElement container : containers) {
            allProduct.add(new Product(container));
        }
        return allProduct.size();
    }

    public List<Product> getAllProductsOnPage(List<WebElement> containers) {
        List<Product> allProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allProducts.add(new Product(container));
        }
        return allProducts;
    }
}
