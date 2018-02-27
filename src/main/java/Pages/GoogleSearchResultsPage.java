package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class GoogleSearchResultsPage extends BasePage {
    private By searchResults = By.className("g");
    private By googleLogo = By.id("logo");


    public GoogleSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<WebElement> getSearchResults(){
        return (ArrayList<WebElement>) driver.findElements(searchResults);
    }

    public void clickGoogleLogo(){
        log.info("Кликаем лого в верхней левой части экрана");
        clickAfterWaitClicable(googleLogo);
    }
}
