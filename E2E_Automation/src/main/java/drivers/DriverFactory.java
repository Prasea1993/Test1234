package drivers;


import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.Constants;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DriverFactory {

// parallel execution , thread safety

    public static ThreadLocal<RemoteWebDriver>   driverRef = new ThreadLocal<>();


    public static synchronized RemoteWebDriver getDriver(){

        return driverRef.get();
    }



   public RemoteWebDriver init_Driver(String executionEnv,String browserType){

       try {
           if (executionEnv.equalsIgnoreCase("Local")) {

               if (browserType.equalsIgnoreCase("Chrome")) {
                   driverRef.set(new ChromeDriver());

               } else if (browserType.equalsIgnoreCase("Firefox")) {

                   driverRef.set(new FirefoxDriver());

               } else if (browserType.equalsIgnoreCase("Edge")) {

                   driverRef.set(new EdgeDriver());

               } else if (browserType.equalsIgnoreCase("Safari")) {
                   driverRef.set(new SafariDriver());
               } else {

                   System.out.println("The type of browser you provided is either incorrect ot not supported at the momemt");
               }
           }


           else {


               if (browserType.equalsIgnoreCase("Chrome")) {

                   MutableCapabilities capabilities = new MutableCapabilities();
                   ChromeOptions options = new ChromeOptions();
                   options.addArguments("incognito");  // ChromeOptions for starting chrome in incognito mode

                   capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                   capabilities.setCapability("browserName", "Chrome");
                   capabilities.setCapability("browserVersion", "latest");
                   HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                   browserstackOptions.put("os", "OS X");
                   browserstackOptions.put("osVersion", "Monterey");
                   capabilities.setCapability("bstack:options", browserstackOptions);
                   String BS_URL = "https://"+Constants.BS_USERNAME+":"+Constants.BS_ACCESSKEY+"@hub-cloud.browserstack.com/wd/hub";

                   driverRef.set(new RemoteWebDriver(new URL(BS_URL), capabilities));

               } else if (browserType.equalsIgnoreCase("Firefox")) {


                   FirefoxOptions browserOptions = new FirefoxOptions();
                   browserOptions.setPlatformName("Windows 11");
                   browserOptions.setBrowserVersion("latest");
                   Map<String, Object> sauceOptions = new HashMap<>();
                   sauceOptions.put("username", Constants.SAUCELABS_USERNAME);
                   sauceOptions.put("accessKey", Constants.SAUCELABS_ACCESSKEY);
                   sauceOptions.put("name", "<your test name>");
                   browserOptions.setCapability("sauce:options", sauceOptions);

                   URL SL_URL = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                   driverRef.set(new RemoteWebDriver(SL_URL, browserOptions));

               } else if (browserType.equalsIgnoreCase("Edge")) {

                   driverRef.set(new EdgeDriver());

               } else if (browserType.equalsIgnoreCase("Safari")) {
                   driverRef.set(new SafariDriver());
               } else {

                   System.out.println("The type of browser you provided is either incorrect ot not supported at the momemt");
               }

           }

       }

       catch(Exception e){
           e.printStackTrace();
       }



        getDriver().manage().window().maximize();
      return getDriver();

    }


    public static void main(String[] args) {
        DriverFactory df = new DriverFactory();
        df.init_Driver("Local","Chrome");

        DriverFactory.getDriver().get("https://demoqa.com/browser-windows");
        DriverFactory.getDriver().findElement(By.id("tabButton")).click();
        DriverFactory.getDriver().findElement(By.id("windowButton")).click();
        DriverFactory.getDriver().findElement(By.id("messageWindowButton")).click();

        String parentWindow = DriverFactory.getDriver().getWindowHandle();

        Set<String> windows = DriverFactory.getDriver().getWindowHandles();


        for(String window : windows){

            DriverFactory.getDriver().switchTo().window(window);
            System.out.println(DriverFactory.getDriver().getTitle());
        }



    }




}
