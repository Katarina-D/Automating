package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiesControllingAccessPage {
    
    private WebDriver driver;
    private By usernameFieldLocator = By.name("username");
    private By passwordFieldLocator = By.name("password");
    private By loginButtonLocator = By.id("login");
    private By goLoginButtonLocator = By.id("gologin");
    
    
    public CookiesControllingAccessPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void enterUsername(String username) {
        driver.findElement(usernameFieldLocator).sendKeys(username);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    
    public void clickOnLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }
    
    public void clickOnGoToLoginButton() {
        driver.findElement(goLoginButtonLocator).click();
    }
    
}
