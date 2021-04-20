package blocks;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class SalePageProduct {
    private WebElement image;
    private WebElement name;
    private WebElement weSalesOldPrice;
    private WebElement weSalesNewPrice;
    private String discount;
    private String salesOldPrice;
    private String salesNewPrice;

    public SalePageProduct() {
    }

    public SalePageProduct(WebElement container) {
        this.image = container.findElement(By.xpath(".//img[contains(@src,'printed')]"));
        this.name = container.findElement(By.xpath(".//h2[@class='h3 product-title']//a[contains(@content,'printed')]"));
        this.weSalesOldPrice = container.findElement(By.xpath(".//span[@class='regular-price']"));
        this.weSalesNewPrice = container.findElement(By.xpath(".//span[@class='price']"));
        this.discount = container.findElement(By.xpath(".//ul[@class='product-flags']//li[@class='product-flag discount']")).getText();
        this.salesOldPrice = container.findElement(By.xpath(".//span[@class='regular-price']")).getText();
        this.salesNewPrice = container.findElement(By.xpath(".//span[@class='price']")).getText();
    }

    public List<SalePageProduct> getAllProductsOnSalePage(List<WebElement> containers) {
        List<SalePageProduct> allSalePageProducts = new ArrayList<>();
        for (WebElement container : containers) {
            allSalePageProducts.add(new SalePageProduct(container));
        }
        return allSalePageProducts;
    }

}
