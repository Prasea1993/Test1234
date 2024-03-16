package stepDefinitions;

import appPages.LoginPage;
import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDefinition {


   LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user launches the application")
    public void user_launches_the_application() {

    }

    @Given("user enters username and password to login")
    public void user_enters_username_and_password_to_login() {

        loginPage.loginToApp("prasha123@gmail.com","Pass1234s");
    }
    @Given("user click on submit button")
    public void user_click_on_submit_button() {

    }
    @Then("user should be able to login to the app")
    public void user_should_be_able_to_login_to_the_app() {

    }


}
