package pages;

import static framework.Helper.generateTitle;
import static framework.Helper.getRandomInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Html5ElementFormTestPage {
    
    private WebDriver driver;
    private By datePickerLocator = By.name("date");
    private By dateTimeLocator = By.name("datetime");
    private By emailFieldLocator = By.id("email-field");
    private By monthFieldLocator = By.id("month-field");
    private By numberFieldLocator = By.id("number-field");
    private By resetButtonLocator = By.xpath("//*[@id=\"HTMLFormElements\"]/div[7]/input[1]");
    private By datePickerIdLocator = By.id("date-picker");
    private By dateTimePickerLocator = By.id("date-time-picker");
    
    public Html5ElementFormTestPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void enterDatePicker() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        driver.findElement(datePickerLocator).sendKeys(dateFormat.format(date));
    }
    
    public void enterLocalDateTime() {
        DateFormat localDateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date = new Date();
        driver.findElement(dateTimeLocator).sendKeys(localDateTimeFormat.format(date), Keys.ENTER);
    }
    
    public void enterEmailField() {
        driver.findElement(emailFieldLocator).clear();
        driver.findElement(emailFieldLocator).sendKeys(generateTitle());
    }
    
    public void enterMonthField() {
        driver.findElement(monthFieldLocator).sendKeys(" ", Keys.ENTER);
    }
    
    public void enterNumberField() {
        driver.findElement(numberFieldLocator).clear();
        driver.findElement(numberFieldLocator).sendKeys(getRandomInteger() + " ");
    }
    
    public void clickOnResetButton() {
        driver.findElement(resetButtonLocator).click();
    }
    
    public String getNumberField() {
        return driver.findElement(numberFieldLocator).getAttribute("value");
    }
    
    public String getDatePicker() {
        return driver.findElement(datePickerIdLocator).getAttribute("value");
    }
    
    public String getMonthField() {
        return driver.findElement(monthFieldLocator).getAttribute("value");
    }
    
    public String getEmailField() {
        return driver.findElement(emailFieldLocator).getAttribute("value");
    }
    
    public String getDateTimePicker() {
        return driver.findElement(dateTimePickerLocator).getAttribute("value");
    }
}
