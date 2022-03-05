package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SignIn extends BasePage {
    By emailFieldLocator = By.id("email_create");
    By createAccountButtonLocator = By.id("SubmitCreate");
    By genderLocator = By.id("id_gender1");
    By firstNameLocator = By.id("customer_firstname");
    By lastNameLocator = By.id("customer_lastname");
    By passwordLocator = By.id("passwd");
    By newsLetterLocator = By.id("newsletter");
    By optinLocator = By.id("optin");


    public SignIn(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        type(emailFieldLocator, email);
        click(createAccountButtonLocator);
    }
    public void enterPersonelInformation(String firstName, String lastName, String password,int birthDay,int birthMonth,int birthYear) {
        click(genderLocator);
        type(firstNameLocator, firstName);
        type(lastNameLocator, lastName);
        type(passwordLocator, password);
        driver.findElement(By.xpath("//select[@id='days']/option[@value='"+birthDay+"']")).click();
        driver.findElement(By.xpath("//select[@id='months']/option[@value='"+birthMonth+"']")).click();
        driver.findElement(By.xpath("//select[@id='years']/option[@value='"+birthYear+"']")).click();
        click(newsLetterLocator);
        click(optinLocator);
    }
    public void enterAdressInformation(String firstName, String lastName,String company,String address,String adress2,String city,int stateNumber,String postCode,String additionalInfo,String homePhone,String mobilePhone,String alias) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("address1")).sendKeys(address);
        driver.findElement(By.id("address2")).sendKeys(adress2);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.xpath("//select[@id='id_state']/option[@value='"+stateNumber+"']")).click();
        driver.findElement(By.id("postcode")).sendKeys(postCode);
        driver.findElement(By.id("other")).sendKeys(additionalInfo);
        driver.findElement(By.id("phone")).sendKeys(homePhone);
        driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
        driver.findElement(By.id("alias")).sendKeys(alias);
        driver.findElement(By.id("submitAccount")).click();;
    }
}
