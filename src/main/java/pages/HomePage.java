package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By signInButtonLocator= By.xpath("//a[contains(text(),'Sign in')]");
    By dressesButtonLocator= By.xpath("//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton(){
        click(signInButtonLocator);
    }
    public void clickDressesButton(){click(dressesButtonLocator);}


}
