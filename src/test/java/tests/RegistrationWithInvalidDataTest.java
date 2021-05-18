package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CreateNewAccountPage;
import pages.MainPage;

public class RegistrationWithInvalidDataTest extends BaseTest {

    @Test
    public void checkColorOfFirstNameField() {
        String firstName = "James8";
        String lastName = "Johnson";
        String email = "lkjlkj@in.ua";
        String password = "1231231234";
        String birthday = "01/01/1970";
        MainPage mainPage = new MainPage();
        SoftAssertions softAssert = new SoftAssertions();

        CreateNewAccountPage createNewAccountPage = mainPage.clickOnSignInButton()
                .clickOnNoAccountButton()
                .clickOnMrFieldWindow()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(email)
                .enterPassword(password)
                .enterBirthday(birthday)
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
