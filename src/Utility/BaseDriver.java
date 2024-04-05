package Utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseDriver {

    public static Logger logger = LogManager.getLogger();

    public static WebDriverWait wait;
    public static WebDriver driver;


    @BeforeClass
    public void BaslangicIslemleri() {


      // switch (browserTipi.toLowerCase()) {
      //     case "chrome":
      //         driver = new ChromeDriver();
      //         break;
      //     case "firefox":
      //         driver = new FirefoxDriver();
      //         break;
      //     case "edge":
      //         driver = new EdgeDriver();
      //         break;
      //     default:
      //         driver = new ChromeDriver();
      //         break;
      // }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }

    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();

    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void myJSClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    public void myAssert(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        Assert.assertTrue(element.getText().contains(text), "Bu Sayfada Değilsiniz");
    }


    @AfterClass
    public void KapanisIslemleri() {
        driver.quit();

        logger.info("Driver kapatıldı");
    }

    @BeforeMethod
    public void BeforeMetod() {
        logger.info("Metod başladı");

        logger.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc) {
        logger.info(sonuc.getName() + " Metod bitti " + (sonuc.getStatus() == 1 ? "Passed" : "failed"));

        logger.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
    }
}
