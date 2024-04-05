import Elements.Elements;
import Methods.Methods;
import Utility.BaseDriver;
import org.testng.annotations.Test;

public class FaultyPayment extends BaseDriver {

    @Test
    public void FaultyPayment(){
        Elements elements=new Elements();
        Methods atc=new Methods();
        atc.addToCart();

    }

}
