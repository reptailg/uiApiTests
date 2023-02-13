package test.ui.yandex_search;

import annotation.Url;
import base.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import pages.StartPage;
import annotation.InitialPage;


public class TestYandexSearch extends TestBase {

    @Test
    @Description("Check recaptcha after start search page")
    @InitialPage(url = Url.YANDEX_START_URL)
    public void checkFullSearchTest(){
        new StartPage().inputTextSearch("Перевод");
        SearchResultPage page = new SearchResultPage();
        page.checkOneBox().checkOneBoxLanguages();
    }

    @Test
    @Description("Check recaptcha after start search page")
    @InitialPage(url = Url.YANDEX_START_URL)
    public void checkSearchRecapTest(){
        new StartPage().inputTextSearch("Перевод").checkOpenRecaptcha();
    }

    @Test
    @Description("Check One-Box in search result")
    @InitialPage(url = Url.YANDEX_SEARCH_URL)
    public void checkOneBoxTest(){
        new SearchResultPage().setSearchValue("Перевод").searchViaButton().checkOneBox().checkOneBoxLanguages();
    }

    @DataProvider(name = "Search result")
    public Object[][] searchResult(){
        return new Object[][]{
                {1, "https://translate.yandex.ru/"},
                {2, "https://translate.google.ru/"}
        };
    }

    @Test(dataProvider = "Search result")
    @Description("Check search results")
    @InitialPage(url = Url.YANDEX_SEARCH_URL)
    public void checkSearchResultTest(int element, String expectedResult){
        SearchResultPage page = new SearchResultPage();
        page.setSearchValue("Перевод").searchViaButton();
        Assert.assertEquals(expectedResult, page.getSerpElementLink(element), "Search element " + element +
                "not equal " + expectedResult);
    }
}
