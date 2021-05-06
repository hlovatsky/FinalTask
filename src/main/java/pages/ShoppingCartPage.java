package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {
    @FindBy(xpath = "//span[@class='product-price']/strong[contains(text(),'16.68')]")
    private WebElement priceOfFirstProduct;

    @FindBy(xpath = "//span[@class='product-price']/strong[contains(text(),'22.94')]")
    private WebElement priceOfSecondProduct;

    @FindBy(xpath = "//div[@class='cart-summary-line cart-total']//span[contains(text(),'39.62')]")
    private WebElement totalPrice;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    private WebElement ProceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public double parsePriceOfFirstProductIntoDouble() {
        String price = priceOfFirstProduct.getAttribute("innerText").replace("€", "");
        double priceOfFirstProduct = Double.parseDouble(price);
        return priceOfFirstProduct;
    }

    public double parsePriceOfSecondProductIntoDouble() {
        String price = priceOfSecondProduct.getAttribute("innerText").replace("€", "");
        double priceOfSecondProduct = Double.parseDouble(price);
        return priceOfSecondProduct;
    }

    public double getTotalPrice() {
        return (double)Math.round((parsePriceOfFirstProductIntoDouble() + parsePriceOfSecondProductIntoDouble()) * 100) /100;

    }

    public double parseTotalPriceToDouble() {
        return Double.parseDouble(totalPrice.getAttribute("textContent").replace("€", ""));

    }

    public PersonalInformationPage checkTotalPrice() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

        if (getTotalPrice() == parseTotalPriceToDouble()) {
            shoppingCartPage.ProceedToCheckoutButton.click();
            return new PersonalInformationPage();

        } else {
            System.out.println("Calculate incorrect");
            return null;
        }
    }
}
