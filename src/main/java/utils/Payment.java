package utils;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class Payment extends BasePage {
    public Payment(WebDriver driver) {
        super(driver);
    }
    By cartLocator=By.xpath("//a[@title='View my shopping cart']");
    By emailAreaLocator=By.id("email");
    By passwordAreaLocator=By.id("passwd");
    By signInButtonLocator=By.id("SubmitLogin");
    By agreeCheckBoxLocator=By.id("cgv");
    By paymentMethodsButtonLocator=By.xpath("//a[@title='Pay by check.']");
    By confirmOrderButtonLocator=By.xpath("//button[@class='button btn btn-default button-medium']");


    public void paymentProcess(String email,String password) {
        click(cartLocator);
        Helper.waitFor(2);
        click(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
        Helper.waitFor(2);
        enterAccountInformation(email,password);
        click(signInButtonLocator);
        Helper.waitFor(2);
        click(By.xpath("//button[@class='button btn btn-default button-medium']"));
        Helper.waitFor(2);
        click(agreeCheckBoxLocator);
        click(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']"));
        Helper.waitFor(2);
        click(paymentMethodsButtonLocator);
        Helper.waitFor(2);
        click(confirmOrderButtonLocator);
        Helper.waitFor(2);
    }
    public void enterAccountInformation(String email,String password) {
        type(emailAreaLocator,email);
        type(passwordAreaLocator,password);
    }
    }

