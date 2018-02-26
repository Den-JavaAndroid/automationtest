package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testconfig.TestConfig;

/**
 * Created by denx7 on 27.02.2018.
 */
public class GoogleMainPage extends BasePage {

    private By searchButton = By.name("btnK");
    private By luckyButton = By.name("btnI");
    private By searchInputField = By.id("lst-ib");


    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage(){
        log.info("Открываем главную страницу");
        driver.get(TestConfig.googleURL);
        waitElementVisibility(searchButton, 60);
    }

    public void inputInSearchField(String searchRequest){
        log.info("Ввводим поисковый запрос: " + searchRequest);
        clickElementAndSendKeysWithTab(searchInputField, searchRequest);
    }

    public void clickSearchButton(){
        log.info("Кликаем кнопку Поиск в Google");
        clickAfterWaitClicable(searchButton);

    }

}
