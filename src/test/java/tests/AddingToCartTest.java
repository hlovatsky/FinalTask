package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AddingToCartTest extends BaseTest {
    @Test
    public void checkTitleOfNewWindow() throws InterruptedException {
        MainPage mainPage = new MainPage();

        ProductPage productPage = mainPage.inputProductsName("Bear")
                .clickOnBrownBearNotebookProduct()
                .clickOnPaperTypeButton()
                .clickOnDotedType()
                .clickOnQuantityField()
                .clickOnAddToCartButton();

        assertThat(productPage.getNewWindowsText()).isEqualTo("Product successfully added to your shopping cart");
    }

    @Test
    public void checkPaperTextAndQuantityNum() throws InterruptedException {
        MainPage mainPage = new MainPage();

        ProductPage productPage = mainPage.inputProductsName("Bear")
                .clickOnBrownBearNotebookProduct()
                .clickOnPaperTypeButton()
                .clickOnDotedType()
                .clickOnQuantityField()
                .clickOnAddToCartButton();

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(productPage.getPaperTypeText()).isEqualTo(" Doted");
        softAssert.assertThat(productPage.getQuantityNum()).isEqualTo(5);
        softAssert.assertAll();
    }

    @Test
    public void checkTotalPrice() throws InterruptedException {
        MainPage mainPage =  new MainPage();

        ProductPage productPage = mainPage.inputProductsName("Bear")
                .clickOnBrownBearNotebookProduct()
                .clickOnPaperTypeButton()
                .clickOnDotedType()
                .clickOnQuantityField()
                .clickOnDotedType()
                .clickOnAddToCartButton();

        assertThat(productPage.getTotalPrice()).isEqualTo(productPage.parseTotalPriceToDouble());
    }
}