package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;
import objects.CodeverosHomePage;
import objects.LoginPage;
import objects.RegistrationTab;
import org.testng.Assert;
import utilities.BaseController;

import java.time.LocalDateTime;

@CucumberOptions(features = "features")
public class AccountRegistrationStepsDef {

    RegistrationTab registrationTab;
    CodeverosHomePage codeverosHomePage;
    LoginPage loginPage;
    BaseController controller;
    String uniqueUserName;

    public AccountRegistrationStepsDef(BaseController controller){
        this.controller = controller;
        loginPage = new LoginPage(this.controller.getDriver());
    }
    @Given("a web browser is at the Codeveros registration page")
    public void aWebBrowserIsAtTheCodeverosRegistrationPage() {
        this.controller.goToSite();
        loginPage.waitForVisibilityOfRegTab();
        registrationTab = loginPage.goToRegistrationSection();
    }

    @When("user enters {string} as a First Name")
    public void userEntersFirstName(String firstName) {
        registrationTab.fillOutFirstName(firstName);
    }

    @When("user enters {string} as a Second Name")
    public void userEntersSecondName(String lastName) {
        registrationTab.fillOutLastName(lastName);
    }

    @When("user enters unique Username")
    public void userEntersUniqueUsername() {
        registrationTab.fillOutUserName(LocalDateTime.now().toString());
    }

    @When("user enters {string} as a Username")
    public void userEntersUsername(String userName) {
        registrationTab.fillOutUserName(userName);
    }

    @When("user enters {string} as a Email Address")
    public void userEnterEmailAddress(String email) {
        registrationTab.fillOutEmail(email);
    }

    @When("user enters {string} as a Password")
    public void userEntersPassword(String password) {
        registrationTab.fillOutPassword(password);
    }

    @When("user enters {string} as a Confirm Password")
    public void userEntersConfirmPassword(String confPassword) {
        registrationTab.fillOutConfirmPassword(confPassword);
    }

    @When("user click Register button")
    public void userClickRegisterButton() {
        registrationTab.submitForm();
    }

    @Then("Codeveros welcome page is shown")
    public void codeverosWelcomePageIsShown() {
        codeverosHomePage = new CodeverosHomePage(this.controller.getDriver());
        Assert.assertTrue(codeverosHomePage.welcomeMessageIsPresented());
    }

    @Then("the Register button stays inactive")
    public void theRegisterButtonStaysInactive() {
        Assert.assertFalse(registrationTab.getRegisterButtonStatus());
    }


}
