package tests;

import blocks.SalePageProduct;
import org.testng.annotations.Test;
import pages.MainPage;

import java.math.RoundingMode;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PricesOfProductsTest extends BaseTest {

    @Test
    public void hasProductOldPrice() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<SalePageProduct> allProductsWithOldPrice = mainPage.clickOnPriceDropLink()
                .getProductsOnSalePage();
        for (SalePageProduct salePageProduct : allProductsWithOldPrice) {
            assertThat(salePageProduct.getWeSalesOldPrice().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void hasProductNewPrice() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<SalePageProduct> allProductsWithNewPrice = mainPage.clickOnPriceDropLink()
                .getProductsOnSalePage();
        for (SalePageProduct salePageProduct : allProductsWithNewPrice) {
            assertThat(salePageProduct.getWeSalesNewPrice().isDisplayed()).isEqualTo(true);
        }
    }

    @Test
    public void checkDiscount() throws InterruptedException {

        MainPage mainPage = new MainPage();

        List<SalePageProduct> allProductsWithPrice = mainPage.clickOnPriceDropLink()
                .getProductsOnSalePage();
        for (SalePageProduct salePageProduct : allProductsWithPrice) {
            String originalOldPrice = salePageProduct.getSalesOldPrice().replace("€", "");
            double priceOld = Double.parseDouble(originalOldPrice);

            String originalNewPrice = salePageProduct.getSalesNewPrice().replace("€", "");
            double priceNew = Double.parseDouble(originalNewPrice);

            String originalDiscount = salePageProduct.getDiscount().substring(1, 3);
            int discount = Integer.parseInt(originalDiscount);

            double percentOfNewPrice = priceNew * 100 / priceOld;
            int percent = (int) (100 - percentOfNewPrice);

            assertThat(discount).isEqualTo(percent);
        }
    }
}
