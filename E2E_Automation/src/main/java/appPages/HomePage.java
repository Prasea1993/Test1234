package appPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public WebDriver driver;

    //tagName[@attributeName='attributevalue']

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }



    private By signUpLink = By.xpath("//a[@href='/login']");



    public void navigateToLoginPage(){

     //  driver.findElement(signUpLink).click();
        clickElement(signUpLink,"CLicking on ");
    }



}
