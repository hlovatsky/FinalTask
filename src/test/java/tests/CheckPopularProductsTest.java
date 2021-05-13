package tests;

import blocks.Product;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class CheckPopularProductsTest extends BaseTest {

    @Test
    public void checkPopularProducts() {

        MainPage mainPage = new MainPage();

        SoftAssertions softAssert = new SoftAssertions();

        List<Product> allProductsOnPage = mainPage.getProductsOnMainPage();
        for (Product product : allProductsOnPage) {
            softAssert.assertThat(product.getWeName().isDisplayed()).isEqualTo(true);
            softAssert.assertThat(product.getWeNewPrice().isDisplayed()).isEqualTo(true);
            softAssert.assertThat(product.parseNewPriceToDouble()).isGreaterThan(0.00);

        }

        int numberOfProductsOnPage = mainPage.getNumberOfProductsOnPage();
        assertThat(numberOfProductsOnPage).isEqualTo(8);

        softAssert.assertAll();
    }
}