package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    
    private WebDriver driver;
    private By confirmExampleButtonLocator = By.id("confirmexample");
    private By promptExampleButtonLocator = By.id("promptexample");
    private By confirmExplanationMessageLocator = By.id("confirmexplanation");
    private By promptExplanationMessageLocator = By.id("promptexplanation");
    private By promptRetvalMessageLocator = By.id("promptretval");
    
    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOnConfirmBoxButton() {
        driver.findElement(confirmExampleButtonLocator).click();
    }
    
    public void clickOnPromptBoxButton() {
        driver.findElement(promptExampleButtonLocator).click();
    }
    
    public String getConfirmExplanation() {
       return driver.findElement(confirmExplanationMessageLocator).getText();
    }
    
    public String getPromptExplanation() {
        return driver.findElement(promptExplanationMessageLocator).getText();
    }
    
    public String getPromptRetval() {
        return driver.findElement(promptRetvalMessageLocator).getText();
    }
}
