package appPages;

import org.openqa.selenium.*;

import java.sql.SQLOutput;
import java.util.Set;

public class BasePage {


    public WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }


    public void clickElement(By by){

        driver.findElement(by).click();
    }

    public void clickElement(By by, String description){

        System.out.println(description + by);
        driver.findElement(by).click();
    }




    public void clickElementUsingJS(By by){

        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);

    }

    public void inputInfo(By by, String input){
        driver.findElement(by).sendKeys(input);
    }


     public void handlePromptAlert(String input, String decision){

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(input);

        driver.switchTo().frame("pact3");
        // sendkeys
         //clicks

         driver.switchTo().defaultContent();
        if(decision.equals("accept")){
            alert.accept();
        }
        else{
            alert.dismiss();
        }
     }

     public void switchToChildWindow(String title){

        String parentWindow = driver.getWindowHandle();   // A
        // action that will trigger additional window

         driver.switchTo().window(parentWindow);
         // clickewd on some element
         // click1
         //click2
         //click3
         Set<String> windows = driver.getWindowHandles();  // A,B,C,D

         for(String window : windows ){

           driver.switchTo().window(window);

             System.out.println(driver.getTitle());

           if(driver.getTitle().equals(title)){


           }


         }

     }


}
