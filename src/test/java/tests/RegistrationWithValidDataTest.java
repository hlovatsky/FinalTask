package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.NewAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationWithValidDataTest extends BaseTest {

    @Test
    public void checkRegistrationOfNewUser() {
        String firstName = "James";
        String lastName = "Johnson";
        String email = "lkjlkj@in.ua";
        String password = "1231231234";
        String birthday = "01/01/1970";
        MainPage mainPage = new MainPage();

        NewAccountPage newAccountPage = mainPage.clickOnSignInButton()
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
                .clickOnSaveButton();

        assertThat(newAccountPage.getTextFromNewAccountField())
                .as("New user doesn't create")
                .isEqualTo("James Johnson");
    }
}
