package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by denx7 on 26.02.2018.
 */
public class BasePage {
    protected WebDriver driver;
    public  final Logger log = Logger.getLogger(getClass().getName());


    protected void clickAfterWaitClicable(By elementBy) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(60, SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        driver.findElement(elementBy).click();
    }

    protected void waitElementVisibility(By elementBy, int secondForWait) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(secondForWait, SECONDS)
                .pollingEvery(2000, MILLISECONDS)
                .ignoring(WebDriverException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    protected void clickElementAndSendKeys(By elementBy, String keys) {
        clickAfterWaitClicable(elementBy);
        driver.findElement(elementBy).sendKeys(keys);
    }

    protected void clickElementAndSendKeysWithTab(By elementBy, String keys) {
        clickAfterWaitClicable(elementBy);
        driver.findElement(elementBy).sendKeys(keys);
        driver.findElement(elementBy).sendKeys(Keys.TAB);
    }

}
