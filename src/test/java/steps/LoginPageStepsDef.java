package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.*;
import org.testng.Assert;
import utilities.BaseController;


public class LoginPageStepsDef {

    LoginTab loginTab;
    RegistrationTab registrationTab;
    CodeverosHomePage codeverosHomePage;
    LoginPage loginPage;
    BaseController controller;
    UserCredentials userCredentials;


    public LoginPageStepsDef (BaseController controller){
        this.controller = controller;
        loginPage = new LoginPage(this.controller.getDriver());
    }

    @Given("a web browser is at Codeveros Sign In page")
    public void aWebBrowserIsAtCodeverosSignInPage() {
        this.controller.goToSite();
        loginPage.waitForVisibilityOfLoginTab();
        loginTab = loginPage.goToLoginSection();
    }

    @Given("a valid user exists in the system")
    public void aValidUserExistsInTheSystem() {
        this.controller.goToSite();
        loginPage.waitForVisibilityOfLoginTab();
        registrationTab = loginPage.goToRegistrationSection();
        userCredentials = registrationTab.registeraNewUser();
        codeverosHomePage = new CodeverosHomePage(this.controller.getDriver());
        Assert.assertTrue(codeverosHomePage.welcomeMessageIsPresented());
        codeverosHomePage.signOut();
    }

    @When("user enters a valid Username")
    public void userEntersAValidUsername() {
        loginTab.fillOutUserName(userCredentials.getUserName());
    }

    @When("user enters a valid Password")
    public void userEntersAValidPassword() {
        loginTab.fillOutPassword(userCredentials.getPassword());
    }

    @When("user enters {string} as a Username_")
    public void userEntersAsAUsername_(String userName) {
        loginTab.fillOutUserName(userName);
    }

    @When("user enters {string} as a Password_")
    public void userEntersAsAPassword_(String password) {
        loginTab.fillOutPassword(password);
    }

    @When("user click Sign In button")
    public void userClickSignInButton() {
        loginTab.submitForm();
    }

    @Then("Codeveros home page is shown")
    public void codeverosHomePageIsShown() {
        codeverosHomePage = new CodeverosHomePage(this.controller.getDriver());
        Assert.assertTrue(codeverosHomePage.welcomeMessageIsPresented());
    }

    @Then("Sign In button stays inactive")
    public void signInButtonStaysInactive() {
        Assert.assertFalse(loginTab.getSignInButtonStatus());
    }

    @Then("Failed login message on Codeveros Sign In page is shown")
    public void failedLoginMessageOnCodeverosSignInPageIsShown() {
        Assert.assertTrue(loginTab.failedLoginMessageIsPresented());
    }

}
