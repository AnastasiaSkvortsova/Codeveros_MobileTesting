package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeController implements BaseController {

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
        WebDriverManager.chromedriver().forceCache().setup();
        driver = new ChromeDriver();
    }

    @Override
    public void goToSite(){
        driver.get(BaseController.siteAddress);
    };
}
