import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_301 extends BaseDriver {
    @Test
    public void US_301(){
        driver.navigate().to("https://shopdemo.e-junkie.com/");
        Elements elements=new Elements();
        Actions action = new Actions(driver);
        myClick(elements.ebookAddCard);
        wait.until(ExpectedConditions.visibilityOf(elements.popupFrame));
        driver.switchTo().frame(elements.popupFrame);
        Assert.assertFalse(elements.addedCard.toString().isEmpty());
        myClick(elements.addPromoCard);
        wait.until(ExpectedConditions.visibilityOf(elements.promoCodeText));
        mySendKeys(elements.promoCodeText, "zehra10");
        myClick(elements.codeApply);
        wait.until(ExpectedConditions.visibilityOf(elements.invalidCode));





    }
}
