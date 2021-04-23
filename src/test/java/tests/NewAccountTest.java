package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class NewAccountTest extends BaseTest {

    @Test
    public void checkName() {
        MainPage mainPage = new MainPage();

        String actualResult = mainPage.clickOnSignInButton()
                .clickOnNoAccountButton()
                .clickOnMrFieldWindow()
                .clickOnFirstNameField("Oleksii")
                .clickOnLastNameField("Hlovatskyi")
                .clickOnEmailField("rith@i.ua")
                .clickPasswordField("operator")
                .clickOnBirthdayField("11/07/1982")
                .clickOnReceiveOffersWindow()
                .clickOnCustomerDataPrivacyWindow()
                .clickOnSignUpForOurNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnSaveButton()
                .getTextFromNewAccountField();

        assertThat(actualResult).isEqualTo("Oleksii Hlovatskyi");
    }
}
