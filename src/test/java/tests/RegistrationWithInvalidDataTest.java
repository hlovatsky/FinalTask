package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import pages.CreateNewAccountPage;
import pages.MainPage;

public class RegistrationWithInvalidDataTest extends BaseTest {

    @Test
    public void checkColorOfFirstNameField() {

        MainPage mainPage = new MainPage();

        SoftAssertions softAssert = new SoftAssertions();

        CreateNewAccountPage createNewAccountPage = mainPage.clickOnSignInButton()
                .clickOnNoAccountButton()
                .clickOnMrFieldWindow()
                .enterInvalidFirstName()
                .enterLastName()
                .enterEmail()
                .enterPassword()
                .enterBirthday()
                .clickOnReceiveOffersWindow()
                .clickOnCustomerDataPrivacyWindow()
                .clickOnSignUpForOurNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnSaveButtonWithInvalidData();

        softAssert.assertThat(createNewAccountPage.getColorOfFirstNameField())
                .as("The colors do not match").isEqualTo("rgb(255, 76, 76) ");

        softAssert.assertThat(createNewAccountPage.isErrorMessageIsDisplayed())
                .as("Message is displayed")
                .isTrue();

        softAssert.assertAll();
    }
}
