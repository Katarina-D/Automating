package admin;

import static framework.Helper.generateTitle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertsPage;
import pages.IndexPage;

public class AlertsTest {
    
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static IndexPage indexPage;
    private static AlertsPage alertsPage;
    
    public AlertsTest() {
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
       alertsPage = new AlertsPage(driver);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void confirmBoxAnswerOk() {
        indexPage.clickOnAlertsLink();
        alertsPage.clickOnConfirmBoxButton();
        driver.switchTo().alert().accept();
        
        String expectedResult = "You clicked OK, confirm returned true.";
        String actualResult = alertsPage.getConfirmExplanation();
        assertTrue("Confirm explanation is not correct", expectedResult.equals(actualResult));
     }
     
     @Test
     public void confirmBoxAnswerCancel() {
        indexPage.clickOnAlertsLink();
        alertsPage.clickOnConfirmBoxButton();
        driver.switchTo().alert().dismiss();
        
        String expectedResult = "You clicked Cancel, confirm returned false.";
        String actualResult = alertsPage.getConfirmExplanation();
        assertTrue("Confirm explanation is not correct", expectedResult.equals(actualResult));
     }
     
     @Test
     public void promptBoxAnswerOk() {
        indexPage.clickOnAlertsLink();
        alertsPage.clickOnPromptBoxButton();
        driver.switchTo().alert().sendKeys(generateTitle());
        driver.switchTo().alert().accept();
        
        String expectedResult = "You clicked OK. 'prompt' returned " + alertsPage.getPromptRetval();
        String actualResult = alertsPage.getPromptExplanation();
        assertTrue("Prompt explanation is not correct", expectedResult.equals(actualResult));
     }
     
     @Test
     public void promptBoxAnswerCancel() {
        indexPage.clickOnAlertsLink();
        alertsPage.clickOnPromptBoxButton();
        driver.switchTo().alert().sendKeys(generateTitle());
        driver.switchTo().alert().dismiss();
        
        String expectedResult = "You clicked Cancel. 'prompt' returned null";
        String actualResult = alertsPage.getPromptExplanation();
        assertTrue("Prompt explanation is not correct", expectedResult.equals(actualResult));
     }
}
