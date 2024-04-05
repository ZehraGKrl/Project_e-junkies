import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
    public Elements() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "(//div[@class='basicDetails']/button)[2]")
    public WebElement ebookAddCard;
    @FindBy(css = "iframe[class='EJIframeV3 EJOverlayV3']")
    public WebElement popupFrame;
    @FindBy(css = "[class='Product-Quantity-Value readOnly']")
    public WebElement addedCard;
    @FindBy(css = "[class='Actions']>button+button")
    public WebElement addPromoCard;
    @FindBy(xpath = "//div[@class='Promo-Box Active']/input")
    public WebElement promoCodeText;
    @FindBy(xpath = "//button[@class='Promo-Apply']")
    public WebElement codeApply;
    @FindBy(xpath = "//*[text()='Invalid promo code']")
    public WebElement invalidCode;

}
