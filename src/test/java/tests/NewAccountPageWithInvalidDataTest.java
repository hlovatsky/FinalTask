package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import pages.MainPage;

public class NewAccountPageWithInvalidDataTest extends BaseTest {

    @Test
    public void checkColorOfFirstNameField() {

        MainPage mainPage = new MainPage();


        String actualResult1 = mainPage.clickOnSignInButton()
                .clickOnNoAccountButton()
                .clickOnMrFieldWindow()
                .clickOnFirstNameField("James8")
                .clickOnLastNameField("Pit")
                .clickOnEmailField("kdjfkj@mail.ru")
                .clickPasswordField("123123123123")
                .clickOnBirthdayField("01/01/1970")
                .clickOnReceiveOffersWindow()
                .clickOnCustomerDataPrivacyWindow()
                .clickOnSignUpForOurNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnSaveButtonWithInvalidData()
                .getColorOfFirstNameField();


        //String[] s = actualResult.split("solid");

        assertEquals(actualResult1, "red");

        boolean isMessageDisplayed = mainPage.clickOnSignInButton()
                .clickOnNoAccountButton()
                .clickOnMrFieldWindow()
                .clickOnFirstNameField("James8")
                .clickOnLastNameField("Pit")
                .clickOnEmailField("kdjfkj@mail.ru")
                .clickPasswordField("123123123123")
                .clickOnBirthdayField("01/01/1970")
                .clickOnReceiveOffersWindow()
                .clickOnCustomerDataPrivacyWindow()
                .clickOnSignUpForOurNewsletterWindow()
                .clickOnAgreeWindow()
                .clickOnSaveButtonWithInvalidData()
                .isErrorMessageIsDisplayed();

        assertTrue(isMessageDisplayed);

    }
}
