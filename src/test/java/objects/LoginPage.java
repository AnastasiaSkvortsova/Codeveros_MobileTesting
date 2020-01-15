package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

    By registrationPageLogo = By.id("mat-tab-label-0-1");
    By loginPageLogo = By.id("mat-tab-label-0-0");
    RegistrationTab registrationTab;
    LoginTab loginTab;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public RegistrationTab goToRegistrationSection (){

        driver.findElement(registrationPageLogo).click();
        registrationTab = new RegistrationTab(driver);
        registrationTab.initOnceVisible();
        return registrationTab;
    }

    public LoginTab goToLoginSection (){

        driver.findElement(loginPageLogo).click();
        loginTab = new LoginTab(driver);
        loginTab.initOnceVisible();
        return loginTab;
    }

    public void waitForVisibilityOfRegTab(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(registrationPageLogo));
    }

    public void waitForVisibilityOfLoginTab(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(loginPageLogo));
    }

}
