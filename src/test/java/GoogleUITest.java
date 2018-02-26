import Pages.GoogleMainPage;
import base.BaseMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by denx7 on 26.02.2018.
 */
public class GoogleUITest {
    private WebDriver driver;
    private BaseMethods baseMethods;

    @BeforeTest
    public void startTest() {
        baseMethods = new BaseMethods();
        driver = baseMethods.getChromeDriver();
    }

    @AfterTest
    public void stopTest(){
        baseMethods.closeDriver(getClass().getSimpleName());
    }

    @Test
    public void googleTest() {
        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        googleMainPage.openMainPage();
        googleMainPage.inputInSearchField("Пушкин Александр Сергеевич");
        googleMainPage.clickSearchButton();
    }
}
