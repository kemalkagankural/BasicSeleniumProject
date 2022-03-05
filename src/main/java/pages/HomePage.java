package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By signInButtonLocator= By.xpath("//a[contains(text(),'Sign in')]");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton(){
        click(signInButtonLocator);
    }


}
