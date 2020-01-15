package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxController implements BaseController{
    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setupController() {
        WebDriverManager.firefoxdriver().forceCache().setup();
        driver = new FirefoxDriver();
    }

    @Override
    public void goToSite(){
        driver.get(BaseController.siteAddress);
    };
}
