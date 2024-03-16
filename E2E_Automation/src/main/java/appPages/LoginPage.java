package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public WebDriver driver;

    //tagName[@attributeName='attributevalue']

    public LoginPage(WebDriver driver){
        super(driver);

        this.driver = driver;
    }

    private By textEmailAddress = By.xpath("//input[@data-qa = 'login-email']");
    private By textPassword = By.xpath("//input[@data-qa = 'login-password']");
    private By buttonLogin = By.xpath("//button[@data-qa = 'login-button']");


    public void loginToApp(String email,String password){

      //  driver.findElement(textEmailAddress).sendKeys(email);
        inputInfo(textEmailAddress,email);
     //   driver.findElement(textPassword).sendKeys(password);
        inputInfo(textPassword,password);
        clickElement(buttonLogin);
    }




}
