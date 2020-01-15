package utilities;

import org.openqa.selenium.WebDriver;

public interface BaseController {
     WebDriver getDriver();
     String siteAddress = "http://192.168.0.7/";

    void setDriver(WebDriver driver);

    void setupController();
    default void teardownController() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
    void goToSite();
}
