package stepDefinitions;

import appPages.HomePage;
import drivers.DriverFactory;
import io.cucumber.java.en.Given;

public class HomeStepDefinition {

    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        homePage.navigateToLoginPage();
    }
}
