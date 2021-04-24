package tests;

import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
        SoftAssertions softAssert =new SoftAssertions();
        for (Product product : allProductsOnPage) {
            softAssert.assertThat(product.parseNewPriceToDouble())
                    .as("Wrong callculation")
                    .isEqualTo(product.getAdjNewPrice());
        }
        softAssert.assertAll();
    }


}
