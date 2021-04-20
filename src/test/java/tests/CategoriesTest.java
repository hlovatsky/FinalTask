package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest extends BaseTest {

    @Test
    public void isMenCategoryDisplayed() {

        MainPage mainPage = new MainPage();

        boolean menCategoryIsDisplayed = mainPage.leanOnClothesLink()
                .isMenCategoryDisplayed();

        assertThat(menCategoryIsDisplayed).isEqualTo(true);
    }

    @Test
    public void isWomenCategoryDisplayed() {

        MainPage mainPage = new MainPage();

        boolean womenCategoryIsDisplayed = mainPage.leanOnClothesLink()
                .isWomenCategoryDisplayed();

        assertThat(womenCategoryIsDisplayed).isEqualTo(true);
    }

    @Test
    public void isStationeryDisplayed() {

        MainPage mainPage = new MainPage();

        boolean stationeryIsDisplayed = mainPage.leanOnAccessoriesLink()
                .isStationeryDisplayed();

        assertThat(stationeryIsDisplayed).isEqualTo(true);
    }

    @Test
    public void isHomeAccessoriesDisplayed() {

        MainPage mainPage = new MainPage();
        boolean homeAccessoriesIsDisplayed = mainPage.leanOnAccessoriesLink()
                .isHomeAccessoriesDisplayed();

        assertThat(homeAccessoriesIsDisplayed).isEqualTo(true);
    }

    @Test
    public void areAnyLinksIsDisplayed() {

        MainPage mainPage = new MainPage();

        boolean anyLinksIsDisplayed = mainPage.leanOnArtLink()
                .areAnyLinksIsDisplayed();

        assertThat(anyLinksIsDisplayed).isEqualTo(false);
    }
}
