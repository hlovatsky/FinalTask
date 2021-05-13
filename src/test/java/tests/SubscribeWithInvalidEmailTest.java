package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.*;

public class SubscribeWithInvalidEmailTest extends BaseTest {

    @Test
    public void checkErrorMessage() {
        MainPage mainPage = new MainPage();

        boolean isErrorTrue = mainPage
                .inputEmail("tttt@ttt")
                .subscribeButton()
                .isErrorMessageExistInEmailField();

        assertTrue(isErrorTrue);

    }
}
