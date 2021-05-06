package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderConfirmPage;
import pages.PersonalInformationPage;
import pages.ShoppingCartPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutEndToEndTest extends BaseTest {
    @Test
    public void getConfirmOfOrder() {
        MainPage mainPage = new MainPage();
        String orderConfirmPage = mainPage.inputProductsName("Mug")
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
                .clickOnPlaceOrderButton()
                .getText();



        assertThat(orderConfirmPage).isEqualTo("YOUR ORDER IS CONFIRMED");
    }
}
