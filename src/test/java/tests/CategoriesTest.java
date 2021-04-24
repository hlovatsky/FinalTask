package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest extends BaseTest {

    @Test
    public void areMenAndWomenCategoryDisplayed() {

        MainPage mainPage = new MainPage();

        boolean menAndWomenCategoriesAreDisplayed = mainPage.leanOnClothesLink()
                .areMenCategoryDisplayed();

        assertThat(menAndWomenCategoriesAreDisplayed).isEqualTo(true);
    }

    @Test
    public void areStationeryAndHomeAccessoriesDisplayed() {

        MainPage mainPage = new MainPage();

        boolean stationeryAndHomeAccessoriesAreDisplayed = mainPage.leanOnAccessoriesLink()
                .areStationeryAndHomeAccessoriesDisplayed();

        assertThat(stationeryAndHomeAccessoriesAreDisplayed).isEqualTo(true);
    }

    @Test
    public void areAnyLinksIsDisplayed() {

        MainPage mainPage = new MainPage();

        boolean anyLinksAreDisplayed = mainPage.leanOnArtLink()
                .areAnyLinksIsDisplayed();

        assertThat(anyLinksAreDisplayed).isEqualTo(false);
    }
}
