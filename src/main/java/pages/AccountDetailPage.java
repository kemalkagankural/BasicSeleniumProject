package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDetailPage extends BasePage{

    By accountNameLocator = By.xpath("//header/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]");

    public AccountDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnAccountDetailPage() {
        return isDisplayed(accountNameLocator);
    }

    public Object checkAccountName(){
        String accountName=accountName().getText();
        return accountName;
    }

    public WebElement accountName(){
        return driver.findElement(accountNameLocator);
    }

}
