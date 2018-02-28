package base;


import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by denx7 on 27.02.2018.
 */
public class BaseApiMethods {

    public static String searchByInn(String inn) {
        String responceBody = given().
                queryParam("innOgrn", inn).
                when().get().then().
//                log().body().
        statusCode(200).
                        body("data.свЮЛ.инн", equalTo(inn)).
                        body(JsonSchemaValidator.matchesJsonSchemaInClasspath("search_response.json")).
                        extract().response().asString();
        return responceBody;
    }

    public static String searchByOgrn(String ogrn) {
        String responceBody = given().
                queryParam("innOgrn", ogrn).
                when().get().then().
//                log().body().
        statusCode(200).
                        body("data.свЮЛ.огрн", equalTo(ogrn)).
                        body(JsonSchemaValidator.matchesJsonSchemaInClasspath("search_response.json")).
                        extract().response().asString();
        return responceBody;
    }

}
