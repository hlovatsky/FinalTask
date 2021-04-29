package pages;

import blocks.Product;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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
        scrollToElementWithJS(emailInput);
        emailInput.sendKeys(email);
        return this;
    }

    public MainPage subscribeButton() {
        subscribeButton.click();
        return this;
    }

    public boolean isErrorMessageExistInEmailField() {
        return isErrorExist(emailInput);
    }

    //Test #2
    @FindBy(xpath = "//button[@aria-label='Language dropdown']")
    private WebElement languageButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']//a[@class='dropdown-item']")
    private List<WebElement> languages;

    public MainPage clickOnLanguageButton() {
        languageButton.click();
        return this;
    }

    public List<WebElement> languages() {
        languages = new ArrayList<>();
        return languages;
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

    @FindBy(xpath = "//li[@id='category-3']//a[@class='dropdown-item dropdown-submenu']")
    private WebElement menAndWomenCategories;

    @FindBy(xpath = "//a[contains(@href,'6-accessories')]")
    private WebElement accessoriesLink;

    @FindBy(xpath = "//li[@id='category-6']//a[@class='dropdown-item dropdown-submenu']")
    private WebElement stationeryAndHomeAccessories;

    @FindBy(xpath = "//a[contains(@href,'9-art')]")
    private WebElement artLink;

    @FindBy(xpath = "//a[@class='dropdown-item dropdown-submenu']")
    private WebElement categoriesMenu;

    public MainPage leanOnClothesLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(clothesLink).build().perform();
        return this;
    }

    public boolean areMenCategoryDisplayed() {
        return menAndWomenCategories.isDisplayed();
    }

    public MainPage leanOnAccessoriesLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(accessoriesLink).build().perform();
        return this;
    }

    public boolean areStationeryAndHomeAccessoriesDisplayed() {
        return stationeryAndHomeAccessories.isDisplayed();
    }

    public MainPage leanOnArtLink() {
        Actions actions = new Actions(driver);
        actions.moveToElement(artLink).build().perform();
        return this;
    }

    public boolean areAnyLinksIsDisplayed() {
        return categoriesMenu.isDisplayed();
    }

    //test #6
    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainersOnMainPage;

    public int getNumberOfProductsOnPage() {
        Product product = new Product();
        int productsOnPage = product.getNumbersOfProducts(productContainersOnMainPage);
        return productsOnPage;
    }

    public List<Product> getProductsOnMainPage() {
        Product product = new Product();
        List<Product> allProductsOnMainPage = product.getAllProductsOnPage(productContainersOnMainPage);
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

    //test #8
    @FindBy(xpath = "//a[@class='all-product-link float-xs-left float-md-right h4']")
    private WebElement allProductsLink;

    public AllProductsPage clickOnAllProductsLink() throws InterruptedException {
        scrollToElementWithJS(allProductsLink);
        allProductsLink.click();
        return new AllProductsPage();
    }

    //test #9
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    public SearchResultPage inputProductsName(String productsName) {
        searchField.sendKeys(productsName, Keys.ENTER);
        return new SearchResultPage();
    }


}
