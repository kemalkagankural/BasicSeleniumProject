package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignInPage extends BasePage {

    By signInLocator = By.id("email_create");


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnSignInPage() {
        return isDisplayed(signInLocator);
    }


}
