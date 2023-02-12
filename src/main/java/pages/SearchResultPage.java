package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static properties.BaseProperties.log;

public class SearchResultPage {

    private final WebElement search = $("#uniq16733372597981");
    private final WebElement btnSearch = $x("//button[@class = 'websearch-button mini-suggest__button']");
    private final WebElement oneBox = $("#f11jnc6b-OP6HxZC");


    @Step("Set search value")
    public SearchResultPage setSearchValue(String value){
        search.sendKeys(value);
        return this;
    }

    @Step("Search via button")
    public SearchResultPage searchViaButton(){
        if (!search.getText().equals("")){
            btnSearch.click();
        }else{
            log.info("Empty search value");
        }
        return this;
    }
    @Step("Check One-Box is display")
    public SearchResultPage checkOneBox(){
        oneBox.isDisplayed();
        return this;
    }
    @Step("Check One-Box languages")
    public void checkOneBoxLanguages(){
        Assert.assertTrue(
                $$x("//span[@class = 'Button2-Text']").stream()
                        .allMatch(x-> x.toString().contains("Английский Русский")));
    }
}
