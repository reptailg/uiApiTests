package base;

import annotation.InitialPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import properties.BaseProperties;
import test.ui.yandex_search.TestYandexSearch;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static Logger log = Logger.getLogger(TestBase.class.getName());
    private String url = "";

    @BeforeMethod
    public void analyzeAnnotation(Method m) {

        if (m.isAnnotationPresent(InitialPage.class)) {
            System.out.println(m.getName() + " : " + m.getAnnotation(InitialPage.class).url().toString());
            url = m.getAnnotation(InitialPage.class).url().toString();
        }
    }
    @BeforeMethod
    public void init() {
        open(BaseProperties.getProperty(url));
    }

    @AfterTest
    public void end(){
        closeWebDriver();
    }
}
