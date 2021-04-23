package tests;

import blocks.Product;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PricesOfProductsTest extends BaseTest {

    @Test
    public void hasProductOldPrice() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<Product> allProductsWithOldPrice = mainPage.clickOnPriceDropLink()
                .getProductsOnPage();
        for (Product product : allProductsWithOldPrice) {
            assertThat(product.getWeOldPrice().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void hasProductNewPrice() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<Product> allProductsWithNewPrice = mainPage.clickOnPriceDropLink()
                .getProductsOnPage();
        for (Product product : allProductsWithNewPrice) {
            assertThat(product.getWeNewPrice().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void checkDiscount() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<Product> allProductsOnPage = mainPage.clickOnPriceDropLink()
                .getProductsOnPage();
        for (Product product : allProductsOnPage) {

            assertThat(product.parseNewPriceToDouble()).isEqualTo(product.getAdjNewPrice());


        }
    }


}
