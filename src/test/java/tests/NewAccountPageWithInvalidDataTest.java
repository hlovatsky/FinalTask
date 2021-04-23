package tests;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

import pages.MainPage;

public class NewAccountPageWithInvalidDataTest extends BaseTest {

    @Test
    public void checkColorOfFirstNameField() {

        MainPage mainPage = new MainPage();

        String actualColor = mainPage.clickOnSignInButton()
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


        String[] s = actualColor.split("solid");

        //assertEquals(s[0], "rgb(255, 76, 76) ");
        assertThat(s[0]).isEqualTo("rgb(255, 76, 76) ");
    }

    @Test
    public void isErrorMessageIsDisplayed() {

        MainPage mainPage = new MainPage();

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

        assertThat(isMessageDisplayed).isTrue();
    }
}
