package stepDefinitions;

import appPages.HomePage;
import appPages.RegistrationPage;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class RegistrationStepDefinition {


    HomePage homePage = new HomePage(DriverFactory.getDriver());
     RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());
    @And("user click on signup or login link on homepage")
    public void userClickOnSignupOrLoginLinkOnHomepage() {
       homePage.navigateToLoginPage();

    }

    @And("user enters {string} and {string} and clicks on signup button")
    public void user_enters_and_and_clicks_on_signup_button(String username, String emailId) {
      registrationPage.enterSignUpDetails(username,emailId);
    }
    @And("user enters {string} and {string} and {string} and {string} and {string}")
    public void user_enters_and_and_and_and(String title, String password, String day, String month, String year) throws InterruptedException {
      registrationPage.enterInitialInfo(title, password, day, month, year);
      Thread.sleep(3000);
    }
    @And("user enters {string} and {string} and {string} and {string}")
    public void user_enters_and_and_and(String fname, String lname, String address1, String address2) {

    }
    @And("{string} and {string} and {string} and {string} and {string}")
    public void and_and_and_and(String country, String state, String city, String zipcode, String mobile) {

    }
    @And("user click on  create account button")
    public void user_click_on_create_account_button() {

    }
    @Then("user should be able to view the account creation confirmation")
    public void user_should_be_able_to_view_the_account_creation_confirmation() {

    }


}
