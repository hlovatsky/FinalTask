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

        OrderConfirmPage orderConfirmPage = mainPage.inputProductsName("Mug")
                .clickOnCustomizableMug()
                .inputProductCustomization("Best mug ever")
                .clickOnSaveCustomizationButton()
                .clickOnAddToCartButton()
                .clickOnContinueShoppingButton()
                .inputNameOfProduct("T-shirt")
                .clickOnTShirtProduct()
                .clickOnBlackColorButton()
                .clickOnAddToCartButton()
                .clickOnProceedToCheckoutButton()
                .checkTotalPrice()
                .clickOnMrWindow()
                .inputFirstName("Petro")
                .inputLastName("Petrenko")
                .inputEmail("fjgjg@mail.ru")
                .inputBirthday("01/01/1970")
                .clickOnReceiveOffersWindow()
                .clickOnCustomerPrivacyWindow()
                .clickOnNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnContinueButton()
                .inputAddress("Vinnitsya")
                .inputZipPostalCodeField("21037")
                .inputCityField("Vinnitsya")
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
