package base;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by denx7 on 26.02.2018.
 */
public class BaseUIMethods {
    private final Logger log = Logger.getLogger(BaseUIMethods.class);
    private WebDriver driver;

    public WebDriver getChromeDriver() {
        if (driver == null) {
            log.debug("Создаем ChromeDriver");
            System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        } else return driver;
    }

    public WebDriver getFirefoxDriver() {
        if (driver == null) {
            log.debug("Создаем FirefoxDriver");
            System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
        } else return driver;
    }

    public void closeDriver(String testName) {
        if (driver != null) {
            log.info("Закрываем драйвер в сценарии " + testName);
            driver.quit();
            driver = null;
        }
    }


    @Attachment("Page screenshot")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
