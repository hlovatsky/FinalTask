package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.*;

public class CheckMessageTest extends BaseTest {

    @Test
    public void checkErrorMessage() throws InterruptedException {
        MainPage mainPage = new MainPage();

        boolean isErrorTrue = mainPage
                .inputEmail("kjfhkdjlkglkfgj")
                .subscribeButton()
                .isErrorMessageExistInEmailField();

        assertFalse(isErrorTrue);

    }
}
