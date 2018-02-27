package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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

    public void openMainPage() {
        log.info("Открываем главную страницу");
        driver.get(TestConfig.googleURL);
        waitElementVisibility(searchButton, 60);
    }

    public void inputInSearchField(String searchRequest) {
        log.info("Ввводим поисковый запрос: " + searchRequest);
        clickElementAndSendKeysWithTab(searchInputField, searchRequest);
    }

    public void clickSearchButton() {
        log.info("Кликаем кнопку Поиск в Google");
        clickAfterWaitClicable(searchButton);
    }

    //если видны кнопки "Поиск в Google" и "Мне повезет!" - значит это главная страница
    public boolean isMainGooglePage() {
        try {
            waitElementVisibility(searchButton, 20);
            waitElementVisibility(luckyButton, 20);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    public String getTitleAtributeOfSearchInputField() {
        //Verifying Tool Tips - в данном случае для всплывающей подсказки используется атрибут title
        return driver.findElement(searchInputField).getAttribute("title");
        //также для подсказок используются различные Jquery plugins.
        //инфо https://www.guru99.com/verify-tooltip-selenium-webdriver.html
    }

}
