package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest extends BaseTest {

    @Test
    public void areMenAndWomenCategoryDisplayed() {

        MainPage mainPage = new MainPage();

        boolean menAndWomenCategoryIsDisplayed = mainPage.leanOnClothesLink()
                .areMenCategoryDisplayed();

        assertThat(menAndWomenCategoryIsDisplayed).isEqualTo(true);
    }

    @Test
    public void areStationeryAndHomeAccessoriesDisplayed() {

        MainPage mainPage = new MainPage();

        boolean stationeryIsDisplayed = mainPage.leanOnAccessoriesLink()
                .areStationeryAndHomeAccessoriesDisplayed();

        assertThat(stationeryIsDisplayed).isEqualTo(true);
    }

    @Test
    public void areAnyLinksIsDisplayed() {

        MainPage mainPage = new MainPage();

        boolean anyLinksIsDisplayed = mainPage.leanOnArtLink()
                .areAnyLinksIsDisplayed();

        assertThat(anyLinksIsDisplayed).isEqualTo(false);
    }
}
