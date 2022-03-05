import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.AccountDetailPage;
import pages.HomePage;
import pages.SignInPage;
import utils.SignIn;

public class Test_Sign_In  extends BaseTest{

    @Test
    @Order(1)
    public void open_sign_in(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        Helper.waitFor(1);
        SignInPage signInPage = new SignInPage(driver);
        Assertions.assertTrue(signInPage.isOnSignInPage() ,
                "Not on sign in  page!");
    }
    @Test
    @Order(2)
    public void sign_in_with_valid_credentials() {
        SignIn signIn=new SignIn(driver);
        signIn.enterEmail("rajeevraj4184@kmail.com");
        Helper.waitFor(5);
        signIn.enterPersonelInformation("Rajeev","Rajeev","12345678",3,11,1997);
        Helper.waitFor(5);
        signIn.enterAdressInformation("Rajeev","Rajeev","MY","Old Town","Left","NY",1,"11111","My Town","123","321","my home");
        Helper.waitFor(5);
        AccountDetailPage accountDetailPage=new AccountDetailPage(driver);
        Assertions.assertTrue(accountDetailPage.isOnAccountDetailPage(),
                "Not on account page!");
    }
    @Test
    @Order(3)
    public  void check_account_name(){
        AccountDetailPage accountDetailPage=new AccountDetailPage(driver);
        Assertions.assertEquals(String.valueOf(accountDetailPage.checkAccountName()),"Rajeev Rajeev",
                "Not equal true account name!");
    }

}
