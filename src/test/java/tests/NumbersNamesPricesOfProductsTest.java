package tests;

import blocks.Product;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class NumbersNamesPricesOfProductsTest extends BaseTest {

    @Test
    public void getNumberOfProducts() {
        MainPage mainPage = new MainPage();

        try {
            int allProductsOnPage = mainPage.getNumberOfProductsOnPage();
            assertThat(allProductsOnPage).isEqualTo(8);
        } catch (NoSuchElementException e) {

        }
    }

    @Test
    public void getNamesOFProducts() {
        MainPage mainPage = new MainPage();

        try {
            List<Product> allProductsWithName = mainPage.getProductsOnMainPage();
            for (Product product : allProductsWithName) {
                assertThat(product.getName().isDisplayed()).isEqualTo(true);
            }
        } catch (NoSuchElementException e) {

        }
    }

    @Test
    public void getPriceOFProducts() {
        MainPage mainPage = new MainPage();

        try {
            List<Product> allProductsWithPrice = mainPage.getProductsOnMainPage();
            for (Product product : allProductsWithPrice) {
                assertThat(product.getWeNewPrice().isDisplayed()).isEqualTo(true);
            }
        } catch (NoSuchElementException e) {

        }
    }

    @Test
    public void isPriceMoreThanZero() {
        MainPage mainPage = new MainPage();

        try {
            List<Product> prices = mainPage.getProductsOnMainPage();
            for (Product product : prices) {
                assertThat(product.parseNewPriceToDouble()).isGreaterThan(0.00);
            }
        } catch (NoSuchElementException e) {

        }
    }
}