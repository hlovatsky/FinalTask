package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.assertTrue;

public class SubscribeWithInvalidEmailTest extends BaseTest {
    @Test
    public void checkErrorMessage() {
        String email = "tttt@ttt";
        MainPage mainPage = new MainPage();

        boolean isErrorTrue = mainPage.enterEmail(email)
                .subscribeButton()
                .isErrorMessageExistInEmailField();

        assertTrue(isErrorTrue);

    }
}
