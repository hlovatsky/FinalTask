package tests;

import blocks.Product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;


import org.testng.annotations.Test;
import pages.MainPage;


import java.util.List;


public class NumbersNamesPricesOfProductsTest extends BaseTest {

    @Test
    public void getNumberOfProducts() {
        MainPage mainPage = new MainPage();

        int allProductsOnPage = mainPage.getNumberOfProductsOnPage();

        assertEquals(allProductsOnPage, 8);
    }

    @Test
    public void getNamesOFProducts() {
        MainPage mainPage = new MainPage();

        List<Product> allProductsWithName = mainPage.getProductsOnPage();
        for (Product product : allProductsWithName) {
            assertThat(product.getName().isDisplayed()).isEqualTo(true);
        }

    }

    @Test
    public void getPriceOFProducts() {
        MainPage mainPage = new MainPage();

        List<Product> allProductsWithPrice = mainPage.getProductsOnPage();
        for (Product product : allProductsWithPrice) {
            assertThat(product.getWePrice().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void isPriceMoreThanZero() {
        MainPage mainPage = new MainPage();

        List<Product> prices = mainPage.getProductsOnPage();
        for (Product product : prices) {
            String price = product.getPrice().replace("€","");
            assertThat(Double.parseDouble(price)).isGreaterThan(0.00);
        }
    }
}

