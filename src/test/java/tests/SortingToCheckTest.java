package tests;

import blocks.Product;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;

import java.util.*;

public class SortingToCheckTest extends BaseTest {

    @Test
    public void areProductsSorted() {
        MainPage mainPage = new MainPage();
        AllProductsPage allProductsPage = new AllProductsPage();
        try {
            List<Product> allProductsOnPageBeforeSort = mainPage.clickOnAllProductsLink()

                    .getAllProductsOnPage();

            String[] beforeSort = new String[allProductsOnPageBeforeSort.size()];

            for (int i = 0; i < allProductsOnPageBeforeSort.size(); i++) {
                beforeSort[i] = allProductsOnPageBeforeSort.get(i).getName().trim();

            }

            allProductsPage.clickOnSortByButton()
                    .clickOnNameAToZLink();

        } catch (NoSuchElementException | InterruptedException exception) {

        }
    }
}
