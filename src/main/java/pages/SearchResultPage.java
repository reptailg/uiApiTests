package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {

    private final WebElement search = $("#uniq16733372597981");
    private final WebElement btnSearch = $x("//button[@class = 'websearch-button mini-suggest__button']");
    private final WebElement oneBox = $("#f11jnc6b-OP6HxZC");

    private static final String SEARCH_VALUE = "Английский Русский";


    @Step("Set search value")
    public SearchResultPage setSearchValue(String value){
        search.sendKeys(value);
        return this;
    }

    @Step("Search via button")
    public SearchResultPage searchViaButton(){
        btnSearch.click();
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
                $$x("//div[@class='Translate-Controls']//span[@class = 'Button2-Text']").stream()
                        .allMatch(x-> SEARCH_VALUE.contains(x.getText())));
    }

    @Step("Get n element SERP link")
    public String getSerpElementLink(int n){
        return $x("//li[@data-cid='"+ n + "']//a[@accesskey ='"+ (n + 1) +"']").getAttribute("href");
    }
}
