package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FindByPlaygroundTestPage {
    private WebDriver driver;
    private List<WebElement> linksList;
    private By linksListLocators = By.cssSelector("ul#ul1 li.normal a.normal");
    
    public FindByPlaygroundTestPage(WebDriver driver) {
       this.driver = driver;
    }
    
    public List<WebElement> linksList() {
       return driver.findElements(linksListLocators);
    }
    
    public void clickOnLastLink() {
       linksList = linksList();
       linksList.get(linksList.size() - 1).click();
    }
    
}
