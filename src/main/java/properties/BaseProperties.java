package properties;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;


public class BaseProperties {

    private BaseProperties() {
        throw new IllegalStateException("Property class");
    }
    public static final Logger log = Logger.getLogger(BaseProperties.class.getName());

    public static String getProperty(String key){

        Properties property = new Properties();
        try(FileInputStream fis = new FileInputStream("src" + File.separator + "test" + File.separator +
                "resources" + File.separator + "config.properties")) {
            property.load(fis);
        } catch (IOException e) {
            log.info("ERROR: no property file");
        }
        return property.getProperty(key);
    }

}
