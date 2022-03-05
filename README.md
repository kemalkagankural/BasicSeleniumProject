# Selenium Project

# Test Case Description

This repo was created for Selenium Web Testing.Within the project, a test scenario was written using Java Selenium and Page Object Model.In addition, BDD approach has been applied in this project. The BDD approach ensures that the test automation is easily understandable by using a common language that can be understood by all units.

## Requirements Before Installation
- Java
- Maven
- Selenium-java
- Webdrivermanager

## Test Steps

- Go to automationpractice home page
- Go to Sign in Page
- Sign in with valid credentials
- Check account name after sign in on Account Page

## Test Steps Definition
```java
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

```

## Test Utils Details

```java
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
```
 You can see two different way of implemantation.First one is came to Base Page methods.These method do click and type via web elements.You need to locator and implement to type and click methods.
 Second way is came to Selenium Core.In this way people use drive and they don't create methods.
 
## Test BasePage Methods

```java
    public WebDriver driver ;

    public BasePage(WebDriver driver){
        this.driver = driver ;
        }

    public WebElement find(By locator){
        return driver.findElement(locator);
        }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
        }

    public void click(By locator){
        find(locator).click();
        }

    public void type(By locator , String text){
        find(locator).sendKeys(text);
        }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
        }
```

In this BasePage methods we create simple methods that like to click,type,displayed.Also when we use this BasePage methods,we can create Web Driver in all page.
Also This BasePage methods can extend other page and utils. After this participation, you can easily perform operations by creating web elements, rather than defining elements for a long time.

## BaseTest Methods
```java
        @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        }

    @AfterAll
    public void tearDown(){
        driver.quit();
        }

```

Using this method, you can easily use it in other test classes by making driver settings easily.

## Test Pages

-First Page is Home Page.
```java
 public class HomePage extends BasePage {

    By signInButtonLocator= By.xpath("//a[contains(text(),'Sign in')]");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void clickSignInButton(){
        click(signInButtonLocator);
    }
}
```

-Second Page is Sign In Page.
```java
public class SignInPage extends BasePage {

    By signInLocator = By.id("email_create");
    
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    public boolean isOnSignInPage() {
        return isDisplayed(signInLocator);
    }
}
```

-Third Page is AccountDetailPage
```java
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
```

## Test Helper
```java
    public class Helper {
    //Wait method
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   }
}
```

As a result of the research, it is not recommended to perform wait operations in the test definition section,so I created a helper for wait with this Helper.
