package test.ui.yandex_search;

import annotation.Url;
import base.TestBase;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import pages.StartPage;
import annotation.InitialPage;


public class TestYandexSearch extends TestBase {

    @Test
    @InitialPage(url = Url.YANDEX_START_URL)
    public void checkSearchRecapTest(){
        new StartPage().inputTextSearch("Перевод").checkOpenRecaptcha();
    }

    @Test
    @InitialPage(url = Url.YANDEX_SEARCH_URL)
    public void checkSearchResultTest(){
        new SearchResultPage().setSearchValue("Перевод").searchViaButton().checkOneBox().checkOneBoxLanguages();

    }
}
