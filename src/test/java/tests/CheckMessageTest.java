package tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.*;

@Slf4j
public class CheckMessageTest extends BaseTest {

    @Test
    public void checkErrorMessage() throws InterruptedException {
        MainPage mainPage = new MainPage();

        boolean isErrorTrue = mainPage
                .inputEmail("kjfhkdjlkglkfgj")
                .subscribeButton()
                .isErrorMessageExistInEmailField();
        log.info("check that info message is disolayed");
        assertFalse(isErrorTrue);

    }
}
