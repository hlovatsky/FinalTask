package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import static org.testng.Assert.*;

public class CreateNewAccountTest extends BaseTest {

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

        assertEquals(actualResult,"Oleksii Hlovatskyi");
    }
}
