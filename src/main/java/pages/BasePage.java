package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        log.info("Openning main page of the application");
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected void scrollToElementWithJS(WebElement element) throws InterruptedException {
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(5000);
    }

    protected Boolean isErrorExist(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return (Boolean) js.executeScript("return arguments[0].checkValidity();", element);
    }
}
