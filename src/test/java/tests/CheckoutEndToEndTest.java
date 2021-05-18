package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderConfirmPage;

public class CheckoutEndToEndTest extends BaseTest {

    @Test
    public void checkTextOfConfirmOfOrder() {
        String firstProduct = "Mug";
        String secondProduct = "T-shirt";
        String productCustomization = "Best mug ever";
        String firstName = "Petro";
        String lastName = "Petrenko";
        String email = "PetrPetrenko@i.ua";
        String birthday = "01/01/1970";
        String address = "Soborna str.";
        String zipCode = "21000";
        String city = "Vinnitsya";
        MainPage mainPage = new MainPage();
        SoftAssertions softAssert = new SoftAssertions();

        OrderConfirmPage orderConfirmPage = mainPage.inputProductsName(firstProduct)
                .clickOnCustomizableMug()
                .inputProductCustomization(productCustomization)
                .clickOnSaveCustomizationButton()
                .clickOnAddToCartButton()
                .clickOnContinueShoppingButton()
                .inputProductsName(secondProduct)
                .clickOnTShirtProduct()
                .clickOnBlackColorButton()
                .clickOnAddToCartButton()
                .clickOnProceedToCheckoutButton()
                .checkTotalPrice()
                .clickOnMrWindow()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputEmail(email)
                .inputBirthday(birthday)
                .clickOnReceiveOffersWindow()
                .clickOnCustomerPrivacyWindow()
                .clickOnNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnContinueButton()
                .inputAddress(address)
                .inputZipPostalCodeField(zipCode)
                .inputCityField(city)
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
