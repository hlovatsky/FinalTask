package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void scrollToElementWithJS(WebElement element) throws InterruptedException {
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
    }

    protected Boolean isErrorExist(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        return (Boolean)js.executeScript("return arguments[0].checkValidity();", element);
    }




}
