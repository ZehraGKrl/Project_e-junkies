import Elements.Elements;
import Methods.Methods;
import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FaultyPayment extends BaseDriver {

    @Test
    public void FaultyPayment(){
        Elements elements=new Elements();
        Methods atc=new Methods();
        atc.addToCart();
        myClick(elements.debitCard);
        wait.until(ExpectedConditions.visibilityOf(elements.payFrame));
        driver.switchTo().frame(elements.payFrame);
        myClick(elements.payButton);






    }

}
