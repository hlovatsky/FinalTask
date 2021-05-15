package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.NewAccountPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationWithValidDataTest extends BaseTest {

    @Test
    public void checkRegistrationOfNewUser() {

        MainPage mainPage = new MainPage();

         NewAccountPage newAccountPage = mainPage.clickOnSignInButton()
                .clickOnNoAccountButton()
                .clickOnMrFieldWindow()
                .enterFirstName()
                .enterLastName()
                .enterEmail()
                .enterPassword()
                .enterBirthday()
                .clickOnReceiveOffersWindow()
                .clickOnCustomerDataPrivacyWindow()
                .clickOnSignUpForOurNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnSaveButton();

        assertThat(newAccountPage.getTextFromNewAccountField())
                .as("New user doesn't create")
                .isEqualTo("Oleksii Hlovatskyi");
    }
}
