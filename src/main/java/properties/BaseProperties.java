package properties;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;


public class BaseProperties {
    public static Logger log = Logger.getLogger(BaseProperties.class.getName());

    public static String getProperty(String key){

        Properties property = new Properties();
        try(FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            property.load(fis);
        } catch (IOException e) {
            log.info("ОШИБКА: Файл свойств отсуствует!");
        }
        return property.getProperty(key);
    }

}
