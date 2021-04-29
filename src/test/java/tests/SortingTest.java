package tests;

import blocks.Product;
import com.google.common.collect.Ordering;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.MainPage;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SortingTest extends BaseTest {

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

           //assertThat(beforeSort).isEqualTo(afterSort);

        } catch (NoSuchElementException | InterruptedException exception) {


        }


    }
}
