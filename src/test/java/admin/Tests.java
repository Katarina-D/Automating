package admin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CookiesControllingAccessPage;
import pages.FindByPlaygroundTestPage;
import pages.IndexPage;


public class Tests {
    
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static IndexPage indexPage;
    private static CookiesControllingAccessPage cookiesControllingAccessPage;
    private static FindByPlaygroundTestPage findByPlaygroundTestPage;
    
    public Tests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 15);
       driver.manage().window().maximize();
    }
    
    @AfterClass
    public static void tearDownClass() {
       driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        indexPage = new IndexPage(driver);
        cookiesControllingAccessPage = new CookiesControllingAccessPage(driver);
        findByPlaygroundTestPage  = new FindByPlaygroundTestPage(driver);
    }
    
    @After
    public void tearDown() {
        
    }
    
    @Test
    public void cookiesControllingPageAccessLogin() {
        indexPage.clickOnCookiesControllingPageAccessLink();
        String usernameInput = "Admin";
        cookiesControllingAccessPage.enterUsername(usernameInput);
        String passwordInput = "AdminPass";
        cookiesControllingAccessPage.enterPassword(passwordInput);
        cookiesControllingAccessPage.clickOnLoginButton();
        cookiesControllingAccessPage.clickOnGoToLoginButton();
         
        String expectedResult = "https://testpages.herokuapp.com/styled/cookies/adminview.html";
        String actualResult = driver.getCurrentUrl();
        assertTrue("URLs doesn't match", expectedResult.equals(actualResult));
     }
     
    @Test
    public void  findByPlaygroundTestPageClickOnLastLink() {
        indexPage.clickOnFindByPlaygroundTestPageLink();
        findByPlaygroundTestPage.clickOnLastLink();
         
        String expectedResult = "https://testpages.herokuapp.com/styled/find-by-playground-test.html#pName24";
        String actualResult = driver.getCurrentUrl();
        assertTrue("URLs doesn't match", expectedResult.equals(actualResult));
     }
     
}
