package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private Properties prop; // definition


    public Properties getProperties(){

        try{
            // Reading a file
            // loading that file to Properties class object

            FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/configuration.properties");
            prop = new Properties(); // initilisation
            prop.load(input);

        }

        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return prop;

    }


}
