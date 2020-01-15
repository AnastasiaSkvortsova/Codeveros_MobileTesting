package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidController implements BaseController {

    private AppiumDriverLocalService appiumDriverLocalService;
    WebDriver driver;

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

        AppiumDriverLocalService appiumDriverLocalService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
        appiumDriverLocalService.start();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        WebDriverManager.chromedriver().forceCache().version("74").setup();

        driver = new AndroidDriver(appiumDriverLocalService.getUrl(), caps);
    }

    @Override
    public void goToSite(){
        driver.get(BaseController.siteAddress);
    };
}
