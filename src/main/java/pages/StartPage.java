package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import static com.codeborne.selenide.Selenide.*;

public class StartPage {
    private final WebElement searchField = $("#text");
    private final WebElement captcha = $x("//span[@class = 'Text Text_weight_regular Text_typography_control-xxl CheckboxCaptcha-LabelText']");
    @Step("Input text in search field")
    public StartPage inputTextSearch(String search){
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Check open reCaptcha page")
    public StartPage checkOpenRecaptcha(){
        Assert.assertEquals(captcha.getText(),"Я не робот","Captcha didn't load");
        return this;
    }


}
