package pages;

import blocks.MainPageProduct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class MainPage extends BasePage {

    //Test #1
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//p[contains(@class,'alert')]")
    private WebElement textFromMessage;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage inputEmail(String email) throws InterruptedException {
        log.info("Scroll to email field");
        scrollToElementWithJS(emailInput);
        log.info("enter kjfhkdjlkglkfgj in email field");
        emailInput.sendKeys(email);
        return this;
    }

    public MainPage subscribeButton() {
        log.info("Clicking on the subscribe button");
        subscribeButton.click();
        return this;
    }

    public boolean isErrorMessageExistInEmailField() {
        return isErrorExist(emailInput);
    }

    //Test #2
    @FindBy(xpath = "//button[@aria-label='Language dropdown']")
    private WebElement languageButton;

    @FindBy(xpath = "//ul[contains(@class,'dropdown-menu')]")
    private List<WebElement> languages;

    public MainPage clickOnLanguageButton() {
        languageButton.click();
        return this;
    }

    //Test #3 and #4
    @FindBy(xpath = "//div[@class='user-info']//span[@class='hidden-sm-down']")
    private WebElement signInButton;

    public LogPage clickOnSignInButton() {
        signInButton.click();
        return new LogPage();
    }

    //Test #5
    @FindBy(xpath = "//a[contains(@href,'3-clothes')]")
    private WebElement clothesLink;

    @FindBy(xpath = "//a[contains(@href,'4-men')]")
    private WebElement menCategory;

    @FindBy(xpath = "//a[contains(@href,'5-women')]")
    private WebElement womenCategory;

    @FindBy(xpath = "//a[contains(@href,'6-accessories')]")
    private WebElement accessoriesLink;

    @FindBy(xpath = "//a[contains(@href,'7-stationery')]")
    private WebElement stationery;

    @FindBy(xpath = "//a[contains(@href,'8-home-accessories')]")
    private WebElement homeAccessories;

    @FindBy(xpath = "//a[contains(@href,'9-art')]")
    private WebElement artLink;

    @FindBy(xpath = "//div[@class='popover sub-menu js-sub-menu collapse']//ul[@class='top-menu']")
    private WebElement emptyFields;

    public MainPage leanOnClothesLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(clothesLink).build().perform();
        return this;
    }

    public boolean isMenCategoryDisplayed() {
        return menCategory.isDisplayed();
    }

    public boolean isWomenCategoryDisplayed() {
        return womenCategory.isDisplayed();
    }

    public MainPage leanOnAccessoriesLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accessoriesLink).build().perform();
        return this;
    }

    public boolean isStationeryDisplayed() {
        return stationery.isDisplayed();
    }

    public boolean isHomeAccessoriesDisplayed() {
        return homeAccessories.isDisplayed();
    }

    public MainPage leanOnArtLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(artLink).build().perform();
        return this;
    }

    public boolean areAnyLinksIsDisplayed() {
        return emptyFields.isDisplayed();
    }

    //test #6
    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainersOnMainPage;

    public int getNumberOfProductsOnPage() {
        MainPageProduct mainPageProduct = new MainPageProduct();
        int productsOnPage = mainPageProduct.getNumbersOfProducts(productContainersOnMainPage);
        return productsOnPage;
    }

    public List<MainPageProduct> getProductsOnMainPage() {
        MainPageProduct mainPageProduct = new MainPageProduct();
        List<MainPageProduct> allProductsOnMainPage = mainPageProduct.getAllProductsOnPage(productContainersOnMainPage);
        return allProductsOnMainPage;
    }

    //test #7
    @FindBy(xpath = "//div[@class='col-md-6 wrapper']//a[@id='link-product-page-prices-drop-1']")
    private WebElement pricesDropLink;

    public OnSalePage clickOnPriceDropLink() throws InterruptedException {
        scrollToElementWithJS(pricesDropLink);
        pricesDropLink.click();
        return new OnSalePage();
    }
}
