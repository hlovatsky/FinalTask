package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.List;

public class CheckLanguagesTest extends BaseTest {

    @Test
    public void checkLanguages() {
        MainPage mainPage = new MainPage();
        SoftAssertions softAssert = new SoftAssertions();

        int numberOfLanguages = mainPage.clickOnLanguageButton()
                .getAllLanguagesInDropdownList();
        softAssert.assertThat(numberOfLanguages)
                .as("Number of languages isn't 44").
                isEqualTo(44);

        List<String> languagesInTheDropDownList = mainPage.getLanguage();
        softAssert.assertThat(languagesInTheDropDownList)
                .as("Dropdown list of languages doesn't contain Українська")
                .contains("Українська");

        softAssert.assertAll();
    }
}
