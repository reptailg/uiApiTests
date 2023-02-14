package base;

import annotation.InitialPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;
import properties.BaseProperties;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static Logger log = Logger.getLogger(TestBase.class.getName());
    private String url = "";


    @BeforeMethod
    public void init(Method m) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        if (m.isAnnotationPresent(InitialPage.class)) {
            url = m.getAnnotation(InitialPage.class).url().toString();
        }else{
            log.info("No url annotation for method " + m.getName());
        }
        open(BaseProperties.getProperty(url));
    }


}
