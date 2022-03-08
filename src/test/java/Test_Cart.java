import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductPage;
import utils.AddCart;
import utils.Payment;


public class Test_Cart extends BaseTest {

    @Test
    @Order(1)
    public void go_to_dresses(){
        HomePage homePage = new HomePage(driver);
        homePage.clickDressesButton();
        Helper.waitFor(2);
        ProductPage productPage = new ProductPage(driver);
        Assertions.assertTrue( productPage.isDisplayedDresses(),
                "Not on dresses page!");
    }
    @Test
    @Order(2)
    public void select_summer_dresses(){
        AddCart addCart = new AddCart(driver);
        addCart.clickSummerDresses();
        Helper.waitFor(2);
    }
    @Test
    @Order(3)
    public void add_to_product(){
        AddCart addCart = new AddCart(driver);
        addCart.addToCartProduct();
        Helper.waitFor(2);
    }
    @Test
    @Order(4)
    public void go_to_payment(){
        Payment payment = new Payment(driver);
        payment.paymentProcess("rajeevraj4184@kmail.com", "12345678");
        Helper.waitFor(2);
        PaymentPage paymentPage = new PaymentPage(driver);
        Assertions.assertTrue( paymentPage.isDisplayedMessage(),
                "Not see payment message!");
    }
}
