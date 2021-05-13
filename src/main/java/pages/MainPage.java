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


    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@value='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//p[contains(@class,'alert')]")
    private WebElement textFromMessage;

    @FindBy(xpath = "//button[@aria-label='Language dropdown']//span")
    private WebElement languageButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']//li")
    private List<WebElement> languagesInDropDownList;

    @FindBy(xpath = "//div[@class='user-info']//span[@class='hidden-sm-down']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='col-md-6 wrapper']//a[@id='link-product-page-prices-drop-1']")
    private WebElement pricesDropLink;

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

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainersOnMainPage;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class='all-product-link float-xs-left float-md-right h4']")
    private WebElement allProductsLink;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage inputEmail(String email) {
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

    public MainPage clickOnLanguageButton() {
        languageButton.click();
        return this;
    }

    public Integer getAllLanguagesInDropdownList() {
        return languagesInDropDownList.size();
    }

    public List<String> languagesInDropList() {
        List<String> languages = new ArrayList<>();
        for (WebElement language : languagesInDropDownList) {
            languages.add(language.getText());
        }
        return languages;
    }

    public LogPage clickOnSignInButton() {
        signInButton.click();
        return new LogPage();
    }

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

    public OnSalePage clickOnPriceDropLink() throws InterruptedException {
        scrollToElementWithJS(pricesDropLink);
        pricesDropLink.click();
        return new OnSalePage();
    }

    public AllProductsPage clickOnAllProductsLink() throws InterruptedException {
        scrollToElementWithJS(allProductsLink);
        allProductsLink.click();
        return new AllProductsPage();
    }

    public SearchResultPage inputProductsName(String productsName) {
        searchField.sendKeys(productsName, Keys.ENTER);
        return new SearchResultPage();
    }
}
