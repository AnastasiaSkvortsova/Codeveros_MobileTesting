package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseController;

public class SetupSteps {

    BaseController controller;

    public SetupSteps(BaseController controller) {
        this.controller = controller;
    }

    @Before
    public void setUpController() {
        controller.setupController();
    }

    @After
    public void tearDownController() {
        controller.teardownController();
    }

    @AfterStep
    public void getScreenshot(Scenario scenario) {

            byte[] screenshot = ((TakesScreenshot) controller.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
    }
}

