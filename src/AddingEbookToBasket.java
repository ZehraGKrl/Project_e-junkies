import Elements.Elements;

import Methods.Methods;
import Utility.BaseDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.Test;

public class AddingEbookToBasket extends BaseDriver {
    @Test
    public void AddingEbook(){
        Elements elements=new Elements();
        Methods atc=new Methods();
        atc.addToCart();

        myClick(elements.addPromoCard);
        wait.until(ExpectedConditions.visibilityOf(elements.promoCodeText));
        mySendKeys(elements.promoCodeText, "zehra10");
        myClick(elements.codeApply);
        wait.until(ExpectedConditions.visibilityOf(elements.invalidCode));

    }
}
