package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderConfirmPage;

public class CheckoutEndToEndTest extends BaseTest {

    @Test
    public void checkTextOfConfirmOfOrder() {
        MainPage mainPage = new MainPage();

        SoftAssertions softAssert = new SoftAssertions();

        OrderConfirmPage orderConfirmPage = mainPage.inputProducts()
                .clickOnCustomizableMug()
                .inputProductCustomization()
                .clickOnSaveCustomizationButton()
                .clickOnAddToCartButton()
                .clickOnContinueShoppingButton()
                .inputProductsName()
                .clickOnTShirtProduct()
                .clickOnBlackColorButton()
                .clickOnAddToCartButton()
                .clickOnProceedToCheckoutButton()
                .checkTotalPrice()
                .clickOnMrWindow()
                .inputFirstName()
                .inputLastName()
                .inputEmail()
                .inputBirthday()
                .clickOnReceiveOffersWindow()
                .clickOnCustomerPrivacyWindow()
                .clickOnNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnContinueButton()
                .inputAddress()
                .inputZipPostalCodeField()
                .inputCityField()
                .clickOnSecondContinueButton()
                .clickOnMyCarrierWindow()
                .clickOnThirdContinueButton()
                .clickOnPayByCheckWindow()
                .checkPrices()
                .clickOnPlaceOrderButton();

        softAssert.assertThat(orderConfirmPage.getTextFromConfirmField())
                .as("The actual text is different from the expected text")
                .isEqualTo("YOUR ORDER IS CONFIRMED");

        softAssert.assertThat(orderConfirmPage.getSumOfPrice())
                .as("Wrong calculate")
                .isEqualTo(orderConfirmPage.parseTotalPriceToDouble());

        softAssert.assertAll();
    }
}
