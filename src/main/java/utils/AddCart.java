package utils;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class AddCart extends BasePage {
    public AddCart(WebDriver driver) {
        super(driver);
    }
    By summerDressesLocator = By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]");
    By searchLocator = By.xpath("//input[@id='search_query_top']");
    By searchButtonLocator = By.xpath("//button[@name='submit_search']");
    By addToCartLocator = By.xpath("//button[@name='Submit']");
    By closeWindowLocator = By.xpath("//span[@title='Close window']");



    public void clickSummerDresses(){
        click(summerDressesLocator);
        Helper.waitFor(2);
        type(searchLocator, "Summer");
        Helper.waitFor(2);
        click(searchButtonLocator);
        Helper.waitFor(2);
    }
    public void addToCartProduct(){
        addToCart().get(0).click();
        Helper.waitFor(2);
        click(addToCartLocator);
        Helper.waitFor(2);
        click(closeWindowLocator);
        Helper.waitFor(2);

    }

    public List<WebElement> addToCart(){
        return driver.findElements(By.xpath("//div/a[@class='product_img_link']"));
    }
}
