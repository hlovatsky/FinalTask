package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

import static pages.BasePage.getDriver;

public class BaseTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browserName) {
        System.out.println("Current browser is : " + browserName);
        System.out.println("Current thread id : " + Thread.currentThread().getId());

        if (browserName == null) {
            browserName = "chrome";
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://demo.prestashop.com/");
        BasePage.setDriverThreadLocal(driver);

        try {
            WebElement webElement = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("loadingMessage")));
        } catch (Exception e) {

        }

        try {
            Boolean webElement = new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingMessage")));
        } catch (Exception e) {

        }

        driver.switchTo().frame("framelive");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }
}