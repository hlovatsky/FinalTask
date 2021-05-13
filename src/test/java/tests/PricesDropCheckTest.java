package tests;

import blocks.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class PricesDropCheckTest extends BaseTest {

    @Test
    public void haveProductsPrices() throws InterruptedException {

        MainPage mainPage = new MainPage();

        SoftAssertions softAssert = new SoftAssertions();

        List<Product> allProductsOnPage = mainPage.clickOnPriceDropLink()
                .getProductsOnPage();
        for (Product product : allProductsOnPage) {
            softAssert.assertThat(product.getWeOldPrice().isDisplayed()).isEqualTo(true);

            softAssert.assertThat(product.getWeNewPrice().isDisplayed()).isEqualTo(true);

            softAssert.assertThat(product.parseNewPriceToDouble())
                    .as("Wrong callculation")
                    .isEqualTo(product.getAdjNewPrice());

            softAssert.assertAll();
        }
    }
}