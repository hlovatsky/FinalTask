package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProductPage;

public class AddingToCartTest extends BaseTest {

    @Test
    public void checkResultAfterAddToCard() throws InterruptedException {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssert = new SoftAssertions();

        ProductPage productPage = mainPage.inputProductsName()
                .clickOnBrownBearNotebookProduct()
                .clickOnPaperTypeButton()
                .clickOnDotedType()
                .clickOnQuantityField()
                .clickOnAddToCartButton();

        softAssert.assertThat(productPage.getNewWindowsText()).
                as("The actual text is different from the expected text")
                .isEqualTo("Product successfully added to your shopping cart");

        softAssert.assertThat(productPage.getPaperTypeText())
                .as("The actual text is different from the expected text")
                .isEqualTo(" Doted");

        softAssert.assertThat(productPage.getQuantityNum())
                .as("Quantity isn't 5")
                .isEqualTo(5);
        softAssert.assertThat(productPage.getTotalPrice())
                .as("Wrong calculate")
                .isEqualTo(productPage.parseTotalPriceToDouble());

        softAssert.assertAll();
    }
}