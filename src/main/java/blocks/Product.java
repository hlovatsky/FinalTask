package blocks;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class Product {
    private WebElement weName;
    private String name;
    private WebElement weOldPrice;
    private Double oldPrice;
    private WebElement weNewPrice;
    private String newPrice;
    private WebElement weDiscount;
    private Integer discount;

    public Product() {
    }

    public Product(WebElement container) {
        this.weName = container.findElement(By.xpath(".//div[@class='product-description']//a[@itemprop='url']"));
        this.name = container.findElement(By.xpath(".//div[@class='product-description']//a[@itemprop='url']")).getText();
        this.weNewPrice = container.findElement(By.xpath(".//span[@class='price']"));
        this.newPrice = container.findElement(By.xpath(".//span[@class='price']")).getText();
        if (container.getAttribute("innerHTML").contains("regular-price")) {
            this.weOldPrice = container.findElement(By.xpath(".//span[@class='regular-price']"));
            this.oldPrice = Double.valueOf(weOldPrice.getText().substring(1));
            this.weDiscount = container.findElement(By.xpath("//ul[@class='product-flags']//li[@class='product-flag discount']"));
            this.discount = Integer.valueOf(weDiscount.getText().substring(1, 3));
        } else {
            this.oldPrice = null;
            this.discount = null;
        }
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

    public double parseNewPriceToDouble() {
        return Double.parseDouble(getNewPrice().replace("€", ""));

    }

    public double getDiscountValue() {
        return (oldPrice * discount / 100);

    }

    public double getAdjNewPrice() {
        return (double) Math.round((oldPrice - getDiscountValue()) * 100) / 100;
    }
}
