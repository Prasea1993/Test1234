package stepDefinitions;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.util.Properties;

public class CommonActions {

    private DriverFactory driverFactory;
    private ConfigReader configReader;
    private RemoteWebDriver driver;
    private Properties properties;




    @Before
    public void openBrowser(){

       configReader = new ConfigReader();
       properties = configReader.getProperties();

       driverFactory = new DriverFactory();
       driver = driverFactory.init_Driver(properties.getProperty("env"), properties.getProperty("browser"));

       driver.get(properties.getProperty("appURL"));


    }


    @After
    public void tearDown(){

     driver.quit();

    }




}
