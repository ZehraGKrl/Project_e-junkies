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


    @AfterClass
    public void KapanisIslemleri() {
        driver.quit();

        logger.info("Driver kapatıldı");
    }

    @BeforeMethod
    public void BeforeMethod() {
        logger.info("Test Method Başladı");
        System.out.println("****************************************");

    }

    @AfterMethod
    public void AfterMetod(ITestResult result) {
        System.out.println("****************************************");
        logger.info(result.getName() + " Metod finished " + (result.getStatus() == 1 ? "Passed" : "Failed"));
    }
}
