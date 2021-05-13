package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckCategoriesTest extends BaseTest {

    @Test
    public void areCategoriesDisplayed() {

        MainPage mainPage = new MainPage();

        SoftAssertions softAssert = new SoftAssertions();

        boolean isMenCategoryLinkDisplayed = mainPage.hoverOverTopMenuLinks("CLOTHES")
                .isCategoryDisplaying("MEN");

        boolean isWomenCategoryLinkDisplayed = mainPage.hoverOverTopMenuLinks("CLOTHES")
                .isCategoryDisplaying("WOMEN");

        softAssert.assertThat(isMenCategoryLinkDisplayed)
                .as("The MEN category isn't display")
                .isEqualTo(true);

        softAssert.assertThat(isWomenCategoryLinkDisplayed)
                .as("The WOMEN category isn't display")
                .isEqualTo(true);

        boolean isStationeryCategoryLinkDisplayed = mainPage.hoverOverTopMenuLinks("ACCESSORIES")
                .isCategoryDisplaying("STATIONERY");

        boolean isHomeAccessoriesLinkDisplayed = mainPage.hoverOverTopMenuLinks("ACCESSORIES")
                .isCategoryDisplaying("HOME_ACCESSORIES");

        softAssert.assertThat(isStationeryCategoryLinkDisplayed)
                .as("The STATIONERY isn't display")
                .isTrue();

        softAssert.assertThat(isHomeAccessoriesLinkDisplayed)
                .as("The HOME_ACCESSORIES isn't display")
                .isTrue();

        boolean isArtLinkDisplayed = mainPage.hoverOverTopMenuLinks("ART").
                isAnySubCategoriesAppears();

        softAssert.assertThat(isArtLinkDisplayed)
                .as("The ART link isn't displayed")
                .isTrue();

        softAssert.assertAll();
    }
}
