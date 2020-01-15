package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodeverosHomePage extends BasicPage {

    private String welcomeMessageSelector;
    private String signOutIconSelector;
    private String confirmSelector;

    public CodeverosHomePage(WebDriver driver){
        super(driver);
        welcomeMessageSelector = ".mat-display-2.page-title";
        signOutIconSelector = "button:nth-of-type(2)  mat-icon[role='img']";
        confirmSelector = ".mat-dialog-actions > button:nth-of-type(2) > .mat-button-wrapper";
    }

    public boolean welcomeMessageIsPresented(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(welcomeMessageSelector)));
        return driver.findElement(By.cssSelector(welcomeMessageSelector)).isDisplayed();
    }


    public void signOut(){
        driver.findElement(By.cssSelector(signOutIconSelector)).click();
        driver.switchTo().activeElement();
        driver.findElement(By.cssSelector(confirmSelector)).click();
    }
}
