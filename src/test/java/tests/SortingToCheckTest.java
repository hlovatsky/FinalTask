package tests;

import blocks.Product;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingToCheckTest extends BaseTest {

    @Test
    public void areProductsSorted() {
        MainPage mainPage = new MainPage();
        Product product = new Product();

        try {
            List<Product> allProductsOnPageBeforeSort = mainPage.clickOnAllProductsLink()
                    .getAllProductsOnPage();

            product.compareTo(product);

            Collections.sort(allProductsOnPageBeforeSort);

            List<Product> allProductsPageAfterSort = mainPage.clickOnAllProductsLink()
                    .clickOnSortByButton()
                    .clickOnNameAToZLink()
                    .getAllProductsOnPage();

            assertThat(allProductsOnPageBeforeSort).isEqualTo(allProductsPageAfterSort);

        } catch (NoSuchElementException | InterruptedException exception) {

        }

    }
}
