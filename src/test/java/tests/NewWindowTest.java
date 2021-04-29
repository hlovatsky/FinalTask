package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NewWindowTest extends BaseTest {
    @Test
    public void checkTitleOfNewWindow() throws InterruptedException {
        MainPage mainPage = new MainPage();

        ProductPage productPage = mainPage.inputProductsName("Bear")
                .clickOnBrownBearNotebookProduct()
                .clickOnPaperTypeButton()
                .clickOnDotedType()
                .clickOnQuantityField()
                .clickOnAddButton();


        assertThat(productPage.getNewWindowsText()).isEqualTo("Product successfully added to your shopping cart");
    }

    @Test
    public void checkPaperText() throws InterruptedException {
        MainPage mainPage = new MainPage();


        ProductPage productPage = mainPage.inputProductsName("Bear")
                .clickOnBrownBearNotebookProduct()
                .clickOnPaperTypeButton()
                .clickOnDotedType()
                .clickOnQuantityField()
                .clickOnAddButton();

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
                .clickOnAddButton();

        assertThat(productPage.getTotalPrice()).isEqualTo(productPage.parseTotalPriceToDouble());
    }
}