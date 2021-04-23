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
    private WebElement name;
    private WebElement weOldPrice;
    private WebElement weNewPrice;
    private String oldPrice;
    private String newPrice;
private String discount;

    public Product() {
    }

    public Product(WebElement container) {
        this.name = container.findElement(By.xpath(".//a[@itemprop='url']"));
        this.weOldPrice = container.findElement(By.xpath(".//span[@class='regular-price']"));
        this.weNewPrice = container.findElement(By.xpath(".//span[@class='price']"));
        this.oldPrice = container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
        this.newPrice = container.findElement(By.xpath(".//span[@class='price']")).getText();
        this.discount = container.findElement(By.xpath("//ul[@class='product-flags']//li[@class='product-flag discount']")).getText();
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

    public double parseOldPriceToDouble() {
        return Double.parseDouble(getOldPrice().replace("€", ""));
    }

    public int parseDiscountToDouble() {
        return Integer.parseInt(getDiscount().substring(1, 3));
    }

    public double parseNewPriceToDouble() {
        return Double.parseDouble(getNewPrice().replace("€", ""));
    }

    public double getDiscountValue() {
        return (parseOldPriceToDouble() * parseDiscountToDouble() / 100);
    }

    public double getAdjNewPrice() {
        return parseOldPriceToDouble() - getDiscountValue();
    }
}