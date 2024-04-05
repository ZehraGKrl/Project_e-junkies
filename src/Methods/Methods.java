package Methods;

import Elements.Elements;
import Utility.BaseDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utility.BaseDriver.driver;
import static Utility.BaseDriver.wait;

public class Methods {
    public void addToCart(){
        BaseDriver bd=new BaseDriver();
        driver.navigate().to("https://shopdemo.e-junkie.com/");
        Elements elements=new Elements();
        Actions action = new Actions(driver);
        bd.myClick(elements.ebookAddCard);
        wait.until(ExpectedConditions.visibilityOf(elements.popupFrame));
        driver.switchTo().frame(elements.popupFrame);
        Assert.assertFalse(elements.addedCart.toString().isEmpty());
    }
}
