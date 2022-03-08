package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    By dressesTitleLocator = By.xpath("//span[@class='category-name'][contains(text(),'Dresses')]");


    public Boolean isDisplayedDresses(){
        return find(dressesTitleLocator).isDisplayed();
    }



}
