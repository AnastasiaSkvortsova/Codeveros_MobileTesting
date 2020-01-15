package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTab extends BasicPage {

    private WebElement userNameInput;
    private WebElement passwordInput;
    private WebElement signInButton;
    private By userNameSelector;
    private String failedLoginMessageSelector;

    public LoginTab(WebDriver driver){
        super(driver);

        userNameSelector = By.id("mat-input-0");
        failedLoginMessageSelector = "p";
    }

    public void fillOutUserName(String userName){
        userNameInput.sendKeys(userName);
    }

    public void fillOutPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void submitForm(){
        signInButton.click();
    }

    public boolean getSignInButtonStatus(){

        return signInButton.isEnabled(); }

    public boolean failedLoginMessageIsPresented(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(failedLoginMessageSelector)));
        return driver.findElement(By.cssSelector(failedLoginMessageSelector)).isDisplayed();
    }

    public void initOnceVisible () {

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(userNameSelector));
        userNameInput = driver.findElement(By.id("mat-input-0"));
        passwordInput = driver.findElement(By.id("mat-input-1"));
        signInButton = driver.findElement(By.cssSelector(".mat-raised-button"));
    }
}
