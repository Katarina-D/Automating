package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {
    
    private WebDriver driver;
    private By navAdminLoginLocator = By.id("adminlogin");
    private By navHtml5formtestLocator = By.id("html5formtest");
    private By navAlertTestLocator = By.id("alerttest");
    private By navFindByTestLocator = By.id("findbytest");
    
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnCookiesControllingPageAccessLink() {
        driver.findElement(navAdminLoginLocator).click();
    }
    
    public void clickOnHtml5ElementFormTestPageLink() {
        driver.findElement(navHtml5formtestLocator).click();
    }
    
    public void clickOnAlertsLink() {
        driver.findElement(navAlertTestLocator).click();
    }
    
    public void clickOnFindByPlaygroundTestPageLink() {
        driver.findElement(navFindByTestLocator).click();
    }
}
