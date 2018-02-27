import base.BaseApiMethods;
import io.restassured.RestAssured;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;


/**
 * Тестирование API поиска по ИНН и ОГРН
 * 1. Проверяем успешность поиска по ИНН/ОГРН
 * 2. Сравниваем результаты полученные по ИНН и ОГРН для одной компании
 */
public class SearchApiTet {
    private ArrayList<String> responces = new ArrayList<>();

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://lkk.esphere.ru";
        RestAssured.basePath = "/informator/api/v2/task/search";
    }

    @Test(groups = "a")
    public void searchByInnTest() {
        responces.add(BaseApiMethods.searchByInnOgrn("7703228474"));
    }

    @Test(groups = "a")
    public void searchByOgrnTest() {
        responces.add(BaseApiMethods.searchByInnOgrn("1037739437966"));
    }

    @Test(dependsOnGroups = "a")
    public void responcesShouldBeEquals() {
        Assert.assertEquals(responces.get(0),responces.get(1),
                "Сравниваем ответы полученные по ИНН и ОГРН для одной компании");
    }

}
