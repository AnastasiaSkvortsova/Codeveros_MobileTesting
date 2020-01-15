package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class RegistrationTab extends BasicPage{

    private WebElement firstNameInput;
    private WebElement lastNameInput;
    private WebElement userNameInput;
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement confirmPasswordInput;
    private WebElement registerButton;
    private By firstNameSelector;

    public RegistrationTab(WebDriver driver){
        super(driver);

        firstNameSelector = By.id("mat-input-2");
    }

    public void fillOutFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void fillOutLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void fillOutUserName(String userName){
        userNameInput.sendKeys(userName);
    }

    public void fillOutEmail(String email){
        emailInput.sendKeys(email);
    }

    public void fillOutPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void fillOutConfirmPassword(String password){
        confirmPasswordInput.sendKeys(password);
    }

    public void submitForm(){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.className("mat-raised-button")));
        registerButton.click();
    }

    public boolean getRegisterButtonStatus(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className("mat-raised-button")));
        return registerButton.isEnabled();
    }

    public UserCredentials registeraNewUser(){
        Random rand = new Random();
        int rand_int = rand.nextInt(100000);
        String userName = "userName"+rand_int;
        String password = "password";
        fillOutFirstName("fName");
        fillOutLastName("lName");
        fillOutUserName(userName);
        fillOutEmail("myEmail@gmail.com");
        fillOutPassword(password);
        fillOutConfirmPassword(password);
        submitForm();
        return new UserCredentials(userName, password);
    }

    public void initOnceVisible (){

        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(firstNameSelector));
        firstNameInput = driver.findElement(By.id("mat-input-2"));
        lastNameInput = driver.findElement(By.id("mat-input-3"));
        userNameInput = driver.findElement(By.id("mat-input-4"));
        emailInput = driver.findElement(By.id("mat-input-5"));
        passwordInput = driver.findElement(By.id("mat-input-6"));
        confirmPasswordInput = driver.findElement(By.id("mat-input-7"));
        registerButton = driver.findElement(By.xpath("//app-root/ng-component[@class='ng-star-inserted']/div/div//mat-tab-group/div/mat-tab-body[2]//auth-register[@class='ng-star-inserted']/form//button[@type='submit']"));
    }


}
