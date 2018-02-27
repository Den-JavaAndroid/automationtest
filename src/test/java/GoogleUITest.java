import Pages.GoogleMainPage;
import Pages.GoogleSearchResultsPage;
import base.BaseUIMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by denx7 on 26.02.2018.
 */
public class GoogleUITest {
    private WebDriver driver;
    private BaseUIMethods baseUIMethods;
    private GoogleMainPage googleMainPage;
    private GoogleSearchResultsPage googleSearchResultsPage;


    @BeforeTest
    public void startTest() {
        baseUIMethods = new BaseUIMethods();
        driver = baseUIMethods.getChromeDriver();
        googleMainPage = new GoogleMainPage(driver);
        googleSearchResultsPage = new GoogleSearchResultsPage(driver);
    }

    @AfterTest
    public void stopTest() {
        baseUIMethods.closeDriver(getClass().getSimpleName());
    }

    @Test
    public void googleSearchFIOTest() {
        googleMainPage.openMainPage();
        googleMainPage.inputInSearchField("Пушкин Александр Сергеевич");
        googleMainPage.clickSearchButton();
//проверяем 3 первых результата
        ArrayList<WebElement> searchResults = googleSearchResultsPage.getSearchResults();
        Assert.assertTrue(searchResults.get(0).getText().contains("Пушкин, Александр Сергеевич — Википедия"), "Проверяем результат поиска: Пушкин, Александр Сергеевич — Википедия");
        Assert.assertTrue(searchResults.get(1).getText().contains("Биография Александра Сергеевича Пушкина"), "Проверяем результат поиска: Биография Александра Сергеевича Пушкина");
        Assert.assertTrue(searchResults.get(2).getText().contains("Пушкин Александр Сергеевич"), "Проверяем результат поиска: Пушкин Александр Сергеевич");

    }

    @Test
    public void googleSearchNameTest() {
        googleMainPage.openMainPage();
        googleMainPage.inputInSearchField("Яндекс");
        googleMainPage.clickSearchButton();
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(driver);
//проверяем 3 первых результата
        ArrayList<WebElement> searchResults = googleSearchResultsPage.getSearchResults();
        Assert.assertTrue(searchResults.get(0).getText().contains("Яндекс"), "Проверяем результат поиска: Яндекс");
        Assert.assertTrue(searchResults.get(1).getText().contains("Яндекс"), "Проверяем результат поиска: Яндекс");
        Assert.assertTrue(searchResults.get(2).getText().contains("Яндекс - YouTube"), "Проверяем результат поиска: Яндекс - YouTube");
    }

    @Test
    public void googleTooltipOfSearchInputTest() {
        googleMainPage.openMainPage();
        Assert.assertEquals(googleMainPage.getTitleAtributeOfSearchInputField(), "Поиск", "Проверка наличия всплывающей подсказки Поиск");
    }

    @Test
    public void googleRedirectToMainPageFromLogoTest() {
        googleMainPage.openMainPage();
        googleMainPage.inputInSearchField("selenium");
        googleMainPage.clickSearchButton();
        googleSearchResultsPage.clickGoogleLogo();
        Assert.assertTrue(googleMainPage.isMainGooglePage(), "Проверяем что открылась главная страница (пустая область результатов)");
    }


}
