package objects;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasicPage {

    WebDriver driver;

    public BasicPage(WebDriver driver){
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void navigate (String url){
        driver.get(url);
    }

}
