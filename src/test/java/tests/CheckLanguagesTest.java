package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckLanguagesTest extends BaseTest {
    @Test
    public void checkNumberOfLanguages() {
        MainPage mainPage = new MainPage();

        int numberOfLanguages = mainPage.clickOnLanguageButton()
                .getAllLanguagesInDropdownList();

        assertThat(numberOfLanguages).isEqualTo(44);
    }

    @Test
    public void checkAvailabilityOfLanguage() {
        MainPage mainPage = new MainPage();

        List<String> languagesInTheDropDownList = mainPage.clickOnLanguageButton()
                .getLanguage();

        assertThat(languagesInTheDropDownList).contains("Українська");
    }
}
