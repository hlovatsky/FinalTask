package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.*;

public class Categories extends BaseTest {

    @Test
    public void areCategoriesDisplayed() {

        MainPage mainPage = new MainPage();

        boolean menCategoryIsDisplayed = mainPage.leanOnClothesLink()
                .isMenCategoryDisplayed();

        assertTrue(menCategoryIsDisplayed);

        boolean womenCategoryIsDisplayed = mainPage.leanOnClothesLink()
                .isWomenCategoryDisplayed();

        assertTrue(womenCategoryIsDisplayed);

        boolean stationeryIsDisplayed = mainPage.leanOnAccessoriesLink()
                .isStationeryDisplayed();

        assertTrue(stationeryIsDisplayed);

        boolean homeAccessoriesIsDisplayed = mainPage.leanOnAccessoriesLink()
                .isHomeAccessoriesDisplayed();

        assertTrue(homeAccessoriesIsDisplayed);

        boolean anyLinksIsDisplayed = mainPage.leanOnArtLink()
                .areAnyLinksIsDisplayed();

        assertFalse(anyLinksIsDisplayed);
    }
}
