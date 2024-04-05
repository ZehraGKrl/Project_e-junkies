package Elements;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utility.BaseDriver.driver;
import static Utility.BaseDriver.wait;

public class Elements {
    public Elements() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "(//div[@class='basicDetails']/button)[2]")
    public WebElement ebookAddCard;
    @FindBy(css = "iframe[class='EJIframeV3 EJOverlayV3']")
    public WebElement popupFrame;
    @FindBy(css = "[class='Product-Quantity-Value readOnly']")
    public WebElement addedCart;
    @FindBy(css = "[class='Actions']>button+button")
    public WebElement addPromoCard;
    @FindBy(xpath = "//div[@class='Promo-Box Active']/input")
    public WebElement promoCodeText;
    @FindBy(xpath = "//button[@class='Promo-Apply']")
    public WebElement codeApply;
    @FindBy(xpath = "//*[text()='Invalid promo code']")
    public WebElement invalidCode;
    @FindBy(xpath = "//button[ contains( text(), 'Debit')]")
    public WebElement debitCard;
    @FindBy(css = "iframe[class='EJIframeV3 EJOverlayV3']")
    public WebElement payFrame;
    @FindBy(css = "[class='Pay-Button']")
    public WebElement payButton;



}
