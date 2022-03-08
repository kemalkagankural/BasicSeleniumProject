package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    By checkPaymentMessageLocator= By.xpath("//p[contains(text(),'Your order on My Store is complete.')]");

    public Boolean isDisplayedMessage(){
        return find(checkPaymentMessageLocator).isDisplayed();
    }
}
