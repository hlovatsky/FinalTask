package tests;

import blocks.MainPageProduct;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import pages.MainPage;
import java.util.List;

public class NumbersNamesPricesOfProductsTest extends BaseTest {

    @Test
    public void getNumberOfProducts() {
        MainPage mainPage = new MainPage();

        int allProductsOnPage = mainPage.getNumberOfProductsOnPage();

        assertThat(allProductsOnPage).isEqualTo(8);
    }

    @Test
    public void getNamesOFProducts() {
        MainPage mainPage = new MainPage();

        List<MainPageProduct> allProductsWithName = mainPage.getProductsOnMainPage();
        for (MainPageProduct mainPageProduct : allProductsWithName) {
            assertThat(mainPageProduct.getName().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void getPriceOFProducts() {
        MainPage mainPage = new MainPage();

        List<MainPageProduct> allProductsWithPrice = mainPage.getProductsOnMainPage();
        for (MainPageProduct mainPageProduct : allProductsWithPrice) {
            assertThat(mainPageProduct.getWePrice().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void isPriceMoreThanZero() {
        MainPage mainPage = new MainPage();

        List<MainPageProduct> prices = mainPage.getProductsOnMainPage();
        for (MainPageProduct mainPageProduct : prices) {
            String price = mainPageProduct.getPrice().replace("€", "");

            assertThat(Double.parseDouble(price)).isGreaterThan(0.00);
        }
    }
}