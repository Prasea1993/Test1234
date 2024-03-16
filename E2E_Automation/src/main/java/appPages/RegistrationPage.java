package appPages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{

    public WebDriver driver;

    public RegistrationPage(WebDriver driver){
        super(driver);

        this.driver = driver;
    }


    private By textUsername = By.xpath("//input[@data-qa='signup-name']");
    private By textEmailAddress = By.xpath("//input[@data-qa='signup-email']");
    private By buttonSignup = By.xpath("//button[@data-qa='signup-button']");
    private By labelMr = By.xpath("//label[@for='id_gender1']");
    private By labelMrs = By.xpath("//label[@for='id_gender2']");
    private By textPassword = By.xpath("//input[@data-qa='password']");
    private By dropDownDay = By.id("days");
    private By dropDownMonth = By.id("months");
    private By dropDownYear = By.id("years");
    private By textFirstName = By.xpath("//input[@data-qa='first_name']");
    private By textLastName = By.xpath("//input[@data-qa='last_name']");
    private By textAddress = By.xpath("//input[@data-qa='address']");
    private By textAddress2 = By.xpath("//input[@data-qa='address2']");
    private By dropDownCountry = By.id("country");
    private By textState = By.xpath("//input[@data-qa='state']");
    private By textCity = By.xpath("//input[@data-qa='city']");
    private By textZipCode = By.xpath("//input[@data-qa='zipcode']");
    private By textMobileNumber = By.xpath("//input[@data-qa='mobile_number']");
    private By buttonCreateAccount = By.xpath("//button[@data-qa='create-account']");

    public void enterSignUpDetails(String username, String emailID){


        Faker faker = new Faker();



        driver.findElement(textUsername).sendKeys(username + faker.name().name());
        driver.findElement(textEmailAddress).sendKeys(emailID+faker.name().firstName()+"kishoretraining@gmail.com");
        driver.findElement(buttonSignup).click();
    }


    public void enterInitialInfo(String title, String password,String day, String month, String year){

        if(title.equalsIgnoreCase("Mr")){
            driver.findElement(labelMr).click();
        }
        else{
            driver.findElement(labelMrs).click();
        }

        driver.findElement(textPassword).sendKeys(password);
        Select days = new Select(driver.findElement(dropDownDay));
        days.selectByVisibleText(day);

        Select months = new Select(driver.findElement(dropDownMonth));
        months.selectByVisibleText(month);

        Select years = new Select(driver.findElement(dropDownYear));
        years.selectByVisibleText(year);

        clickElementUsingJS(buttonCreateAccount);

    }

}
