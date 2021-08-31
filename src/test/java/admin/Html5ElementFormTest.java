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
import pages.Html5ElementFormTestPage;
import pages.IndexPage;

public class Html5ElementFormTest {
    
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static IndexPage indexPage;
    private static Html5ElementFormTestPage html5ElementFormTestPage;
    
    public Html5ElementFormTest() {
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
        html5ElementFormTestPage  = new Html5ElementFormTestPage(driver);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void html5ElementFormTestPageReset() {
        indexPage.clickOnHtml5ElementFormTestPageLink();
        html5ElementFormTestPage.enterDatePicker();
        html5ElementFormTestPage.enterLocalDateTime();
        html5ElementFormTestPage.enterEmailField();
        html5ElementFormTestPage.enterMonthField();
        html5ElementFormTestPage.enterNumberField();
        html5ElementFormTestPage.clickOnResetButton();
         
        String expectedResult = "https://testpages.herokuapp.com/styled/html5-form-test.html";
        String actualResult = driver.getCurrentUrl();
        assertTrue("URLs doesn't match", expectedResult.equals(actualResult));
        
        String expectedNumberResult = "42";
        String actualNumberResult = html5ElementFormTestPage.getNumberField();
        assertTrue("Default numbers don't match", expectedNumberResult.equals(actualNumberResult));
        
        String expectedDateResult = "";
        String actualDateResult = html5ElementFormTestPage.getDatePicker();
        assertTrue("Default date doesn't match", expectedDateResult.equals(actualDateResult));
        
        String expectedMonthResult = "";
        String actualMonthResult = html5ElementFormTestPage.getMonthField();
        assertTrue("Default month doesn't match", expectedMonthResult.equals(actualMonthResult));
        
        String expectedEmailResult = "bob@mailinator.com";
        String actualEmailResult = html5ElementFormTestPage.getEmailField();
        assertTrue("Default email doesn't match", expectedEmailResult.equals(actualEmailResult));
        
        String expectedLocalDateTimeResult = "2018-01-01T01:01";
        String actualLocalDateTimeResult = html5ElementFormTestPage.getDateTimePicker();
        assertTrue("Default local date and time doesn't match", expectedLocalDateTimeResult.equals(actualLocalDateTimeResult));
    }
}
