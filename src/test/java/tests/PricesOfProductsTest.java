package tests;

import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class PricesOfProductsTest extends BaseTest {

    @Test
    public void haveProductsPrices() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<Product> allProductsWithPrices = mainPage.clickOnPriceDropLink()
                .getProductsOnPage();
        SoftAssertions softAssert = new SoftAssertions();
        for (Product product : allProductsWithPrices) {
            softAssert.assertThat(product.getWeOldPrice().isDisplayed()).isEqualTo(true);
            softAssert.assertThat(product.getWeNewPrice().isDisplayed()).isEqualTo(true);
            softAssert.assertAll();
        }
    }

    @Test
    public void checkDiscount() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<Product> allProductsOnPage = mainPage.clickOnPriceDropLink()
                .getProductsOnPage();
        SoftAssertions softAssert = new SoftAssertions();
        for (Product product : allProductsOnPage) {
            softAssert.assertThat(product.parseNewPriceToDouble())
                    .as("Wrong callculation")
                    .isEqualTo(product.getAdjNewPrice());
        }
        softAssert.assertAll();
    }
}