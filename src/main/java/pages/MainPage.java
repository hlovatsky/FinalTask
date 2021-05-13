package pages;

import blocks.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = "//li[@id='category-9']//li")
    private List<WebElement> artLink;

    @FindBy(xpath = "//div[@itemprop='itemListElement']")
    private List<WebElement> productContainersOnMainPage;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class='all-product-link float-xs-left float-md-right h4']")
    private WebElement allProductsLink;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public MainPage inputEmail() {
        emailInput.sendKeys("tttt@ttt");
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

    Actions actions = new Actions(getDriver());

    public MainPage hoverOverTopMenuLinks(String linkName) {
        String categoryId = null;
        switch (linkName) {
            case "CLOTHES":
                categoryId = "3";
                break;
            case "ACCESSORIES":
                categoryId = "6";
                break;
            case "ART":
                categoryId = "9";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        actions.moveToElement(getDriver().findElement(By.xpath(baseXpath))).build().perform();
        return this;
    }

    public boolean isCategoryDisplaying(String linkName) {
        String categoryId = null;
        switch (linkName) {
            case "MEN":
                categoryId = "4";
                break;
            case "WOMEN":
                categoryId = "5";
                break;
            case "STATTIONERY":
                categoryId = "7";
                break;
            case "HOME_ACCESSORIES":
                categoryId = "8";
                break;
        }
        String baseXpath = "//li[@id='category-" + categoryId + "']";
        return getDriver().findElement(By.xpath(baseXpath)).isDisplayed();
    }

    public boolean isAnySubCategoriesAppears() {
        return artLink.size() != 0;
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

    public OnSalePage clickOnPriceDropLink() {
        pricesDropLink.click();
        return new OnSalePage();
    }

    public SearchResultPage inputNameOfProduct() {
        searchField.sendKeys("Bear", Keys.ENTER);
        return new SearchResultPage();
    }

    public SearchResultPage inputProductsName() {
        searchField.sendKeys("Mug", Keys.ENTER);
        return new SearchResultPage();
    }
}
