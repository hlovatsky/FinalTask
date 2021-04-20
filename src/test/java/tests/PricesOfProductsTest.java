package tests;

import blocks.Product;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PricesOfProductsTest {

    @Test
    public void hasProductOldPrice() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<Product> allProductsWithOldPrice = mainPage.clickOnPriceDropLink()
                .getProductsOnSalesPage();
        for (Product product : allProductsWithOldPrice) {
            assertThat(product.getSalesOldPrice().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void hasProductNewPrice() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<Product> allProductsWithNewPrice = mainPage.clickOnPriceDropLink()
                .getProductsOnSalesPage();
        for (Product product : allProductsWithNewPrice) {
            assertThat(product.getSalesNewPrice().isDisplayed()).isEqualTo(true);
        }
    }
}
